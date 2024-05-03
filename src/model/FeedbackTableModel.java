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
public class FeedbackTableModel extends AbstractTableModel {

    private IUserService service = new UserService();

    // List to store the entries (rows) in the table
    private List<Feedback> entries;
    // Column names for the table
    private final String[] columnNames = {"ID", "Username", "Description"};

    /**
     * Constructor to initialize the table model.
     */
    public FeedbackTableModel() {
        entries = new ArrayList<>();
    }

    /**
     * Add a new entry to the table.
     *
     * @param entry The expense or income entry to add.
     */
    public void addEntry(Feedback entry) {
        entries.add(entry);
        // Notify the table that a new row has been inserted
        fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
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

        Feedback entry = entries.get(rowIndex);

        // Return the value for the cell based on the column index
        switch (columnIndex) {
            case 0:
                return entry.getId();
            case 1:
                return service.findById(entry.getUserID()).getUsername() ;
            case 2:
                return entry.getDescription();
                default:
                    return null;
        }

    }

}
