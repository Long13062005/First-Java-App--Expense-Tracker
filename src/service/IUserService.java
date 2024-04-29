/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
    
import repository.*;
import java.util.List;
import model.User;


/**
 *
 * @author TechCare
 */
public interface IUserService {
     boolean create(User user);
    List<User> getAll();
    User getById(int id);
    boolean changePassword(User user);
    boolean delete(int id);
    boolean login(String username,String password);
    boolean adminLogin(String username,String password);
}