/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alatt
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Deletewindow extends JFrame{
   javax.swing.JLabel jLabelBackground;
     javax.swing.JLabel jLabelTitle;
    javax.swing.JComboBox<String> jComboBoxOrderID;
     javax.swing.JButton jButtonBack;
     javax.swing.JButton jButtonDelete;
     javax.swing.JButton jButtonViewTable;
    JTextField orderIdText;
    Color pink = new Color(254, 172, 177);
    Color c2 = new Color(185, 157, 78);
    Font Sub_heading= new Font("Serif",Font.BOLD,25);
    Font Sub_heading2= new Font("Serif",Font.BOLD,20);
    Connection con;
    
    

    
      public Deletewindow() {
        String title = "DELETE AN EXISTING ORDER";
        this.setTitle(title);
        this.setSize(938, 1146);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper2.png"))));
        
        JLabel orderIdLabel;
        orderIdLabel = new JLabel("Order Id : ");
        orderIdLabel.setBounds(200, 275, 150, 50);
        orderIdLabel.setForeground(c2);
        orderIdLabel.setFont(Sub_heading);
        add(orderIdLabel);
        
        
        orderIdText = new JTextField();
        orderIdText.setBounds(330, 280, 350, 40);
        orderIdText.setBackground(pink);
        orderIdText.setForeground(Color.WHITE);
        Font fontorderIdText = new Font("SansSerif", Font.PLAIN, 20);
        orderIdText.setFont(Sub_heading);
        add(orderIdText);

        jButtonViewTable = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        jButtonViewTable.setBackground(Color.WHITE);
        jButtonViewTable.setForeground(c2);
        jButtonViewTable.setContentAreaFilled(false);
        jButtonViewTable.setFocusPainted(false);
        jButtonViewTable.setBorder(new LineBorder(c2));
        jButtonViewTable.setFont(Sub_heading2);
     
        jButtonViewTable.setText("View Table");
         jButtonViewTable.setBounds(520, 420, 140, 40);
         add(jButtonViewTable);
       

        jButtonDelete.setBackground(Color.WHITE);
        jButtonDelete.setFont(Sub_heading2);
        jButtonDelete.setForeground(c2);
        jButtonDelete.setContentAreaFilled(false);
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setText("delete");
        jButtonDelete.setBorder(new LineBorder(c2));
        jButtonDelete.setBounds(350, 420, 140, 40);
        add(jButtonDelete);
        

        
        

        jButtonDelete.addActionListener(new DeleteAction());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        
        jButtonViewTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                 String g=e.getActionCommand();
        
               if(g.equalsIgnoreCase("View Table")){
                     try {
                         DisplayTables dt=new DisplayTables();
                         dt.setVisible(true);
                     } catch (SQLException ex) {
                         Logger.getLogger(addWindow.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(addWindow.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }
                }
    
                
            }
        );
        

    }

    class DeleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String orderID = (String) orderIdText.getText();

            String table1 = "orders";
            String sql = "DELETE FROM " + table1 +" WHERE O_id='" + orderID +"'";
            
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowersstore", "root", "123456");
                    PreparedStatement st = conn.prepareStatement(sql)) {
                
                int val = st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Order Deleted Successfully");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Deletewindow.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                }
        }
    }  


