/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket_money_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class CurrentMonth extends javax.swing.JFrame {
    
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    
    int count = 0;
    int currentbal = 0;
    int rest = 0;
    

    /**
     * Creates new form NewJFrame
     */
    public CurrentMonth() {
        initComponents();
        
        
        date();
        combo();
//        addcatagory();

        currentaccount();
        dailylimit();
    }
   
    
    public void date(){
        
     // Total day :::::::::::::::::::::
        
        Calendar calendar = Calendar.getInstance();
        int year = 0;
        calendar.set(Calendar.YEAR, year);
        int month = 0;
        calendar.set(Calendar.MONTH, month);
        int tnumDays = calendar.getActualMaximum(Calendar.DATE);
        
     // Today's Time ::::::::::::::::
     
        Calendar date = Calendar.getInstance();
        int today = date.get(Calendar.DATE);
        
       rest = tnumDays - today;
        
    }
    
    public void combo(){
        try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("select * from catagory");
            
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                String catagory = rs.getString("catagory");
                
                jComboBoxCatagory.addItem(catagory);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void addcatagory(){
       
        
        try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("SELECT * FROM `catagory`");
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
               //String u = jTextFieldSingUpUserName.getText().trim();
               String cname = rs.getString("catagory");
               if(jTextFieldcategory.getText().trim().equalsIgnoreCase(cname)){
                    count = 1;
                   break;
               }
           }
           if(count == 0){
           pstmt=(PreparedStatement) con.prepareStatement("INSERT INTO `catagory` (`id`, `catagory`) VALUES (NULL, '"+jTextFieldcategory.getText().trim()+"')");
     
            int isOk=0;
            isOk = pstmt.executeUpdate();
            if(isOk>0)
            {
                JOptionPane.showMessageDialog(null, "Successfully Add Category "+jTextFieldcategory.getText()+"","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                 
                combo();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Failed.!","Error",JOptionPane.ERROR_MESSAGE);

            }
            }
        else{
            JOptionPane.showMessageDialog(null, "Hey Bro!! Already have this category..!!");
            count = 0;
        }
        
        }
        catch(SQLException ex){
      JOptionPane.showMessageDialog(null, "Error occured due to:\n"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
    }
    finally{
        try{
                if(pstmt!=null) pstmt.close();
                if(con!=null)con.close();
            }
                    catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error occured due to:\n"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        
    }
               
        }
    }
    
    private void currentaccount(){
        
        String id = new String();
        id = MainFrame.jTextFieldUserName.getText().trim();
        
        try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("SELECT currentbal FROM accounts WHERE username= '"+id+"'");
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String ac = rs.getString("currentbal");
                jTextFieldYouHave.setText(ac);
                currentbal = Integer.parseInt(ac);
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  
       finally{
        try{
                if(pstmt!=null) pstmt.close();
                if(con!=null)con.close();
            }
                    catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error occured due to:\n"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        
    }
               
        } 
    }
    
    private void dailylimit(){
        
        float dailylimit = (currentbal/rest);
        
        jTextFieldDailyLimit.setText(String.valueOf(dailylimit));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButtonAddamount = new javax.swing.JButton();
        jTextFieldAdd = new javax.swing.JTextField();
        jTextFieldYouHave = new javax.swing.JTextField();
        jTextFieldDailyLimit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCatagory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jButtonAdd2 = new javax.swing.JButton();
        jButtonaddcatagory = new javax.swing.JButton();
        jTextFieldcategory = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCostList = new javax.swing.JButton();
        jTextFieldTodayYouHave = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Add New Amount :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 170, 140, 29));

        jButtonAddamount.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonAddamount.setForeground(new java.awt.Color(102, 255, 51));
        jButtonAddamount.setText("Add");
        jButtonAddamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddamountActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAddamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jTextFieldAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 225, -1));

        jTextFieldYouHave.setEditable(false);
        jTextFieldYouHave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldYouHave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 315, -1));

        jTextFieldDailyLimit.setEditable(false);
        jTextFieldDailyLimit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldDailyLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 315, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("You have :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 109, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Your Daily limit :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jComboBoxCatagory.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(jComboBoxCatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 137, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 0));
        jLabel5.setText("Category :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 230, 80, 26));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Amount :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jTextFieldAmount.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 87, -1));

        jButtonAdd2.setBackground(new java.awt.Color(255, 51, 51));
        jButtonAdd2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonAdd2.setText("Add");
        jButtonAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdd2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 59, -1));

        jButtonaddcatagory.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonaddcatagory.setForeground(new java.awt.Color(51, 255, 51));
        jButtonaddcatagory.setText("Add");
        jButtonaddcatagory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddcatagoryActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonaddcatagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 89, -1));

        jTextFieldcategory.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(jTextFieldcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 220, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Add a Category :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 135, 33));

        jButtonCostList.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButtonCostList.setForeground(new java.awt.Color(255, 0, 102));
        jButtonCostList.setText("Total cost list.. :)");
        jButtonCostList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostListActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCostList, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 203, -1));

        jTextFieldTodayYouHave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldTodayYouHave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 202, -1));

        jButtonOK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonOK.setForeground(new java.awt.Color(255, 204, 204));
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 90, -1));

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("Or Today You Have :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pocket_money_manager/current.jpeg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonaddcatagoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddcatagoryActionPerformed
        // TODO add your handling code here:
        if(jTextFieldcategory.getText().trim().equals(null)){
                JOptionPane.showMessageDialog(null, "Write first bro.. :D ");
                
            }
        else{
            addcatagory();
        }
    }//GEN-LAST:event_jButtonaddcatagoryActionPerformed

    private void addamount(){
        
        int a = Integer.parseInt(jTextFieldAdd.getText());
        int total = a+currentbal;
        String id = new String();
        id = MainFrame.jTextFieldUserName.getText().trim();
        
       try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("UPDATE accounts SET currentbal = '"+total+"' where username = '"+id+"' ");
            int isOK=0;
            
            isOK = pstmt.executeUpdate();
            if(isOK>0){
                JOptionPane.showMessageDialog(null, "Succussfully added..!!");
                currentaccount();
                dailylimit();
                jTextFieldAdd.setText(null);
                return;
            }
            else{
                JOptionPane.showMessageDialog(null, "Not added..!!");
                
            }
       }
       catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e);
       }
       finally{
        try{
                if(pstmt!=null) pstmt.close();
                if(con!=null)con.close();
            }
                    catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error occured due to:\n"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        
    }
               
        }
       
    }
    
    private void jButtonAddamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddamountActionPerformed
        // TODO add your handling code here:
        if(jTextFieldAdd.getText().trim().equals(null)){
            JOptionPane.showMessageDialog(null, "Add a amount.!");
            jTextFieldAdd.requestFocus();
        }
        else{
            addamount();
        }
    }//GEN-LAST:event_jButtonAddamountActionPerformed

    private void jButtonAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdd2ActionPerformed
        // TODO add your handling code here:
        
        if(jTextFieldAmount.getText().trim().equals(null)){
            JOptionPane.showMessageDialog(null, "Add an cost brother..!!");
            jTextFieldAmount.requestFocus();
            return;
        }
        else{
            addcost();
        }
    }//GEN-LAST:event_jButtonAdd2ActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO add your handling code here:
        
        if(jTextFieldTodayYouHave.getText().equals(null)){
            
            JOptionPane.showMessageDialog(null, "Write first..!! :O ");
            jTextFieldTodayYouHave.requestFocus();
        }
        else{
            todayhave();
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCostListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostListActionPerformed
        // TODO add your handling code here:
        
        dispose();
        costTable ct = new costTable();
        ct.setVisible(true);
        ct.setResizable(false);
        
    }//GEN-LAST:event_jButtonCostListActionPerformed

    
    private void todayhave(){
        
        int a = Integer.parseInt(jTextFieldTodayYouHave.getText());
        String id = new String();
        id = MainFrame.jTextFieldUserName.getText().trim();
        
       try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("UPDATE accounts SET currentbal = '"+a+"' where username = '"+id+"' ");
            int isOK=0;
            
            isOK = pstmt.executeUpdate();
            if(isOK>0){
                JOptionPane.showMessageDialog(null, "Succussfully added your todays balance..!!");
                currentaccount();
                dailylimit();
                jTextFieldTodayYouHave.setText(null);
                return;
            }
            else{
                JOptionPane.showMessageDialog(null, "Not added..!!");
                
            }
       }
       catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e);
       }
       finally{
        try{
                if(pstmt!=null) pstmt.close();
                if(con!=null)con.close();
            }
                    catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error occured due to:\n"+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        
    }
               
        }
       
    }
    
   private void addcost(){
        
       
        int now = Integer.parseInt(jTextFieldYouHave.getText().trim());
        int cost = Integer.parseInt(jTextFieldAmount.getText());
        
        if(cost<now){
            String id = new String();
            id = MainFrame.jTextFieldUserName.getText().trim();
            int total = currentbal-cost;
            
            try{
            
            con = (Connection) DriverManager.getConnection(pocket_money_manager.DB_Connection.db_url, pocket_money_manager.DB_Connection.db_userName, pocket_money_manager.DB_Connection.db_password);
            pstmt=(PreparedStatement) con.prepareStatement("UPDATE accounts SET currentbal = '"+total+"' where username = '"+id+"' ");
            
            int isOK = pstmt.executeUpdate();
            if(isOK>0){
//                con = (Connection) DriverManager.getConnection(trying.DB_Connection.db_url, trying.DB_Connection.db_userName, trying.DB_Connection.db_password);
                pstmt=(PreparedStatement) con.prepareStatement("INSERT INTO `cost`(`id`, `username`, `catagory`, `cost`, `date`) VALUES (null,'"+id+"','"+jComboBoxCatagory.getSelectedItem()+"','"+cost+"',CURRENT_TIMESTAMP)");
                int isOk = pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Successfully add this cost.");
                
                currentaccount();
                dailylimit();
            }
            else{
                
                JOptionPane.showMessageDialog(null, "Something wrong.. :( ");
            }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
        }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "You dont have enough balance to cost like this.! Add some amount first.!!");
            jTextFieldAmount.setText(null);
            jTextFieldAdd.requestFocus();
        }     
    } 
    
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
            java.util.logging.Logger.getLogger(CurrentMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentMonth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd2;
    private javax.swing.JButton jButtonAddamount;
    private javax.swing.JButton jButtonCostList;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonaddcatagory;
    private javax.swing.JComboBox<String> jComboBoxCatagory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldAdd;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldDailyLimit;
    private javax.swing.JTextField jTextFieldTodayYouHave;
    private javax.swing.JTextField jTextFieldYouHave;
    private javax.swing.JTextField jTextFieldcategory;
    // End of variables declaration//GEN-END:variables
}
