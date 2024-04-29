/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
    
import java.util.List;
import model.User;
import model.dto.UserDto;


/**
 *
 * @author TechCare
 */
public interface IUserRepository {
     boolean create(User user);
    List<UserDto> getAll();
    User getById(int id);
    boolean changePassword(User user);
    boolean delete(int id);
    boolean login(String username,String password);
    boolean adminLogin(String username,String password);
}
