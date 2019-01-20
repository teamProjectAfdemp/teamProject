package com.teamproject.db;

import com.teamproject.db.RouteDAO;
import com.teamproject.bean.User;
import static com.teamproject.db.RouteDAO.routeDAO;
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

        String query = "SELECT * FROM `Users` WHERE `username` = \'" + username + "\';";

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

        String query = "SELECT `id` FROM `Users` WHERE `id` = '" + userID + "' AND `password` = '" + pass + "';";

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            newID = (Integer) row.get("id");
        }
        return newID != 0;
    }

    public int checkUsernamePassword(String username, String pass) {
        int userId = 0;

        String query = ("SELECT * FROM `teamproject`.`Users` WHERE `username` = '" + username + "' AND `password` = '" + pass + "';");

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            userId = (Integer) row.get("id");
        }
        return userId;
    }

    public User getUserById(int id) {
        User user = new User();
        
        String query = ("SELECT * FROM `teamproject`.`Users` WHERE `id` = '" + id + "';");

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);
        
        for (Map<String, Object> row : answer) {
            user.setFname((String) row.get("fname"));
            user.setLname((String) row.get("lname"));
            user.setUsername((String) row.get("username"));
            user.setId( (Integer) row.get("id"));
            System.out.println(row.get("id"));
            System.out.println("ONE MORE USER");
        }
        
        System.out.println(user.getId());

        return user;
    }

    public int createUser(String username, String pass, String fname, String lname) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query = "INSERT INTO `Users` (`username`,`password`,`fname`,`lname`)"
                + "VALUES (?,?,?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setString(1, username);
            prest.setString(2, pass);
            //prest.setInt(3,2);  //create a user with reader role
            prest.setString(3, fname);
            prest.setString(4, lname);
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    public void setUser(User curUser) {
        String query = "SELECT * FROM `Users` "
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

        String query = "SELECT * FROM `Users` "
                + "WHERE `username` LIKE " + like
                + " OR `fname` LIKE " + like
                + " OR `lname` LIKE " + like + ";";

        return getUsersfromQuery(query);
    }

    public HashMap<Integer, User> selectAllUsers() {
        String query = "SELECT * FROM `teamproject`.`Users`;";
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

    public int updateUser(User user) {

        String query = "UPDATE `teamproject`.`Users` SET `fname` = '" + user.getFname()
                + "' ,`lname` = '" + user.getLname() + "' WHERE `id` = '" + user.getId() + "';";
        
        System.out.println(query);
        return execUpdateInsert(query);
        
    }
    
    public int deleteUser(User user) {
        
        String query = "DELETE FROM `teamproject`.`Users` WHERE `id` = '" + user.getId() + "';";
        
        System.out.println(query);
        return execUpdateInsert(query);
    }
    
    public int disableUser(User user) {
        
        // NOT YET IMPLEMENTED ON DB
         String query = "UPDATE `Users` SET `active` = '" + "??" + "' WHERE `id` = '" + user.getId() + "';";
        return execUpdateInsert(query);
        
    }

    public int updatePass(User user) {

        String query = "UPDATE `Users` SET `password` = '" + user.getPassword() + "' WHERE `id` = '" + user.getId() + "';";
        return execUpdateInsert(query);

    }
}
