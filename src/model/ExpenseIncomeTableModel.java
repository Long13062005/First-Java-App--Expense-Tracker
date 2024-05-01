/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TechCare
 */
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import db.BaseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import repository.IExpenseRepository;
import repository.IUserRepository;
import repository.imp.ExpenseRepository;
import repository.imp.UserRepository;

/**
 *
 * @author 1BestCsharp
 */
public class ExpenseIncomeTableModel extends AbstractTableModel {

    private IExpenseRepository expense = new ExpenseRepository();
    // List to store the entries (rows) in the table
    private List<ExpenseIncomeEntry> entries;
    // Column names for the table
    private BaseRepository database = new BaseRepository();
    private PreparedStatement ps;
 
    private final String[] columnNames = {"ID", "Date", "Description", "Amount", "Type"};

    /**
     * Constructor to initialize the table model.
     */
    public ExpenseIncomeTableModel() {
        entries = new ArrayList<>();
    }

    /**
     * Add a new entry to the table.
     *
     * @param entry The expense or income entry to add.
     */
    public void addEntry(ExpenseIncomeEntry entry   ) {
        entries.add(entry);
        // Notify the table that a new row has been inserted
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    
    public void showEntry(ExpenseIncomeEntry entry) {

        entries.add(entry);
        // Notify the table that a new row has been inserted
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
    }

    public void delEntry(int id) {

        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getId() == id) {
                entries.remove(id);

            }
        }
    }
 public void clearEntry() {

        for (int i = 0; i < entries.size(); i++) {
             
                entries.remove(i);

            
        }
    }
    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ExpenseIncomeEntry entry = entries.get(rowIndex);

        // Return the value for the cell based on the column index
        switch (columnIndex) {
            case 0:
                return entry.getId();
            case 1:
                return entry.getDate();
            case 2:
                return entry.getDescription();
            case 3:
                return entry.getAmount();
            case 4:
                return entry.getType();
            default:
                return null;
        }

    }

    public void removeRow(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 

 

}
