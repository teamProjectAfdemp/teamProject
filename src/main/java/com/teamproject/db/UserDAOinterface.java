package com.teamproject.db;


public interface UserDAOinterface {
    void createUser(String username, String password, String fname, String lname);
    void updateUser(int id, String username, String password, String fname, String lname);
    void deleteUser();
    void deleteUserById(int id);
}
