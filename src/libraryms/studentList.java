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





public class studentList extends javax.swing.JFrame {
    
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    
    private JTable studentList;
    private int rowIndex;
    private DefaultTableModel model;
    
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


    /**
     * Creates new form studentList
     */
    public studentList() {
        initComponents();
        loadBookList();
        memberid.setText(String.valueOf(getMax()));
      


    }
     
   public int getMax() {
    int id = 0;
    Statement st = null;
    ResultSet rs = null;
    
    try {
        // Ensure the connection is open
        if (conn == null || conn.isClosed()) {
            conn = getDatabaseConnection();  // Open the connection if it's closed
        }
        
        // Use COALESCE to handle case where no member_id exists yet
        String query = "SELECT COALESCE(MAX(member_id), 0) FROM members";
        st = conn.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.next()) {
            id = rs.getInt(1); // Get the max member_id
        }
    } catch (SQLException ex) {
        Logger.getLogger(studentList.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close resources in the finally block to ensure they are always closed
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (SQLException ex) {
            Logger.getLogger(studentList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return id + 1; // Return the next available member ID
}

    
    private void loadBookList() {

    try {
        // Establish database connection
        conn = getDatabaseConnection();

        // Query to fetch all books
        String query = "SELECT * FROM members";
        pstmt = conn.prepareStatement(query);

        // Execute query and get results
        rs = pstmt.executeQuery();

        // Update booklist (JTable) using rs2xml
        Table.setModel(DbUtils.resultSetToTableModel(rs));

        // Refresh the UI
        Table.revalidate();
        Table.repaint();


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


    private boolean isSorted = false; 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        middleinitial = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        birthday = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        memberid = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        sort = new javax.swing.JButton();
        back = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 3));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 3));

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel3.setText("First name");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel4.setText("Last name");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel5.setText("Email");

        middleinitial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleinitialActionPerformed(evt);
            }
        });

        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel7.setText("Birthday");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel8.setText("Gender");

        save.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel10.setText("Middle Initial");

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jLabel11.setText("Student Id");

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        memberid.setBackground(new java.awt.Color(204, 204, 204));
        memberid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberidActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        sort.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        sort.setText("SORT");
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(back)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edit)
                                        .addGap(18, 18, 18)
                                        .addComponent(sort))
                                    .addComponent(memberid, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(middleinitial, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edit)
                        .addComponent(sort))
                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middleinitial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save)
                    .addComponent(delete)
                    .addComponent(clear))
                .addGap(63, 63, 63))
        );

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel2.setText("Add student");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "First name", "Middle name", "Last name", "Email", "Member ID", "Birthday", "Gender"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Table);

        jScrollPane5.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel9.setText("Search Student");

        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        refresh.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search)
                        .addGap(18, 18, 18)
                        .addComponent(refresh)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search)
                        .addComponent(refresh))
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    
    private void middleinitialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleinitialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleinitialActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
 
    }//GEN-LAST:event_searchbarActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void memberidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberidActionPerformed
        
    }//GEN-LAST:event_memberidActionPerformed

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
 DefaultTableModel model = (DefaultTableModel) Table.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    Table.setRowSorter(sorter);

    // Specify the column index for sorting (e.g., 0 for the first column)
    int columnIndexForNames = 0; // Change this if the student name column is in a different position

    // Use a List and manually add a SortKey for Java 8 compatibility
    List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    sortKeys.add(new RowSorter.SortKey(columnIndexForNames, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys);

    System.out.println("Sorting applied successfully.");

    }//GEN-LAST:event_sortActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       new librarianLog().setVisible(true);
       
       dispose();
    }//GEN-LAST:event_backActionPerformed
    private void loadStudentData() {
    // Database query to fetch all student data
    String query = "SELECT member_id, first_name, middle_initial, last_name, email_add, gender, birthday FROM members";
    
    try (Connection conn = getDatabaseConnection()) {
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        studentList.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading student data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
     }
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
                                   
    String memberId = memberid.getText().trim();
    String firstName = firstname.getText().trim();
    String middleInitial = middleinitial.getText().trim();
    String lastName = lastname.getText().trim();
    String emailAddress = email.getText().trim();
    java.util.Date birthDate = birthday.getDate();
    String genderText = (String) gender.getSelectedItem();

    // Input validation
    if (firstName.isEmpty() || middleInitial.isEmpty() || lastName.isEmpty() || memberId.isEmpty() || emailAddress.isEmpty() || birthDate == null || genderText == null) {
        JOptionPane.showMessageDialog(this, "All required fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (middleInitial.length() > 1) {
        JOptionPane.showMessageDialog(this, "Middle initial must be a single letter.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conn = getDatabaseConnection()) {
        // Check for unique constraints
        String checkQuery = "SELECT * FROM members WHERE member_id = ? OR first_name = ? OR middle_initial = ? OR last_name = ? OR email_add = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setString(1, memberId);
        checkStmt.setString(2, firstName);
        checkStmt.setString(3, middleInitial);
        checkStmt.setString(4, lastName);
        checkStmt.setString(5, emailAddress);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "A member with similar details already exists. Please verify your input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert the member into the database
       String insertQuery = "INSERT INTO members (member_id, first_name, middle_initial, last_name, email_add, gender, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        pstmt.setString(1, memberId);
        pstmt.setString(2, firstName);
        pstmt.setString(3, middleInitial);
        pstmt.setString(4, lastName);
        pstmt.setString(5, emailAddress);
        pstmt.setString(6, genderText);
        pstmt.setDate(7, new java.sql.Date(birthDate.getTime())); // Convert java.util.Date to java.sql.Date

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear form fields for new input
            memberid.setText("");
            firstname.setText("");
            middleinitial.setText("");
            lastname.setText("");
            email.setText("");
            birthday.setDate(null);
            gender.setSelectedIndex(0);

            // Refresh the JTable to display the new member
            refreshActionPerformed(evt);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving member: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
                                       
    // Get the table model
    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    
    // Get the selected row from the table
    int rowIndex = Table.getSelectedRow();
    
    // Check if a row is selected
    if (rowIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        return;
    }

    // Confirm deletion with the user
    int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this student?", 
        "Confirm Deletion", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    
    if (response != JOptionPane.YES_OPTION) {
        return; // User clicked 'No', so exit the method
    }

    // Get the member_id for the selected row (assuming member_id is in the first column [index 0] of the table)
    int memberId = (int) model.getValueAt(rowIndex, 0); // Cast to int (Assuming member_id is an integer)

    // SQL DELETE query
    String deleteQuery = "DELETE FROM members WHERE member_id = ?";

    try (PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
        ps.setInt(1, memberId); // Bind member_id to the prepared statement
        int rowsDeleted = ps.executeUpdate(); // Execute the query
        
        if (rowsDeleted > 0) {
            // Remove the selected row from the JTable
            model.removeRow(rowIndex);
            JOptionPane.showMessageDialog(this, "Student deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete student. Please try again.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while deleting the student: " + e.getMessage());
    }

    }//GEN-LAST:event_deleteActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       try {
        // Establish database connection
        conn = getDatabaseConnection();

        // Query to fetch all books
        String query = "SELECT * FROM members";
        pstmt = conn.prepareStatement(query);

        // Execute query and get results
        rs = pstmt.executeQuery();

        // Set the table model to display the data from the ResultSet
        Table.setModel(DbUtils.resultSetToTableModel(rs));

        // Refresh the table UI
        Table.revalidate();
        Table.repaint();

        // Optional success message
        JOptionPane.showMessageDialog(this, "Student list refreshed successfully.", "Refresh Success", JOptionPane.INFORMATION_MESSAGE);
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
                                     
    // Get the search term from the search bar
    String searchTerm = searchbar.getText().trim();
    
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a search term.");
        return;
    }

 
    String searchQuery = "SELECT * FROM members WHERE first_name LIKE ? OR middle_initial LIKE ? OR last_name LIKE ? OR email_add LIKE ?";

    try (PreparedStatement ps = conn.prepareStatement(searchQuery)) {
        
        String wildcardTerm = "%" + searchTerm + "%";
        ps.setString(1, wildcardTerm);
        ps.setString(2, wildcardTerm);
        ps.setString(3, wildcardTerm);
        ps.setString(4, wildcardTerm);
        
        // Execute the query and get results
        ResultSet rs = ps.executeQuery();

        // Clear the current rows in the JTable
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);

        // If results are found, populate the table with search results
        while (rs.next()) {
            // Assuming the columns are ordered as: member_id, first_name, middle_initial, last_name, email_add, birthday, gender
            Object[] row = {
                rs.getInt("member_id"),
                rs.getString("first_name"),
                rs.getString("middle_initial"),
                rs.getString("last_name"),
                rs.getString("email_add"),
                rs.getDate("birthday"),
                rs.getString("gender")
            };
            model.addRow(row);
        }

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No matching students found.");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while searching for the student: " + e.getMessage());
    }

    }//GEN-LAST:event_searchActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

    DefaultTableModel model = (DefaultTableModel) Table.getModel();
    int rowIndex = Table.getSelectedRow();

    // Check if a row is selected
    if (rowIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please select a member to edit.");
        return;
    }

    // Get the new values from the form fields (Assuming these are JTextFields and JComboBox)
    String updatedFirstName = firstname.getText();
    String updatedMiddleInitial = middleinitial.getText();
    String updatedLastName = lastname.getText();
    String updatedEmail = email.getText();
    java.util.Date updatedBirthday = birthday.getDate(); // Assuming birthday is a JDateChooser
    String updatedGender = gender.getSelectedItem().toString(); // Assuming gender is a JComboBox

    // Validate the inputs (simple validation example)
    if (updatedFirstName.isEmpty() || updatedLastName.isEmpty() || updatedEmail.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out.");
        return;
    }

    // Update the table model with the new values (assuming column indices are correct)
    model.setValueAt(updatedFirstName, rowIndex, 1);
    model.setValueAt(updatedMiddleInitial, rowIndex, 2);
    model.setValueAt(updatedLastName, rowIndex, 3);
    model.setValueAt(updatedEmail, rowIndex, 4);
    model.setValueAt(updatedGender, rowIndex, 6);

    // Handle the birthday field (convert the date to string format if necessary)
    if (updatedBirthday != null) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(updatedBirthday);
        model.setValueAt(formattedDate, rowIndex, 5);
    }

    // Get the member_id for the selected row (assuming it is in column 0)
    int memberId = (int) model.getValueAt(rowIndex, 0);

    // Update the member's record in the database
    String updateQuery = "UPDATE members SET first_name = ?, middle_initial = ?, last_name = ?, email_add = ?, birthday = ?, gender = ? WHERE member_id = ?";
    try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
        ps.setString(1, updatedFirstName); // Bind first name as a String
        ps.setString(2, updatedMiddleInitial); // Bind middle initial as a String
        ps.setString(3, updatedLastName); // Bind last name as a String
        ps.setString(4, updatedEmail); // Bind email as a String
        ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(updatedBirthday)); // Convert Date to String and bind
        ps.setString(6, updatedGender); // Bind gender as a String (THIS IS THE KEY PART)
        ps.setInt(7, memberId); // Bind member_id as an Integer (assuming member_id is of type INT)

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Member details updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update member details.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    }//GEN-LAST:event_editActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
// Retrieve and populate fields from the selected row
model = (DefaultTableModel) Table.getModel();
rowIndex = Table.getSelectedRow();

memberid.setText(model.getValueAt(rowIndex, 0).toString());
firstname.setText(model.getValueAt(rowIndex, 1).toString());
middleinitial.setText(model.getValueAt(rowIndex, 2).toString());
lastname.setText(model.getValueAt(rowIndex, 3).toString());
email.setText(model.getValueAt(rowIndex, 4).toString());

try {
    Object dateValue = model.getValueAt(rowIndex, 5);
    if (dateValue != null && dateValue.toString().matches("\\d{4}-\\d{2}-\\d{2}")) {
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue.toString());
        birthday.setDate(date);
    } else {
        birthday.setDate(null);
        Logger.getLogger(studentList.class.getName()).log(Level.WARNING, "Invalid date value: " + dateValue);
    }
} catch (ParseException ex) {
    Logger.getLogger(studentList.class.getName()).log(Level.SEVERE, "Error parsing date", ex);
}

Object genderValue = model.getValueAt(rowIndex, 6);

if (genderValue != null) {
    String genderText = genderValue.toString().trim().toUpperCase();
    
    if (genderText.equals("MALE")) {
        gender.setSelectedIndex(0); // Assuming MALE is at index 0
    } else if (genderText.equals("FEMALE")) {
        gender.setSelectedIndex(1); // Assuming FEMALE is at index 1
    } else {
        gender.setSelectedIndex(-1); // If gender is not "MALE" or "FEMALE", deselect
        Logger.getLogger(studentList.class.getName()).log(Level.WARNING, "Unexpected gender value: " + genderValue);
    }
} else {
    gender.setSelectedIndex(-1); // If gender value is null, deselect the combo box
    Logger.getLogger(studentList.class.getName()).log(Level.WARNING, "Gender value is null for row: " + rowIndex);
}


    }//GEN-LAST:event_TableMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
                                     
    // Clear all JTextField inputs
    memberid.setText(""); 
    firstname.setText(""); 
    middleinitial.setText(""); 
    lastname.setText(""); 
    email.setText("");
    
    birthday.setDate(null);
    gender.setSelectedItem(null);
    
    memberid.requestFocus(); 

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
            java.util.logging.Logger.getLogger(studentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton back;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField memberid;
    private javax.swing.JTextField middleinitial;
    private javax.swing.JButton refresh;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchbar;
    private javax.swing.JButton sort;
    // End of variables declaration//GEN-END:variables
}
