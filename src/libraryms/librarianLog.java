/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryms;

import javax.swing.*;

/**
 *
 * @author USER
 */
public class librarianLog extends javax.swing.JFrame {

    /**
     * Creates new form librarianLog
     */
    public librarianLog() {
        initComponents();
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addbook = new javax.swing.JButton();
        studentlist = new javax.swing.JButton();
        borrowedbook = new javax.swing.JButton();
        reservedbook = new javax.swing.JButton();
        returnbook = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(577, 577, 577)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        addbook.setBackground(new java.awt.Color(255, 255, 255));
        addbook.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        addbook.setText("Add Books");
        addbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookActionPerformed(evt);
            }
        });

        studentlist.setBackground(new java.awt.Color(255, 255, 255));
        studentlist.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        studentlist.setText("Student List");
        studentlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentlistActionPerformed(evt);
            }
        });

        borrowedbook.setBackground(new java.awt.Color(255, 255, 255));
        borrowedbook.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        borrowedbook.setText("Borrowed Book");
        borrowedbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowedbookActionPerformed(evt);
            }
        });

        reservedbook.setBackground(new java.awt.Color(255, 255, 255));
        reservedbook.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        reservedbook.setText("Reserved Book");
        reservedbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservedbookActionPerformed(evt);
            }
        });

        returnbook.setBackground(new java.awt.Color(255, 255, 255));
        returnbook.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        returnbook.setText("Returned Books");
        returnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookActionPerformed(evt);
            }
        });

        logout.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LIBRARIAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(700, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(699, 699, 699))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(addbook)
                .addGap(95, 95, 95)
                .addComponent(studentlist)
                .addGap(121, 121, 121)
                .addComponent(borrowedbook)
                .addGap(117, 117, 117)
                .addComponent(reservedbook)
                .addGap(113, 113, 113)
                .addComponent(returnbook)
                .addGap(150, 150, 150))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(814, 814, 814)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentlist)
                    .addComponent(borrowedbook)
                    .addComponent(returnbook)
                    .addComponent(addbook)
                    .addComponent(reservedbook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(90, 90, 90))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(187, 187, 187)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(298, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookActionPerformed
      new returnbooks().setVisible(true);
      
      dispose();
    }//GEN-LAST:event_returnbookActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
      int response = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Confirm Logout",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    // Check the user's response
    if (response == JOptionPane.YES_OPTION) {
        // If 'Yes' is selected, show the login form and close the current form
        new Loginmain().setVisible(true);
        this.dispose(); // Closes the current form
    } else {
        // If 'No' is selected, do nothing (close the dialog)
        JOptionPane.showMessageDialog(this, "Logout cancelled.", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
   
    }//GEN-LAST:event_logoutActionPerformed

    private void studentlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentlistActionPerformed
    new studentList().setVisible(true);
    
    
    dispose();
    }//GEN-LAST:event_studentlistActionPerformed

    private void addbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookActionPerformed
     new booklist().setVisible(true);
     
     dispose();
    }//GEN-LAST:event_addbookActionPerformed

    private void borrowedbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowedbookActionPerformed
        new borrowbooks().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_borrowedbookActionPerformed

    private void reservedbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservedbookActionPerformed
       new reservebooks().setVisible(true);
       
       dispose();
    }//GEN-LAST:event_reservedbookActionPerformed

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
            java.util.logging.Logger.getLogger(librarianLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(librarianLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(librarianLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(librarianLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new librarianLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbook;
    private javax.swing.JButton borrowedbook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logout;
    private javax.swing.JButton reservedbook;
    private javax.swing.JButton returnbook;
    private javax.swing.JButton studentlist;
    // End of variables declaration//GEN-END:variables
}
