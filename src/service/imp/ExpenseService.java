/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.imp;

import java.util.List;
import model.ExpenseIncomeEntry;
import model.User;
import repository.IExpenseRepository;
import repository.imp.*;
import service.IExpenseService;

/**
 *
 * @author TechCare
 */
public class ExpenseService implements IExpenseService{
    private final IExpenseRepository expenseRepo = new ExpenseRepository();

    @Override
    public boolean create(ExpenseIncomeEntry expenseIncomeEntry, User user) {
        return expenseRepo.create(expenseIncomeEntry, user);
    }

    @Override
    public List<ExpenseIncomeEntry> getAll(User user) {
        return expenseRepo.getAll(user);
    }

    @Override
    public ExpenseIncomeEntry getById(int id, User user) {
        return expenseRepo.getById(id, user);
    }

    @Override
    public boolean delete(int id, User user) {
        return expenseRepo.delete(id, user);
    }

    @Override
    public int createAndGetId(ExpenseIncomeEntry entry, User user) {
return expenseRepo.createAndGetId(entry, user);
        }

    @Override
    public List<ExpenseIncomeEntry> findByDate(String dateFind, User user) {
        return expenseRepo.findByDate(dateFind, user);
        
    }

   
}
