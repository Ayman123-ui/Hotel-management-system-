package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener 
{
       JButton newCustomer,newrooms,department,allemployee, ManagerInfo,CustomerInfo,searchroom,update,cleanstatus,pickup,checkout,logout;
     Reception()
    {
       getContentPane().setBackground(Color.PINK);
       setLayout(null);
       
       newCustomer = new JButton("New Customer Form");
       newCustomer.setBounds(10,20,200,30);
       newCustomer.setBackground(Color.BLACK);
       newCustomer.setForeground(Color.WHITE);
       newCustomer.addActionListener(this);
       add(newCustomer);
        
       newrooms= new JButton("Rooms");
       newrooms.setBounds(10,60,200,30);
       newrooms.setBackground(Color.BLACK);
       newrooms.setForeground(Color.WHITE);
       newrooms.addActionListener(this);
       add(newrooms);
        
       department = new JButton("Department");
       department.setBounds(10,100,200,30);
       department.setBackground(Color.BLACK);
       department.setForeground(Color.WHITE);
       department.addActionListener(this);
       add(department);
       
       allemployee = new JButton("All Employee");
       allemployee.setBounds(10,140,200,30);
       allemployee.setBackground(Color.BLACK);
       allemployee.setForeground(Color.WHITE);
       allemployee.addActionListener(this);
       add(allemployee);
        
       CustomerInfo = new JButton("Customer Info");
       CustomerInfo.setBounds(10,180,200,30);
       CustomerInfo.setBackground(Color.BLACK);
       CustomerInfo.setForeground(Color.WHITE);
       CustomerInfo.addActionListener(this);
       add(CustomerInfo);
        
       ManagerInfo = new JButton("Manager");
       ManagerInfo.setBounds(10,220,200,30);
       ManagerInfo.setBackground(Color.BLACK);
       ManagerInfo.setForeground(Color.WHITE);
       ManagerInfo.addActionListener(this);
       add(ManagerInfo);
       
       checkout = new JButton("Checkout");
       checkout.setBounds(10,260,200,30);
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
       add(checkout);
           
       update = new JButton("update");
       update.setBounds(10,300,200,30);
       update.setBackground(Color.BLACK);
       update.setForeground(Color.WHITE);
       update.addActionListener(this);
       add(update);
       
       cleanstatus = new JButton("Cleaning Status");
       cleanstatus.setBounds(10,340,200,30);
       cleanstatus.setBackground(Color.BLACK);
       cleanstatus.setForeground(Color.WHITE);
       cleanstatus .addActionListener(this);
       add(cleanstatus);
        
       pickup = new JButton("Pickup Services");
       pickup.setBounds(10,380,200,30);
       pickup.setBackground(Color.BLACK);
       pickup .setForeground(Color.WHITE);
       pickup.addActionListener(this);
       add(pickup);
        
       searchroom = new JButton("Search Room");
       searchroom.setBounds(10,420,200,30);
       searchroom.setBackground(Color.BLACK);
       searchroom.setForeground(Color.WHITE);
       searchroom.addActionListener(this);
       add(searchroom);
     
       logout = new JButton("Logout");
       logout.setBounds(10,460,200,30);
       logout.setBackground(Color.BLACK);
       logout.setForeground(Color.WHITE);
       logout.addActionListener(this);
       add(logout);
      
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpeg"));
       JLabel image=new JLabel(i1);
       image.setBounds(270,20,500,470);
       add(image);
        
       setBounds(350,210,850,545);
       setVisible(true);    
}
       public void actionPerformed(ActionEvent ae) 
  {
       if (ae.getSource()== newCustomer)
       {
          setVisible(false);
          new AddCustomer();
       }
       else if (ae.getSource()== newrooms)
       {
            setVisible(false);
            new Room();
       }
       else if (ae.getSource()== department) 
       {
          setVisible(false);
          new Department();
       }
       else if (ae.getSource()== allemployee)
       {
          setVisible(false);
          new EmployeeInfo();
       }
       else if (ae.getSource()== ManagerInfo) 
       {
          setVisible(false);
          new ManagerInfo();
       }
       else if (ae.getSource()== CustomerInfo)
       {
          setVisible(false);
          new CustomerInfo();
       } 
       else if (ae.getSource()== searchroom)
       {
          setVisible(false);
          new SearchRoom();
       }
       else if(ae.getSource() == update)
       {
          setVisible(false);
          new UpdateCheck();
       }
       else if (ae.getSource() == cleanstatus)
       {
          setVisible(false);
          new updateroom();
       }
       else if(ae.getSource()==pickup)
       {
          setVisible(false);
          new Pickup();
       }
       else if (ae.getSource()==checkout)
       {
          setVisible(false);
          new Checkout();
       }
       else if (ae.getSource() == logout)
       {
          setVisible(false);
          System.exit(0);
       }
  }
  
       public static void main (String[] args) 
       { 
       new Reception();
       }
}

