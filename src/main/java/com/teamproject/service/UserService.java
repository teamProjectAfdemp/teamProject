/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.service;

import com.teamproject.bean.User;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Takis
 */

public interface UserService {
    
     List<User>  findAllUsers();
     
     User findUser(int id);
     
     public boolean isUserExist(User user);
     
     public boolean saveUser(User user);
    
}
