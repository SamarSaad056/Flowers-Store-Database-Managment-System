/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alatt
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class ViewTableWindow extends JFrame {
    JLabel orderIdLabel;
    JTextField orderIdText;
    JButton show;
    Color pink = new Color(254, 172, 177);
    Color gold = new Color(185, 157, 78);

    Connection con;
    JTable table;
    String[] columnNames = new  String[]{"Order ID", "Order Date", "Branch Number", "Customer ID"};

    String url = "jdbc:mysql://localhost:3306/flowersstore";//(flowersstore) is the name of my database
    String userName = "root";
    String password = "123456";

    DefaultTableModel model;
    JScrollPane scroll;
    
    int t=0;
    String roll = "";
    String name = "";
    String cl = "";
    String sec = "";
    
    Font Sub_heading= new Font("Serif",Font.BOLD,25);
    Font Sub_heading2= new Font("Serif",Font.BOLD,20);

    public ViewTableWindow() {



        setTitle("RETRIVE AN INFORMATION OF ORDER TABLES");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        //setVisible(true);
        setSize(938,1146);
        setLocationRelativeTo(null);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper2.png"))));

        orderIdLabel = new JLabel("Order Id : ");
        orderIdLabel.setBounds(220, 275, 150, 50);
        orderIdLabel.setForeground(gold);
        orderIdLabel.setFont(Sub_heading);
        add(orderIdLabel);

        orderIdText = new JTextField();
        orderIdText.setBounds(350, 287, 200, 30);
        orderIdText.setBackground(pink);
        orderIdText.setForeground(Color.WHITE);
        orderIdText.setFont(Sub_heading2);
        add(orderIdText);

        show = new JButton(" Display ");
        show.setBackground(Color.WHITE);
        show.setForeground(gold);
        show.setBorder(new LineBorder(gold));
        show.setBounds(590, 287, 130, 30);
        this.add(show);


//--------------------------------------------------table code------------------------------------

 JPanel tp= new JPanel( new GridLayout(1,1));
        tp.setBounds(160, 350, 600, 300);

       model =  new DefaultTableModel() ;
        model.setColumnIdentifiers(columnNames);

        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tp.add(scroll);
        add(tp);


        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ac();
            }
        });

    }
    //----------------------------Connecting to database---------------------------------------

    public void ac() {

        t++;
        String textvalue = orderIdText.getText();
        int teV = Integer.parseInt(textvalue);

        try {
            if(t>1){model.removeRow(0); t=1;}
            con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from Orders where O_id = " + teV;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            int i = 0;
            if (rs.next()) {
                roll = rs.getString("O_id");
                name = rs.getString("O_date");
                cl = rs.getString("b_no");
                sec = rs.getString("c_id");
                model.addRow(new Object[]{roll, name, cl, sec});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }


}
