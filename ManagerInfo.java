
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame implements ActionListener
{
    JTable table;
    JButton Back;
  ManagerInfo(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel l1= new JLabel ("Name");
     l1.setBounds(40,10,100,20);
     add(l1);
     
     JLabel l2= new JLabel ("Age");
     l2.setBounds(170,10,100,20);
     add(l2);
     
     JLabel l3= new JLabel ("Gender");
     l3.setBounds(290,10,100,20);
     add(l3);
     
     JLabel l4= new JLabel ("Job");
     l4.setBounds(400,10,100,20);
     add(l4);
     
     JLabel l5= new JLabel ("Salary");
     l5.setBounds(540,10,100,20);
     add(l5);
     
     JLabel l6= new JLabel ("Phone no");
     l6.setBounds(650,10,100,20);
     add(l6);
     
     JLabel l7= new JLabel ("Email Id");
     l7.setBounds(770,10,100,20);
     add(l7);
     
     JLabel l8= new JLabel ("Aadhar No");
     l8.setBounds(900,10,100,20);
     add(l8);
     
     table = new JTable();
     table.setBounds(0,35,1000,400);
     table.setBackground(Color.pink);
     add(table);

    try
    {
     Conn c = new Conn();
     ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
     table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (Exception e)
    {
     e.printStackTrace();
    }
    Back =new JButton("Back");
    Back.setBackground(Color.BLACK);
    Back.setForeground(Color.WHITE);
    Back.setBounds(415,600,120,30);
    Back.addActionListener(this);
    add(Back);
      
    setBounds(270,80,1010,700);
    getContentPane().setBackground(Color.pink);
    setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae) 
    {
    setVisible(false);
      new Reception();
    }
public static void main(String[] args)
        {
      new ManagerInfo();
        }
}

