/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TechCare
 */
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import service.IUserService;
import service.imp.UserService;


/**
 *
 * @author 1BestCsharp
 */
public class UserTableModel extends AbstractTableModel {
    private IUserService service = new UserService();

    // List to store the entries (rows) in the table
    private List<User> entries ;
    // Column names for the table
    private final String[] columnNames = {"ID","Username","Balance","Role"};
    
    /**
     * Constructor to initialize the table model.
     */
    public UserTableModel(){
        entries = new ArrayList<>();
    }
            

    /**
     * Add a new entry to the table.
     *
     * @param entry The expense or income entry to add.
     */
    public void addEntry(User entry){
        entries.add(entry);
        // Notify the table that a new row has been inserted
        fireTableRowsInserted(entries.size()-1, entries.size()-1);
    }
    public void delEntry() {
       for (int i = 0; i < entries.size(); i++) {
            entries.remove(i);
            // Notify the table that a row has been deleted
            fireTableRowsDeleted(i, i);
            break; // Exit the loop after deleting the entry
    }
    }
     public void removeEntry() {
        for(int i = 0;i< entries.size();i++) {
              
                entries.remove(i);
           
        }
    }
    
    @Override
    public int getRowCount() { return entries.size(); }

    @Override
    public int getColumnCount() { return columnNames.length;}

    @Override
    public String getColumnName(int column){ return columnNames[column]; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        User entry = entries.get(rowIndex);
        
        // Return the value for the cell based on the column index
        switch(columnIndex){
            case 0: return entry.getId();
            case 1: return entry.getUsername();
            case 2: return entry.getBalance();
            case 3:  if(entry.getRoleID() == 1) {
                return "Admin";
            }   else {
                return "User";
            }
            default: return null;
        }
        
        
    }
    public List<User> findEntry(String username) {
        entries = service.getAll();
        List<User> userFind = new ArrayList<>();
    for (User entry : entries) {
        if (entry.getUsername().contains(username)) {
            userFind.add(entry);

        }
    }

    return userFind;  
}
    public void clearEntries() {
    entries.clear();
    fireTableDataChanged();
}

}
