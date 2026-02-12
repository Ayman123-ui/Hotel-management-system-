
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener
{
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
  AddEmployee()
    {
    setLayout(null);
    JLabel lblname = new JLabel("NAME");
    lblname.setBounds(60,30,140,40);
    lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblname.setForeground(Color.WHITE);
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(200,30,150,30);
    tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfname);
    
    JLabel lblage = new JLabel("AGE");
    lblage.setBounds(60,80,120,30);
    lblage.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblage.setForeground(Color.WHITE);
    add(lblage);
    
    tfage = new JTextField();
    tfage.setBounds(200,80,150,30);
    tfage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfage);
    
    JLabel lblgender = new JLabel("GENDER");
    lblgender.setBounds(60,128,100,30);
    lblgender.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblgender.setForeground(Color.WHITE);
    add(lblgender);
    
    rbmale = new JRadioButton("Male");
    rbmale.setBounds(200,130,70,30);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
    rbmale.setBackground(Color.WHITE);
    add(rbmale);
    
    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(270,130,70,30);
    rbfemale.setFont(new Font("Tahoma", Font.PLAIN,14));
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(rbmale);
    bg.add(rbfemale);
    
    JLabel lbljob = new JLabel("JOB");
    lbljob.setBounds(60,177,120,30);
    lbljob.setFont(new Font("Tahoma",Font.PLAIN,20));
    lbljob.setForeground(Color.WHITE);
    add(lbljob);
    
    String str[] = { "Front Desk Clerks" , "Porters", "House Keeping" , "Kitchen Staff" ,"Room Service" ,"Cheifs","Waiter/Waitress" , "Manager" , "Accountant"};
    cbjob = new JComboBox(str);
    cbjob.setBounds(200,180,150,30);
    cbjob.setBackground(Color.WHITE);
    cbjob.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(cbjob);
    
    JLabel lblsalary = new JLabel("SALARY");
    lblsalary.setBounds(60,230,120,30);
    lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblsalary.setForeground(Color.WHITE);
    add(lblsalary);
    
    tfsalary = new JTextField();
    tfsalary.setBounds(200,230,150,30);
    tfsalary.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfsalary);
    
    JLabel lblphone = new JLabel("PHONE");
    lblphone.setBounds(60,280,120,30);
    lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblphone.setForeground(Color.WHITE);
    add(lblphone);
    
    tfphone = new JTextField();
    tfphone.setBounds(200,280,150,30);
    tfphone.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfphone);
    
    JLabel lblemail = new JLabel("EMAIL");
    lblemail.setBounds(60,330,120,30);
    lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblemail.setForeground(Color.WHITE);
    add(lblemail);
    
    tfemail = new JTextField();
    tfemail.setBounds(200,330,150,30);
    tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfemail);
    
    JLabel lblaadhar = new JLabel("AADHAR");
    lblaadhar.setBounds(60,380,120,30);
    lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
    lblaadhar.setForeground(Color.WHITE);
    add(lblaadhar);
    
    tfaadhar = new JTextField();
    tfaadhar.setBounds(200,380,150,30);
    tfaadhar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(tfaadhar);
    
    submit= new JButton("SUBMIT");
    submit.setBackground(Color.black);
    submit.setForeground(Color.WHITE);
    submit.setBounds(120,430,150,30);
    submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    add(submit);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/employee1.jpeg"));
    Image i2= i1.getImage().getScaledInstance(430,430,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel  image = new JLabel(i3);
    image.setBounds(380,2,400,500);
    submit.addActionListener(this);
    add(image);
    
    getContentPane().setBackground(Color.DARK_GRAY);
    setBounds(350,200,850,540);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone= tfphone.getText();
        String email = tfemail.getText();
        //String emailRegex =""
        String aadhar = tfaadhar.getText();
        String job = (String) cbjob.getSelectedItem();
        String gender = null;
        
        if(name.isEmpty())
        {
         JOptionPane.showMessageDialog(null , "Name should not be empty");
         return;
        }
        if(name.matches("\\d+"))
        {
         JOptionPane.showMessageDialog(null , "please enter valid name");
         return;
        }
        if(age.isEmpty()){
         JOptionPane.showMessageDialog(null , "Age should not be empty");
         return;
        }
        if(!age.matches("\\d+")) 
        {
         JOptionPane.showMessageDialog(null , "invalid age");
         return;
        }
        if(salary.isEmpty())
        {
         JOptionPane.showMessageDialog(null , "Salary should not be empty");
         return;
        }
        if(!salary.matches("\\d+"))
        {
         JOptionPane.showMessageDialog(null , "Enter valid salary");
         return;
        }
         
        if(phone.isEmpty())
        {
         JOptionPane.showMessageDialog(null , "Phone number should not be empty");
         return;
        }
        if(!phone.matches("\\d+"))
        {
         JOptionPane.showMessageDialog(null , "Enter Valid Phone Number");
         return;
        }  
        
        if(phone.length() != 10)
        {
         JOptionPane.showMessageDialog(null, "Invalid Phone Number. Please enter 10 digits.");
         return;
        }
         
        if(email.isEmpty()) 
        {
         JOptionPane.showMessageDialog(null , "Email should not be empty ");
         return;
        }
        if(!email.contains("@") || !email.contains(".")) 
        {
         JOptionPane.showMessageDialog(null , "please enter valid email ");     
         return;
        }
         
         if(aadhar.isEmpty())
        {
         JOptionPane.showMessageDialog(null , "Adhar Number should not be empty");
         return;
        }
        if(aadhar.length() != 12)
        {
         JOptionPane.showMessageDialog(null, "Invalid Aadhaar Number. Please enter 12 digits.");
         return;
        }
         
        if(rbmale.isSelected()) 
        {
         gender = "Male";
        }
        else if(rbfemale.isSelected()) 
        {
         gender = "female";
        }    
        
      //  String job = (String) cbjob.getSelectedItem();
        
        try 
          {
            Conn conn = new Conn();
            String query ="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
            
          }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
  
    }
    public static void main(String[] args) 
    {
    new AddEmployee();
    }
}


