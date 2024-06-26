/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.admin;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.User;
import service.IUserService;
import service.imp.UserService;
import view.security.LoginForm;
import view.security.ChangePassWindow;

/**
 *
 * @author TechCare
 */
public class AdminDashboard extends javax.swing.JFrame {
    private User user;
        private IUserService service = new UserService();


    public AdminDashboard(User user) {
        this.user = service.getByUsername(user.getUsername());
        initComponents();
        scaleImage();
        setTitle("Dashboard");

    }

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        scaleImage();
   

    }
    public void scaleImage(){
        ImageIcon icon = new ImageIcon("E:\\VKU\\JavaAdvandce\\Lab1\\DACS1\\src\\assets\\administrator.png");
        ImageIcon iconUser = new ImageIcon("E:\\VKU\\JavaAdvandce\\Lab1\\DACS1\\src\\assets\\investor.png");
        ImageIcon iconExpense = new ImageIcon("E:\\VKU\\JavaAdvandce\\Lab1\\DACS1\\src\\assets\\expenses.png");
        
        Image image = icon.getImage();
        Image imageUser = iconUser.getImage();
        Image imageExpense = iconExpense.getImage();

        
        Image imgScale = image.getScaledInstance(iconAdmin.getWidth(), iconAdmin.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleUser = imageUser.getScaledInstance(iconUs.getWidth(), iconUs.getHeight(), Image.SCALE_SMOOTH);
        Image imgScaleExpense = imageExpense.getScaledInstance(iconExp.getWidth(), iconExp.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(imgScale);
        ImageIcon scaledIconUs = new ImageIcon(imgScaleUser);
        ImageIcon scaledIconExp = new ImageIcon(imgScaleExpense);

        iconAdmin.setIcon(scaledIcon);
        iconUs.setIcon(scaledIconUs);
        iconExp.setIcon(scaledIconExp);
        usernameLabel.setText(user.getUsername());
        userAmount.setText(String.valueOf(service.countUser()));
        if( user.getBalance()> 0) {
            expense.setText(String.valueOf(user.getBalance()));
            expense.setForeground(java.awt.Color.BLUE);
        } else {
            expense.setText(String.valueOf(user.getBalance()));
            expense.setForeground(java.awt.Color.RED);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        iconAdmin = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        userAmount = new javax.swing.JLabel();
        usernameLabel4 = new javax.swing.JLabel();
        expense = new javax.swing.JLabel();
        ExpenseLabel = new javax.swing.JLabel();
        changeBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        iconExp = new javax.swing.JButton();
        iconUs = new javax.swing.JButton();
        iconUs1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(iconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 241, 234));

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        jPanel2.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 111, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome back, Admin!");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 246, 253, 80));

        usernameLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 36)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 253, 70));

        userAmount.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        userAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userAmount.setText("users amount  ");
        userAmount.setToolTipText("");
        jPanel2.add(userAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 250, 30));

        usernameLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        usernameLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel4.setText("users amount  ");
        usernameLabel4.setToolTipText("");
        jPanel2.add(usernameLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, 30));

        expense.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        expense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expense.setText("users amount  ");
        expense.setToolTipText("");
        jPanel2.add(expense, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 250, 30));

        ExpenseLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        ExpenseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExpenseLabel.setText("Expense");
        ExpenseLabel.setToolTipText("");
        jPanel2.add(ExpenseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 30));

        changeBtn.setText("Change Password");
        changeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBtnActionPerformed(evt);
            }
        });
        jPanel2.add(changeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 130, -1));

        jPanel1.setBackground(new java.awt.Color(3, 21, 68));

        iconExp.setForeground(new java.awt.Color(255, 255, 255));
        iconExp.setToolTipText("");
        iconExp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExpActionPerformed(evt);
            }
        });

        iconUs.setToolTipText("");
        iconUs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconUsActionPerformed(evt);
            }
        });

        iconUs1.setBackground(new java.awt.Color(242, 242, 242));
        iconUs1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        iconUs1.setText("Feedback");
        iconUs1.setToolTipText("");
        iconUs1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconUs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconUs1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Expense List");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(iconUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconUs1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(iconExp, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(iconUs, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(iconUs1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExpActionPerformed
        // TODO add your handling code here:
        ExpenseListAdmin exp =new ExpenseListAdmin(user);
        exp.setVisible(true);
        dispose();
    }//GEN-LAST:event_iconExpActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginForm form = new LoginForm();
        form.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void iconUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconUsActionPerformed
        // TODO add your handling code here:
        new UserList(user).setVisible(true);
        dispose();
    }//GEN-LAST:event_iconUsActionPerformed

    private void iconUs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconUs1ActionPerformed
        // TODO add your handling code here:
        new FeedbackList().setVisible(true);
    }//GEN-LAST:event_iconUs1ActionPerformed

    private void changeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBtnActionPerformed
        // TODO add your handling code here:
        new ChangePassWindow(user).setVisible(true);
    }//GEN-LAST:event_changeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ExpenseLabel;
    private javax.swing.JButton changeBtn;
    private javax.swing.JLabel expense;
    private javax.swing.JLabel iconAdmin;
    private javax.swing.JButton iconExp;
    private javax.swing.JButton iconUs;
    private javax.swing.JButton iconUs1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel userAmount;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel4;
    // End of variables declaration//GEN-END:variables
}
