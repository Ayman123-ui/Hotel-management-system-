package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener
{
    JTable table;
    JButton Back,Submit;
    Choice typeofcar;
    JCheckBox available;
  Pickup()
  {
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel text= new JLabel ("Pick Up Service");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));
     text.setBounds(400,40,200,30);
     add(text);
     
     JLabel lblbed= new JLabel ("Type Of Car");
     lblbed.setBounds(50,100,100,20);
     lblbed.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(lblbed);
     
     typeofcar = new Choice();
     typeofcar.setBounds(150,100,200,25);
     add(typeofcar);
     
     try
     {
      Conn c = new Conn();
      ResultSet rs=c.s.executeQuery("select * from driver");
      while(rs.next())
      {
      typeofcar.add(rs.getString("brand"));
      }
     }
     catch (Exception e)
     {
      e.printStackTrace();
     }
     
     JLabel l1= new JLabel ("Name");
     l1.setBounds(30,160,200,20);
     add(l1);
     
     JLabel l2= new JLabel ("Age");
     l2.setBounds(200,160,100,20);
     add(l2);
     
     JLabel l3= new JLabel ("Gender");
     l3.setBounds(330,160,100,20);
     add(l3);
     
     JLabel l4= new JLabel ("Company");
     l4.setBounds(460,160,100,20);
     add(l4);
     
     JLabel l5= new JLabel ("Brand");
     l5.setBounds(620,160,100,20);
     add(l5);
     
     JLabel l6= new JLabel ("Availability");
     l6.setBounds(740,160,100,20);
     add(l6);
     
     JLabel l7= new JLabel ("location");
     l7.setBounds(880,160,100,20);
     add(l7);
     
     table = new JTable();
     table.setBounds(0,180,1000,300);
     table.setBackground(Color.pink);
     add(table);
     
     try
     {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from driver");
      table.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch (Exception e)
     {
     e.printStackTrace();
     }
        
    Back =new JButton("Back");
    Back.setBackground(Color.BLACK);
    Back.setForeground(Color.WHITE);
    Back.setBounds(500,520,120,30);
    Back.addActionListener(this);
    add(Back);
        
    Submit=new JButton("Submit");
    Submit.setBackground(Color.BLACK);
    Submit.setForeground(Color.WHITE);
    Submit.setBounds(300,520,120,30);
    Submit.addActionListener(this);
    add(Submit);   
      
    setBounds(300,150,1000,600);
    getContentPane().setBackground(Color.pink);
    setVisible(true);    
    }
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()== Submit)
      {
      try 
      {
       String query = "Select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
       Conn conn = new Conn();
       ResultSet rs;
       rs=conn.s.executeQuery(query);
       table.setModel(DbUtils.resultSetToTableModel(rs));
       }
      catch(Exception e) 
      {
      e.printStackTrace();
      }
        } 
      else
      {
      setVisible(false);
      new Reception();
      }
    }
 public static void main(String[] args)
     {
      new Pickup();
     }
}