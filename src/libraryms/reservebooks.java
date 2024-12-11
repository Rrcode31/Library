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


public class reservebooks extends javax.swing.JFrame {
    
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

   
    public reservebooks() {
        initComponents();
        loadReserveList();
        convertReservationsToBorrowBooks();
    }
    
    private void loadReserveList() {
    // Create the table model to hold the column names and data
    DefaultTableModel model = (DefaultTableModel) reservelist.getModel();

    // Clear any existing rows in the table before loading new data
    model.setRowCount(0);

    // Query to fetch reservation data from the database
    String query = "SELECT * FROM book_reserve"; // Replace with your actual query to fetch reserved books

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
                rs.getDate("reserve_date"),         
                rs.getDate("borrow_date"),
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservelist = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        studentId = new javax.swing.JTextField();
        bookid = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        Reservedate = new com.toedter.calendar.JDateChooser();
        borrowdate = new com.toedter.calendar.JDateChooser();
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
        jLabel3.setText("Reserve Book");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        reservelist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reservelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "student Id ", "Firstname", "Middles Initail", "Last name", "Book id", "Title", "reserve date", "Borrow date", "copies"
            }
        ));
        reservelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservelistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(reservelist);

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
        jLabel11.setText("Search reserved book");

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
        jLabel8.setText("Reserve date:");

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setText("Borrow date:");

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
                    .addComponent(borrowdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(Reservedate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
                .addComponent(Reservedate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    String searchTerm = searchbox.getText().trim();
    
    // Validate input - check if the search term is not empty
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Clear the current rows in the table before loading search results
    DefaultTableModel model = (DefaultTableModel) reservelist.getModel();
    model.setRowCount(0); // Clears the table
    
    // Connect to the database and perform the search query
    try (Connection conn = getDatabaseConnection()) {
        // Prepare the search query
        String searchQuery = "SELECT * FROM book_reserve WHERE first_name LIKE ? OR last_name LIKE ? OR title LIKE ?";
        
        // Prepare the statement
        PreparedStatement stmt = conn.prepareStatement(searchQuery);
        stmt.setString(1, "%" + searchTerm + "%");
        stmt.setString(2, "%" + searchTerm + "%");
        stmt.setString(3, "%" + searchTerm + "%");

        // Execute the query
        ResultSet rs = stmt.executeQuery();
        
        boolean foundResults = false;  // Flag to check if any results are found
        
        // Add the search results to the table
        while (rs.next()) {
            String studentId = rs.getString("member_id");
            String firstName = rs.getString("first_name");
            String middleName = rs.getString("middle_initial");
            String lastName = rs.getString("last_name");
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            Date reservedDate = rs.getDate("reserved_date");
            Date borrowDate = rs.getDate("borrow_date");
            int copiesReserved = rs.getInt("copies_borrowed");
            
            // Add the row to the table model
            model.addRow(new Object[] { studentId, firstName, middleName, lastName, bookId, title, reservedDate, borrowDate, copiesReserved });
            foundResults = true;
        }
        
        // If no results are found, show an error message
        if (!foundResults) {
            JOptionPane.showMessageDialog(this, "No matching records found in the reserve list.", "Search Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error searching reserve list: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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

    // Get values from input fields
    String studentid = studentId.getText().trim();
    String firstName = firstname.getText().trim();
    String middleName = middlename.getText().trim();
    String lastName = lastname.getText().trim();
    String bookId = bookid.getText().trim();
    String titlee = title.getText().trim();
    java.util.Date reservedDate = Reservedate.getDate();
    java.util.Date borrowDate = borrowdate.getDate();
    int copiesReserved;

    // Validate inputs
    if (studentid.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() ||
        bookId.isEmpty() || titlee.isEmpty() || reservedDate == null || borrowDate == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        copiesReserved = Integer.parseInt(copies.getText().trim());
        if (copiesReserved <= 0) {
            JOptionPane.showMessageDialog(this, "Copies reserved must be a positive integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Copies must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
        // Check if the book is available for reservation (not borrowed)
        String checkAvailabilityQuery = "SELECT copies FROM books WHERE book_id = ? AND copies > 0";
        PreparedStatement checkAvailabilityStmt = conn.prepareStatement(checkAvailabilityQuery);
        checkAvailabilityStmt.setString(1, bookId);
        ResultSet rs = checkAvailabilityStmt.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Book is not available for reservation.", "Book Unavailable", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert reservation details into the book_reservation table
        String insertReservationQuery = "INSERT INTO book_reserve (member_id, first_name, middle_initial, last_name, book_id, title,reserve_date, borrow_date, copies_borrowed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertReservationStmt = conn.prepareStatement(insertReservationQuery);
        insertReservationStmt.setString(1, studentid);
        insertReservationStmt.setString(2, firstName);
        insertReservationStmt.setString(3, middleName);
        insertReservationStmt.setString(4, lastName);
        insertReservationStmt.setString(5, bookId);
        insertReservationStmt.setString(6, titlee);

        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlReservedDate = new java.sql.Date(reservedDate.getTime());
        java.sql.Date sqlBorrowDate = new java.sql.Date(borrowDate.getTime());

        insertReservationStmt.setDate(7, sqlReservedDate);
        insertReservationStmt.setDate(8, sqlBorrowDate);
        insertReservationStmt.setInt(9, copiesReserved);

        int rowsInserted = insertReservationStmt.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Book reserved successfully!", "Reservation Success", JOptionPane.INFORMATION_MESSAGE);
             loadReserveList();
             
        } else {
            JOptionPane.showMessageDialog(this, "Failed to reserve the book.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_submitActionPerformed
public void convertReservationsToBorrowBooks() {
    String checkReservationsQuery = "SELECT * FROM book_reserve WHERE borrow_date <= NOW()";

    try (Connection conn = getDatabaseConnection()) {
        PreparedStatement stmt = conn.prepareStatement(checkReservationsQuery);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String studentId = rs.getString("member_id");
            String firstName = rs.getString("first_name");
            String middleName = rs.getString("middle_initial");
            String lastName = rs.getString("last_name");
            int bookId = rs.getInt("book_id");
            String title = rs.getString("title");
            Date borrowDate = rs.getDate("borrow_date");
            int copiesReserved = rs.getInt("copies_borrowed");

            // Calculate the return date (5 days after borrow date)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(borrowDate);
            calendar.add(Calendar.DAY_OF_MONTH, 5);  // Add 5 days to the borrow date
            Date returnDate = new Date(calendar.getTimeInMillis());

            // Add to book_borrow table
            String insertBorrowQuery = "INSERT INTO book_borrow (member_id, first_name, middle_initial, last_name, book_id, title, borrow_date, return_date, copies_borrowed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertBorrowStmt = conn.prepareStatement(insertBorrowQuery);
            insertBorrowStmt.setString(1, studentId);
            insertBorrowStmt.setString(2, firstName);
            insertBorrowStmt.setString(3, middleName);
            insertBorrowStmt.setString(4, lastName);
            insertBorrowStmt.setInt(5, bookId);
            insertBorrowStmt.setString(6, title);
            insertBorrowStmt.setDate(7, borrowDate);  // Borrow date from reservation
            insertBorrowStmt.setDate(8, returnDate); // Automatically set return date (5 days later)
            insertBorrowStmt.setInt(9, copiesReserved);

            int borrowRowsInserted = insertBorrowStmt.executeUpdate();

            if (borrowRowsInserted > 0) {
                // Optionally, remove the reservation once it's converted
                String deleteReservationQuery = "DELETE FROM book_reserve WHERE member_id = ? AND book_id = ?";
                PreparedStatement deleteReservationStmt = conn.prepareStatement(deleteReservationQuery);
                deleteReservationStmt.setString(1, studentId);
                deleteReservationStmt.setInt(2, bookId);
                int deletedRows = deleteReservationStmt.executeUpdate();
                
                if (deletedRows > 0) {
                    System.out.println("Successfully deleted reservation for member_id: " + studentId + ", book_id: " + bookId);
                } else {
                    System.out.println("No reservation found to delete for member_id: " + studentId + ", book_id: " + bookId);
                }
            }
        }

        // Refresh the reserve list to reflect the changes
        loadReserveList();

    } catch (SQLException e) {
        System.out.println("Error converting reservations to borrow: " + e.getMessage());
    }
}

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
                                    
    // Clear the current rows in the reserve list table
    DefaultTableModel model = (DefaultTableModel) reservelist.getModel();
    model.setRowCount(0);  // This removes all rows in the table
    
    // Now, reload the reserve list from the database
    loadReserveList();  // This method will fetch data from the database and populate the table

    // Show a message that the table has been refreshed
    JOptionPane.showMessageDialog(this, "Reserve list has been refreshed.", "Table Refreshed", JOptionPane.INFORMATION_MESSAGE);

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
                                     
    // Get the selected row from the reserve list table
    int rowIndex = reservelist.getSelectedRow();
    
    // Check if a valid row is selected
    if (rowIndex != -1) {
        // Get the student ID and book ID from the selected row
        String studentId = reservelist.getValueAt(rowIndex, 0).toString();  // Assuming student ID is in the first column
        int bookId = Integer.parseInt(reservelist.getValueAt(rowIndex, 4).toString()); // Assuming book ID is in the fifth column
        
        // Confirm deletion with the user
        int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this reservation?", 
                "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (confirmation == JOptionPane.YES_OPTION) {
            try (Connection conn = getDatabaseConnection()) {
                // Prepare SQL query to delete the reservation from the database
                String deleteQuery = "DELETE FROM book_reserve WHERE member_id = ? AND book_id = ?";
                PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
                deleteStmt.setString(1, studentId);
                deleteStmt.setInt(2, bookId);
                
                // Execute the deletion query
                int rowsDeleted = deleteStmt.executeUpdate();
                
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Reservation deleted successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Optionally, remove the deleted row from the table view
                    ((DefaultTableModel) reservelist.getModel()).removeRow(rowIndex);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete the reservation.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a reservation to delete.", 
            "No Selection", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
                                 
    studentId.setText("");   // Clear student ID field
    firstname.setText("");   // Clear first name field
    middlename.setText("");  // Clear middle name field
    lastname.setText("");    // Clear last name field
    bookid.setText("");      // Clear book ID field
    title.setText("");       // Clear title field
    copies.setText("");      // Clear copies field

    // Clear JDateChooser (reserve date and borrow date)
    Reservedate.setDate(null);  // Clear reserve date
    borrowdate.setDate(null);   // Clear borrow date
    
    // Optionally, reset the focus to the first field (e.g., studentId)
    studentId.requestFocus();   // Set focus back to studentId field

    }//GEN-LAST:event_clearActionPerformed

    private void reservelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservelistMouseClicked

    int rowIndex = reservelist.getSelectedRow();
    
    // Check if a valid row was clicked
    if (rowIndex != -1) {
        // Get data from the clicked row
        String studentIde = reservelist.getValueAt(rowIndex, 0).toString(); // Assuming student ID is in the first column
        String firstName = reservelist.getValueAt(rowIndex, 1).toString();  // Assuming first name is in the second column
        String middleName = reservelist.getValueAt(rowIndex, 2).toString(); // Middle name
        String lastName = reservelist.getValueAt(rowIndex, 3).toString();   // Last name
        String bookId = reservelist.getValueAt(rowIndex, 4).toString();      // Book ID
        String titlee = reservelist.getValueAt(rowIndex, 5).toString();       // Title of the book
        java.util.Date reservedDate = (java.util.Date) reservelist.getValueAt(rowIndex, 6);  // Reserved date (assuming it’s in the 7th column)
        java.util.Date borrowDate = (java.util.Date) reservelist.getValueAt(rowIndex, 7);   // Borrow date (assuming it's in the 8th column)
        int copiesReserved = Integer.parseInt(reservelist.getValueAt(rowIndex, 8).toString()); // Copies reserved (9th column)

        // Now set these values in the appropriate input fields (or process them as needed)
        studentId.setText(studentIde);
        firstname.setText(firstName);
        middlename.setText(middleName);
        lastname.setText(lastName);
        bookid.setText(bookId);
        title.setText(titlee);
        Reservedate.setDate(reservedDate);
        borrowdate.setDate(borrowDate);
        copies.setText(String.valueOf(copiesReserved));
        
        // You can add more code to perform other actions like updating the reservation, deleting, etc.
    }

    }//GEN-LAST:event_reservelistMouseClicked

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
            java.util.logging.Logger.getLogger(reservebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservebooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Reservedate;
    private javax.swing.JButton back;
    private javax.swing.JTextField bookid;
    private com.toedter.calendar.JDateChooser borrowdate;
    private javax.swing.JButton clear;
    private javax.swing.JTextField copies;
    private javax.swing.JButton delete;
    private javax.swing.JTextField firstname;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JButton refresh;
    private javax.swing.JTable reservelist;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField studentId;
    private javax.swing.JButton submit;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
