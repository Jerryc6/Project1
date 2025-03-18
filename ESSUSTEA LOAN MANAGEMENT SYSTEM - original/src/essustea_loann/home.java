/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 * Gin himo eni nga system han batch 2023-2024,
 * nahibaroan ko nga dre la haro mamay it paghimo ht software, wry kataposan nga pag code, pag inaram, pag pinan miling hin mga sources han code,
 * ngan napalipong ha ulo, ma abot it point nga gin kaka storya mo nat imo kalugaringon, pag pipinakianahan mo tim kalugaringon ma buo mo mola it system haha.
 * makalilipay kon nakaka asya ngan it imo mga theory na o ungod haha, agi pag pinanmiling han codes pag inaram ht iba iba nga methods damo nak nag ka de discover
 * ha internet hasta nga nan hihingadto nak ht mga website nga dre mahi aag an ha chrome ngan google. "DARK WEB" nag set up lak hn proxy para maiba ko it ak location,
 * para dre malocate it ungod nga public ip nak gin ko conneckan nga wifi, private ip ht loptop, ngan an usb gn installan ko hin operating system asyat ak gn gagamit
 * kysa htun operating system ht loptop, para dikitan ngani hn malware or ano la nga virus dre apektado an loptop. asya ghap nga nag iniha an pag hinimo hni nga system 
 * ky agin kadamo nak nag ka didiscover wry nak pakag fucos nak system haha. hasta nga nag iinaram ak hin panhimo himo hin virus. na aastigan la ak ky pina agi la hin
 * code kaya mo ma control it dre imo loptop ngan mababaroan mo kon anot aada ht iya file manager.
 * so yun damo pa adto nan hingalimtan ko an iba. kon nabasa mo eni always be positve ngan isipa permi nga ngatanan nga problema myda solustion, 
 * mas mahiloag it langit kysa ht tuna, kaya damo permi it solosyon.
 *  
 */
package essustea_loann;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
//import javaapplication12.LoanRecord;
//import javaapplication12.mainframe;
//import static javaapplication12.mainframe.numberToWords;
//import static javaapplication12.mainframe.numberToWordss;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Sandy Ogaro, Mark Kenneth Diangzon, Johnrey Bagason, Jerryc Lanuevo
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    Statement st;

    public home() {

        initComponents();

        String url = "jdbc:mysql://127.0.0.1:3306/essusserver";
        String user = "root";
        String pass = "essustealoanmanagementsystem01";
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }

        ddd();
        dt();
        payment_now();
        applicants_contact_info();
        applicants_personal_loan();
        ikaduha();
        //payrecords();
        ddd1();

        trasac();
    }
    //Show_data_inTable tabless = new Show_data_inTable();

    public void ddd() {
        dAte.setText(addSubtractDate(1));
    }

    public static String addSubtractDate(int n) {
        DateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, n);
        String result = dateFormat.format(cal.getTime());
        return result;
    }
    
    public void ddd1() {
        date2.setText(addSubtractDatee(1));
    }
    
    public static String addSubtractDatee(int nn) {
        DateFormat dateFormatt = new SimpleDateFormat("MM yyyy");
        Calendar call = Calendar.getInstance();
        call.add(Calendar.MONTH, nn);
        String resultt = dateFormatt.format(call.getTime());
        return resultt;
    }

    public void dt() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy");
        String dd = sdf.format(d);

        date1.setText(dd);
    }

    public void payment_now() {
        String l = "SELECT * FROM floan_records";

        try {
            PreparedStatement pst = con.prepareStatement(l);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tablerecord.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(9)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

    public void payment_noww() {
        String l = "SELECT * FROM floan_records ORDER BY fapplicant_id DESC";

        try {
            PreparedStatement pst = con.prepareStatement(l);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tablerecord.getModel();
            if (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(9)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

    public void applicants_contact_info() {
        String ll = "SELECT * FROM floan_records";

        try {
            PreparedStatement pst = con.prepareStatement(ll);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(3), rs.getString(11)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

    public void applicants_personal_loan() {
        String lll = "SELECT * FROM floan_records";

        try {
            PreparedStatement pst = con.prepareStatement(lll);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

    public void ikaduha() {
        String llll = "SELECT * FROM floan_records";

        try {
            PreparedStatement pst = con.prepareStatement(llll);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }
    
    
    
     public void trasac() {
        String llll = "SELECT * FROM fapplicant_transaction";

        try {
            PreparedStatement pst = con.prepareStatement(llll);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(9),rs.getString(7),rs.getString(10)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }
    
    
    
    

    public void payrecords() {
        String record = "SELECT * FROM fessu_loan";

        try {
            PreparedStatement pst = con.prepareStatement(record);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tablerecord.getModel();
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }

//******************************************************************************//
    public void applicants_dataa() {

        String uun = ed.getText();

        try {
            String sql = "SELECT * FROM floan_records WHERE fapplicant_id=?";
            pst = con.prepareCall(sql);

            pst.setString(1, uun);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                nname.setText(rs.getString(2));
                loanableamount.setText(rs.getString(4));
                servicefee.setText(rs.getString(5));
                netamount.setText(rs.getString(6));
                interestpermonth.setText(rs.getString(7));
                moamortization.setText(rs.getString(8));
                monthduration.setText(rs.getString(9));
                startofdeduction.setText(rs.getString(10));
                dateof.setText(rs.getString(11));

                bal.setText(rs.getString(12));
                curentM.setText(rs.getString(13));

                jTextField2.setText(rs.getString(18));
                jTextField5.setText(rs.getString(19));
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
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

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dAte = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        b1 = new javax.swing.JTextArea();
        jtxtName = new javax.swing.JTextField();
        jtxtContact = new javax.swing.JTextField();
        jtxtLoanableAmount = new javax.swing.JTextField();
        comboStartDeductio = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        ido = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablerecord = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nname = new javax.swing.JTextField();
        loanableamount = new javax.swing.JTextField();
        servicefee = new javax.swing.JTextField();
        netamount = new javax.swing.JTextField();
        interestpermonth = new javax.swing.JTextField();
        moamortization = new javax.swing.JTextField();
        monthduration = new javax.swing.JTextField();
        startofdeduction = new javax.swing.JTextField();
        dateof = new javax.swing.JTextField();
        bal = new javax.swing.JTextField();
        curentM = new javax.swing.JTextField();
        ed = new javax.swing.JTextField();
        no_FilterAmo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jtxtInterestperMonth = new javax.swing.JTextField();
        jtxtNetAmount = new javax.swing.JTextField();
        jtxtMonthlyAmo = new javax.swing.JTextField();
        jtxtServiceFee = new javax.swing.JTextField();
        jtxtLoanWord = new javax.swing.JTextField();
        jtxtMonthlyAmoW = new javax.swing.JTextField();
        jtxtMonthDu = new javax.swing.JTextField();
        balanceremaining = new javax.swing.JTextField();
        monthdurationleft = new javax.swing.JTextField();
        payment = new javax.swing.JTextField();
        dateoftrans = new javax.swing.JTextField();
        nname1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        date2 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        LABEL = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        JlABLE = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        Pdate = new javax.swing.JTextField();
        Pname = new javax.swing.JTextField();
        Pcontact = new javax.swing.JTextField();
        Ploanableword = new javax.swing.JTextField();
        loanableN = new javax.swing.JTextField();
        PloanableAmount = new javax.swing.JTextField();
        Pservicefee = new javax.swing.JTextField();
        Pnetamount = new javax.swing.JTextField();
        Pinterestpermonth = new javax.swing.JTextField();
        Pmoamortization = new javax.swing.JTextField();
        Pduration = new javax.swing.JTextField();
        Pstartofdeduction = new javax.swing.JTextField();
        PPdate = new javax.swing.JTextField();
        PPname = new javax.swing.JTextField();
        PPloanableword = new javax.swing.JTextField();
        PPloanableamount = new javax.swing.JTextField();
        PPmoamortizationword = new javax.swing.JTextField();
        PPmoamortization = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        PPstartofdeduction = new javax.swing.JTextField();
        dasdasdasdasdds = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 770));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));

        dAte.setForeground(new java.awt.Color(0, 153, 0));
        dAte.setText("jLabel19");

        date1.setForeground(new java.awt.Color(0, 153, 0));
        date1.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(dAte, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date1)
                    .addComponent(dAte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 0, 1130, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("ESSUSTEA LOAN MANAGEMENT SYSTEM - CREATE LOAN");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 26, 541, -1));

        b1.setEditable(false);
        b1.setBackground(new java.awt.Color(51, 51, 51));
        b1.setColumns(20);
        b1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 153, 51));
        b1.setRows(5);
        jScrollPane1.setViewportView(b1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 54, 1030, 456));
        jPanel4.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 551, 228, 30));

        jtxtContact.setDocument(new JavaApplication12(15));
        jtxtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtContactActionPerformed(evt);
            }
        });
        jPanel4.add(jtxtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 220, 29));

        jtxtLoanableAmount.setEditable(false);
        jtxtLoanableAmount.setForeground(new java.awt.Color(255, 255, 255));
        jtxtLoanableAmount.setBorder(null);
        jtxtLoanableAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtLoanableAmountKeyTyped(evt);
            }
        });
        jPanel4.add(jtxtLoanableAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 160, 30));

        comboStartDeductio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        comboStartDeductio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboStartDeductio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStartDeductioActionPerformed(evt);
            }
        });
        jPanel4.add(comboStartDeductio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, 160, 28));

        jButton3.setText("CLEAR");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 110, 34));

        jLabel2.setText("CONTACT NUMBER");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 115, 20));

        jLabel3.setText("APPLICANT NAME");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 522, 115, -1));

        jLabel4.setText("MONTH DURATION");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 160, -1));

        jLabel5.setText("LOANABLE AMOUNT");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 522, 738, -1));

        jButton8.setText("PRINT");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 190, 34));

        jButton9.setText("SAVE");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 110, 34));

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 160, -1));

        ido.setEditable(false);
        ido.setForeground(new java.awt.Color(255, 255, 255));
        ido.setText("jTextField8");
        ido.setBorder(null);
        jPanel4.add(ido, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 610, -1, -1));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablerecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablerecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.#", "APPLICANT NAME", "CONTACT NUMBER", "LOAN BALANCE", "MONTH DURATION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablerecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablerecord.setGridColor(new java.awt.Color(0, 0, 0));
        tablerecord.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tablerecord.setShowGrid(true);
        tablerecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablerecordMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablerecord);
        if (tablerecord.getColumnModel().getColumnCount() > 0) {
            tablerecord.getColumnModel().getColumn(0).setMinWidth(100);
            tablerecord.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablerecord.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1110, 520));

        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("SEARCH NAME");
        jTextField1.setBorder(null);
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("ESSUSTEA LOAN MANAGEMENT SYSTEM - PAY LOAN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 621, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("RECENT");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 50, -1));

        nname.setForeground(new java.awt.Color(255, 255, 255));
        nname.setText("jTextField2");
        nname.setBorder(null);
        nname.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nnameCaretUpdate(evt);
            }
        });
        nname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nnameKeyTyped(evt);
            }
        });
        jPanel5.add(nname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));

        loanableamount.setForeground(new java.awt.Color(255, 255, 255));
        loanableamount.setText("jTextField2");
        loanableamount.setBorder(null);
        loanableamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanableamountActionPerformed(evt);
            }
        });
        jPanel5.add(loanableamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 50, 30));

        servicefee.setForeground(new java.awt.Color(255, 255, 255));
        servicefee.setText("jTextField9");
        servicefee.setBorder(null);
        jPanel5.add(servicefee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 40, 30));

        netamount.setForeground(new java.awt.Color(255, 255, 255));
        netamount.setText("jTextField5");
        netamount.setBorder(null);
        jPanel5.add(netamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 30, -1));

        interestpermonth.setForeground(new java.awt.Color(255, 255, 255));
        interestpermonth.setText("jTextField4");
        interestpermonth.setBorder(null);
        jPanel5.add(interestpermonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, 20));

        moamortization.setForeground(new java.awt.Color(255, 255, 255));
        moamortization.setText("jTextField7");
        moamortization.setBorder(null);
        jPanel5.add(moamortization, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 40, 30));

        monthduration.setEditable(false);
        monthduration.setForeground(new java.awt.Color(255, 255, 255));
        monthduration.setText("jTextField7");
        monthduration.setBorder(null);
        jPanel5.add(monthduration, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 90, 30));

        startofdeduction.setEditable(false);
        startofdeduction.setForeground(new java.awt.Color(255, 255, 255));
        startofdeduction.setText("jTextField7");
        startofdeduction.setBorder(null);
        jPanel5.add(startofdeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 70, 30));

        dateof.setForeground(new java.awt.Color(255, 255, 255));
        dateof.setText("jTextField6");
        dateof.setBorder(null);
        dateof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateofActionPerformed(evt);
            }
        });
        jPanel5.add(dateof, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 40, -1));

        bal.setForeground(new java.awt.Color(255, 255, 255));
        bal.setText("jTextField6");
        bal.setBorder(null);
        jPanel5.add(bal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 40, -1));

        curentM.setForeground(new java.awt.Color(255, 255, 255));
        curentM.setText("jTextField6");
        curentM.setBorder(null);
        jPanel5.add(curentM, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 30, -1));

        ed.setEditable(false);
        ed.setForeground(new java.awt.Color(255, 255, 255));
        ed.setBorder(null);
        jPanel5.add(ed, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, -1));

        no_FilterAmo.setEditable(false);
        no_FilterAmo.setForeground(new java.awt.Color(255, 255, 255));
        no_FilterAmo.setText("jTextField8");
        no_FilterAmo.setBorder(null);
        jPanel5.add(no_FilterAmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, -1, -1));

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("APPLICANTS PERSONAL PAYMENT RECORDS");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 970, 430, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "APPLICANT NAME", "PAYMENT", "MONTH LEFT", "INTEREST", "PRINCIPAL", "BALANCE", "DATE", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jPanel9.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1020, 1030, 200));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("APPLICANTS PERSONAL LOAN AND INFORMATION RECORDS");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 50));

        jPanel14.setBackground(new java.awt.Color(0, 153, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("APPLICANTS CONTACT INFO");

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME OF APPLICANT", "CONTACT NUMBER", "DATE"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jTable2.setShowGrid(true);
        jScrollPane3.setViewportView(jTable2);

        jPanel15.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1050, 240));

        jPanel17.setBackground(new java.awt.Color(0, 153, 0));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "APPLICANT NAME", "LOANABLE AMOUNT", "SERVICE FEE", "NET AMOUNT", "INTEREST PER MONTH"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "APPLICANT NAME", "MONTHLY AMORTIZATION", "MONTH DURATION", "START OF DEDUCTION", "DATE"
            }
        ));
        jScrollPane6.setViewportView(jTable5);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("APPLICANTS PERSONAL LOAN");

        jPanel18.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addComponent(jScrollPane4)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 360, 1050, 590));

        jScrollPane8.setViewportView(jPanel9);

        jPanel7.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 640));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1060, 640));

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel11.setBackground(new java.awt.Color(51, 204, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtInterestperMonth.setText("jTextField1");
        jPanel11.add(jtxtInterestperMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 17, 145, -1));

        jtxtNetAmount.setText("jTextField2");
        jPanel11.add(jtxtNetAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 145, -1));

        jtxtMonthlyAmo.setText("jTextField3");
        jPanel11.add(jtxtMonthlyAmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 145, -1));

        jtxtServiceFee.setText("jTextField4");
        jPanel11.add(jtxtServiceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 145, -1));

        jtxtLoanWord.setText("jTextField5");
        jPanel11.add(jtxtLoanWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 151, -1));

        jtxtMonthlyAmoW.setText("jTextField6");
        jPanel11.add(jtxtMonthlyAmoW, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 139, -1));

        jtxtMonthDu.setText("jTextField1");
        jPanel11.add(jtxtMonthDu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 145, -1));

        balanceremaining.setText("jTextField6");
        jPanel11.add(balanceremaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        monthdurationleft.setText("jTextField7");
        monthdurationleft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthdurationleftActionPerformed(evt);
            }
        });
        jPanel11.add(monthdurationleft, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        payment.setText("jTextField8");
        jPanel11.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        dateoftrans.setText("jTextField9");
        jPanel11.add(dateoftrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        nname1.setText("jTextField2");
        nname1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                nname1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel11.add(nname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 180, -1));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jTextField3.setText("jTextField3");
        jPanel11.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jTextField4.setText("jTextField4");
        jPanel11.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jTextField5.setText("jTextField5");
        jPanel11.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jTextField6.setText("jTextField6");
        jPanel11.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        date2.setText("jTextField8");
        jPanel11.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel10);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("BELOW THIS LINE TO BE FILLED UP BY THE PROJECT IN-CHARGE");
        jPanel16.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 790, 58));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("APPLICATION FOR CHARACTER SALARY LOAN");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 580, 32));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel33.setText("DATE :");
        jPanel16.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 164, 60, 30));

        LABEL.setText("________________________________________________");
        jPanel16.add(LABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel34.setText("CONTACT NUMBER :");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 190, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel35.setText("Fill in the blanks properly and legibly.");
        jPanel16.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, 20));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel37.setText("DIRECTIONS:");
        jPanel16.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, -1));

        JlABLE.setText("________________________________________________________________");
        jPanel16.add(JlABLE, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 20));

        jLabel38.setText("________________________________________________________________");
        jPanel16.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, 20));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel40.setText("NAME OF APPLICANT :");
        jPanel16.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 210, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel36.setText("I hereby apply for a loan with a gross amount of:");
        jPanel16.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 390, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setText("_______________________________________________________________________");
        jPanel16.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 570, 40));

        jLabel41.setText("____________________________________________");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 230, 20));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel42.setText("( Php )");
        jPanel16.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 60, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Project Incharge/Tresurer");
        jPanel16.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1090, 210, 20));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("PROMISORY NOTE");
        jPanel16.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 1100, 412, 58));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel46.setText("______________________________________________________________________________________________");
        jPanel16.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1070, 1430, 50));

        jLabel47.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel47.setText("Service Fee :");
        jPanel16.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, -1, -1));

        jLabel48.setText("__________________________________________________________");
        jPanel16.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 860, 290, 20));

        jLabel49.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel49.setText("Loanable Amount :");
        jPanel16.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 170, -1));

        jLabel50.setText("_________________________________________________________");
        jPanel16.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 650, 290, 20));

        jLabel51.setText("________________________________________________________");
        jPanel16.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 690, 280, -1));

        jLabel52.setText("________________________________________________________");
        jPanel16.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, 290, -1));

        jLabel53.setText("________________________________________________________");
        jPanel16.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 760, 280, -1));

        jLabel54.setText("__________________________________________________________");
        jPanel16.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 800, 280, -1));

        jLabel55.setText("_________________________________________________________");
        jPanel16.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 830, 280, -1));

        jLabel56.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel56.setText("Start of Deduction :");
        jPanel16.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 860, -1, 20));

        jLabel57.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel57.setText("Net Amount :");
        jPanel16.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, -1, 20));

        jLabel58.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel58.setText("Interest per Month :");
        jPanel16.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, -1, 20));

        jLabel59.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel59.setText("Mo. Amortization :");
        jPanel16.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, -1, 30));

        jLabel60.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel60.setText("Duration :");
        jPanel16.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 830, -1, 20));

        jLabel61.setText("____________________________________________________");
        jPanel16.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 250, 30));

        jLabel62.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Signature of Borrower");
        jPanel16.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 500, 230, -1));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("JOSEPH S. ABUNALES");
        jPanel16.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1070, 230, -1));

        jLabel64.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Name of Borrower");
        jPanel16.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 1470, 190, 20));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel65.setText("_______________________________________________________________________________________");
        jPanel16.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 1420, 50));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("ESSUSTEA MONITARY SUPPORT");
        jPanel16.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 33, 620, 58));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel67.setText("DATE :");
        jPanel16.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 1160, 90, -1));

        jLabel69.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel69.setText("I,");
        jPanel16.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1200, 20, 40));

        jLabel70.setText("_____________________________________________________________");
        jPanel16.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1270, 210, 20));

        jLabel71.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel71.setText("having receive the amount of");
        jPanel16.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 1210, 240, -1));

        jLabel72.setText("________________________________________________________");
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 1280, 220, 20));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel73.setText("( Php)");
        jPanel16.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1260, 50, 40));

        jLabel74.setText("_________________________________________________");
        jPanel16.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 1240, 200, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel75.setText("In the event I failed to settle the monthly amortization, I waive my rights not to  enjoy any Government & Private loan until");
        jPanel16.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1350, 1220, -1));

        jLabel76.setText("_______________________________________________");
        jPanel16.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1210, 220, 20));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel77.setText("( Php)");
        jPanel16.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1230, -1, -1));

        jLabel78.setText("______________________________________________________________________________________");
        jPanel16.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1210, 430, 30));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel79.setText("authorize the payroll starting the amount of");
        jPanel16.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1230, 370, -1));

        jLabel80.setText("________________________________________________________________________________________");
        jPanel16.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1230, 490, 30));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel81.setText("from the payroll starting the ");
        jPanel16.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 1270, 240, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel82.setText("until the total sum will be paid.");
        jPanel16.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1300, 260, 30));

        jLabel83.setText("____________________________________________________");
        jPanel16.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 980, 250, 30));

        jLabel84.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Signature of Borrower");
        jPanel16.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 1000, 210, 20));

        jLabel85.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Signature over Printed Name");
        jPanel16.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1450, 280, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Pesos only.");
        jPanel16.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 320, 90, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("amount of");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 1270, 90, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText(" my monthly amortization amortization is fully setteld.");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 1370, 480, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Pesos only.");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 1210, 90, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Pesos only.");
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1260, -1, 40));

        jLabel43.setText("_______________________________________________________");
        jPanel16.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1430, -1, 20));

        Pdate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pdate.setBorder(null);
        Pdate.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel16.add(Pdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 290, 30));

        Pname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pname.setBorder(null);
        Pname.setCaretColor(new java.awt.Color(255, 255, 255));
        Pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PnameActionPerformed(evt);
            }
        });
        jPanel16.add(Pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 270, -1));

        Pcontact.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pcontact.setBorder(null);
        Pcontact.setCaretColor(new java.awt.Color(255, 255, 255));
        Pcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PcontactActionPerformed(evt);
            }
        });
        jPanel16.add(Pcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 230, -1));

        Ploanableword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Ploanableword.setBorder(null);
        Ploanableword.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel16.add(Ploanableword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 520, -1));

        loanableN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loanableN.setBorder(null);
        loanableN.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel16.add(loanableN, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 180, 40));

        PloanableAmount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PloanableAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PloanableAmount.setText("jTextField7");
        PloanableAmount.setBorder(null);
        jPanel16.add(PloanableAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, 270, -1));

        Pservicefee.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pservicefee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pservicefee.setText("jTextField7");
        Pservicefee.setBorder(null);
        jPanel16.add(Pservicefee, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, 270, -1));

        Pnetamount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pnetamount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pnetamount.setText("jTextField7");
        Pnetamount.setBorder(null);
        jPanel16.add(Pnetamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 710, 270, 30));

        Pinterestpermonth.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pinterestpermonth.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pinterestpermonth.setText("jTextField7");
        Pinterestpermonth.setBorder(null);
        jPanel16.add(Pinterestpermonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 750, 270, -1));

        Pmoamortization.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pmoamortization.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pmoamortization.setText("jTextField7");
        Pmoamortization.setBorder(null);
        jPanel16.add(Pmoamortization, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 790, 270, -1));

        Pduration.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pduration.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pduration.setText("jTextField7");
        Pduration.setBorder(null);
        jPanel16.add(Pduration, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 820, 270, -1));

        Pstartofdeduction.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Pstartofdeduction.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pstartofdeduction.setText("jTextField7");
        Pstartofdeduction.setBorder(null);
        jPanel16.add(Pstartofdeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 850, 270, -1));

        PPdate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PPdate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        PPdate.setText("jTextField7");
        PPdate.setBorder(null);
        jPanel16.add(PPdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 1150, 140, 40));

        PPname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PPname.setText("jTextField7");
        PPname.setBorder(null);
        PPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPnameActionPerformed(evt);
            }
        });
        jPanel16.add(PPname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1200, 220, 30));

        PPloanableword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PPloanableword.setText("jTextField7");
        PPloanableword.setBorder(null);
        jPanel16.add(PPloanableword, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 1210, 310, -1));

        PPloanableamount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PPloanableamount.setText("jTextField7");
        PPloanableamount.setBorder(null);
        jPanel16.add(PPloanableamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1230, 220, -1));

        PPmoamortizationword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PPmoamortizationword.setText("jTextField7");
        PPmoamortizationword.setBorder(null);
        jPanel16.add(PPmoamortizationword, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 1230, 590, -1));

        PPmoamortization.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PPmoamortization.setText("jTextField7");
        PPmoamortization.setBorder(null);
        jPanel16.add(PPmoamortization, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1270, 200, -1));

        jLabel68.setText("___________________________________________");
        jPanel16.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1280, 210, 20));

        PPstartofdeduction.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        PPstartofdeduction.setText("jTextField7");
        PPstartofdeduction.setBorder(null);
        PPstartofdeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPstartofdeductionActionPerformed(evt);
            }
        });
        jPanel16.add(PPstartofdeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 1270, 190, -1));

        dasdasdasdasdds.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dasdasdasdasdds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dasdasdasdasdds.setText("jTextField7");
        dasdasdasdasdds.setToolTipText("");
        dasdasdasdasdds.setBorder(null);
        jPanel16.add(dasdasdasdasdds, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1420, 250, -1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1430, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1490, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab5", jPanel12);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 1120, 700));

        jButton4.setBackground(new java.awt.Color(51, 153, 0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CREATE LOAN");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 60));

        jButton5.setBackground(new java.awt.Color(51, 153, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("PAY LOAN");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 320, 60));

        jButton6.setBackground(new java.awt.Color(51, 153, 0));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("LOAN RECORDS");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 320, 60));

        jButton7.setBackground(new java.awt.Color(51, 153, 0));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("LOGOUT");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 320, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/fflogo.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 200, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1478, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtContactActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jtxtName.setText("");
        jtxtContact.setText("");
        jtxtLoanableAmount.setText("");
        b1.setText("");
        jTextField7.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboStartDeductioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStartDeductioActionPerformed

        b1.setText("");
        
        String nams = jtxtName.getText();
        String nums = jtxtContact.getText();
        String loans = jtxtLoanableAmount.getText();
        String monthD = jtxtMonthDu.getText();

        if (nams.equals("") && nums.equals("") && loans.equals("") && monthD.equals("")) {
            JOptionPane.showMessageDialog(this, "No Loanable Amount", "Message", JOptionPane.ERROR_MESSAGE);
        } else {

        }

// TODO add your handling code here:
        String start = comboStartDeductio.getSelectedItem().toString();
        jtxtMonthDu.setText(start);

        if (jtxtName.getText().length() <= 0 || jtxtContact.getText().length() <= 0 || jtxtLoanableAmount.getText().length() <= 0 || jtxtMonthDu.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill in the blanks propely and legibly", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int num1 = Integer.parseInt(jtxtLoanableAmount.getText());
            do {
                if (num1 >= 1 && num1 <= 10000000) {
                    jtxtLoanWord.setText(numberToWords(num1));
                } else {
                    //  jtxtLoanWord.setText("Ivalid");
                }
            } while (num1 <= 0 || num1 > 1000000);

            double num3 = 0.02;
            int num4 = Integer.parseInt(jtxtMonthDu.getText());
            int num5 = num4;

            // num3 is service fee = 0.02 computation naman is loanable amount * 0.02
            double serviceRes = num1 * num3;

            // pagkuha naman ht Net Amount is Loanable Amount Minus Services Fee is equal Net Amount
            double result = num1 - serviceRes;

            // Pagkuha naman han monthly amount service fee * how many month + loanble amount / month
            double resmonthly = serviceRes * num5 + num1;
            double diVayd = resmonthly / num4;

            // Result Below //
            jtxtInterestperMonth.setText("2%"); 
            jtxtNetAmount.setText("" + result); //loanble amount - service fee = net amount
            jtxtServiceFee.setText("" + serviceRes);// loanable amount * 0.02
            jtxtMonthlyAmo.setText("" + diVayd);// service fee * month + loanable amount / month

            balanceremaining.setText("" + num1);

            String aa = comboStartDeductio.getSelectedItem().toString();
            monthdurationleft.setText(aa);
            jtxtMonthDu.setText(aa);
            payment.setText("" + num1);
            dateoftrans.setText("date");

            if (num1 == 0) {
                JOptionPane.showMessageDialog(this, "Error data", "Error", JOptionPane.ERROR_MESSAGE);
            }

            String tr = jtxtMonthlyAmo.getText();
            double d = Double.parseDouble(tr);
            jtxtMonthlyAmo.setText(String.format("%.0f", d));

            jTextField3.setText(""); //servicefee
            jTextField2.setText(diVayd + ""); //mo amortization

            jTextField4.setText(diVayd + ""); //payement
            // minus
            jTextField5.setText(serviceRes + ""); //interestm
            String tr4r = jTextField4.getText();
            double dd8 = Double.parseDouble(tr4r);
            jTextField4.setText(String.format("%,.0f", dd8) + ".00"); //amortization

            String sss = jTextField5.getText();
            double ssss = Double.parseDouble(sss);
            jTextField5.setText(String.format("%.0f", ssss)); //service fee

            int num = Integer.parseInt(jtxtMonthlyAmo.getText());
            do {
                if (num >= 1 && num <= 10000000) {
                    jtxtMonthlyAmoW.setText(numberToWordss(num));
                } else {
                    jtxtMonthlyAmoW.setText("Ivalid");
                }
            } while (num <= 0 || num > 1000000);

            jtxtMonthlyAmo.setText(String.format("%,.0f", d) + ".00");

            String tr1 = jtxtNetAmount.getText();
            double d1 = Double.parseDouble(tr1);
            jtxtNetAmount.setText(String.format("%,.0f", d1) + ".00");

            String tr2 = jtxtServiceFee.getText();
            double d2 = Double.parseDouble(tr2);
            jtxtServiceFee.setText(String.format("%,.0f", d2) + ".00");

            String tr3 = jtxtLoanableAmount.getText();
            double d3 = Double.parseDouble(tr3);
            jtxtLoanableAmount.setText(String.format("%,.0f", d3) + ".00");

            b1.setText(b1.getText() + "NAME OF APPLICANT :");
            String name = jtxtName.getText();
            b1.setText(b1.getText() + "     " + name + "\n");

            b1.setText(b1.getText() + "CONTACT :");
            String contactt = jtxtContact.getText();
            b1.setText(b1.getText() + "               " + contactt + "\n");

            b1.setText(b1.getText() + "LOANABLE AMOUNT :    ");
            String utangamountt = jtxtLoanableAmount.getText();
            b1.setText(b1.getText() + "   " + utangamountt + "   ");

            String utangword = jtxtLoanWord.getText();
            b1.setText(b1.getText() + utangword + "   Pesos only." + "\n");

            b1.setText(b1.getText() + "Service Fee :      ");
            String service1 = jtxtServiceFee.getText();
            b1.setText(b1.getText() + "     " + service1 + "\n");

            b1.setText(b1.getText() + "Net Amount :            ");
            String netAmount = jtxtNetAmount.getText();
            b1.setText(b1.getText() + netAmount + "\n");

            b1.setText(b1.getText() + "Interest per Month :   ");
            String interest = jtxtInterestperMonth.getText();
            b1.setText(b1.getText() + " " + interest + "\n");

            b1.setText(b1.getText() + "Mo.Amortization :       ");
            String amor = jtxtMonthlyAmo.getText();
            b1.setText(b1.getText() + amor + "    ");

            String amorw = jtxtMonthlyAmoW.getText();
            b1.setText(b1.getText() + amorw + "  Pesos only." + "\n");

            b1.setText(b1.getText() + "Duration :       ");
            String du = jtxtMonthDu.getText();
            b1.setText(b1.getText() + "       " + du + "  Months \n");

            b1.setText(b1.getText() + "Start of Deduction :");
            String s = dAte.getText();
            b1.setText(b1.getText() + "    " + s + " ");
        }

    }//GEN-LAST:event_comboStartDeductioActionPerformed

    private void PnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PnameActionPerformed

    private void PcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PcontactActionPerformed

    private void PPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PPnameActionPerformed

    private void PPstartofdeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPstartofdeductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PPstartofdeductionActionPerformed


    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        if((jtxtName.getText().equals("") || jtxtContact.getText().equals("") || jTextField7.getText().equals(""))){
            JOptionPane.showMessageDialog(this, "Please input data","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            //start here:
        //String nams = jtxtName.getText();
        //String nums = jtxtContact.getText();
        //String loans = jtxtLoanableAmount.getText();
        // String monthD = jtxtMonthDu.getText();
        String fname_app = jtxtName.getText();
        String fcon_num = jtxtContact.getText();
        String floan_amount = jtxtLoanableAmount.getText();
        String fservice_fee = jtxtServiceFee.getText();
        String fnet_amount = jtxtNetAmount.getText();
        String finterest_per_month = jtxtInterestperMonth.getText();
        String fmonthly_amortization = jtxtMonthlyAmo.getText();
        String fmonth_duration = jtxtMonthDu.getText();
        String fstart_deduction = dAte.getText();
        String fdate = date1.getText();
        String fbalance_remaining = balanceremaining.getText();
        String fmonth_duration_left = monthdurationleft.getText();
        String fpayment_z = payment.getText();
        String fdate_of_transaction = dateoftrans.getText();
        String floan_word = jtxtLoanWord.getText();
        String famo_word = jtxtMonthlyAmoW.getText();
        String fmo_amo = jTextField2.getText();
        String fservi_ce_fee = jTextField5.getText();
       
        
        //String namesz = jtxtName.getText();
        //String loanamountz = jtxtLoanableAmount.getText();
        // String paymentz = payment.getText();
        // String monthleftz = monthdurationleft.getText();
        //String datez = date1.getText();
        //String startz = dAte.getText();
        //String full_name = jtxtName.getText();
        //String con_tact = jtxtContact.getText();
        //String loanable_amount = jtxtLoanableAmount.getText();
        //String numbers_words = jtxtLoanWord.getText();
        //String duration_month = jtxtMonthDu.getText();
        //String service_fee = jtxtServiceFee.getText();
        //String net_amount = jtxtNetAmount.getText();
        // String interest_permonth = jtxtInterestperMonth.getText();
        // String mo_amortization = jtxtMonthlyAmo.getText();
        // String number_word = jtxtMonthlyAmoW.getText();
        //String startof_deduction = dAte.getText();
        //String dater = date1.getText();
//***********************************TRY AND CATCH ****************************************************//
        try {
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/essusserver", "root", "essustealoanmanagementsystem01");

            String mySql = "INSERT INTO floan_records (fname_app,fcon_num,floan_amount,fservice_fee,fnet_amount,finterest_per_month,fmonthly_amortization,fmonth_duration,fstart_deduction,fdate,fbalance_remaining,fmonth_duration_left,fpayment_z,fdate_of_transaction,floan_word,famo_word,fmo_amo,fservi_ce_fee)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //String mySql1 = "insert into essu_loan (full_name,con_tact,loanable_amount,numbers_words,duration_month,service_fee,net_amount,interest_permonth,mo_amortization,number_word,startof_deduction,dater)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            // String mq = "insert into another(namesz,loanamountz,paymentz,monthleftz,datez,startz)values(?,?,?,?,?,?)";

            PreparedStatement mySt = con.prepareStatement(mySql);
            // PreparedStatement mySt1 = con.prepareStatement(mySql1);
            //  PreparedStatement mySt2 = con.prepareStatement(mq);

            mySt.setString(1, fname_app);
            mySt.setString(2, fcon_num);
            mySt.setString(3, floan_amount);
            mySt.setString(4, fservice_fee);
            mySt.setString(5, fnet_amount);
            mySt.setString(6, finterest_per_month);
            mySt.setString(7, fmonthly_amortization);
            mySt.setString(8, fmonth_duration);
            mySt.setString(9, fstart_deduction);
            mySt.setString(10, fdate);
            mySt.setString(11, fbalance_remaining);
            mySt.setString(12, fmonth_duration_left);
            mySt.setString(13, fpayment_z);
            mySt.setString(14, fdate_of_transaction);
            mySt.setString(15, floan_word);
            mySt.setString(16, famo_word);
            mySt.setString(17, fmo_amo);
            mySt.setString(18, fservi_ce_fee);

            // mySt1.setString(1,full_name);
            // mySt1.setString(2,con_tact);
            // mySt1.setString(3,loanable_amount);
            // mySt1.setString(4,numbers_words);
            // mySt1.setString(5,duration_month);
            // mySt1.setString(6,service_fee);
            // mySt1.setString(7,net_amount);
            // mySt1.setString(8,interest_permonth);
            // mySt1.setString(9,mo_amortization);
            // mySt1.setString(10,number_word);
            // mySt1.setString(11,startof_deduction);
            // mySt1.setString(12,dater);
            // mySt2.setString(1,namesz);
            // mySt2.setString(2,loanamountz);
            // mySt2.setString(3, paymentz);
            // mySt2.setString(4,monthleftz);
            // mySt2.setString(5,datez);
            // mySt2.setString(6,startz);
            //****************************PreparedStatement st = con.prepareStatement(sql);*********************************************************//
            mySt.executeUpdate();
            // mySt1.executeUpdate();
            // mySt2.executeUpdate();

            String nam = jtxtName.getText();
            Pname.setText(nam);

            String da = date1.getText();
            Pdate.setText(da);

            String coN = jtxtContact.getText();
            Pcontact.setText(coN);

            String ll = jtxtLoanableAmount.getText();
            loanableN.setText(ll);

            String lw = jtxtLoanWord.getText();
            Ploanableword.setText(lw);

            String ln = jtxtLoanableAmount.getText();
            PloanableAmount.setText(ln);

            String ps = jtxtServiceFee.getText();
            Pservicefee.setText(ps);

            String pn = jtxtNetAmount.getText();
            Pnetamount.setText(pn);

            String pin = jtxtInterestperMonth.getText();
            Pinterestpermonth.setText(pin);

            String pma = jtxtMonthlyAmo.getText();
            Pmoamortization.setText(pma);

            String pd = jtxtMonthDu.getText();
            Pduration.setText(pd);

            String psd = dAte.getText();
            Pstartofdeduction.setText(psd);

            String ppn = jtxtName.getText();
            PPname.setText(ppn);

            String dda = date1.getText();
            PPdate.setText(dda);

            String ppl = jtxtLoanWord.getText();
            PPloanableword.setText(ppl);

            String ppll = jtxtLoanableAmount.getText();
            PPloanableamount.setText(ppll);

            String ppma = jtxtMonthlyAmoW.getText();
            PPmoamortizationword.setText(ppma);

            String ppmaa = jtxtMonthlyAmo.getText();
            PPmoamortization.setText(ppmaa);

            String ppstd = dAte.getText();
            PPstartofdeduction.setText(ppstd);

            String pppname = jtxtName.getText();
            dasdasdasdasdds.setText(pppname);

            JOptionPane.showMessageDialog(this, "Successfull!","Message",JOptionPane.INFORMATION_MESSAGE);
            con.close();
            payment_noww();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

//####################################   APPLICANTS CONTACT INFO:   ##############################################################################################################//            
        if (jtxtName.getText().equals("") || jtxtContact.getText().equals("") || date1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter All Data!");
        } else {
            String data1[] = {jtxtName.getText(), jtxtContact.getText(), date1.getText()};
            DefaultTableModel tblm1 = (DefaultTableModel) jTable2.getModel();
            tblm1.addRow(data1);
        }
//#########################################    END HERE:    ######################################################################################################//            

//####################################   APPLICANTS PERSONAL LOAN:   ##############################################################################################################//
        if (jtxtName.getText().equals("") || jtxtLoanableAmount.getText().equals("") || jtxtServiceFee.getText().equals("") || jtxtNetAmount.getText().equals("") || jtxtInterestperMonth.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data !!");
        } else {
            String data2[] = {jtxtName.getText(), jtxtLoanableAmount.getText(), jtxtServiceFee.getText(), jtxtNetAmount.getText(), jtxtInterestperMonth.getText()};
            DefaultTableModel tblm2 = (DefaultTableModel) jTable3.getModel();
            tblm2.addRow(data2);
        }
//##########################################   END HERE:   ##############################################################################################################//

//####################################   APPLICANTS PERSONAL LOAN:   ##############################################################################################################//
        if (jtxtName.getText().equals("") || jtxtMonthlyAmo.getText().equals("") || jtxtMonthDu.getText().equals("") || dAte.getText().equals("") || date1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all data !!");
        } else {

            String data3[] = {jtxtName.getText(), jtxtMonthlyAmo.getText(), jtxtMonthDu.getText(), dAte.getText(), date1.getText()};

            DefaultTableModel tblm3 = (DefaultTableModel) jTable5.getModel();
            tblm3.addRow(data3);
        }
//##########################################   END HERE:   ##############################################################################################################//

//##########################################   PAY LOAN :   ##############################################################################################################//
        // if(jtxtName.getText().equals("")||jtxtContact.getText().equals("")||jtxtLoanableAmount.getText().equals("")||jtxtMonthDu.getText().equals("")){
        //    JOptionPane.showMessageDialog(this,"Please enter all data !!");
        // }else{
        //   String data4 [] = {jtxtName.getText(),jtxtContact.getText(),jtxtLoanableAmount.getText(),jtxtMonthDu.getText()};
        // DefaultTableModel tblm4 = (DefaultTableModel)tablerecord.getModel();
        // tblm4.addRow(data4);
        // }
//##########################################   END HERE:   ##############################################################################################################//
//end here :
        }
        
        
       

        jtxtName.setText("");
        jtxtContact.setText("");
        jtxtLoanableAmount.setText("");
        jTextField7.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tablerecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablerecordMouseClicked
        // TODO add your handling code here:
        int index = tablerecord.getSelectedRow();
        TableModel model = tablerecord.getModel();
        String nnname = model.getValueAt(index, 0).toString();
        String date = model.getValueAt(index, 3).toString();

        ed.setText(nnname);
        applicants_dataa();

        applicants_data pra = new applicants_data();

        pra.jTextField133.setText(dateof.getText());
        pra.applicantsname.setText(nname.getText());
        pra.jTextField15.setText(loanableamount.getText());
        pra.jTextField16.setText(servicefee.getText());
        pra.jTextField17.setText(netamount.getText());
        pra.jTextField18.setText(interestpermonth.getText());
        pra.jTextField19.setText(moamortization.getText());
        pra.m2.setText(monthduration.getText());
        pra.jTextField21.setText(startofdeduction.getText());
        //pra.balanceee.setText(bal.getText());
        pra.balanceremainingg.setText(bal.getText());
        pra.monthleftss.setText(curentM.getText());

        //pra.jTextField2ii.setText(jTextField2.getText());
        //pra.jTextField1o.setText(jTextField5.getText());

        pra.idd1.setText(ed.getText());

        pra.setVisible(true);
    }//GEN-LAST:event_tablerecordMouseClicked

    private void nname1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_nname1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_nname1AncestorAdded

    private void dateofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofActionPerformed

    private void nnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nnameKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_nnameKeyTyped

    private void nnameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nnameCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_nnameCaretUpdate

    private void monthdurationleftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthdurationleftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthdurationleftActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (Pdate.getText().length() <= 0 || Pdate.getText().length() <= 0 || Pcontact.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "The data you input is not save yet.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            printRecord(jPanel16);
            JOptionPane.showMessageDialog(this,"Print Succesfull","Message",JOptionPane.INFORMATION_MESSAGE);
            
        jtxtName.setText("");
        jtxtContact.setText("");
        jtxtLoanableAmount.setText("");
        b1.setText("");
        jTextField7.setText("");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void loanableamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanableamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loanableamountActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        String gago = jTextField7.getText();

        jtxtLoanableAmount.setText("" + gago);
        int value = Integer.parseInt(jtxtLoanableAmount.getText().replaceAll(",", ""));
        jtxtLoanableAmount.setText(value + "");
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jtxtLoanableAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtLoanableAmountKeyTyped

    }//GEN-LAST:event_jtxtLoanableAmountKeyTyped

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField7KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this,"Do you want to Logout?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
            login lll = new login();
            lll.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String[] TEENS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private static final String[] TENS = {null, null, "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};

    public static String numberToWords(int number) {
        if (number < 10) {
            return ONES[number];
        } else if (number < 20) {
            return TEENS[number % 10];
        } else if (number < 100) {
            return TENS[number / 10] + ((number % 10 >= 0) ? " " + numberToWords(number % 10) : " ");
        } else if (number < 1000) {
            return ONES[number / 100] + " Hundred" + ((number % 10 >= 0) ? " " + numberToWords(number % 100) : " ");
        }
        return numberToWords(number / 1000) + " Thousand" + ((number % 1000 > 0) ? " " + numberToWords(number % 1000) : " ");
    }

    private static final String[] ONESs = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String[] TEENSs = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private static final String[] TENSs = {null, null, "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};

    public static String numberToWordss(int numberr) {
        if (numberr <= 10) {
            return ONESs[numberr];
        } else if (numberr < 20) {
            return TEENSs[numberr % 10];
        } else if (numberr < 100) {
            return TENSs[numberr / 10] + ((numberr % 10 >= 0) ? " " + numberToWordss(numberr % 10) : " ");
        } else if (numberr < 1000) {
            return ONESs[numberr / 100] + " Hundred" + ((numberr % 10 >= 0) ? " " + numberToWordss(numberr % 100) : " ");
        }
        return numberToWordss(numberr / 1000) + " Thousand" + ((numberr % 1000 > 0) ? " " + numberToWordss(numberr % 1000) : " ");
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlABLE;
    private javax.swing.JLabel LABEL;
    private javax.swing.JTextField PPdate;
    private javax.swing.JTextField PPloanableamount;
    private javax.swing.JTextField PPloanableword;
    private javax.swing.JTextField PPmoamortization;
    private javax.swing.JTextField PPmoamortizationword;
    private javax.swing.JTextField PPname;
    private javax.swing.JTextField PPstartofdeduction;
    private javax.swing.JTextField Pcontact;
    private javax.swing.JTextField Pdate;
    private javax.swing.JTextField Pduration;
    private javax.swing.JTextField Pinterestpermonth;
    private javax.swing.JTextField PloanableAmount;
    private javax.swing.JTextField Ploanableword;
    private javax.swing.JTextField Pmoamortization;
    private javax.swing.JTextField Pname;
    private javax.swing.JTextField Pnetamount;
    private javax.swing.JTextField Pservicefee;
    private javax.swing.JTextField Pstartofdeduction;
    private javax.swing.JTextArea b1;
    public static javax.swing.JTextField bal;
    private javax.swing.JTextField balanceremaining;
    private javax.swing.JComboBox<String> comboStartDeductio;
    public static javax.swing.JTextField curentM;
    private javax.swing.JLabel dAte;
    private javax.swing.JTextField dasdasdasdasdds;
    private javax.swing.JLabel date1;
    private javax.swing.JTextField date2;
    public static javax.swing.JTextField dateof;
    private javax.swing.JTextField dateoftrans;
    public static javax.swing.JTextField ed;
    private javax.swing.JTextField ido;
    public static javax.swing.JTextField interestpermonth;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jtxtContact;
    private javax.swing.JTextField jtxtInterestperMonth;
    private javax.swing.JTextField jtxtLoanWord;
    private javax.swing.JTextField jtxtLoanableAmount;
    private javax.swing.JTextField jtxtMonthDu;
    private javax.swing.JTextField jtxtMonthlyAmo;
    private javax.swing.JTextField jtxtMonthlyAmoW;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtNetAmount;
    private javax.swing.JTextField jtxtServiceFee;
    private javax.swing.JTextField loanableN;
    public static javax.swing.JTextField loanableamount;
    public static javax.swing.JTextField moamortization;
    public static javax.swing.JTextField monthduration;
    private javax.swing.JTextField monthdurationleft;
    public static javax.swing.JTextField netamount;
    public static javax.swing.JTextField nname;
    public static javax.swing.JTextField nname1;
    public static javax.swing.JTextField no_FilterAmo;
    private javax.swing.JTextField payment;
    public static javax.swing.JTextField servicefee;
    public static javax.swing.JTextField startofdeduction;
    private javax.swing.JTable tablerecord;
    // End of variables declaration//GEN-END:variables

    private void printRecord(JPanel panel) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics2D.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
                graphics2D.scale(0.5, 0.5);

                jPanel16.paint(graphics2D);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean returningResult = printerJob.printDialog();
        if (returningResult) {
            try {
                printerJob.print();
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error:" + printerException.getMessage());
            }

        }
    }

}
