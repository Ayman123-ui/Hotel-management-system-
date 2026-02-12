package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;
public class Checkout extends JFrame implements ActionListener 
{
       Choice customer;
       JLabel lblroomno, lblcheckintime, lblcheckouttime;
       JButton checkout, back;
  Checkout() 
  {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Check Out");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer NO");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);

        customer = new Choice();
        customer.setBounds(150, 80, 150, 25);
        add(customer);

        lblroomno = new JLabel(); // Initialize lblroomnumber
        lblcheckintime = new JLabel(); // Initialize lblcheckintime

        try
        {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from customer");
         while (rs.next()) 
         {
          customer.add(rs.getString("number"));
               // lblroomnumber.setText(rs.getString("room"));  Moved inside the loop
               // lblcheckintime.setText(rs.getString("time")); Moved inside the loop
         }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        //Moved these lines inside try block after customer.add so they are executed for selected customer.
         try
         {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");
         while(rs.next())
         {
          lblroomno.setText(rs.getString("room"));
          lblcheckintime.setText(rs.getString("time"));
         }
        }
         catch (Exception e)
         {
            e.printStackTrace();
         }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/verify.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20);
        add(tick);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);

        lblroomno.setBounds(150, 130, 100, 30);
        add(lblroomno);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 170, 30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBounds(30, 280, 120, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(170, 280, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/cardcheck.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);

        setBounds(300, 200, 800, 400);
        getContentPane().setBackground(Color.pink);
        setVisible(true);
    }

    @Override // Added @Override annotation
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == checkout)
          {
            String query1 = "delete from customer where number = '" + customer.getSelectedItem() + "'"; // fixed typo here
            String query2 = "update room set availability ='Available' where roomno='" + lblroomno.getText() + "'";
         try 
         {
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
           JOptionPane.showMessageDialog(null, "Checkout Done");
           setVisible(false);
           new Reception();
          }
         catch (Exception e)
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
        new Checkout(); // Removed unnecessary anonymous inner class
    }
}
