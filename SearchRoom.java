
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener
{
    JTable table;
    JButton Back,Submit;
    JComboBox bed_type;
    JCheckBox available;
 SearchRoom(){
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel text= new JLabel ("Search For Room");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));
     text.setBounds(400,40,200,30);
     add(text);
     
     JLabel lblbed= new JLabel ("Bed Type");
     lblbed.setBounds(50,100,100,20);
     lblbed.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(lblbed);
     
     bed_type = new JComboBox (new String[]{"Single Beds","Double Beds"});
     bed_type.setBounds(150,100,150,25);
     bed_type.setBackground(Color.WHITE);
     add(bed_type);
     
     available = new JCheckBox("Only display Available");
     available.setBounds(650,100,150,25);
     available.setBackground(Color.WHITE);
     add(available);
     
     JLabel l1= new JLabel ("Room Number");
     l1.setBounds(50,160,200,20);
     add(l1);
     
     JLabel l2= new JLabel ("Availability");
     l2.setBounds(270,160,100,20);
     add(l2);
     
     JLabel l3= new JLabel ("Cleaning Status");
     l3.setBounds(450,160,100,20);
     add(l3);
     
     JLabel l4= new JLabel ("Price");
     l4.setBounds(670,160,100,20);
     add(l4);
     
     JLabel l5= new JLabel ("Bed Type");
     l5.setBounds(870,160,100,20);
     add(l5);
     
     table = new JTable();
     table.setBounds(0,180,1000,300);
     table.setBackground(Color.pink);
     add(table);
     
    try
    {
     Conn c = new Conn();
     ResultSet rs = c.s.executeQuery("select * from room");
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
     String query1 = "Select * from room where bed_type = '"+bed_type.getSelectedItem()+"'";
     String query2 = "Select * from room where availability= 'Available' AND bed_type = '"+bed_type.getSelectedItem()+"'";
     Conn conn = new Conn();
     ResultSet rs;
     if(available.isSelected())
     {
      rs = conn.s.executeQuery(query2);
     }
     else 
       {
        rs = conn.s.executeQuery(query1);
       }
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
            new SearchRoom();
        }
}