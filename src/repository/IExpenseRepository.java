/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
    
import java.util.List;
import model.ExpenseIncomeEntry;
import model.User;


/**
 *
 * @author TechCare
 */
public interface IExpenseRepository {
     boolean create(ExpenseIncomeEntry expenseIncomeEntry,User user);
    List<ExpenseIncomeEntry> getAll(User user);
    ExpenseIncomeEntry getById(int id,User user);
    boolean delete(int id,User user);
    
    int createAndGetId(ExpenseIncomeEntry entry, User user);
    List<ExpenseIncomeEntry> findByDate(String date,User user);
}
