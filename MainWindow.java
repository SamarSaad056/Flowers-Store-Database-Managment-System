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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.border.LineBorder;
public class MainWindow extends JFrame implements ActionListener {
    JLabel warringMassage;
    JPasswordField fieldpass;
    JTextField fielduser;
    public MainWindow(){
        
        super("MAIN WINDOW");
        setSize(938,1146);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper.png"))));
        
        //font 
        Font base_heading=new Font("Monospaced",Font.BOLD,30);
        Font Sub_heading= new Font("Serif",Font.BOLD,25);
       //colors
        Color c1 = new Color(254, 172, 177);
        Color c2 = new Color(185, 157, 78);
        
        //Warring massage:
        Font Wmassage= new Font("Monospaced",Font.BOLD,15);
        warringMassage=new JLabel(); 
        warringMassage.setFont(Wmassage);
        warringMassage.setForeground(c1);
        warringMassage.setBounds(320,665,400,90);
        add(warringMassage);
       
        //username:
        fielduser=new JTextField(40);
        fielduser.setBackground(Color.WHITE);
        fielduser.setForeground(c2);
        fielduser.setBorder(new LineBorder(c2));
        fielduser.setBounds(320,660,250,31);
        add(fielduser);

        //button for login
        JButton buttonlogin=new JButton("Login");  
        buttonlogin.setBackground(Color.WHITE);
        buttonlogin.setForeground(c1);
        buttonlogin.setContentAreaFilled(false);
        buttonlogin.setFocusPainted(false);
        buttonlogin.setBorder(new LineBorder(c1));
        buttonlogin.setFont(Sub_heading);
        buttonlogin.addActionListener(this);
        buttonlogin.setBounds(380,735,130,40);
        add(buttonlogin);

    }
    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
             String useerN =fielduser.getText().trim();
             String g=ae.getActionCommand();
             ChooseService s=new ChooseService();
        if(g.equalsIgnoreCase("Login")){
            if(useerN.equals("0452") ){ 
               String n="";
                  warringMassage.setText(n);
                  s.setVisible(true);
               }
            else if (useerN.equals("0411") ){ 
               String n="";
                  warringMassage.setText(n);
                  s.setVisible(true);}
            else if (useerN.equals("0056") ){ 
               String n="";
                  warringMassage.setText(n);
                  s.setVisible(true);}
              else{ String n="check your usrename again..";
                  warringMassage.setText(n);
     }
            
    }
}}
