/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
    
import repository.*;
import java.util.List;
import model.ExpenseIncomeEntry;
import model.User;


/**
 *
 * @author TechCare
 */
public interface IExpenseService {
     boolean create(ExpenseIncomeEntry expenseIncomeEntry);
    List<ExpenseIncomeEntry> getAll();
    ExpenseIncomeEntry getById(int id);
    boolean update(ExpenseIncomeEntry expenseIncomeEntry);
    boolean delete(int id);
}
