/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.imp;

import db.DatabaseConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ExpenseIncomeEntry;
import model.User;
import repository.IExpenseRepository;

/**
 *
 * @author TechCare
 */
public class ExpenseRepository implements IExpenseRepository{
       private DatabaseConnect database = new DatabaseConnect();
    private Connection connection = null;
    private PreparedStatement ps;

    @Override
    public boolean create(ExpenseIncomeEntry expenseIncomeEntry,User user) {
          try {           
      database.ConnectJDBC();
      connection = database.getConnection();
    if (connection != null) {
         ps = connection.prepareStatement("INSERT INTO `expense` VALUES (?, ?,?,?) Where user_id = ?");
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
    }
    } catch (SQLException ex) {
        Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
    }

    @Override
    public List<ExpenseIncomeEntry> getAll() {
    }

    @Override
    public ExpenseIncomeEntry getById(int id) {
    }

    @Override
    public boolean update(ExpenseIncomeEntry expenseIncomeEntry,User user) {
    }

    @Override
    public boolean delete(int id) {
    }
    
}
