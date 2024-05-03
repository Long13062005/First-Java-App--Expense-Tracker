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
    User getByUsername(String username);
    boolean changePassword(User user,String changePassword);
    boolean delete(int id);
    boolean login(String username,String password);
    boolean adminLogin(String username,String password);
    User findById(int id);
    boolean updateBalance(int id,double newBalance);
    int countUser();
}
