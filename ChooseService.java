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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class ChooseService extends JFrame implements ActionListener{
     public ChooseService(){
         super("CHOOSE A SERVICE");
         setSize(938,1146);
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         setLocationRelativeTo(null);
          getContentPane().setBackground(Color.WHITE);
          setContentPane(new JLabel(new ImageIcon(getClass().getResource("wallpaper3.png"))));

          //font
          Font base_heading=new Font("Serif",Font.BOLD,15);
          //colors
          Color c1 = new Color(254, 172, 177);
          Color c2 = new Color(185, 157, 78);

        //creat menu and JmanuItem
         JMenuBar super1=new JMenuBar();
         setJMenuBar(super1);
        
         JMenu base=new JMenu("Service");
         base.setForeground(c2);
         base.setFont(base_heading);
         super1.add(base);
        
        JMenuItem sub1= new JMenuItem("ADD A NEW ORDER");
        sub1.setForeground(c2);
        sub1.setFont(base_heading);
        sub1.addActionListener(this);
        base.add(sub1);
        
        JMenuItem sub2= new JMenuItem("DELET AN EXISTING ORDER");
        sub2.setForeground(c2);
        sub2.setFont(base_heading);
        sub2.addActionListener(this);
        base.add(sub2);
        
        JMenuItem sub3= new JMenuItem("RETRIVE AN INFORMATION");
        sub3.setForeground(c2);
        sub3.setFont(base_heading);
        sub3.addActionListener(this);
        base.add(sub3);
        
    }

    
    

   
    public void actionPerformed(ActionEvent ae) {
        String g=ae.getActionCommand();
        
        
        if(g.equalsIgnoreCase("ADD A NEW ORDER")){
            addWindow a=new addWindow();
            a.setVisible(true);
            
            
        }
        if (g.equalsIgnoreCase("DELET AN EXISTING ORDER")){
            Deletewindow DW=new Deletewindow();
            DW.setVisible(true);

        }
        if(g.equalsIgnoreCase("RETRIVE AN INFORMATION")){
           ViewTableWindow vt=new ViewTableWindow();
           vt.setVisible(true);

        }
    }
}
