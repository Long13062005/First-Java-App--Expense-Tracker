/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.admin;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ExpenseIncomeEntry;
import model.ExpenseIncomeTableModel;
import model.User;
import service.IExpenseService;
import service.IUserService;
import service.imp.ExpenseService;
import service.imp.UserService;
import view.user.*;

/**
 *
 * @author TechCare
 */
public class ExpenseListAdmin extends javax.swing.JFrame {

    private ExpenseIncomeTableModel tableModel = new ExpenseIncomeTableModel();
    private double balance; // The current balance based on the added expenses and incomes.
    private IExpenseService expenseService = new ExpenseService();
    private IUserService userService = new UserService();
    private static User user;

    public ExpenseListAdmin(User user) {
        ExpenseListAdmin.user = user;
        initComponents();

        // Initialize the table model and balance variable.
        balance = userService.findById(user.getId()).getBalance();
        // Create a JTable and set up a scroll pane to display the data.

        balanceLabel.setText("Balance: $" + userService.findById(user.getId()).getBalance());

        table.setModel(tableModel);
        table.setFillsViewportHeight(true);
        showList();

        // Set the title, default close operation, and visibility of the main frame.
        setTitle("Expenses And Incomes Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Creates new form ExpenseList
     */
  private void addEntry() {
    // Get input values from input fields.
    if (dateField.getCalendar() == null) {
        JOptionPane.showMessageDialog(this, "Enter the Date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = dateFormat.format(dateField.getDate());
    String description = descriptionField.getText();
    String amountStr = amountField.getText();
    String type = (String) typeBox.getSelectedItem();
    double amount;

    // Validate input values.
    // you can the description and date to the validation
    if (amountStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter the Amount", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        amount = Double.parseDouble(amountStr);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid Amount Format", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convert expenses to negative values.
    if (type.equals("Expense")) {
        amount *= -1;
    }

    // Create a new entry.
    ExpenseIncomeEntry entry = new ExpenseIncomeEntry(date, description, amount, type);
    
    // Add the entry to the database and retrieve the generated ID.
    int generatedId = expenseService.createAndGetId(entry, userService.findById(user.getId()));

    // Update the entry with the generated ID.
    entry.setId(generatedId);

    // Add the entry to the table.
    tableModel.addEntry(entry);

    // Update the balance and display the new balance.
    balance += amount;
    userService.updateBalance(user.getId(), balance);
    balanceLabel.setText("Balance: $" + userService.findById(user.getId()).getBalance());
    JOptionPane.showMessageDialog(null, "Add Expense successfully");

    // Clear input fields for the next entry.
    clearInputFields();
}

    //delEntry
    private void delEntry() {
    int selRow = table.getSelectedRow();
    if (selRow == -1) {
        // No row is selected, show an error message
        JOptionPane.showMessageDialog(null, "Please select a record to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int id = Integer.parseInt(table.getValueAt(selRow, 0).toString());

    int delItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete this?", "Warning", JOptionPane.YES_NO_OPTION);
    if (delItem == JOptionPane.YES_OPTION) {
        // Get the amount of the entry before deleting it
        double amount = expenseService.getById(id, userService.findById(user.getId())).getAmount();

        // Update the balance
        balance -= amount;
        userService.updateBalance(user.getId(), balance);
        balanceLabel.setText("Balance: $" + userService.findById(user.getId()).getBalance());

        // Delete the entry
        expenseService.delete(id, userService.findById(user.getId()));
        JOptionPane.showMessageDialog(null, "Record Deleted");
    }
    dispose();
    new ExpenseListAdmin(user).setVisible(true);
}
    // Method to clear input fields.

    private void clearInputFields() {
        dateField.setCalendar(null);
        descriptionField.setText("");
        amountField.setText("");
        typeBox.setSelectedIndex(0);
    }

    private void showList() {
        List<ExpenseIncomeEntry> entries = expenseService.getAll(userService.findById(user.getId()));

        // Populate table rows
        for (ExpenseIncomeEntry entry : entries) {
            tableModel.addEntry(entry);
        }

        // Notify the table that the data has changed
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateField = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        amountField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        typeBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        clearBtn1 = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        balanceLabel = new javax.swing.JLabel();
        delBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        addButton.setBackground(new java.awt.Color(204, 204, 0));
        addButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 90, 20));
        jPanel1.add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 170, -1));

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 180, -1));
        jPanel1.add(amountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 90, 20));

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income" }));
        jPanel1.add(typeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Description");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 110, 20));

        clearBtn.setBackground(new java.awt.Color(51, 51, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 90, 30));

        clearBtn1.setBackground(new java.awt.Color(51, 51, 255));
        clearBtn1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        clearBtn1.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn1.setText("Clear");
        clearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 90, 30));

        searchBtn.setBackground(new java.awt.Color(204, 204, 0));
        searchBtn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, 30));

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setForeground(java.awt.Color.darkGray);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        balanceLabel.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(242, 242, 242));
        balanceLabel.setText("Balance : 0.0$");
        jPanel2.add(balanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 186, -1));

        delBtn.setBackground(new java.awt.Color(255, 0, 0));
        delBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        jPanel2.add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 90, 30));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Description", "Price", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        delEntry();
    }//GEN-LAST:event_delBtnActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addEntry();
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
                clearInputFields();

    }//GEN-LAST:event_clearBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        // TODO add your handling code here:
        AdminDashboard ad = new AdminDashboard(user);
        dispose();
        ad.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void clearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtn1ActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
         if (dateField.getCalendar() == null) {
        JOptionPane.showMessageDialog(this, "Enter the Date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String date = dateFormat.format(dateField.getDate());
          List<ExpenseIncomeEntry> expenseIncomeEntrys = expenseService.findByDate(date,userService.findById(user.getId()));
    
    // Add the search results to the table model
    new SearchExpenseWindow(expenseIncomeEntrys);
    }//GEN-LAST:event_searchBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpenseListAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseListAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseListAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseListAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseListAdmin(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField amountField;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearBtn1;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JButton delBtn;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> typeBox;
    // End of variables declaration//GEN-END:variables
}
