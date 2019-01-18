/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamproject.service;

import com.teamproject.bean.User;
import com.teamproject.db.UserDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 *
 * @author Takis
 */

@Service("userService")
public class UserServiceImpl implements UserService{
    
    private static final AtomicLong counter = new AtomicLong();
    
    private static List<User> users;
    private static HashMap<Integer,User> usersMap;
	
	static{
            usersMap = UserDAO.getInstance().selectAllUsers();
	}

	public List<User> findAllUsers() {
                usersMap = UserDAO.getInstance().selectAllUsers();
                List<User> users1 = new ArrayList<>();
                usersMap.forEach((k, v) -> users1.add(v));
                users = users1;
		return users;
	}
        
        public User findUser(int id){
            return usersMap.get(id);
        }
        
        public boolean isUserExist(User user) {
            return ( UserDAO.getInstance().checkUser(user.getUsername()) ==1) ;
        }
        
        public boolean saveUser(User user) {
            return ( UserDAO.getInstance().createUser(user.getUsername(), user.getPassword(), user.getFname(), user.getLname()) ==1 );
        }
 
}
