package object;

import persistent.UserDA;

import java.util.HashMap;

public class User {

    private String fname;
    private String lname;
    private String email;
    private String username;
    private String password;
    private long contact;

    public User(String fname, String lname, String email, String username, String password, long contact) {
        this.setFname(fname);
        this.setLname(lname);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        this.setContact(contact);
    }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(String username) {
        this.setUsername(username);
    }

    public String getFname() {
        return fname;
    }

    private void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    private void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public long getContact() {
        return contact;
    }

    private void setContact(long contact) {
        this.contact = contact;
    }

    public int registerUser() {
        try {
            UserDA.registerUser(fname, lname, email, username, password, contact);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public int loginUser() {
        return UserDA.loginUser(username, password);
    }

    public String retrieveName() {
        return UserDA.retrieveName(this.username);
    }
}
