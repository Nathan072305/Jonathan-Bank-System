
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;


public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        
          try{
            Connection();
            Function();
            
        } catch(SQLException ex){
            
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
Connection connection;
    
    Statement statement;
    
    private static final String DbName = "please";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/" + DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";

    
    
    public void Connection() throws SQLException{
        
        try {
            Class.forName(DbDriver);
            connection = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            statement = connection.createStatement();
            if (connection != null) {
                JOptionPane.showMessageDialog(null, "Welcome to registration");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
       
        }
    }
     private int getIdForUpdate(String username, String name, String password, String Phone) {
        int id = -1; 
        
        try {
            String selectQuery = "SELECT id FROM user WHERE Username=? OR Name=? OR Password=? OR Phone=?";
            PreparedStatement pstmt = connection.prepareStatement(selectQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setString(4, Phone);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
     
    
    
    public void Function(){
        PreparedStatement pst;
        
        try {
            
            pst = connection.prepareStatement("SELECT * FROM user");
            
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnCount = rsmd.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel) DetailTable.getModel();
            tableModel.setRowCount(0);
            
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 2; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    
                    if (value instanceof Number) {
                        rowData.add(value);
                    } else {
                        
                        rowData.add(value.toString());
                    }
                }
                tableModel.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Create = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        PassTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        PhoneTF = new javax.swing.JTextField();
        UserTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        DetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Username", "Password", "Email", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        DetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DetailTable);
        if (DetailTable.getColumnModel().getColumnCount() > 0) {
            DetailTable.getColumnModel().getColumn(0).setResizable(false);
            DetailTable.getColumnModel().getColumn(1).setResizable(false);
            DetailTable.getColumnModel().getColumn(2).setResizable(false);
            DetailTable.getColumnModel().getColumn(3).setResizable(false);
            DetailTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel4.setText("Email:");

        jLabel3.setText("Password:");

        jLabel2.setText("Username:");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel1.setText("Name:");

        jLabel5.setText("Phone Number:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameTF)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PhoneTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UserTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PassTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EmailTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
         PreparedStatement pst;
         
         
        String name = NameTF.getText();
        String username = UserTF.getText();
        String password = PassTF.getText();
        String Email_Address = EmailTF.getText();
        String Phone_Number = PhoneTF.getText();
       
        String regex1 = "^09[0-9]{9}$";
        String regex2 = "^[a-zA-Z]+$";
        
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        
        Matcher matcherContactNumber = pattern1.matcher(Phone_Number);
        Matcher matcherName = pattern2.matcher(name);
        
        
         
        if(name.equals("")||username.equals("")||password.equals("")||Email_Address.equals("")||Phone_Number.equals("")){
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){   
            JOptionPane.showMessageDialog(null, "Invalid name. Name should contain only alphabet characters");    
        }else if(!matcherContactNumber.matches()){
            
            JOptionPane.showMessageDialog(null, "Phone number is Invalid. Enter a valid Number format - PH number");

        }else{
            
            try{
                int Add = JOptionPane.showConfirmDialog(null, "Confirm to Add Data", "Warning", JOptionPane.YES_NO_OPTION);
            
                if (Add == JOptionPane.YES_OPTION) {
                
                pst = connection.prepareStatement("insert into user(Name,Username,Password,Email,Phone)value(?,?,?,?,?)");
                
                pst.setString(1, NameTF.getText());
                pst.setString(2, UserTF.getText());
                pst.setString(3, PassTF.getText());
                pst.setString(4, EmailTF.getText());
                pst.setString(5, PhoneTF.getText());
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Added");
                Function();
                
                NameTF.setText("");
                NameTF.requestFocus();
                UserTF.setText("");
                PassTF.setText("");
                EmailTF.setText("");
                PhoneTF.setText("");
                
                }
            }catch(SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
         
    }//GEN-LAST:event_CreateActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        PreparedStatement pst;
        
        String name = NameTF.getText();
        String username = UserTF.getText();
        String password = PassTF.getText();
        String Email_Address = EmailTF.getText();
        String Phone_Number = PhoneTF.getText();
       
        String regex1 = "^09[0-9]{9}$";
        String regex2 = "^[a-zA-Z]+$";
        
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        
        Matcher matcherContactNumber = pattern1.matcher(Phone_Number);
        Matcher matcherName = pattern2.matcher(name);
        
           if (name.equals("") || username.equals("") || password.equals("") || Email_Address.equals("") || Phone_Number.equals("")) {
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){   
            JOptionPane.showMessageDialog(null, "Invalid name. Name should contain only alphabet characters");    
        } else if (!matcherContactNumber.matches()) {
            JOptionPane.showMessageDialog(null, "Phone number is Invalid. Enter a valid Number format");
            

              
        } else {
            
            try{
   
            int Update = JOptionPane.showConfirmDialog(null, "Confirm to Update", "Warning", JOptionPane.YES_NO_OPTION);
            
            if (Update == JOptionPane.YES_OPTION) {
   
                int id = getIdForUpdate(username,name,password,Phone_Number);
                String updateQuery = "UPDATE user SET Username=?, Password=?, ContactNumber=?, Address=?, Name=? WHERE id=?";
                pst = connection.prepareStatement(updateQuery);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, Email_Address);
                pst.setString(5, Phone_Number);
                pst.setString(1, name);
                pst.setInt(6, id);
                
                int rowsAffected = pst.executeUpdate();
                Function();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Updated");
                } else {
                    JOptionPane.showMessageDialog(null, "No details to update");
                }
            }
                
     
                
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "An Error occurred while updating. Please try again later.");
            }
            
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
    }//GEN-LAST:event_BackActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        DefaultTableModel table = (DefaultTableModel) DetailTable.getModel();
        int selectedRow = DetailTable.getSelectedRow();
        
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }
        
        String name = NameTF.getText();
        String username = UserTF.getText();
        
        PreparedStatement pst;
        
        try {
            
            String rowName = table.getValueAt(selectedRow, 0).toString();
            String rowUsername = table.getValueAt(selectedRow, 2).toString();
            
            
            int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm to delete", "Warning", JOptionPane.YES_NO_OPTION);
            
            if (deleteItem == JOptionPane.YES_OPTION) {
                
                pst = connection.prepareStatement("DELETE FROM user WHERE Name = ? AND Username = ?");
                pst.setString(1, name);
                pst.setString(2, username);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    
                    table.removeRow(selectedRow);
                    
                    
                    for (int i = selectedRow; i < table.getRowCount(); i++) {
                        table.setValueAt(i + 1, i, 0);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Record has been deleted");
                    Function();
                    
                    
                    NameTF.setText("");
                    NameTF.requestFocus();
                    UserTF.setText("");
                    PassTF.setText("");
                    EmailTF.setText("");
                    PhoneTF.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No record found with the specified Name and Username.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for row number.");
        }
                                          
    
    
        
    }//GEN-LAST:event_DeleteActionPerformed

    private void DetailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailTableMouseClicked
        DefaultTableModel Table = (DefaultTableModel)DetailTable.getModel();
        int selectedRows = DetailTable.getSelectedRow();
        
        NameTF.setText(Table.getValueAt(selectedRows,0).toString());
        UserTF.setText(Table.getValueAt(selectedRows,1).toString());
        PassTF.setText(Table.getValueAt(selectedRows,2).toString());
       EmailTF.setText(Table.getValueAt(selectedRows,3).toString());
       PhoneTF.setText(Table.getValueAt(selectedRows,4).toString());
        DetailTable.isEditing();
        
    }//GEN-LAST:event_DetailTableMouseClicked

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Create;
    private javax.swing.JButton Delete;
    private javax.swing.JTable DetailTable;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JTextField NameTF;
    private javax.swing.JTextField PassTF;
    private javax.swing.JTextField PhoneTF;
    private javax.swing.JButton Update;
    private javax.swing.JTextField UserTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
