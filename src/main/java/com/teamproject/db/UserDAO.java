package com.teamproject.db;

import com.teamproject.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

// DAOs are singleton. Private constructor
// Call them through getInstance() to get the same object always
public class UserDAO extends Database {

    public static UserDAO userDAO = null;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public int checkUser(String username) {
        int userID = 0;

        String query = "SELECT * FROM `users` WHERE `username` = \'" + username + "\';";

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            userID = (Integer) row.get("id");
        }
        return userID;
    }

    public boolean checkPass(int userID, String pass) {
        boolean userAuth = false;
        int newID = 0;

        String query = "SELECT `id` FROM `users` WHERE `id` = '" + userID + "' AND `pass` = '" + pass + "';";

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            newID = (Integer) row.get("id");
        }
        return newID != 0;
    }
    
     public int checkUsernamePassword(String username, String pass) {
        int userId = 0;
        
        String query = ("SELECT * FROM `users` WHERE `username` = '" + username + "' AND `pass` = '" + pass + "';");
        
        Collection<Map<String,Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);
        
        for (Map<String,Object> row: answer) {
            userId = (Integer) row.get("id");
        }
        
        return userId;
    }

    public void setUser(User curUser) {

        String query = "SELECT * FROM `users` "
                + "WHERE `id` = '" + curUser.getId() + "';";

        //Execute the query and Get the ArrayList of maps (the ROWS!)
        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        //Loop through the rows and get values
        for (Map<String, Object> row : answer) {
            curUser.setId((Integer) row.get("id"));
            curUser.setUsername((String) row.get("username"));
        }
    }

    public HashMap<Integer, User> searchForUser(String keyword) {
        String like = "'%" + keyword + "%'";

        String query = "SELECT * FROM `users` "
                + "WHERE `username` LIKE " + like
                + " OR `fname` LIKE " + like
                + " OR `lname` LIKE " + like + ";";

        return getUsersfromQuery(query);
    }

    public HashMap<Integer, User> selectAllUsers() {
        String query = "SELECT * FROM `chatapp`.`users`;";
        return getUsersfromQuery(query);
    }

    public HashMap<Integer, User> getUsersfromQuery(String query) {

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        HashMap<Integer, User> usersFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setUsername((String) row.get("username"));
            user.setFname((String) row.get("fname"));
            user.setLname((String) row.get("lname"));
//            user.setRegDate( (Date) row.get("create_date"));
//            user.setActive( ((Integer) row.get("active")) == 1 );
            usersFound.put(user.getId(), user);
        }
        return usersFound;
    }
}
