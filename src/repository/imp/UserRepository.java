/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.imp;

import db.BaseRepository;
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
public class UserRepository implements IUserRepository {

    private BaseRepository database = new BaseRepository();
    private Connection connection = null;
    private PreparedStatement ps;
    private final String SHOW_LIST_USER = "SELECT * FROM user";
    private final String DELETE_USER = " DELETE FROM user WHERE id = ? ";
    private final String FIND_BY_NAME_USER = "SELECT * FROM user where username = ?;";
    private final String ADD_USER = "INSERT INTO `user` (username, password) VALUES (?, ?) ";
    private final String FIND_USER_ID = "SELECT * FROM USER WHERE ID = ?";
    private final String UPDATE_BALANCE = "UPDATE user SET balance = ? WHERE id = ?";
    private final String COUNT_USER = "SELECT COUNT(*) AS user_count FROM user WHERE role_id = 2;";

    //Register
    @Override
    public boolean create(User user) {
        connection = database.getConnectDB();

        try {

            ps = connection.prepareStatement(ADD_USER);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            int rowsInserted = ps.executeUpdate();

            // Check if the user was successfully inserted
            if (rowsInserted > 0) {
                return true; // User created successfully

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        ResultSet resultSet = null;
        connection = database.getConnectDB();

        try {

            String query = SHOW_LIST_USER;
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                                double price = resultSet.getDouble("balance");
                int roleId = resultSet.getInt("role_id");
                User user = new User(id, username, password, price,roleId);
                userList.add(user);

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
    public User getByUsername(String username) {
        ResultSet resultSet = null;
        User user = null;
        connection = database.getConnectDB();

        try {

            String query = FIND_BY_NAME_USER;
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String usernameFind = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                int roleId = resultSet.getInt("role_id");
                user = new User(id, usernameFind, password, balance, roleId);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            // Handle SQLException appropriately, e.g., throw an exception or log it.
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
                // Handle SQLException appropriately, e.g., throw an exception or log it.
            }
        }
        return user;
    }

    @Override
    public boolean changePassword(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        connection = database.getConnectDB();

        try {

            ps = connection.prepareStatement(DELETE_USER);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean login(String username, String password) {
        connection = database.getConnectDB();

        try {

            ps = connection.prepareStatement("SELECT * FROM `user` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return true; // User exists

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //adminLogin
    @Override
    public boolean adminLogin(String username, String password) {
        connection = database.getConnectDB();

        try {

            ps = connection.prepareStatement("SELECT * FROM `user` WHERE `username` = ? AND `password` = ? AND role_id = 1");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return true; // User exists
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public User findById(int id) {
        ResultSet resultSet = null;
        User user = null;
        connection = database.getConnectDB();

        try {

            // Assuming FIND_USER_ID is defined somewhere as a constant
            String query = FIND_USER_ID;
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int idFind = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                int roleId = resultSet.getInt("role_id");
                user = new User(idFind, username, password, balance, roleId);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            // Handle SQLException appropriately, e.g., throw an exception or log it.
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
                // Handle SQLException appropriately, e.g., throw an exception or log it.
            }
        }
        return user;

    }

    @Override
    public boolean updateBalance(int id, double newBalance) {
        connection = database.getConnectDB();
        try {

            // Prepare the SQL statement
            PreparedStatement ps = connection.prepareStatement(UPDATE_BALANCE);

            // Set the parameters
            ps.setDouble(1, newBalance); // newBalance is the updated balance value
            ps.setInt(2, id); // userId is the ID of the user whose balance you want to update

            // Execute the update statement
            int rowsUpdated = ps.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update balance.");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Return false if an SQL exception occurs
        }
    }

    @Override
    public int countUser() {
        ResultSet resultSet = null;
        connection = database.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(COUNT_USER);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int userCount = resultSet.getInt("user_count");
                // Do something with the user count, such as returning it or using it in your application
                return userCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
// Return a default value or handle the case where no count is retrieved
        return -1; // Or any other default value
    }

}
