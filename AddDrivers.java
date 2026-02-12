package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDrivers  extends JFrame implements ActionListener
{
       JButton add,cancel;
       JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
       JComboBox availablecombo,gendercombo;
     AddDrivers()
     {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);

       JLabel heading = new JLabel("Add Drivers");
       heading.setFont(new Font("Tahoma",Font.BOLD,18));
       heading.setBounds(130,25,200,20);
       add(heading);
       
       JLabel lblname = new JLabel("Name");
       lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblname.setBounds(60,90,120,20);
       add(lblname);

       tfname=new JTextField();
       tfname.setBounds(200,90,150,30);
       tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(tfname);

       JLabel lblage = new JLabel("Age");
       lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
       lblage.setBounds(60,140,120,30);
       add(lblage);
       
       tfage=new JTextField();
       tfage.setBounds(200,140,150,30);
       tfage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(tfage);
       
       JLabel lblgender = new JLabel("Gender");
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
       lblgender.setBounds(60,190,120,30);
       add(lblgender);
       
       String ageOptions[]={"Male","Female"};
       gendercombo = new JComboBox(ageOptions);
       gendercombo.setBounds(200,190,150,30);
       gendercombo.setBackground(Color.WHITE);
       gendercombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(gendercombo);

       JLabel lblprice = new JLabel("Car Company");
       lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblprice.setBounds(60,240,120,30);
       add(lblprice);

       tfcompany=new JTextField();
       tfcompany.setBounds(200,240,150,30);
       tfcompany.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(tfcompany);
       
       JLabel lbltype = new JLabel("Car Models");
       lbltype.setFont(new Font("Tahoma",Font.PLAIN,17));
       lbltype.setBounds(60,290,120,30);
       add(lbltype);
      
       tfmodel=new JTextField();
       tfmodel.setBounds(200,290,150,30);
       tfmodel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(tfmodel);
      
       JLabel lblavailable = new JLabel("Available");
       lblavailable.setFont(new Font("Tahoma",Font.PLAIN,17));
       lblavailable.setBounds(60,340,120,30);
       add(lblavailable);
      
       String deiverOptions[]={"Available","Busy"};
       availablecombo = new JComboBox(deiverOptions);
       availablecombo.setBounds(200,340,150,30);
       availablecombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       availablecombo.setBackground(Color.WHITE);
       add(availablecombo);
       
       JLabel lbllocation = new JLabel("Location");
       lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
       lbllocation.setBounds(60,390,120,30);
       add(lbllocation);
       
       tflocation=new JTextField();
       tflocation.setBounds(200,390,150,30);
       tflocation.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       add(tflocation);
       
       add = new JButton("Add Driver");
       add.setForeground(Color.WHITE);
       add.setBackground(Color.BLACK);
       add.setBounds(60,445,130,35);
       add.addActionListener(this);
       add(add);
       
       cancel= new JButton("Cancel");
       cancel.setForeground(Color.WHITE);
       cancel.setBackground(Color.BLACK);
       cancel.setBounds(220,445,130,35);
       cancel.addActionListener(this);
       add(cancel);
      
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/car.jpeg"));
       Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon (i2);
       JLabel image=new JLabel(i3);
       image.setBounds(290,10,750,520);
       add(image);

       setBounds(270,110,1000,600);
       getContentPane().setBackground(Color.CYAN);
       setVisible(true);
}
       public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == add) {
       String name = tfname.getText();
       String age =tfage.getText();
       String gender =(String) gendercombo.getSelectedItem();
       String company =tfcompany.getText();
       String brand =  tfmodel.getText();
       String available = (String) availablecombo.getSelectedItem();
       String location = tflocation.getText();
     
      try 
      {
       Conn conn = new Conn();
       String str = "insert into driver value('"+name+"', '"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
       conn.s.executeUpdate(str);
       JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
       setVisible(false);
      }
      catch (Exception e) 
      {
          e.printStackTrace();
      }
}
     }
     public static void main(String[] args)
        {
     new AddDrivers();
        }
}


    

