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

public class borrowbooks extends javax.swing.JFrame {
    
    ResultSet rs = null;
    
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

    
    public borrowbooks() {
        initComponents();
        loadBookList();
    }
    
    private void loadBookList() {
    try (Connection conn = getDatabaseConnection()) {
        String query = "SELECT * FROM book_borrow";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) booklist.getModel();
        model.setRowCount(0); // Clear existing rows

        while (rs.next()) {
            Object[] row = new Object[9];
            row[0] = rs.getString("member_id");
            row[1] = rs.getString("first_name");
            row[2] = rs.getString("middle_initial");
            row[3] = rs.getString("last_name");
            row[4] = rs.getInt("book_id");
            row[5] = rs.getString("title");
            row[6] = rs.getDate("borrow_date");
            row[7] = rs.getDate("return_date");
            row[8] = rs.getInt("copies_borrowed");

            model.addRow(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading book list: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        borrowdate = new com.toedter.calendar.JDateChooser();
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
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        borrowlist = new javax.swing.JScrollPane();
        booklist = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        search = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setText("Student Id");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel6.setText("Book Id:");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel7.setText("Title:");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setText("Borrow date:");

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setText("Return date:");

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

        edit.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

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
                    .addComponent(returndate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(middlename)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(copies, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submit)
                        .addGap(26, 26, 26)
                        .addComponent(refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(edit))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addComponent(jLabel4)
                                .addComponent(studentId)
                                .addComponent(jLabel8)
                                .addComponent(bookid)
                                .addComponent(jLabel6)
                                .addComponent(lastname)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(title)
                                .addComponent(borrowdate, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
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
                .addComponent(borrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returndate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copies, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit)
                    .addComponent(refresh)
                    .addComponent(edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(delete)
                    .addComponent(clear))
                .addGap(11, 11, 11))
        );

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        jLabel3.setText("Borrow Book");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        booklist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        booklist.setModel(new javax.swing.table.DefaultTableModel(
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
                "Studernt Id", "First name", "Middle Initial", "Last name", "Book Id", "Title", "Borrow date", "Return date", "copies"
            }
        ));
        booklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booklistMouseClicked(evt);
            }
        });
        borrowlist.setViewportView(booklist);

        jScrollPane3.setViewportView(borrowlist);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        jLabel11.setText("Search borrower");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(104, 104, 104)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(search)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                     
    String studentid = studentId.getText().trim();
    String firstName = firstname.getText().trim();
    String middleName = middlename.getText().trim();
    String lastName = lastname.getText().trim();
    String bookId = bookid.getText().trim();
    String titlee = title.getText().trim();
    int copiesBorrowed;
    java.util.Date borrowDate = borrowdate.getDate();
    java.util.Date returnDate = returndate.getDate();

    // Validate inputs
    if (studentid.isEmpty() || 
        firstName.isEmpty() || 
        middleName.isEmpty() || 
        lastName.isEmpty() || 
        bookId.isEmpty() || 
        titlee.isEmpty() || 
        borrowDate == null || 
        returnDate == null) 
    {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        copiesBorrowed = Integer.parseInt(copies.getText().trim());
        if (copiesBorrowed <= 0) {
            JOptionPane.showMessageDialog(this, "Copies borrowed must be a positive integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Copies must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
        
        // Check if there are enough copies of the book available
        String checkCopiesQuery = "SELECT copies FROM books WHERE book_id = ?";
        PreparedStatement checkCopiesStmt = conn.prepareStatement(checkCopiesQuery);
        checkCopiesStmt.setString(1, bookId);
        ResultSet rs = checkCopiesStmt.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Book not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int availableCopies = rs.getInt("copies");

        if (copiesBorrowed > availableCopies) {
            JOptionPane.showMessageDialog(this, "Not enough copies available. Only " + availableCopies + " copies left.", "Availability Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert borrow details into book_borrow table
        String insertBorrowQuery = "INSERT INTO book_borrow (member_id, first_name, middle_initial, last_name, book_id, title, borrow_date, return_date, copies_borrowed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertBorrowStmt = conn.prepareStatement(insertBorrowQuery);
        insertBorrowStmt.setString(1, studentid);
        insertBorrowStmt.setString(2, firstName);
        insertBorrowStmt.setString(3, middleName);
        insertBorrowStmt.setString(4, lastName);
        insertBorrowStmt.setString(5, bookId);
        insertBorrowStmt.setString(6, titlee);

        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlBorrowDate = new java.sql.Date(borrowDate.getTime());
        java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());
        
        insertBorrowStmt.setDate(7, sqlBorrowDate);
        insertBorrowStmt.setDate(8, sqlReturnDate);
        insertBorrowStmt.setInt(9, copiesBorrowed);

        int rowsInserted = insertBorrowStmt.executeUpdate();

        if (rowsInserted > 0) {
            
           // Subtract copies from the books table
String updateCopiesQuery = "UPDATE books SET copies = copies - ? WHERE book_id = ?";
PreparedStatement updateCopiesStmt = conn.prepareStatement(updateCopiesQuery);
updateCopiesStmt.setInt(1, copiesBorrowed);
updateCopiesStmt.setString(2, bookId);
int rowsUpdated = updateCopiesStmt.executeUpdate();

// Check if the number of copies for the book is now zero or less
         String checkAvailabilityQuery = "SELECT copies FROM books WHERE book_id = ?";
       PreparedStatement checkAvailabilityStmt = conn.prepareStatement(checkAvailabilityQuery);
      checkAvailabilityStmt.setString(1, bookId);
       rs = checkAvailabilityStmt.executeQuery();

if (rs.next()) {
    int remainingCopies = rs.getInt("copies");

    // If no copies are left, update the availability to false
    if (remainingCopies <= 0) {
        String updateAvailabilityQuery = "UPDATE books SET availability = FALSE WHERE book_id = ?";
        PreparedStatement updateAvailabilityStmt = conn.prepareStatement(updateAvailabilityQuery);
        updateAvailabilityStmt.setString(1, bookId);
        updateAvailabilityStmt.executeUpdate();
    }
}



            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Book borrowed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Refresh the booklist table
                loadBookList();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update the book list.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to borrow the book.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_submitActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
                                   
    try (Connection conn = getDatabaseConnection()) {
        // SQL query to fetch all borrow records from the book_borrow table
        String query = "SELECT * FROM book_borrow";

        // Prepare and execute the statement
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        // Get the table model for the borrow list table
        DefaultTableModel model = (DefaultTableModel) booklist.getModel();

        // Clear existing rows in the table
        model.setRowCount(0);

        // Populate the table with the fetched data
        while (rs.next()) {
            Object[] row = new Object[9]; // Assuming 9 columns in the book_borrow table
            row[0] = rs.getString("member_id"); // student ID
            row[1] = rs.getString("first_name");
            row[2] = rs.getString("middle_initial");
            row[3] = rs.getString("last_name");
            row[4] = rs.getInt("book_id");
            row[5] = rs.getString("title");
            row[6] = rs.getDate("borrow_date");
            row[7] = rs.getDate("return_date");
            row[8] = rs.getInt("copies_borrowed");

            // Add row to the table model
            model.addRow(row);
        }

        // Show a success message if rows are loaded
        JOptionPane.showMessageDialog(this, "Borrow list refreshed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error refreshing borrow list: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_refreshActionPerformed

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
                                   
    // Get the search query from the searchbox
    String searchQuery = searchbox.getText().trim();

    // Check if the search query is empty
    if (searchQuery.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search query.", "Search Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
        // SQL query to search for borrowed books based on search criteria
        String query = "SELECT * FROM book_borrow WHERE member_id LIKE ? OR first_name LIKE ? OR middle_initial LIKE ? OR last_name LIKE ? OR book_id LIKE ? OR title LIKE ?";

        // Prepare the statement and set parameters for the query
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchQuery + "%"); // Search member_id
        pstmt.setString(2, "%" + searchQuery + "%"); // Search first_name
        pstmt.setString(3, "%" + searchQuery + "%"); // Search middle_initial
        pstmt.setString(4, "%" + searchQuery + "%"); // Search last_name
        pstmt.setString(5, "%" + searchQuery + "%"); // Search book_id
        pstmt.setString(6, "%" + searchQuery + "%"); // Search title

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Get the table model for the booklist table
        DefaultTableModel model = (DefaultTableModel) booklist.getModel();

        // Clear existing rows in the table
        model.setRowCount(0);

        // Populate the table with the fetched data
        while (rs.next()) {
            Object[] row = new Object[9]; // 9 columns as per the data structure
            row[0] = rs.getString("member_id"); // student ID
            row[1] = rs.getString("first_name");
            row[2] = rs.getString("middle_initial");
            row[3] = rs.getString("last_name");
            row[4] = rs.getInt("book_id");
            row[5] = rs.getString("title");
            row[6] = rs.getDate("borrow_date");
            row[7] = rs.getDate("return_date");
            row[8] = rs.getInt("copies_borrowed");

            model.addRow(row); // Add row to the table model
        }

        // Check if no books were found
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No borrowed books found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error searching borrowed books: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_searchActionPerformed

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

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
                                    
    // Retrieve updated values from the input fields
    String memberId = studentId.getText().trim();
    String firstName = firstname.getText().trim();
    String middleInitial = middlename.getText().trim();
    String lastName = lastname.getText().trim();
    String bookId = bookid.getText().trim();
    String titlee = title.getText().trim();
    java.util.Date borrowDate = borrowdate.getDate(); // Assuming borrowdate is a JDateChooser
    java.util.Date returnDate = returndate.getDate(); // Assuming returndate is a JDateChooser
    String copiesBorrowedStr = copies.getText().trim();
    
    // Validate that all required fields are filled in
    if (memberId.isEmpty() || firstName.isEmpty() || middleInitial.isEmpty() || lastName.isEmpty() || bookId.isEmpty() || titlee.isEmpty() || borrowDate == null || returnDate == null || copiesBorrowedStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int copiesBorrowed = Integer.parseInt(copiesBorrowedStr); // Parse the number of copies borrowed

    // SQL query to update the borrow record
    String query = "UPDATE book_borrow SET first_name = ?, middle_initial = ?, last_name = ?, book_id = ?, title = ?, borrow_date = ?, return_date = ?, copies_borrowed = ? WHERE member_id = ? AND book_id = ?";

    try (Connection conn = getDatabaseConnection()) {
        // Prepare the SQL statement
        PreparedStatement pstmt = conn.prepareStatement(query);

        // Set the values for the update query
        pstmt.setString(1, firstName);
        pstmt.setString(2, middleInitial);
        pstmt.setString(3, lastName);
        pstmt.setInt(4, Integer.parseInt(bookId));  // Ensure bookId is integer
        pstmt.setString(5, titlee);
        pstmt.setDate(6, new java.sql.Date(borrowDate.getTime()));  // Convert java.util.Date to java.sql.Date
        pstmt.setDate(7, new java.sql.Date(returnDate.getTime()));  // Convert java.util.Date to java.sql.Date
        pstmt.setInt(8, copiesBorrowed);
        pstmt.setString(9, memberId);  // For specific student
        pstmt.setInt(10, Integer.parseInt(bookId));  // For specific book

        // Execute the update query
        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Record updated successfully.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No matching record found to update.", "Update Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error updating borrow record: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_editActionPerformed

    private void booklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booklistMouseClicked

    // Get the selected row index
    int selectedRow = booklist.getSelectedRow();

    // Check if no row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row with data.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        return; // Exit if no row is selected
    }

    // Ensure the selected row contains valid data (e.g., check if the first cell is not null)
    if (booklist.getValueAt(selectedRow, 0) == null) {
        JOptionPane.showMessageDialog(this, "The selected row is empty. Please select a valid row.", "Invalid Row", JOptionPane.WARNING_MESSAGE);
        return; // Exit if the selected row is empty
    }

    // Proceed to retrieve the data from the selected row
    try {
        String memberId = booklist.getValueAt(selectedRow, 0).toString(); // student ID
        String firstName = booklist.getValueAt(selectedRow, 1).toString();
        String middleInitial = booklist.getValueAt(selectedRow, 2).toString();
        String lastName = booklist.getValueAt(selectedRow, 3).toString();
        String bookId = booklist.getValueAt(selectedRow, 4).toString();
        String titlee = booklist.getValueAt(selectedRow, 5).toString();
        Date borrowDate = (Date) booklist.getValueAt(selectedRow, 6); // Borrow Date
        Date returnDate = (Date) booklist.getValueAt(selectedRow, 7); // Return Date
        int copiesBorrowed = Integer.parseInt(booklist.getValueAt(selectedRow, 8).toString());

        // Set the data into corresponding text fields or labels
        studentId.setText(memberId);
        firstname.setText(firstName);
        middlename.setText(middleInitial);
        lastname.setText(lastName);
        bookid.setText(bookId);
        title.setText(titlee);
        borrowdate.setDate(borrowDate); // Assuming borrowdate is a JDateChooser
        returndate.setDate(returnDate); // Assuming returndate is a JDateChooser
        copies.setText(String.valueOf(copiesBorrowed)); // Assuming copies is a JTextField

    } catch (Exception e) {
        // If there’s an error, show a message
        JOptionPane.showMessageDialog(this, "Error while retrieving row data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Log the stack trace for debugging
    }
    }//GEN-LAST:event_booklistMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
                                       
    // Get the selected row index from the booklist table
    int selectedRow = booklist.getSelectedRow();

    // Check if a row is selected
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Delete Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ask for confirmation before deletion
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this record?", 
        "Confirm Delete", 
        JOptionPane.YES_NO_OPTION);
    
    // If user clicks "No", cancel the deletion
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        // Get the book_id from the selected row
        DefaultTableModel model = (DefaultTableModel) booklist.getModel();
        int bookId = Integer.parseInt(model.getValueAt(selectedRow, 4).toString()); // Assuming book_id is in column 4 (adjust as necessary)

        // Remove the book from the database
        try (Connection conn = getDatabaseConnection()) {
            String deleteQuery = "DELETE FROM book_borrow WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, bookId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Remove the row from the table after successful deletion from the database
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Book record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: No record found to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid book ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
                                    
    // Clear all the text fields
    studentId.setText(""); 
    firstname.setText(""); 
    middlename.setText(""); 
    lastname.setText(""); 
    bookid.setText(""); 
    title.setText(""); 
    copies.setText(""); 

    // Clear the date pickers (if you're using JDateChooser)
    borrowdate.setDate(null); 
    returndate.setDate(null); 
    
    // Optionally, reset the focus to the first field
    studentId.requestFocus(); 

    }//GEN-LAST:event_clearActionPerformed

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
            java.util.logging.Logger.getLogger(borrowbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(borrowbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(borrowbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(borrowbooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new borrowbooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField bookid;
    private javax.swing.JTable booklist;
    private com.toedter.calendar.JDateChooser borrowdate;
    private javax.swing.JScrollPane borrowlist;
    private javax.swing.JButton clear;
    private javax.swing.JTextField copies;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JButton refresh;
    private com.toedter.calendar.JDateChooser returndate;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField studentId;
    private javax.swing.JButton submit;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
