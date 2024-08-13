/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alatt
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class DisplayTables extends JFrame implements ActionListener {
 
    //compenent
    JComboBox Tchoose;
    JTable table1,table2,table3,table4;
    DefaultTableModel model1,model2, model3, model4;
    JScrollPane scroll1,scroll2,scroll3,scroll4;
    JPanel tp,tp1,tp2,tp3,tp4;   
    
    //fonts
    Font Sub_heading= new Font("Serif",Font.BOLD,25);
    Font Sub_heading2= new Font("Serif",Font.BOLD,20);
    
    //colors
    Color c1 = new Color(254, 172, 177);
    Color c2 = new Color(185, 157, 78);
    
    //connections
    String url = "jdbc:mysql://localhost:3306/flowersstore";
    String userName = "root";
    String password = "123456";
    Connection con;
    
    //colomns names for the tables
    String[] OcolumnNames = new  String[]{"Order ID", "Order Date", "Branch Number", "Customer ID"};
    String[] CncolumnNames = new  String[]{"Order ID", "Flower ID", "Flower Number"};
    String[] McolumnNames = new  String[]{"Order ID", "Employee ID"};
    String[] CscolumnNames = new  String[]{"Customer ID", "Customer Name", "Customer Phone", "Customer Address"};
    
    //help to display rows 
    String roll = "";
    String name = "";
    String cl = "";
    String sec = "";
    
    public DisplayTables() throws SQLException, ClassNotFoundException {
    
        super("DISPLAY TABLES'S INFORMATION ");
        setSize(938,1146);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper2.png"))));        
  
   
        //jlebel setting
        JLabel TName= new JLabel("Table Name :");
        TName.setFont(Sub_heading);
        TName.setForeground(c2);
        TName.setBounds(30,160,200,40);
        add(TName);
        
        //jcomboBox setting
        Tchoose=new JComboBox();
        Tchoose.addItem("Orders");
        Tchoose.addItem("Customer" );
        Tchoose.addItem("Contain");
        Tchoose.addItem("Made_by" );
        Tchoose.setFont(Sub_heading2);
        Tchoose.setBackground(Color.WHITE);
        Tchoose.setForeground(c2);
        Tchoose.setBorder(new LineBorder(c2));
        Tchoose.setBounds(200,173,250,31);
        Tchoose.addActionListener(this);
        add(Tchoose);
        
        //display button setting
        JButton buttonDisplay=new JButton("Display Table");  
        buttonDisplay.setBackground(Color.WHITE);
        buttonDisplay.setForeground(c2);
        buttonDisplay.setContentAreaFilled(false);
        buttonDisplay.setFocusPainted(false);
        buttonDisplay.setBorder(new LineBorder(c2));
        buttonDisplay.setFont(Sub_heading2);
        buttonDisplay.addActionListener(this);
        buttonDisplay.setBounds(480,174,150,30);
        add(buttonDisplay);  
        
        //table setting
        tp= new JPanel( new GridLayout(1,1));
        tp.setBounds(60,250,800,450);
        
        tp1= new JPanel( new GridLayout(1,1));
        tp1.setBounds(60,250,800,450);
        
        tp2= new JPanel( new GridLayout(1,1));
        tp2.setBounds(60,250,800,450);
        
        tp3= new JPanel( new GridLayout(1,1));
        tp3.setBounds(60,250,800,450);
        
        tp4= new JPanel( new GridLayout(1,1));
        tp4.setBounds(60,250,800,450);
        
        //orders tables
        model1 =  new DefaultTableModel() ;
        model1.setColumnIdentifiers(OcolumnNames);
        table1=new JTable(model1);
        table1.setForeground(c2);
        table1.setBorder(new LineBorder(c2));
        scroll1 = new JScrollPane(table1);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tp1.add(scroll1);
        add(tp1);
        
        //contain tabels
        model2 =  new DefaultTableModel() ;
        model2.setColumnIdentifiers(CncolumnNames);
        table2=new JTable(model2);
        table2.setForeground(c2);
        table2.setBorder(new LineBorder(c2));
        scroll2 = new JScrollPane(table2);
        scroll2.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll2.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tp2.add(scroll2);
        add(tp2);
        
        //made by tables
        model3 =  new DefaultTableModel() ;
        model3.setColumnIdentifiers(CscolumnNames);
        table3=new JTable(model3);
        table3.setForeground(c2);
        table3.setBorder(new LineBorder(c2));
        scroll3 = new JScrollPane(table3);
        scroll3.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll3.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tp3.add(scroll3);
        add(tp3);
        
        //contain tables
        model4 =  new DefaultTableModel() ;
        model4.setColumnIdentifiers(McolumnNames);
        table4=new JTable(model4);
        table4.setForeground(c2);
        table4.setBorder(new LineBorder(c2));
        scroll4 = new JScrollPane(table4);
        scroll4.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll4.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);        
        tp4.add(scroll4);
        add(tp4);
        

        ///////////////////////////////////////
        add(tp);
       
        tp1.setVisible(false);
        tp2.setVisible(false);
        tp3.setVisible(false);
        tp4.setVisible(false);
}
    public void actionPerformed(ActionEvent ae) {

            String TChossen;
            String sqlQ = null;
            String g=ae.getActionCommand();
            
            if (g.equals("Display Table")){

                int rowCount1=model1.getRowCount();
                for (int i = rowCount1-1; i >=0; i--) {
                    model1.removeRow(i);
                }
                int rowCount2=model2.getRowCount();
                for (int i = rowCount2-1; i >=0; i--) {
                    model2.removeRow(i);
                }
                int rowCount3=model3.getRowCount();
                for (int i = rowCount3-1; i >=0; i--) {
                    model3.removeRow(i);
                }
                int rowCount4=model4.getRowCount();
                for (int i = rowCount4-1; i >=0; i--) {
                    model4.removeRow(i);
                }

                TChossen=Tchoose.getSelectedItem()+"";
                
                if(TChossen.equalsIgnoreCase("Orders"))
                {   
                          tp.setVisible(false);
                          tp1.setVisible(true);
                          tp2.setVisible(false);
                          tp3.setVisible(false);
                          tp4.setVisible(false);
                }
                
                if(TChossen.equalsIgnoreCase("Contain"))
                {   
                          tp.setVisible(false);
                          tp1.setVisible(false);
                          tp2.setVisible(true);
                          tp3.setVisible(false);
                          tp4.setVisible(false);
                }
               
                if(TChossen.equalsIgnoreCase("Customer"))
                {   
                          tp.setVisible(false); 
                          tp1.setVisible(false);
                          tp2.setVisible(false);
                          tp3.setVisible(true);
                          tp4.setVisible(false);
                }
                
                if(TChossen.equalsIgnoreCase("Made_by"))
                {   
                          tp.setVisible(false);
                          tp1.setVisible(false);
                          tp2.setVisible(false);
                          tp3.setVisible(false);
                          tp4.setVisible(true);
                }
                
                sqlQ = "select * from " + TChossen;
                System.out.println(sqlQ);
                
                if(sqlQ.equalsIgnoreCase("select * from Orders"))
                ac(sqlQ);
                
                if(sqlQ.equalsIgnoreCase("select * from Customer"))
                ac1(sqlQ);
                
                if(sqlQ.equalsIgnoreCase("select * from Contain"))
                ac2(sqlQ);
                
                if(sqlQ.equalsIgnoreCase("select * from Made_by"))
                ac3(sqlQ);
            }
   
    }
    
    //orders tables
    public void ac(String sqlQ) {
     try {
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sqlQ);
            ResultSet rs = ps.executeQuery();


            //int i = 0;
            while (rs.next()) {
                roll = rs.getString("O_id");
                name = rs.getString("O_date");
                cl = rs.getString("b_no");
                sec = rs.getString("c_id");
                model1.addRow(new Object[]{roll, name, cl, sec});
                //i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
       // customers tables
        public void ac1(String sqlQ) {
         try {
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sqlQ);
            ResultSet rs = ps.executeQuery();


            //int i = 0;
            while (rs.next()) {
                roll = rs.getString("c_id");
                name = rs.getString("c_name");
                cl = rs.getString("c_phone");
                sec = rs.getString("c_address");
                model3.addRow(new Object[]{roll, name, cl, sec});
                //i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
        
        //contain tables
        public void ac2(String sqlQ) {
             try {
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sqlQ);
            ResultSet rs = ps.executeQuery();


            //int i = 0;
            while (rs.next()) {
                roll = rs.getString("O_id");
                name = rs.getString("f_id");
                cl = rs.getString("Flower_no");
                model2.addRow(new Object[]{roll, name, cl});
                //i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
     // made by tables
      public void ac3(String sqlQ) {
       try {
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sqlQ);
            ResultSet rs = ps.executeQuery();


            //int i = 0;
            while (rs.next()) {
                roll = rs.getString("O_id");
                name = rs.getString("e_id");
                model4.addRow(new Object[]{roll, name});
                //i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
