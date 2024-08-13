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
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class addWindow extends JFrame{
    String url = "jdbc:mysql://localhost:3306/flowersstore";//(flowersstore) is the name of my database
    String userName = "root";
    String password = "123456";

    JLabel orderIdLabel;
    JLabel orderDateLabel;
    JLabel branchNameLabel;
    JLabel customerIdLabel;
    JLabel customerNameLabel;
    JLabel customerAddressLabel;
    JLabel customerPhoneLabel;
    JLabel flowerNameLabel;
    JLabel flowersNumberLabel;
    JLabel EmployeeIdLabel;

     JComboBox branchBox,flowerBox,empolyeeBox;
     
    JTextField orderIdText;
    JTextField orderDateText;
    JTextField branchNameText;
    JTextField customerIdText;
    JTextField customerNameText;
    JTextField customerAddressText;
    JTextField customerPhoneText;
    JTextField flowerNameText;
    JTextField flowersNumberText;
    JTextField EmployeeIdText;

    JButton add;
    JButton back;
    JButton view;

    Color pink= new Color(254,172,177);
    Color pinkk= new Color(230,172,180);
    Color gold= new Color(185,157,78);

    Font Sub_heading= new Font("Serif",Font.BOLD,25);
    Font Sub_heading2= new Font("Serif",Font.BOLD,20);

    String textValueFlowerName;
     public addWindow()
    {
        this.setTitle("ADD A NEW ORDER");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(938,1146);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


       setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper2Cut.png"))));


      orderIdLabel = new JLabel("Order Id : ");
        orderIdLabel.setBounds(40,50,150,50);
        orderIdLabel.setForeground(gold);
       orderIdLabel.setFont(Sub_heading2);
        this.add(orderIdLabel);

        orderIdText= new JTextField();
       orderIdText.setBounds(190+100,63,200,25);
       orderIdText.setBackground(pink);
       orderIdText.setForeground(Color.WHITE);
       orderIdText.setFont(Sub_heading2);
       this.add(orderIdText);


        orderDateLabel = new JLabel("Order date : ");
        orderDateLabel.setBounds(40,100,150,50);
        orderDateLabel.setForeground(gold);
        orderDateLabel.setFont(Sub_heading2);
        this.add(orderDateLabel);



        Date date= new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String strDate= sdf.format(date);



        orderDateText= new JTextField();
        orderDateText.setBounds(190+100,110,200,25);
        orderDateText.setBackground(pink);
        orderDateText.setForeground(Color.WHITE);
        orderIdText.setFont(Sub_heading2);
        orderDateText.setText(strDate);
        this.add(orderDateText);


        branchNameLabel= new JLabel("Branch name :");
        branchNameLabel.setBounds(40,150,170,50);
        branchNameLabel.setForeground(gold);
        branchNameLabel.setFont(Sub_heading2);
        this.add(branchNameLabel);




        String [] branches= {"Flower Story","Lavender Bouquets","Pink Garden","Secret Garden","Bloom Flowers"};
        branchBox= new JComboBox(branches);
        branchBox.setBounds(190+100,160,200,25);
        branchBox.setBackground(pink);

        branchBox.setRenderer( new MyComboBoxRenderer("please choose branch"));
        branchBox.setSelectedIndex(-1);
        branchBox.setForeground(Color.WHITE);

        this.add(branchBox);

        customerIdLabel= new JLabel("Customer Id :");
        customerIdLabel.setBounds(40,230,170,50);
        customerIdLabel.setForeground(gold);
        customerIdLabel.setFont(Sub_heading2);
        this.add(customerIdLabel);

        customerIdText= new JTextField();
        customerIdText.setBounds(190+100,240,200,25);
        customerIdText.setBackground(pink);
        customerIdText.setForeground(Color.WHITE);
        customerIdText.setFont(Sub_heading2);
        //orderIdText.setText(String.valueOf(date));
        this.add(customerIdText);

        customerNameLabel= new JLabel("Customer Name :");
        customerNameLabel.setBounds(40,290,170,50);
        customerNameLabel.setForeground(gold);
        customerNameLabel.setFont(Sub_heading2);
        this.add(customerNameLabel);

        customerNameText= new JTextField();
        customerNameText.setBounds(190+100,295,200,25);
        customerNameText.setBackground(pink);
        customerNameText.setForeground(Color.WHITE);
        customerNameText.setFont(Sub_heading2);
        this.add(customerNameText);


        customerAddressLabel= new JLabel("Customer Address :");
        customerAddressLabel.setBounds(40,350,180,50);
        customerAddressLabel.setForeground(gold);
        customerAddressLabel.setFont(Sub_heading2);
        this.add(customerAddressLabel);

        customerAddressText= new JTextField();
        customerAddressText.setBounds(190+100,357,200,25);
        customerAddressText.setBackground(pink);
        customerAddressText.setForeground(Color.WHITE);
        customerAddressText.setFont(Sub_heading2);
        //orderIdText.setText(String.valueOf(date));
        this.add(customerAddressText);


        customerPhoneLabel= new JLabel("Customer Phone :");
        customerPhoneLabel.setBounds(40,410,170,50);
        customerPhoneLabel.setForeground(gold);
        customerPhoneLabel.setFont(Sub_heading2);
        this.add(customerPhoneLabel);


        customerPhoneText= new JTextField();
        customerPhoneText.setBounds(190+100,417,200,25);
        customerPhoneText.setBackground(pink);
        customerPhoneText.setForeground(Color.WHITE);
        customerPhoneText.setFont(Sub_heading2);
        //orderIdText.setText(String.valueOf(date));
        this.add(customerPhoneText);

        flowerNameLabel= new JLabel("Flower Name :");
        flowerNameLabel.setBounds(40,490,150,50);
        flowerNameLabel.setForeground(gold);
        flowerNameLabel.setFont(Sub_heading2);
        this.add(flowerNameLabel);


        String [] flowers= {"White rose","White lily","White Tulip","White Carantion","White Gypsopila Bouquet",
                "Red roses","Red Tulip","Red Carantion",
                "Pink rose","Pink lily","Pink Tulip","Pink Carnation","Pink Gypsopila Bouquet",
                "Yallow rose","Yallow Tulip",
                "Purple Lilac","Purple Gypsopila Bouquet","Blue Gypsopila Bouquet",
        "Cotton flower Bouquet","Bluebell Bouquet","Carantion Bouquet","Lilac Bouquet","Lavender Bouquet","Tulip Bouquet","Sunflower"
        ,"Sunflower Bouquet","lily Bouquet"};
        flowerBox= new JComboBox(flowers);
        flowerBox.setBounds(190+100,498,200,25);
        flowerBox.setBackground(pink);

        flowerBox.setRenderer( new MyComboBoxRenderer("please choose flower"));
        flowerBox.setSelectedIndex(-1);
        flowerBox.setForeground(Color.WHITE);
        this.add(flowerBox);



        flowersNumberLabel= new JLabel("Flowers Number :");
        flowersNumberLabel.setBounds(40,550,170,50);
        flowersNumberLabel.setForeground(gold);
        flowersNumberLabel.setFont(Sub_heading2);
        this.add(flowersNumberLabel);


      flowersNumberText= new JTextField();
        flowersNumberText.setBounds(190+100,554,200,25);
        flowersNumberText.setBackground(pink);
        flowersNumberText.setForeground(Color.WHITE);
        flowersNumberText.setFont(Sub_heading2);
        this.add(flowersNumberText);


        EmployeeIdLabel= new JLabel("Employee Id :");
        EmployeeIdLabel.setBounds(40,605,150,50);
        EmployeeIdLabel.setForeground(gold);
        EmployeeIdLabel.setFont(Sub_heading2);//Mangabey
        this.add(EmployeeIdLabel);




        String [] employee= {"10984","10933","10345","11097","11009","11000","11111","12334","12330",
                "20665","20995","20452","21333","21090","21343","21232","22000",
                "30885","30158","30223","31454","31002","31088","31023","32332","32567"
                ,"40955","40321","40446","41443","41020","41962","42090","42300",
                "50222","50444","50977","51887","51632","51555","52334","52998","74930","96666"};

        empolyeeBox= new JComboBox(employee);
        empolyeeBox.setBounds(190+100,612,200,25);
        empolyeeBox.setBackground(pink);

        empolyeeBox.setRenderer( new MyComboBoxRenderer("please choose id"));
        empolyeeBox.setSelectedIndex(-1);
        empolyeeBox.setForeground(Color.WHITE);
        this.add(empolyeeBox);



        JButton badd= new JButton("Add");
        badd.setBackground(Color.WHITE);
        badd.setForeground(gold);
        badd.setBorder(new LineBorder(gold));
        badd.setBounds(260,700,130,30);
        this.add(badd);

        JButton bview= new JButton("View Table");
        bview.setBackground(Color.WHITE);
        bview.setForeground(gold);
        bview.setBorder(new LineBorder(gold));
        bview.setBounds(410,700,130,30);
        this.add(bview);



        badd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ac();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
    
                
            }
        });
        
        
            bview.addActionListener(new ActionListener() {
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

//-------------------------Connting to databse & adding to table--------
    public void ac() throws ParseException {


                String textValueOrderId = orderIdText.getText();
                int oid= Integer.parseInt(textValueOrderId);

                String textValueOrderDate=orderDateText.getText();
                 Date od=new SimpleDateFormat("yyyy-MM-dd").parse(textValueOrderDate);

                String textValueBranchName= branchBox.getSelectedItem()+"";

                 int branchNo=0;
                if(textValueBranchName.equals("Flower Story")) branchNo=1;
                else  if(textValueBranchName.equals("Lavender Bouquets")) branchNo=2;
                else if(textValueBranchName.equals(" Pink Garden")) branchNo=3;
                else if (textValueBranchName.equals(" Secret Garden")) branchNo=4;
                else branchNo=5;

                String textValueCustomerId= customerIdText.getText();
                int cid=Integer.parseInt(textValueCustomerId);

                String textValueCustomerName= customerNameText.getText();

                String textValueCustomerAddress= customerAddressText.getText();

                String textValueCustomerPhone=customerPhoneText.getText();

                 textValueFlowerName=flowerBox.getSelectedItem()+"";

                String textValueFlowersNumber= flowersNumberText.getText();
                int fno=  Integer.parseInt(textValueFlowersNumber);

                String textValueEmployeeId= empolyeeBox.getSelectedItem()+"";
                int eid= Integer.parseInt(textValueEmployeeId);



                try {

                   Connection con = DriverManager.getConnection(url, userName, password);

                    String sql1 = "insert into Customer values (?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql1);
                    ps.setInt(1,cid);
                    ps.setString(2,textValueCustomerName);
                    ps.setString(3,textValueCustomerPhone);
                    ps.setString(4,textValueCustomerAddress);
                    ps.execute();

                     String sql2="insert into Orders values (?,?,?,?)";
                    PreparedStatement ps1 = con.prepareStatement(sql2);
                    ps1.setInt(1,oid);
                    ps1.setString(2,  (String)textValueOrderDate);
                    ps1.setInt(3,branchNo);
                    ps1.setInt(4,cid);
                    ps1.execute();

                    String sql3= "insert into Made_by values (?,?)";
                    PreparedStatement ps2 = con.prepareStatement(sql3);
                    ps2.setInt(1,oid);
                    ps2.setInt(2,eid);
                    ps2.execute();

                     String sql4="insert into Contain values (?,?,?)";
                    PreparedStatement ps3 = con.prepareStatement(sql4);
                    ps3.setInt(1,oid);
                    ps3.setInt(2,flowerId(textValueFlowerName));
                    ps3.setInt(3,fno);
                    ps3.execute();
                    
                     JOptionPane.showMessageDialog(null, "Order Added Successfully");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }


            }

            public int flowerId(String n )
             {
               if(n.equals("White rose"))     return 001;
               else if(n.equals("Red roses")) return 002;
               else if(n.equals("Pink rose")) return 003;
               else if(n.equals("yallow rose")) return 004;
               else if(n.equals("roses Bouquet")) return 005;
               else if(n.equals("white lily")) return 006;
               else if(n.equals("pink lily")) return 007;
               else if(n.equals("lily Bouquet")) return 8;
               else if(n.equals("Sunflower")) return 9;
               else if(n.equals("Sunflower Bouquet")) return 010;
               else if(n.equals(" White Tulip")) return 011;
               else if(n.equals("Pink Tulip")) return 012;
               else if(n.equals("Yallow Tulip")) return 013;
               else if(n.equals("Red Tulip")) return 014;
               else if(n.equals("Tulip Bouquet")) return 015;
               else if(n.equals("Lavender Bouquet")) return 016;
               else if(n.equals("White Lilac")) return 017;
               else if(n.equals("Purple Lilac")) return 18;
               else if(n.equals("Lilac Bouquet")) return 19;
               else if(n.equals("Pink Carnation")) return 020;
               else if(n.equals("Red Carantion")) return 021;
               else if(n.equals("White Carantion")) return 022;
               else if(n.equals("Carantion Bouquet")) return 023;
               else if(n.equals("Bluebell Bouquet")) return 024;
               else if(n.equals("Cotton flower Bouquet")) return 025;
               else if(n.equals("White Gypsopila Bouquet")) return 026;
               else if(n.equals("Pink Gypsopila Bouquet")) return 027;
               else if(n.equals("Purple Gypsopila Bouquet")) return 28;
               else return 29;

             }






   /* public static void main(String a[])
  {
      addWindow addWindow=  new addWindow();
      addWindow.setVisible(true);

  }*/
}
class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
    private final String _title;

    public MyComboBoxRenderer(String title) {
        _title = title;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean hasFocus) {
        if (index == -1 && value == null)
            setText(_title);
        else
            setText(value.toString());
        return this;
    }
}


    

