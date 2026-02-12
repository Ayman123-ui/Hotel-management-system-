
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener 
{
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    Choice croom;
    JLabel lbltime,checkintime,lbldeposit,text,lblid,lblnumber,lblname,lblgender,lblcountry,lblroom;
    JButton Add,Back;
    JRadioButton rbmale,rbfemale;
  AddCustomer() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
      
    text = new JLabel("NEW CUSTOMER FORM");
    text.setBounds(100,20,300,30);
    text.setFont(new Font("Raleway",Font.PLAIN,24));
    add(text);

    lblid = new JLabel("ID");
    lblid.setBounds(100,75,300,30);
    lblid.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lblid);

    String options[] = {"Aadhar","Passport","Driving License","Voter Id"};
    comboid = new JComboBox(options); 
    comboid.setBounds(200,75,150,30);
    comboid.setBackground(Color.WHITE);
    add(comboid);
     
    lblnumber = new JLabel("Number");
    lblnumber.setBounds(90,132,500,20);
    lblnumber.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lblnumber);

    tfnumber = new JTextField();
    tfnumber.setBounds(200,130,150,30);
    add(tfnumber);
    
    lblname = new JLabel("Name");
    lblname.setBounds(90,190,100,20);
    lblname.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(200,185,150,30);
    add(tfname); 
      
    lblgender = new JLabel("Gender");
    lblgender.setBounds(90,245,100,20);
    lblgender.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lblgender);
    
    rbmale = new JRadioButton("Male");
    rbmale.setBounds(200,245,70,30);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
    rbmale.setBackground(Color.WHITE);
    add(rbmale);
    
    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(280,245,70,30);
    rbfemale.setFont(new Font("Tahoma", Font.PLAIN,14));
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(rbmale);
    bg.add(rbfemale);

    lblcountry = new JLabel("Country");
    lblcountry.setBounds(90,300,100,19);
    lblcountry.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lblcountry);
    
    tfcountry = new JTextField();
    tfcountry.setBounds(200,300,150,27);
    add(tfcountry);
    
    lblroom = new JLabel("Room Number");
    lblroom.setBounds(55,350,140,18);
    lblroom.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lblroom);
    
    croom = new Choice();
    croom.setBounds(200,352,150,35);
    add(croom);
    
    try 
    {
     Conn conn = new Conn ();
     String query = "Select * from room where availability='Available'";
     ResultSet rs = conn.s.executeQuery(query);
     while(rs.next()) 
      {
     croom.add(rs.getString(("roomno")));
      }
    }
     catch (Exception e) 
     {
     e.printStackTrace();
     }
    
    lbltime= new JLabel("Check in Time");
    lbltime.setBounds(50,396,150,18);
    lbltime.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lbltime);
    
    Date date =new Date();
    
    checkintime= new JLabel("" + date);
    checkintime.setBounds(200,400,150,18);
    checkintime.setFont(new Font("Tahoma",Font.PLAIN,15));
    add(checkintime);
    
    lbldeposit = new JLabel("Deposit");
    lbldeposit.setBounds(90,450,150,19);
    lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,19));
    add(lbldeposit);
    
    tfdeposit = new JTextField();
    tfdeposit.setBounds(200,450,150,27);
    add(tfdeposit);
    
    Add =new JButton("Add");
    Add.setBackground(Color.BLACK);
    Add.setForeground(Color.WHITE);
    Add.setBounds(70,495,120,27);
    Add.addActionListener(this);
    add(Add);
    
    Back =new JButton("Back");
    Back.setBackground(Color.BLACK);
    Back.setForeground(Color.WHITE);
    Back.setBounds(210,495,120,27);
    Back.addActionListener(this);
    add(Back);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/boy.jpeg"));
    Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon (i2);
    JLabel image=new JLabel(i3);
    image.setBounds(420,80,300,390);
    add(image);
    
    setBounds(350,160,810,570);
    getContentPane().setBackground(Color.pink);
    setVisible(true);
  }
 public void actionPerformed(ActionEvent ae)   
     {
    if (ae.getSource()== Add)
     {
    String id = (String) comboid.getSelectedItem();
    String number = tfnumber.getText();
    String name = tfname.getText();
    String gender = null;
    if (id.equals(""))
     {
    JOptionPane.showMessageDialog(null , "id should not be empty");
    return;
     }
    if (number.equals(""))
     {
    JOptionPane.showMessageDialog(null , "Phone number should not be empty");
    return;
     }
    
     if(number.length() != 10)
        {
         JOptionPane.showMessageDialog(null, "Invalid Phone Number. Please enter 10 digits.");
         return;
        }
         
         
    if (name.equals("")) 
     {
    JOptionPane.showMessageDialog(null , "name should not be empty");
    return;
     }
    if (rbmale.isSelected())
     {
    gender = "Male";
     }
    else if (rbfemale.isSelected())
     {
    gender = "Female";
     }    
    String country = tfcountry.getText();
    if (country.equals("")) 
     {
    JOptionPane.showMessageDialog(null , "country should not be empty");
    return;
     }
    String room = croom.getSelectedItem();
    String time = checkintime.getText();
    String deposit = tfdeposit.getText();
    if (deposit.equals("")) 
     {
    JOptionPane.showMessageDialog(null , "deposit is must");
    return;
     }
    try 
    {
    String query = "insert into customer values('"+id+"', '"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";    
    String query2 = "update room set availability='Occupied' where roomno = '"+room+"'";
    Conn conn = new Conn();
    conn.s.executeUpdate(query);
    conn.s.executeUpdate(query2);
    JOptionPane.showMessageDialog(null,"New Customer Added Succesfully");
    setVisible(false);
    new Reception(); 
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
     }
    else if (ae.getSource()==Back)
    {
    setVisible(false);
    new Reception();
    }
     }
  public  static void main(String[]args)
  {
      new AddCustomer();
  }
}
    

