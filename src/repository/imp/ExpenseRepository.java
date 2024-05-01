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
import model.ExpenseIncomeEntry;
import model.User;
import repository.IExpenseRepository;
import repository.IUserRepository;

/**
 *
 * @author TechCare
 */
public class ExpenseRepository implements IExpenseRepository{
       private BaseRepository database = new BaseRepository();
    private Connection connection = null;
    private PreparedStatement ps;
    private IUserRepository repository = new UserRepository();
    private final String SHOW_LIST_EXPENSE ="SELECT * FROM expense where User_id = ?";
    private final String DELETE_EXPENSE =" DELETE FROM EXPENSE WHERE id = ? and User_id = ?";
    private final String FIND_BY_ID_EXPENSE ="SELECT * FROM EXPENSE where id = ? and User_id = ?;";
    private final String ADD_EXPENSE  ="INSERT INTO `expense` (`date`, `description`, price ,type_expense, user_id) VALUES (?,?,?,?,?) ";
    private final String FIND_BY_DATE_EXPENSE  ="SELECT * FROM expense WHERE `date` = ? AND user_id = ? ";

    @Override
    public boolean create(ExpenseIncomeEntry expenseIncomeEntry,User user) {
              connection = database.getConnectDB();

          try {           
         ps = connection.prepareStatement(ADD_EXPENSE);
        ps.setString(1,expenseIncomeEntry.getDate());
        ps.setString(2,expenseIncomeEntry.getDescription());
        ps.setDouble(3,expenseIncomeEntry.getAmount());
        ps.setString(4,expenseIncomeEntry.getType());
        ps.setInt(5, user.getId());
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
    public List<ExpenseIncomeEntry> getAll(User user) {
          List<ExpenseIncomeEntry> entrys = new ArrayList<>();
                ResultSet resultSet = null;
              connection = database.getConnectDB();

                   try {
                String query = SHOW_LIST_EXPENSE;
                ps = connection.prepareStatement(query);
                ps.setInt(1, user.getId());
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String date = resultSet.getString("date");
                    String description = resultSet.getString("description");
                     double amount = resultSet.getInt("Price");
                     String type = resultSet.getString("type_expense");
                    ExpenseIncomeEntry eie = new ExpenseIncomeEntry(id,date,description,amount,type);
                    entrys.add(eie);
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

        return entrys;
    }

    @Override
    public ExpenseIncomeEntry getById(int id,User user) {
        ResultSet resultSet = null;
        ExpenseIncomeEntry expense = null;
                      connection = database.getConnectDB();

       try {
                String query = FIND_BY_ID_EXPENSE;
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.setInt(2, user.getId());

                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int idFind = resultSet.getInt("id");
                      String date = resultSet.getString("date");
                    String description = resultSet.getString("description");
                     double amount = resultSet.getInt("Price");
                     String type = resultSet.getString("type_expense");
                     expense = new ExpenseIncomeEntry(idFind, date, description,amount,type);
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
       return expense;
    }

    @Override
    public boolean delete(int id,User user) {
                    connection = database.getConnectDB();

         try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXPENSE);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,user.getId());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }   
    }
    @Override
    public int createAndGetId(ExpenseIncomeEntry entry, User user) {
    int generatedId = 0; // Initialize the generated ID variable

    try {
        connection = database.getConnectDB();

            ps = connection.prepareStatement(ADD_EXPENSE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entry.getDate());
            ps.setString(2, entry.getDescription());
            ps.setDouble(3, entry.getAmount());
            ps.setString(4, entry.getType());
            ps.setInt(5, user.getId());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Get the generated ID
                }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close resources
        // Handle SQLException appropriately
    }

    return generatedId;
}

    @Override
    public List<ExpenseIncomeEntry> findByDate(String dateFind, User user) {
         List<ExpenseIncomeEntry> entrys = new ArrayList<>();
                ResultSet resultSet = null;
              connection = database.getConnectDB();

                   try {
                String query = FIND_BY_DATE_EXPENSE;
                ps = connection.prepareStatement(query);
                ps.setString(1, dateFind);
                ps.setInt(2, user.getId());
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String date = resultSet.getString("date");
                    String description = resultSet.getString("description");
                     double amount = resultSet.getInt("Price");
                     String type = resultSet.getString("type_expense");
                    ExpenseIncomeEntry eie = new ExpenseIncomeEntry(id,date,description,amount,type);
                    entrys.add(eie);
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

        return entrys;
    }

    
}
