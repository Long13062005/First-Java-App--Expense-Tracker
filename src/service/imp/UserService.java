/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.imp;

import db.BaseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import repository.IUserRepository;
import repository.imp.UserRepository;
import service.IUserService;

/**
 *
 * @author TechCare
 */
public class UserService implements IUserService{
    IUserRepository userRepository = new UserRepository();
    private BaseRepository database;
    private Connection connection;
    private PreparedStatement ps;
    //Register
    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public boolean changePassword(User user,String changePassword) {
        return userRepository.changePassword(user,changePassword);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean login(String username, String password) {
        return userRepository.login(username, password);
    }
    //checkPass
     public boolean checkPasswordConfirm(String password, String confirmPassword) {
        // Check if both password and confirmPassword are not null
        if (password != null && confirmPassword != null) {
            // Compare the two strings
            return password.equals(confirmPassword);
        } else {
            // If either password or confirmPassword is null, return false
            return false;
        }
    }
     //checkUsernameDuplicate
  public boolean checkUsernameDuplicate(String username) {
    List<User> userCheck = userRepository.getAll();
    for (User u : userCheck) {
        if (u.getUsername().equals(username)) {
            return true; // Username already exists
        }
    }
    return false; // Username does not exist
}

    @Override
    public boolean adminLogin(String username, String password) {
        return userRepository.adminLogin(username, password);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean updateBalance(int id, double newBalance) {
        return userRepository.updateBalance(id, newBalance);
    }

    @Override
    public int countUser() {
        return userRepository.countUser();
    }
    
    
}
