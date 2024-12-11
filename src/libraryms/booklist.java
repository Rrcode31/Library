/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libraryms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;


public class booklist extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pstmt = null;
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

    public booklist() {
        initComponents();
        loadBookList();
    }
    
    
   private void loadBookList() {

    try {
        // Establish database connection
        conn = getDatabaseConnection();

        // Query to fetch all books
        String query = "SELECT * FROM books";
        pstmt = conn.prepareStatement(query);

        // Execute query and get results
        rs = pstmt.executeQuery();

        // Update booklist (JTable) using rs2xml
        booklist.setModel(DbUtils.resultSetToTableModel(rs));

        // Refresh the UI
        booklist.revalidate();
        booklist.repaint();



    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage(), "Resource Closing Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        booklist = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        avail = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();
        sort = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        bookid = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        copies = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        sort1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        search.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 21)); // NOI18N
        jLabel9.setText("Search Book");

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 3, true));

        booklist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " Book Id", "Title", "Author", "Year Published", "Copies", "Availability"
            }
        ));
        booklist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booklistMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(booklist);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        refresh.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 3));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setText("Book Id:");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setText("Year published:");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel5.setText("Author");

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setText("Title:");

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel7.setText("Copies:");

        save.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel8.setText("Availability:");

        avail.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        avail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable", " " }));
        avail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        sort.setBackground(new java.awt.Color(255, 255, 255));
        sort.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        sort.setText("Sort");
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(204, 0, 51));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookidActionPerformed(evt);
            }
        });

        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });

        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });

        copies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiesActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        sort1.setBackground(new java.awt.Color(255, 255, 255));
        sort1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        sort1.setText("Clear");
        sort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(868, 868, 868))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sort1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(avail, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(copies, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copies, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sort))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(sort1)
                    .addComponent(edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 65)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Library Management System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setText("ADD BOOK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(refresh)
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refresh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       try {
        // Establish database connection
        conn = getDatabaseConnection();

        // Query to fetch all books
        String query = "SELECT * FROM books";
        pstmt = conn.prepareStatement(query);

        // Execute query and get results
        rs = pstmt.executeQuery();

        // Set the table model to display the data from the ResultSet
        booklist.setModel(DbUtils.resultSetToTableModel(rs));

        // Refresh the table UI
        booklist.revalidate();
        booklist.repaint();

        // Optional success message
        JOptionPane.showMessageDialog(this, "Book list refreshed successfully.", "Refresh Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        // Handle SQL errors
        JOptionPane.showMessageDialog(this, "Error refreshing data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage(), "Resource Closing Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_refreshActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
                                       
    // Get the search query from the search box
    String searchQuery = searchbox.getText().trim();

    // Check if the search query is empty
    if (searchQuery.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search query.", "Search Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
      
        String query = "SELECT * FROM books WHERE book_id LIKE ? OR title LIKE ? OR author LIKE ? OR copies LIKE ? OR  year_published  LIKE ?";

        // Prepare the statement and set parameters for the query
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchQuery + "%"); // Search book_id
        pstmt.setString(2, "%" + searchQuery + "%"); // Search title
        pstmt.setString(3, "%" + searchQuery + "%"); // Search author
        pstmt.setString(4, "%" + searchQuery + "%"); // Search genre
        pstmt.setString(5, "%" + searchQuery + "%"); // Search publisher

        // Execute the query
        ResultSet rs = pstmt.executeQuery();

        // Get the table model for the booklist table
        DefaultTableModel model = (DefaultTableModel) booklist.getModel();

        // Clear existing rows in the table
        model.setRowCount(0);

        // Populate the table with the fetched data
        while (rs.next()) {
            Object[] row = new Object[6]; // Assuming 6 columns (book_id, title, author, genre, publisher, availability)
            row[0] = rs.getInt("book_id");
            row[1] = rs.getString("title");
            row[2] = rs.getString("author");
            row[3] = rs.getString("year_published");
            row[4] = rs.getInt("copies");
            row[5] = rs.getString("availability"); // Added availability column

            model.addRow(row); // Add row to the table model
        }

        // Check if no books were found
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No books found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error searching books: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_searchActionPerformed

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
   
    }//GEN-LAST:event_searchboxActionPerformed

    private void copiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copiesActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookidActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

    // Get the book ID from the text field or other input component
    String bookId = bookid.getText().trim(); // Assuming you have a JTextField for bookId

    // Validate input
    if (bookId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a Book ID to delete.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
        // Check if the book exists in the database
        String checkQuery = "SELECT book_id FROM books WHERE book_id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                // Book ID not found
                JOptionPane.showMessageDialog(this, "Book ID not found. Please check the ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Delete the book from the database
        String deleteQuery = "DELETE FROM books WHERE book_id = ?";
        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
            deleteStmt.setString(1, bookId);

            int rowsAffected = deleteStmt.executeUpdate();
            if (rowsAffected > 0) {
                // Show success message
                JOptionPane.showMessageDialog(this, "Book deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // In case of any issue with deletion
                JOptionPane.showMessageDialog(this, "Failed to delete the book. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed

    // Get the DefaultTableModel of the JTable
    DefaultTableModel model = (DefaultTableModel) booklist.getModel();
    
    // Create a TableRowSorter with the model
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    booklist.setRowSorter(sorter);

    // Specify the column index to be sorted
    // For example, we can sort by the book title (column index 1), or any column of your choice
    int columnIndexForSorting = 1; // Change this to the index of the column you want to sort by (e.g., 0 for book_id, 1 for title, etc.)

    // Create a List to manually set the SortKey
    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    
    // Sort in ascending order
    sortKeys.add(new RowSorter.SortKey(columnIndexForSorting, SortOrder.ASCENDING));
    
    // Set the sort keys
    sorter.setSortKeys(sortKeys);

    System.out.println("Sorting applied successfully.");

    }//GEN-LAST:event_sortActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new librarianLog().setVisible(true);

        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void availActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availActionPerformed

    }//GEN-LAST:event_availActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 // Get the values from the input fields
String bookId = bookid.getText().trim();
String titlee = title.getText().trim();
String authorr = author.getText().trim();
String yearPublished = year.getText().trim();
String copiess = copies.getText().trim();

// Input validation
if (bookId.isEmpty() || titlee.isEmpty() || authorr.isEmpty() || yearPublished.isEmpty() || copiess.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    // Convert year and copies to integers
    int year = Integer.parseInt(yearPublished);
    int numCopies = Integer.parseInt(copiess);

    // Validate year and copies
    if (year <= 0 || numCopies < 0) {
        JOptionPane.showMessageDialog(this, "Year must be a positive integer and Copies cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Set availability based on the number of copies
    String availability = (numCopies == 0) ? "Unavailable" : (String) avail.getSelectedItem();

    // Try-with-resources to manage the database connection
    try (Connection conn = getDatabaseConnection()) {

        // Check if the book ID already exists
        String checkQuery = "SELECT book_id FROM books WHERE book_id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Book ID already exists. Please use a unique ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Insert the book into the database
        String query = "INSERT INTO books (book_id, title, author, year_published, copies, availability) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookId);
            pstmt.setString(2, titlee);   // Corrected from title
            pstmt.setString(3, authorr);  // Corrected from author
            pstmt.setInt(4, year);
            pstmt.setInt(5, numCopies);
            pstmt.setString(6, availability);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Show success message with an "OK" button
                JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Year and Copies must be numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error saving book: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
                                    
    String bookId = bookid.getText().trim();
    String titlee = title.getText().trim();
    String authorr = author.getText().trim();
    String yearPublished = year.getText().trim();
    String copiess = copies.getText().trim();
    String availability = (String) avail.getSelectedItem();

    // Input validation
    if (bookId.isEmpty() || titlee.isEmpty() || authorr.isEmpty() || yearPublished.isEmpty() || copiess.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Validate year and copies as numeric values
        int year = Integer.parseInt(yearPublished);
        int numCopies = Integer.parseInt(copiess);

        if (year <= 0 || numCopies < 0) {
            JOptionPane.showMessageDialog(this, "Year must be a positive integer and Copies cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update the book record in the database
        try (Connection conn = getDatabaseConnection()) {
            String query = "UPDATE books SET title = ?, author = ?, year_published = ?, copies = ?, availability = ? WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, titlee);
            pstmt.setString(2, authorr);
            pstmt.setInt(3, year);
            pstmt.setInt(4, numCopies);
            pstmt.setString(5, availability);
            pstmt.setString(6, bookId); // Specify the book_id for updating

            // Execute the update query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                // Show success message if the update was successful
                JOptionPane.showMessageDialog(this, "Book details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // If no rows were affected, display an error message
                JOptionPane.showMessageDialog(this, "Book ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Year and Copies must be numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error updating book: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_editActionPerformed

    private void booklistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booklistMouseClicked
                                      
    // Get the selected row index in the table
    int selectedRow = booklist.getSelectedRow();
    
    if (selectedRow != -1) { // Check if a row is selected
        // Get the values from the selected row
        String selectedBookId = booklist.getValueAt(selectedRow, 0).toString();
        String selectedTitle = booklist.getValueAt(selectedRow, 1).toString();
        String selectedAuthor = booklist.getValueAt(selectedRow, 2).toString();
        String selectedYear = booklist.getValueAt(selectedRow, 3).toString();
        String selectedCopies = booklist.getValueAt(selectedRow, 4).toString();
        String selectedAvailability = booklist.getValueAt(selectedRow, 5).toString();
        
        // Set the values into the respective JTextFields
        bookid.setText(selectedBookId);
        title.setText(selectedTitle);
        author.setText(selectedAuthor);
        year.setText(selectedYear);
        copies.setText(selectedCopies);
        avail.setSelectedItem(selectedAvailability);
    }

    }//GEN-LAST:event_booklistMouseClicked

    private void sort1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort1ActionPerformed
                                     
   
    bookid.setText(""); 
    title.setText(""); 
    author.setText(""); 
    year.setText(""); 
    copies.setText(""); 
    avail.setSelectedItem(null);

    // Optionally, reset the focus to the first field
    bookid.requestFocus(); 

    }//GEN-LAST:event_sort1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(booklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(booklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(booklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(booklist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new booklist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField author;
    private javax.swing.JComboBox<String> avail;
    private javax.swing.JButton back;
    private javax.swing.JTextField bookid;
    private javax.swing.JTable booklist;
    private javax.swing.JTextField copies;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refresh;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbox;
    private javax.swing.JButton sort;
    private javax.swing.JButton sort1;
    private javax.swing.JTextField title;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables

}


