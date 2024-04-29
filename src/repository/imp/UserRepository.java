/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.imp;

import db.DatabaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.dto.UserDto;
import repository.IUserRepository;

/**
 *
 * @author TechCare
 */
public class UserRepository implements IUserRepository{

    private DatabaseConnect database = new DatabaseConnect();
    private Connection connection = null;
    private PreparedStatement ps;

    //Register
    @Override
    public boolean create(User user) {
        
  try {           
      database.ConnectJDBC();
      connection = database.getConnection();
    if (connection != null) {
         ps = connection.prepareStatement("INSERT INTO `user` (username, password) VALUES (?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        int rowsInserted = ps.executeUpdate();

        // Check if the user was successfully inserted
        if (rowsInserted > 0) {
            return true; // User created successfully
        }
    }
    } catch (SQLException ex) {
        Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
    }



    @Override
    public List<UserDto> getAll() {
                List<User> userList = new ArrayList<>();
                ResultSet resultSet = null;

                   try {
            connection = database.getConnection();
            if (connection != null) {
                String query = "SELECT * FROM user";
                ps = connection.prepareStatement(query);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int roleId = resultSet.getInt("role_id");
                    UserDto user = new User(id, username, password,roleId);
                    userList.add(user);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return userList;
    }
    

    @Override
    public User getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean changePassword(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean login(String username, String password) {

    try {           
      database.ConnectJDBC();
      connection = database.getConnection();
    if (connection != null) {
        PreparedStatement ps = connection.prepareStatement("SELECT `username`, `password` FROM `user` WHERE `username` = ? AND `password` = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            return true; // User exists
        }
    }
    } catch (SQLException ex) {
        Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
    }
    //adminLogin
    @Override
    public boolean adminLogin(String username, String password) {
   try {           
      database.ConnectJDBC();
      connection = database.getConnection();
    if (connection != null) {
        PreparedStatement ps = connection.prepareStatement("SELECT `username`, `password` FROM `user` WHERE `username` = ? AND `password` = ? AND role_id = 1");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            return true; // User exists
        }
    }
    } catch (SQLException ex) {
        Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
    }
     
    
}
