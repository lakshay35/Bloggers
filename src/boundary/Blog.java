package boundary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import object.User;
import persistent.UserDA;

@WebServlet("/Blog")
public class Blog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signUp = request.getParameter("signUp");
        String logout = request.getParameter("logout");

        if(signUp!= null) {
            registerNewUser(request, response);
        } else if(logout != null) {
            logUserOut(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String checkIfUserExists = request.getParameter("checkIfUserExists");
        String logout = request.getParameter("logoutButton");
        String about = request.getParameter("aboutButton");
        String homepage = request.getParameter("homepageButton");

        if(login != null) {
            loginUser(request, response);
        } else if(checkIfUserExists != null) {
            checkIfUserExists(request, response);
        } else if(logout != null) {
            logUserOut(request, response);
        } else if(about != null) {
            openAboutPage(request, response);
        } else if(homepage != null) {
            openHomePage(request, response);
        }
    }

    private void registerNewUser(HttpServletRequest request, HttpServletResponse response) {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");

        User user = new User(fname, lname, email, username, password, Long.parseLong(contact));
        try {
            if(user.registerUser() == 1) {
                response.getWriter().write("Congratulations. You have successfully been registered");
            } else {
                response.getWriter().write("Oh no. Something went wrong with your registration");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        try {
            int i = user.loginUser();
            if(i == 1) {
                TemplateProcessor processor = new TemplateProcessor("WEB-INF/templates", getServletContext());
                HashMap root = new HashMap();
                String name = user.retrieveName();
                root.put("name", name);
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                processor.process("homepage.ftl", root, response);
            } else if(i == 0){
                response.sendRedirect("signin.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void checkIfUserExists(HttpServletRequest request, HttpServletResponse response) {
        boolean emailExists = UserDA.checkIfEmailExists(request.getParameter("email"));
        boolean usernameExists = UserDA.checkIfUsernameExists(request.getParameter("username"));
        Gson gson = new Gson();
        JsonObject json = new JsonObject();
        int responseCode = 200;

        if(emailExists && usernameExists) {
            json.addProperty("text", "email/username");
            responseCode = 403;
        } else if(emailExists) {
            json.addProperty("text", "email");
            responseCode = 403;
        } else if(usernameExists) {
            json.addProperty("text", "username");
            responseCode = 403;
        }

        json.addProperty("statusCode", responseCode);

        try {
            response.setContentType("application/json");
            response.getWriter().write(String.valueOf(json));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logUserOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        try {
            response.sendRedirect("index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openAboutPage(HttpServletRequest request, HttpServletResponse response) {
        TemplateProcessor processor = new TemplateProcessor("WEB-INF/templates", getServletContext());
        HashMap root = new HashMap();
        HttpSession session = request.getSession(false);
        if(session != null) {
            root.put("name", session.getAttribute("name"));
        }
        processor.process("about.ftl", root, response);
    }

    private void openHomePage(HttpServletRequest request, HttpServletResponse response) {
        TemplateProcessor processor = new TemplateProcessor("WEB-INF/templates", getServletContext());
        HashMap root = new HashMap();
        HttpSession session = request.getSession(false);
        if(session != null) {
            root.put("name", session.getAttribute("name"));
        }
        processor.process("homepage.ftl", root, response);
    }

}
