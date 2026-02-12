 
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
       JMenuItem addemployee,addroom,adddrivers; 
       JMenu admin;
     Dashboard() 
{
        setBounds(0,0,1535,1000);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dash.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1750, 970, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);        
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,45));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
     
        admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
     
        addemployee= new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        addroom= new JMenuItem("ADD ROOMS");
        addroom.addActionListener(this);
        admin.add(addroom);
        
        adddrivers= new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        JMenu Abt=new JMenu("ABOUT US");
        Abt.setForeground(Color.red);
        mb.add(Abt);

        JMenuItem a=new JMenuItem("Welcome to Grand Hotel. We offer clean rooms,");
        Abt.add(a);

        JMenuItem ab=new JMenuItem("excellent services, and everything you need for a comfortable stay.");
        Abt.add(ab);

        JMenuItem abtu=new JMenuItem("Located in Mumbai, we are perfect for anyone visiting for work or fun.");
        Abt.add(abtu);

        JMenu Contact=new JMenu("CONTACT US");
        Contact.setForeground(Color.BLUE);
        mb.add(Contact);

        JMenuItem mbn=new JMenuItem("mb-7208575678");
        Contact.add(mbn);

        JMenuItem mbnn=new JMenuItem("mb-9085175678");
        Contact.add(mbnn);

        JMenuItem em1=new JMenuItem("email-nashra913@gmail.com");
        Contact.add(em1);

        JMenuItem em2=new JMenuItem("email-ayman100@gmail.com");
        Contact.add(em2);
       
        setVisible(true);
  }
    public void actionPerformed(ActionEvent ae)
    {
 if(ae.getActionCommand().equals("ADD EMPLOYEE"))
 {
   new AddEmployee();
 }
 else if(ae.getActionCommand().equals("ADD ROOMS"))
 {
   new AddRoom();
 }
 else if(ae.getActionCommand().equals("ADD DRIVERS"))
 {
   new AddDrivers();
 }else if(ae.getActionCommand().equals("RECEPTION"))
 {
   new Reception ();
 }
}
 public static void main(String[] args)
 {
  new Dashboard();
 }
}

 