/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package essustea_loann;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import static essustea_loann.home.dateof;
import static essustea_loann.home.interestpermonth;
import static essustea_loann.home.loanableamount;
import static essustea_loann.home.moamortization;
import static essustea_loann.home.monthduration;
import static essustea_loann.home.netamount;
import static essustea_loann.home.nname;
import static essustea_loann.home.servicefee;
import static essustea_loann.home.startofdeduction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSetMetadata;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sandy Ogaro
 */
public class applicants_data extends javax.swing.JFrame {

    /**
     * Creates new form applicants_data
     */
    
    
    PreparedStatement pst;
    //PreparedStatement pstt;
    ResultSet rs;
    //ResultSet rss;
    Connection con;
    Statement st;
    
    
    int q, i;
    
    public applicants_data() {
        initComponents();
        
        String url = "jdbc:mysql://127.0.0.1:3306/essusserver";
         String user = "root";
         String pass = "essustealoanmanagementsystem01"; 
       try{
           con = DriverManager.getConnection(url,user,pass);
        }catch(Exception ex){
             System.out.println("Error :" +ex.getMessage());
       }
       
       
       
        
       
       
   
       //bayad();
       dt();
     // applicants();
       tdf();
       tdfg();
    }
    
    
    
    
    public void update(){
        try{
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/essusserver","root","essustealoanmanagementsystem01"); 

            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();
            q = stData.getColumnCount();
            
            DefaultTableModel re = (DefaultTableModel)tapay.getModel();
            re.setRowCount(0);
            
            while(rs.next()){
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++ ){
                    columnData.add(rs.getString("fpaymentt"));
                    columnData.add(rs.getString("fmonthdurationleftt"));
                    columnData.add(rs.getString("fdateoftransactionn"));
                }
                re.addRow(columnData);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
//###################################################################################################//   
     public void applicants(){
         
        String uunn = idd1.getText();

        String sql = "select * from fapplicant_transaction where fapplicant_id = ?";
       
        try{
           pst = con.prepareCall(sql);
           pst.setString(1,uunn);
         
           ResultSet rs = pst.executeQuery();
           DefaultTableModel model = (DefaultTableModel)tapay.getModel();
           while(rs.next()){
               model.addRow(new String []{rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(10),rs.getString(7)});
            }
           
           pst.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error :" + ex.getMessage());
        }
    }
    
 //************************************************************************************************//   
     
     
     
     
     
     
     
     
//##################################################################################################//     
    public  void bayad(){
         try{
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/essusserver","root","essustealoanmanagementsystem01");
                Statement st = con.createStatement();
                boolean b=st.execute("update floan_records set fbalance_remaining='"+balanceremainingg.getText()+"', fmonth_duration_left='"+monthleftss.getText()+"', fpayment_z='"+jTextField22.getText()+"', fdate_of_transaction='"+jLabel100.getText()+"', fmo_amo='"+jTextField2ii.getText()+"', fservi_ce_fee='"+jTextField1o.getText()+"' where fname_app='"+applicantsname.getText()+"'");
                
                if(!b){
                    formWindowOpened(null);
                }
        }catch(Exception e){
            System.out.println("Error :" + e.getMessage());
        }
    }
    
    //###########################################################################################//
    
    public void dt(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy");
        String dd = sdf.format(d);
        
       jLabel100.setText(dd);
    }
    
    public void tdf(){
        Date dq = new Date();
        SimpleDateFormat ssdf = new SimpleDateFormat("MM yyyy");
        String ddq = ssdf.format(dq);
        
       MonthYear.setText(ddq);
    }
    
        public void tdfg(){
        Date dq = new Date();
        SimpleDateFormat ssdf = new SimpleDateFormat("MM yyyy");
        String ddq = ssdf.format(dq);
        
       monthz.setText(ddq);
    }
    
    
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&//
    
    
    
    
    
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11 //    
    public void ball(){
        
        String b = "select * from fkabug_osan where fbalanceremainingg=?";
        
        try{
            pst = con.prepareCall(b);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                //jTextField24.setText(rs.getString(2));
            }
            
        }catch(Exception e){
            System.out.println("Error :" + e.getMessage());
        }
    }
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1//
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRadiobutton = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tapay = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField133 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        applicantsname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        payyy = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        balanceremainingg = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        balanceee = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        monthleftss = new javax.swing.JTextField();
        m2 = new javax.swing.JTextField();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        paidd = new javax.swing.JTextField();
        jTextField1o = new javax.swing.JTextField();
        jTextField2ii = new javax.swing.JTextField();
        jTextField1q = new javax.swing.JTextField();
        idd1 = new javax.swing.JTextField();
        amo_noFilter = new javax.swing.JTextField();
        balanc_1 = new javax.swing.JTextField();
        klj = new javax.swing.JLabel();
        MonthYear = new javax.swing.JTextField();
        monthz = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel6.setBackground(new java.awt.Color(0, 102, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tapay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tapay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tapay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PAYMENT", "MONTH DURATION LEFT", "INTEREST", "PRINCIPAL OF MONTH", "REMARKS", "DATE OF TRANSACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tapay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tapay.setEnabled(false);
        tapay.setFocusable(false);
        tapay.setGridColor(new java.awt.Color(51, 51, 0));
        tapay.setRequestFocusEnabled(false);
        tapay.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tapay.setSelectionForeground(new java.awt.Color(204, 0, 0));
        tapay.setShowGrid(true);
        jScrollPane2.setViewportView(tapay);
        if (tapay.getColumnModel().getColumnCount() > 0) {
            tapay.getColumnModel().getColumn(0).setMinWidth(100);
            tapay.getColumnModel().getColumn(0).setPreferredWidth(100);
            tapay.getColumnModel().getColumn(0).setMaxWidth(100);
            tapay.getColumnModel().getColumn(1).setResizable(false);
            tapay.getColumnModel().getColumn(2).setMinWidth(100);
            tapay.getColumnModel().getColumn(2).setPreferredWidth(100);
            tapay.getColumnModel().getColumn(2).setMaxWidth(100);
            tapay.getColumnModel().getColumn(3).setResizable(false);
            tapay.getColumnModel().getColumn(4).setMinWidth(90);
            tapay.getColumnModel().getColumn(4).setPreferredWidth(90);
            tapay.getColumnModel().getColumn(4).setMaxWidth(90);
            tapay.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 740, 410));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("DATE OF TRANSACTION :");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 67, 190, 20));

        jTextField133.setBackground(new java.awt.Color(0, 102, 0));
        jTextField133.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField133.setForeground(new java.awt.Color(255, 255, 255));
        jTextField133.setBorder(null);
        jTextField133.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField133, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 140, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("NAME OF APPLICANT :");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, -1));

        applicantsname.setBackground(new java.awt.Color(0, 102, 0));
        applicantsname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        applicantsname.setForeground(new java.awt.Color(255, 255, 255));
        applicantsname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        applicantsname.setBorder(null);
        applicantsname.setCaretColor(new java.awt.Color(0, 102, 0));
        applicantsname.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                applicantsnameCaretUpdate(evt);
            }
        });
        applicantsname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                applicantsnameKeyReleased(evt);
            }
        });
        jPanel6.add(applicantsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 170, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("LOANABLE AMOUNT :");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 160, -1));

        jTextField15.setBackground(new java.awt.Color(0, 102, 0));
        jTextField15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField15.setBorder(null);
        jTextField15.setCaretColor(new java.awt.Color(0, 102, 0));
        jTextField15.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField15CaretUpdate(evt);
            }
        });
        jPanel6.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SERVICE FEE :");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, 20));

        jTextField16.setBackground(new java.awt.Color(0, 102, 0));
        jTextField16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField16.setBorder(null);
        jTextField16.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 170, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NET AMOUNT :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 247, 150, 20));

        jTextField17.setBackground(new java.awt.Color(0, 102, 0));
        jTextField17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField17.setBorder(null);
        jTextField17.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 170, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("START OF DEDUCTION :");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("INTEREST PER MONTH :");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 190, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("MO. AMORTIZATION :");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 327, 190, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("MONTH DURATION :");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, 30));

        jTextField18.setBackground(new java.awt.Color(0, 102, 0));
        jTextField18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField18.setBorder(null);
        jTextField18.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 170, 30));

        jTextField19.setBackground(new java.awt.Color(0, 102, 0));
        jTextField19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField19.setBorder(null);
        jTextField19.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 170, 30));

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(0, 102, 0));
        jTextField20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(0, 102, 0));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField20.setBorder(null);
        jTextField20.setCaretColor(new java.awt.Color(0, 102, 0));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 190, 30));

        jTextField21.setBackground(new java.awt.Color(0, 102, 0));
        jTextField21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 255, 255));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField21.setBorder(null);
        jTextField21.setCaretColor(new java.awt.Color(0, 102, 0));
        jPanel6.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 170, 30));

        jTextField22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });
        jPanel6.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 150, 30));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PAYMENT AS OF NOW :");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 180, 30));

        payyy.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        payyy.setText("PAY");
        payyy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payyy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payyyActionPerformed(evt);
            }
        });
        jPanel6.add(payyy, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 160, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 0));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setText("BALANCE REMAINING :");

        balanceremainingg.setText("balance remaining");
        balanceremainingg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceremaininggActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceremainingg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceremainingg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 950, 740, 40));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 770, 10));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setText("APPLICANTS   PERSONAL   LOAN   DETAILS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        balanceee.setEditable(false);
        balanceee.setBackground(new java.awt.Color(0, 102, 0));
        balanceee.setForeground(new java.awt.Color(0, 102, 0));
        balanceee.setText("balance");
        balanceee.setBorder(null);
        balanceee.setCaretColor(new java.awt.Color(0, 102, 0));
        balanceee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceeeActionPerformed(evt);
            }
        });
        jPanel6.add(balanceee, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 120, -1));

        jLabel100.setForeground(new java.awt.Color(0, 102, 0));
        jLabel100.setText("date of transaction");
        jPanel6.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 100, -1));

        monthleftss.setEditable(false);
        monthleftss.setBackground(new java.awt.Color(0, 102, 0));
        monthleftss.setForeground(new java.awt.Color(0, 102, 0));
        monthleftss.setBorder(null);
        monthleftss.setCaretColor(new java.awt.Color(0, 102, 0));
        monthleftss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthleftssActionPerformed(evt);
            }
        });
        jPanel6.add(monthleftss, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 130, -1));

        m2.setBackground(new java.awt.Color(0, 102, 0));
        m2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        m2.setForeground(new java.awt.Color(255, 255, 255));
        m2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        m2.setBorder(null);
        m2.setCaretColor(new java.awt.Color(0, 102, 0));
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });
        jPanel6.add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 160, 30));

        buttonGroupRadiobutton.add(r1);
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setText("Full Payment");
        r1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });
        jPanel6.add(r1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 90, -1));

        buttonGroupRadiobutton.add(r2);
        r2.setForeground(new java.awt.Color(255, 255, 255));
        r2.setText("Month Payment");
        r2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });
        jPanel6.add(r2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        paidd.setEditable(false);
        paidd.setBackground(new java.awt.Color(0, 102, 0));
        paidd.setForeground(new java.awt.Color(0, 102, 0));
        paidd.setText("jTextField1");
        paidd.setBorder(null);
        paidd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paiddActionPerformed(evt);
            }
        });
        jPanel6.add(paidd, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, -1));

        jTextField1o.setEditable(false);
        jTextField1o.setBackground(new java.awt.Color(0, 102, 0));
        jTextField1o.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1o.setText("jTextField1");
        jTextField1o.setBorder(null);
        jTextField1o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1oActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField1o, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        jTextField2ii.setEditable(false);
        jTextField2ii.setBackground(new java.awt.Color(0, 102, 0));
        jTextField2ii.setForeground(new java.awt.Color(0, 102, 0));
        jTextField2ii.setText("jTextField2");
        jTextField2ii.setBorder(null);
        jTextField2ii.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2iiCaretUpdate(evt);
            }
        });
        jTextField2ii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2iiActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField2ii, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        jTextField1q.setEditable(false);
        jTextField1q.setBackground(new java.awt.Color(0, 102, 0));
        jTextField1q.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1q.setText("jTextField1");
        jTextField1q.setBorder(null);
        jPanel6.add(jTextField1q, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        idd1.setEditable(false);
        idd1.setBackground(new java.awt.Color(0, 102, 0));
        idd1.setForeground(new java.awt.Color(0, 102, 0));
        idd1.setText("id");
        idd1.setBorder(null);
        idd1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                idd1CaretUpdate(evt);
            }
        });
        jPanel6.add(idd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 40, -1));

        amo_noFilter.setEditable(false);
        amo_noFilter.setBackground(new java.awt.Color(0, 102, 0));
        amo_noFilter.setForeground(new java.awt.Color(0, 102, 0));
        amo_noFilter.setText("jTextField1");
        amo_noFilter.setBorder(null);
        jPanel6.add(amo_noFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 110, -1));

        balanc_1.setEditable(false);
        balanc_1.setBackground(new java.awt.Color(0, 102, 0));
        balanc_1.setForeground(new java.awt.Color(0, 102, 0));
        balanc_1.setText("jTextField1");
        balanc_1.setBorder(null);
        balanc_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanc_1ActionPerformed(evt);
            }
        });
        jPanel6.add(balanc_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, -1, -1));

        klj.setForeground(new java.awt.Color(0, 102, 0));
        klj.setText("jLabel1");
        jPanel6.add(klj, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, -1, -1));

        MonthYear.setEditable(false);
        MonthYear.setBackground(new java.awt.Color(0, 102, 0));
        MonthYear.setForeground(new java.awt.Color(0, 102, 0));
        MonthYear.setBorder(null);
        jPanel6.add(MonthYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 90, -1));

        monthz.setEditable(false);
        monthz.setBackground(new java.awt.Color(0, 102, 0));
        monthz.setForeground(new java.awt.Color(0, 102, 0));
        monthz.setBorder(null);
        jPanel6.add(monthz, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 60, -1));

        jScrollPane3.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payyyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payyyActionPerformed
        // TODO add your handling code here:
        
        //############### r1.isSelected here : ################################//   
        
         if(r1.isSelected()==true){
            //condition here:

            String qa = jTextField22.getText();
            String et = balanceee.getText();
            double sa = Double.parseDouble(et);
            
            String we = balanc_1.getText();
            double ds = Double.parseDouble(we);
            
            String sz = monthleftss.getText();
            int rt = Integer.parseInt(sz);
            
            
           String  df = jTextField21.getText();
           //int opo = Integer.parseInt(df);
           
           String ft = paidd.getText();
           //int yut = Integer.parseInt(ft);
           
           String ryi = MonthYear.getText();
           //int dre = Integer.parseInt(ryi);
            
            if(sa!=ds){
                JOptionPane.showMessageDialog(this,"The data you input is not match.\nto current balance","ERROR",JOptionPane.ERROR_MESSAGE);
                jTextField22.setText("");
            }
            
            else if(rt==0 || sa==0){
                JOptionPane.showMessageDialog(this,"The loan  is fully paid","Error",JOptionPane.ERROR_MESSAGE);
                jTextField22.setText("");
            }//else if(ryi == ryi){
               // JOptionPane.showMessageDialog(this,"The deduction is next month","Error",JOptionPane.ERROR_MESSAGE);
                //jTextField22.setText("");
            //}
            
            else{
                balanceremainingg.setText("0");
                jTextField1q.setText("0");
                jTextField1o.setText("0");
                monthleftss.setText("0");
                paidd.setText("Fully Paid");
                jTextField2ii.setText("0");
                
                
              String fname_customer = applicantsname.getText();
              String fpayment_customer = jTextField22.getText();
              String fmonth_duration_left_customer = monthleftss.getText();
              String finterest_customer = jTextField1o.getText();
              String fprincipal_customer = jTextField1q.getText();
              String fdate_of_transaction_customer = jLabel100.getText();
              String fapplicant_id = idd1.getText();
              String fbalance_customer = balanceremainingg.getText();
              String fpaid_or_not = paidd.getText();

            try{
                
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/essusserver","root","essustealoanmanagementsystem01");  
                String input = "insert into fapplicant_transaction(fname_customer,fpayment_customer,fmonth_duration_left_customer,finterest_customer,fprincipal_customer,fdate_of_transaction_customer,fapplicant_id,fbalance_customer,fpaid_or_not)values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement database = con.prepareStatement(input);
                
                database.setString(1, fname_customer);
                database.setString(2, fpayment_customer);
                database.setString(3, fmonth_duration_left_customer);
                database.setString(4, finterest_customer);
                database.setString(5, fprincipal_customer);
                database.setString(6, fdate_of_transaction_customer);
                database.setString(7, fapplicant_id);
                database.setString(8, fbalance_customer);
                database.setString(9, fpaid_or_not);
                
                JOptionPane.showMessageDialog(this,"Sucessfull","Success",JOptionPane.INFORMATION_MESSAGE);
                
                database.executeUpdate();
                bayad();
                
               if (jTextField22.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data !!");
        } else {

            String data3[] = {jTextField22.getText(), monthleftss.getText(), jTextField1o.getText(), jTextField1q.getText(), paidd.getText(),jLabel100.getText()};

            DefaultTableModel tblm3 = (DefaultTableModel) tapay.getModel();
            tblm3.addRow(data3);
        }
           
            jTextField22.setText("");
            }catch(Exception ex){
                System.out.println("Error" + ex.getMessage());
            }
            
            }
            

            if(sa==0){
                  JOptionPane.showMessageDialog(this,"The balance is already paid and\nit cannot edit it anymore","ERROR",JOptionPane.ERROR_MESSAGE);
                  jTextField22.setText("");
              } 

            

            
        //############### r2.isSelected here : ################################//    
            
        }else if(r2.isSelected()==true){
            //condition here: 
            
            String lc = jTextField2ii.getText();
            double kd = Double.parseDouble(lc);
            
            double ghk = Double.parseDouble(balanc_1.getText());
       
            String yb = balanceee.getText();
            double pv = Double.parseDouble(balanceee.getText());
      // a
            double kj = pv - ghk;
       
            String  df = jTextField21.getText();
            String ft = paidd.getText();
            
            String ryi = MonthYear.getText();
            
            String hyuo = monthz.getText();
            
            if(ghk < kd || ghk > kd){
                JOptionPane.showMessageDialog(this, "Payment doesen't match to Monthly Amortization","Error",JOptionPane.ERROR_MESSAGE);
                jTextField22.setText("");
            }//else if(ryi == ryi){
               // JOptionPane.showMessageDialog(this,"The deduction is next month","ERROR",JOptionPane.ERROR_MESSAGE);
               // jTextField22.setText("");
          //  }
            //else 
            
            else{
                balanceremainingg.setText(""+kj);
            
            String fx = balanceremainingg.getText();
            double lk = Double.parseDouble(fx);
            balanceremainingg.setText(String.format("%,.0f",lk)+".00");
            
            String yi = monthleftss.getText();
            int ry = Integer.parseInt(yi);
            int im = 1;
            int ub = ry-im;
            paidd.setText("Not fully paid");
            monthleftss.setText(ub+"");
            
            
            
            
              String fname_customer = applicantsname.getText();
              String fpayment_customer = jTextField22.getText();
              String fmonth_duration_left_customer = monthleftss.getText();
              String finterest_customer = jTextField1o.getText();
              String fprincipal_customer = jTextField1q.getText();
              String fdate_of_transaction_customer = jLabel100.getText();
              String fapplicant_id = idd1.getText();
              String fbalance_customer = balanceremainingg.getText();
              String fpaid_or_not = paidd.getText();

            try{
                
                Connection con;
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/essusserver","root","essustealoanmanagementsystem01");  
                String input = "insert into fapplicant_transaction(fname_customer,fpayment_customer,fmonth_duration_left_customer,finterest_customer,fprincipal_customer,fdate_of_transaction_customer,fapplicant_id,fbalance_customer,fpaid_or_not)values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement database = con.prepareStatement(input);
                
                database.setString(1, fname_customer);
                database.setString(2, fpayment_customer);
                database.setString(3, fmonth_duration_left_customer);
                database.setString(4, finterest_customer);
                database.setString(5, fprincipal_customer);
                database.setString(6, fdate_of_transaction_customer);
                database.setString(7, fapplicant_id);
                database.setString(8, fbalance_customer);
                database.setString(9, fpaid_or_not);
                
                JOptionPane.showMessageDialog(this,"Sucessfull","Success",JOptionPane.INFORMATION_MESSAGE);
                
                database.executeUpdate();
                bayad();
                
                jTextField22.setEditable(false);
                
                if (jTextField22.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data !!");
        } else {

            String data3[] = {jTextField22.getText(), monthleftss.getText(), jTextField1o.getText(), jTextField1q.getText(), paidd.getText(),jLabel100.getText()};

            DefaultTableModel tblm3 = (DefaultTableModel) tapay.getModel();
            tblm3.addRow(data3);
        }
                
               // if(hyuo == hyuo){
                //JOptionPane.showMessageDialog(this, "Payment is done","Error",JOptionPane.ERROR_MESSAGE);
                
                jTextField22.setText("");
                jTextField22.setEditable(false);
           // }
           
          //  jTextField22.setText("");
            
            }catch(Exception ex){
                System.out.println("Error" + ex.getMessage());
            }
            
            }
             
            
            
            
            
            
            
        }else if(r1.isSelected()==false){
            JOptionPane.showMessageDialog(this, "Please select if Full Payment or Month Payment","Error",JOptionPane.ERROR_MESSAGE);
        }else if(r2.isSelected()==false){
            JOptionPane.showMessageDialog(this, "Please select if Full Payment or Month Payment","Error",JOptionPane.ERROR_MESSAGE);
        }

        
        
        
    }//GEN-LAST:event_payyyActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField22KeyTyped

    private void balanceremaininggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceremaininggActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceremaininggActionPerformed

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        // TODO add your handling code here:
        String gagoa = jTextField22.getText();
        
        balanc_1.setText(""+gagoa);
        double valuea = Double.parseDouble(balanc_1.getText().replaceAll(",", ""));
        balanc_1.setText(valuea+"");

    }//GEN-LAST:event_jTextField22KeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //applicants();
            double gg = Double.parseDouble(jTextField2ii.getText());
            double hh = Double.parseDouble(jTextField1o.getText());
            double pp = gg-hh;
            jTextField1q.setText(pp+"");
            
            
            
            
            String qw = balanceremainingg.getText();
            double sx = Double.parseDouble(qw);
            balanceremainingg.setText(String.format("%,.0f",sx));
    }//GEN-LAST:event_formWindowOpened

    private void applicantsnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_applicantsnameKeyReleased
        // TODO add your handling code here:
        //applicants();
    }//GEN-LAST:event_applicantsnameKeyReleased

    private void applicantsnameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_applicantsnameCaretUpdate
        // TODO add your handling code here:
        //applicants();
    }//GEN-LAST:event_applicantsnameCaretUpdate

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void jTextField1oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1oActionPerformed

    private void monthleftssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthleftssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthleftssActionPerformed

    private void idd1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_idd1CaretUpdate
        // TODO add your handling code here:
        applicants();
        
        String lk = jTextField16.getText();
        
        jTextField1o.setText(lk);
        double val=Double.parseDouble(jTextField1o.getText().replaceAll(",", ""));
        jTextField1o.setText(val+"");
        
        
        String yx = jTextField19.getText();
        
        jTextField2ii.setText(""+yx);
        double yn = Double.parseDouble(jTextField2ii.getText().replaceAll(",", ""));
        jTextField2ii.setText(yn+"");
        
        
        String kg = balanceremainingg.getText();
        balanceee.setText(""+kg);
        double ou = Double.parseDouble(balanceee.getText().replaceAll(",",""));
        balanceee.setText(""+ou);
        
    }//GEN-LAST:event_idd1CaretUpdate

    private void jTextField2iiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2iiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2iiActionPerformed

    private void jTextField2iiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2iiCaretUpdate
        // TODO add your handling code here:
 
    }//GEN-LAST:event_jTextField2iiCaretUpdate

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m2ActionPerformed

    private void jTextField15CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField15CaretUpdate
        // TODO add your handling code here:
        
        
         
    }//GEN-LAST:event_jTextField15CaretUpdate

    private void paiddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paiddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paiddActionPerformed

    private void balanc_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanc_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanc_1ActionPerformed

    private void balanceeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceeeActionPerformed

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
            java.util.logging.Logger.getLogger(applicants_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(applicants_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(applicants_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(applicants_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applicants_data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MonthYear;
    public static javax.swing.JTextField amo_noFilter;
    public static javax.swing.JTextField applicantsname;
    private javax.swing.JTextField balanc_1;
    public static javax.swing.JTextField balanceee;
    public static javax.swing.JTextField balanceremainingg;
    private javax.swing.ButtonGroup buttonGroupRadiobutton;
    public static javax.swing.JTextField idd1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField jTextField133;
    public static javax.swing.JTextField jTextField15;
    public static javax.swing.JTextField jTextField16;
    public static javax.swing.JTextField jTextField17;
    public static javax.swing.JTextField jTextField18;
    public static javax.swing.JTextField jTextField19;
    public static javax.swing.JTextField jTextField1o;
    private javax.swing.JTextField jTextField1q;
    public static javax.swing.JTextField jTextField20;
    public static javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    public static javax.swing.JTextField jTextField2ii;
    private javax.swing.JLabel klj;
    public static javax.swing.JTextField m2;
    public static javax.swing.JTextField monthleftss;
    private javax.swing.JTextField monthz;
    private javax.swing.JTextField paidd;
    private javax.swing.JButton payyy;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JTable tapay;
    // End of variables declaration//GEN-END:variables
}
