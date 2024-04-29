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
    List<ExpenseIncomeEntry> getAll();
    ExpenseIncomeEntry getById(int id);
    boolean update(ExpenseIncomeEntry expenseIncomeEntry,User user);
    boolean delete(int id);
}
