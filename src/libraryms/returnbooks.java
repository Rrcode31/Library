/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;        
import java.sql.DriverManager;       
import java.sql.PreparedStatement;  
import java.sql.Statement;           
import java.sql.ResultSet;            
import java.sql.SQLException;        
import java.sql.Date;                
import java.sql.Time;                
import java.sql.Timestamp;           
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Statement;
import java.util.logging.*;
import javax.swing.table.TableRowSorter;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class returnbooks extends javax.swing.JFrame {
    
    Connection conn = null;
    
     private static final String DB_URL = "jdbc:mysql://localhost:3306/librarysystem";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "Cuevas0731";

    private Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public returnbooks() {
        initComponents();
        loadReturnList();
        
    }

   private void loadReturnList() {
    // Create the table model to hold the column names and data
    DefaultTableModel model = (DefaultTableModel) returnlist.getModel();

    // Clear any existing rows in the table before loading new data
    model.setRowCount(0);

    // Query to fetch reservation data from the database
    String query = "SELECT * FROM book_return"; // Replace with your actual query to fetch reserved books

    try (Connection conn = getDatabaseConnection();  // Assume you have a method to get DB connection
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        // Iterate through the result set and add each row to the table
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("member_id"),           
                rs.getString("first_name"),           
                rs.getString("middle_initial"),          
                rs.getString("last_name"),            
                rs.getInt("book_id"),                
                rs.getString("title"),   
                rs.getDate("return_date"),         
                rs.getInt("copies_borrowed")
            });
        }
    } catch (SQLException e) {
        // Handle any SQL exceptions (errors) that occur during query execution
        JOptionPane.showMessageDialog(this, "Error loading reserve data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        returnlist = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        studentId = new javax.swing.JTextField();
        bookid = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        returndate = new com.toedter.calendar.JDateChooser();
        copies = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Library Management System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(255, 255, 255))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        jLabel3.setText("Return Book");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        returnlist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        returnlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Member Id", "First name", "Middle Initial", "Last Name", "Book Id", "Title ", "Return date", "Copies"
            }
        ));
        returnlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(returnlist);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        jLabel11.setText("Search returned book");

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setText("Student Id");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setText("Book Id:");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setText("Title:");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setText("return date:");

        jLabel10.setText("Copies:");

        studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdActionPerformed(evt);
            }
        });

        bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookidActionPerformed(evt);
            }
        });

        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        copies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiesActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        refresh.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel12.setText("First name");

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel13.setText("Middle Initial");

        middlename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middlenameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel14.setText("Last name");

        delete.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(copies, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submit)
                        .addGap(18, 18, 18)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(back))
                    .addComponent(middlename)
                    .addComponent(firstname)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refresh))
                    .addComponent(studentId)
                    .addComponent(bookid)
                    .addComponent(lastname)
                    .addComponent(title)
                    .addComponent(returndate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(refresh)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returndate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copies, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit)
                    .addComponent(back)
                    .addComponent(clear))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search)
                        .addGap(35, 35, 35))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
                                     
    String searchKeyword = searchbox.getText().trim(); // Get text from the search box
    
    if (searchKeyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a keyword to search.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Clear the table before displaying new search results
    DefaultTableModel model = (DefaultTableModel) returnlist.getModel();
    model.setRowCount(0); // Remove any previous rows
    
    // Perform the search query
    try (Connection conn = getDatabaseConnection()) {
        // SQL query to search for returned books based on the keyword (e.g., by title, member name, etc.)
        String searchQuery = "SELECT * FROM book_return WHERE title LIKE ? OR first_name LIKE ? OR last_name LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(searchQuery);
        String searchPattern = "%" + searchKeyword + "%"; // Add wildcard for LIKE query
        
        // Set parameters for the LIKE queries
        stmt.setString(1, searchPattern);
        stmt.setString(2, searchPattern);
        stmt.setString(3, searchPattern);
        
        ResultSet rs = stmt.executeQuery();
        
        // Loop through the results and add them to the JTable
        while (rs.next()) {
            String memberId = rs.getString("member_id");
            String firstName = rs.getString("first_name");
            String middleInitial = rs.getString("middle_initial");
            String lastName = rs.getString("last_name");
            String bookId = rs.getString("book_id");
            String title = rs.getString("title");
            Date returnDate = rs.getDate("return_date");
            int copiesBorrowed = rs.getInt("copies_borrowed");
            
            // Add each row to the table
            model.addRow(new Object[] {memberId, firstName, middleInitial, lastName, bookId, title, returnDate, copiesBorrowed});
        }
        
        // If no results found
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No books found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_searchActionPerformed

    private void studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdActionPerformed

    private void bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookidActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void copiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copiesActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
// Get the input values from text fields and date chooser
String studentid = studentId.getText().trim();
String firstName = firstname.getText().trim();
String middleName = middlename.getText().trim();
String lastName = lastname.getText().trim();
String bookId = bookid.getText().trim();
String titlee = title.getText().trim();
java.util.Date returnDate = returndate.getDate();
int copiesReturned;

// Input validation
if (studentid.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() ||
    bookId.isEmpty() || titlee.isEmpty() || returnDate == null) {
    JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    copiesReturned = Integer.parseInt(copies.getText().trim());
    if (copiesReturned <= 0) {
        JOptionPane.showMessageDialog(this, "Copies returned must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Copies must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try (Connection conn = getDatabaseConnection()) {
    // Start a transaction to ensure all queries happen atomically
    conn.setAutoCommit(false);

    // 1️⃣ Insert the returned book into the `book_return` table
    String insertReturnQuery = "INSERT INTO book_return (member_id, first_name, middle_initial, last_name, book_id, title, return_date, copies_borrowed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement insertReturnStmt = conn.prepareStatement(insertReturnQuery)) {
        insertReturnStmt.setString(1, studentid);
        insertReturnStmt.setString(2, firstName);
        insertReturnStmt.setString(3, middleName);
        insertReturnStmt.setString(4, lastName);
        insertReturnStmt.setString(5, bookId);
        insertReturnStmt.setString(6, titlee);

        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());
        insertReturnStmt.setDate(7, sqlReturnDate);
        insertReturnStmt.setInt(8, copiesReturned);

        int rowsInserted = insertReturnStmt.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Book return recorded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to record the book return.", "Error", JOptionPane.ERROR_MESSAGE);
            conn.rollback();
            return;
        }
    }

    // 2️⃣ Check current copies borrowed before updating
    String checkCopiesQuery = "SELECT copies_borrowed FROM book_borrow WHERE member_id = ? AND book_id = ?";
    try (PreparedStatement checkCopiesStmt = conn.prepareStatement(checkCopiesQuery)) {
        checkCopiesStmt.setString(1, studentid);
        checkCopiesStmt.setString(2, bookId);
        
        ResultSet rs = checkCopiesStmt.executeQuery();
        if (rs.next()) {
            int currentCopiesBorrowed = rs.getInt("copies_borrowed");
            int newCopiesBorrowed = currentCopiesBorrowed - copiesReturned;

            if (newCopiesBorrowed > 0) {
                // Update the `book_borrow` table
                String updateBorrowQuery = "UPDATE book_borrow SET copies_borrowed = ? WHERE member_id = ? AND book_id = ?";
                try (PreparedStatement updateBorrowStmt = conn.prepareStatement(updateBorrowQuery)) {
                    updateBorrowStmt.setInt(1, newCopiesBorrowed);
                    updateBorrowStmt.setString(2, studentid);
                    updateBorrowStmt.setString(3, bookId);
                    updateBorrowStmt.executeUpdate();
                }
            } else {
                // Delete the row if no more copies are borrowed
                String deleteIfZeroQuery = "DELETE FROM book_borrow WHERE member_id = ? AND book_id = ?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteIfZeroQuery)) {
                    deleteStmt.setString(1, studentid);
                    deleteStmt.setString(2, bookId);
                    deleteStmt.executeUpdate();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No borrow record found for this student and book.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 3️⃣ Update the number of available copies in the `books` table
    String updateBookCopiesQuery = "UPDATE books SET copies = copies + ? WHERE book_id = ?";
    try (PreparedStatement updateBookCopiesStmt = conn.prepareStatement(updateBookCopiesQuery)) {
        updateBookCopiesStmt.setInt(1, copiesReturned);  // Increment the copies in the Books table
        updateBookCopiesStmt.setString(2, bookId);
        int rowsUpdated = updateBookCopiesStmt.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Book copies updated successfully in the inventory.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update book copies in the inventory.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 4️⃣ Commit the transaction
    conn.commit();

    // 5️⃣ Reload the updated return list in the table
    loadReturnList();

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    try {
        conn.rollback();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error rolling back transaction: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_submitActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
                                  
    // Clear the current rows in the returnlist table
    DefaultTableModel model = (DefaultTableModel) returnlist.getModel();
    model.setRowCount(0);  // This removes all rows in the table
    
    // Reload the return list data from the database
    loadReturnList();  // This method should fetch data from the book_return table and populate the table
    
    // Show a message that the table has been refreshed
    JOptionPane.showMessageDialog(this, "The return book list has been refreshed.", "Refresh Successful", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_refreshActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new librarianLog().setVisible(true);

        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void middlenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middlenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

    int[] selectedRows = returnlist.getSelectedRows();
    
    if (selectedRows.length == 0) {
        // If no rows are selected, show a message
        JOptionPane.showMessageDialog(this, "Please select rows to delete.", "No Rows Selected", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Confirm deletion
    int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected records?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    
    if (confirmation == JOptionPane.YES_OPTION) {
        try (Connection conn = getDatabaseConnection()) {
            // Prepare a SQL query for deleting records from the book_return table
            String deleteQuery = "DELETE FROM book_return WHERE member_id = ? AND book_id = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);

            // Loop through the selected rows and delete from the table and database
            for (int i = 0; i < selectedRows.length; i++) {
                int row = selectedRows[i];

                // Get values from the selected row to delete the corresponding record from the database
                String studentIdValue = returnlist.getValueAt(row, 0).toString(); // studentId from column 0
                String bookIdValue = returnlist.getValueAt(row, 4).toString(); // bookId from column 4

                // Set parameters for the delete query
                deleteStmt.setString(1, studentIdValue);
                deleteStmt.setString(2, bookIdValue);
                deleteStmt.executeUpdate(); // Execute the delete query
            }

            // Now, remove the rows from the table (we need to remove from the end to avoid index shift)
            DefaultTableModel model = (DefaultTableModel) returnlist.getModel();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
            }

            // Optionally, refresh the table or show a success message
            JOptionPane.showMessageDialog(this, "Selected records have been deleted successfully.", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting records: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
                                  
    // Clear all JTextFields
    studentId.setText("");
    firstname.setText("");
    middlename.setText("");
    lastname.setText("");
    bookid.setText("");
    title.setText("");
    copies.setText("");
    
    // Clear JDateChooser (set to null)
    returndate.setDate(null);
    
    // Optionally, display a confirmation message
    JOptionPane.showMessageDialog(this, "All input fields have been cleared.", "Clear Fields", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_clearActionPerformed

    private void returnlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnlistMouseClicked
   
int selectedRow = returnlist.getSelectedRow();

if (selectedRow != -1) { // Check if a row is selected
    // Retrieve data from the selected row (use the correct column indexes)
    String studentIdValue = returnlist.getValueAt(selectedRow, 0).toString();  // Assuming column 0 is studentId
    String firstNameValue = returnlist.getValueAt(selectedRow, 1).toString();  // Assuming column 1 is firstName
    String middleNameValue = returnlist.getValueAt(selectedRow, 2).toString(); // Assuming column 2 is middleName
    String lastNameValue = returnlist.getValueAt(selectedRow, 3).toString();   // Assuming column 3 is lastName
    String bookIdValue = returnlist.getValueAt(selectedRow, 4).toString();     // Assuming column 4 is bookId
    String titleValue = returnlist.getValueAt(selectedRow, 5).toString();      // Assuming column 5 is title
    String copiesReturnedValue = returnlist.getValueAt(selectedRow, 7).toString(); // Assuming column 6 is copies returned

    // Set values in the input fields
    studentId.setText(studentIdValue);
    firstname.setText(firstNameValue);
    middlename.setText(middleNameValue);
    lastname.setText(lastNameValue);
    bookid.setText(bookIdValue);
    title.setText(titleValue);
    
    // Optionally, set the return date from the table (if the return date column exists)
    String returnDateValue = returnlist.getValueAt(selectedRow, 6).toString(); // Assuming column 7 is returnDate
    try {
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(returnDateValue);
        returndate.setDate(date); // Set the date in JDateChooser
    } catch (ParseException e) {
        e.printStackTrace();
    }

    copies.setText(copiesReturnedValue);
}

    }//GEN-LAST:event_returnlistMouseClicked

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
            java.util.logging.Logger.getLogger(returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField bookid;
    private javax.swing.JButton clear;
    private javax.swing.JTextField copies;
    private javax.swing.JButton delete;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JButton refresh;
    private com.toedter.calendar.JDateChooser returndate;
    private javax.swing.JTable returnlist;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField studentId;
    private javax.swing.JButton submit;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
