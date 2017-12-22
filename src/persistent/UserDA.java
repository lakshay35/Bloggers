package persistent;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import object.User;
import org.bson.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class UserDA {

    private static MongoCollection<Document> customers;

    static {
        try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("test");
            customers = database.getCollection("customers");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void registerUser(String fname, String lname, String email, String username, String password, long contact) throws Exception {
        Document document = new Document();
        document.append("fname", fname);
        document.append("lname", lname);
        document.append("email", email);
        document.append("username", username);
        document.append("password", password);
        document.append("contact", contact);
        customers.insertOne(document);
    }

    public static int loginUser(String username, String password) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.append("username", username);
        whereQuery.append("password", password);
        FindIterable<Document> iterable = customers.find(whereQuery);
        Document document = iterable.first();
        if(document != null && document.get("username").equals(username) && document.get("password").equals(password)) {
            return 1;
        }
        return 0;
    }

    public static boolean checkIfUsernameExists(String username) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.append("username", username);
        FindIterable<Document> iterable = customers.find(whereQuery);
        Document document = iterable.first();
        if(document != null) {
            return true;
        }
        return false;
    }

    public static boolean checkIfEmailExists(String email) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.append("email", email);
        FindIterable<Document> iterable = customers.find(whereQuery);
        Document document = iterable.first();
        if(document != null) {
            return true;
        }
        return false;
    }

    public static String retrieveName(String username) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.append("username", username);
        FindIterable<Document> iterable = customers.find(whereQuery);
        Document document = iterable.first();
        if(document == null) {
            return null;
        }
        return document.getString("fname");
    }

    public static User retrieveDetails(String username) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.append("username", username);
        FindIterable<Document> iterable = customers.find(whereQuery);
        Document document = iterable.first();
        if(document == null) {
            return null;
        }


        User user = new User(document.getString("fname"), document.getString("lname"), document.getString("email"), document.getString("username"), document.getString("password"), document.getLong("contact"));
        return user;
    }
}
