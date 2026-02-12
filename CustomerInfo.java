package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener
{
    JTable table;
    JButton Back;
  CustomerInfo(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel l1= new JLabel ("Documnet Type");
     l1.setBounds(10,10,100,20);
     add(l1);
     
     JLabel l2= new JLabel ("Number");
     l2.setBounds(160,10,100,20);
     add(l2);
     
     JLabel l3= new JLabel ("Name");
     l3.setBounds(290,10,100,20);
     add(l3);
     
     JLabel l4= new JLabel ("Gender");
     l4.setBounds(410,10,100,20);
     add(l4);
     
     JLabel l5= new JLabel ("Country");
     l5.setBounds(540,10,100,20);
     add(l5);
     
     JLabel l6= new JLabel ("Room no");
     l6.setBounds(640,10,100,20);
     add(l6);
    
     JLabel l8= new JLabel ("check in time");
     l8.setBounds(760,10,100,20);
     add(l8);
     
     JLabel l9= new JLabel ("Deposite");
     l9.setBounds(900,10,100,20);
     add(l9);
     
     table = new JTable();
     table.setBounds(0,35,1000,400);
     table.setBackground(Color.pink);
     add(table);

    try
    {
    Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from Customer");
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
    new CustomerInfo();
        }
}




