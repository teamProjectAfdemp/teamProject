package com.teamproject.db.Interface;

import com.teamproject.bean.User;
import java.util.HashMap;

public interface UserDAOinterface {
    public HashMap<Integer, String> getidUsernamesMap();
    public int checkUser(String username);
    public int checkUsernamePassword(String username, String pass);
    public User getUserById(int id);
    public int createUser(String username, String pass, String fname, String lname);
    public void setUser(User curUser);
    public HashMap<Integer, User> searchForUser(String keyword);
    public HashMap<Integer, User> selectAllUsers();
    public HashMap<Integer, User> getUsersfromQuery(String query);
    public int updateUser(User user);
    public int deleteUser(User user);
}
