package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HotelManagementSystem extends JFrame implements ActionListener
{
 HotelManagementSystem() 
 {
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     java.net.URL url =HotelManagementSystem.class.getResource("style.css");
     if (url != null) 
     {
    try 
    {
        frame.getContentPane().setBackground(Color.decode("#FFFFFF")); // default background color
        String css = url.toString();
        String[] styles = css.split(";");
        for (String style : styles) {
            if (!style.isEmpty()) {
                String[] property = style.split(":");
                if (property.length == 2) {
                    String propertyName = property[0].trim();
                    String propertyValue = property[1].trim();
                    if (propertyName.equals("background-color")) {
                    frame.getContentPane().setBackground(Color.decode(propertyValue));
                    }
                }
            }
        }
    } catch (Exception e)
    {
        System.err.println("Error loading CSS: " + e.getMessage());
    }
     }
     //frame.getContentPane().setBackground(Color.decode("GREEN")); // default background color
       setSize(2210,900);
       setLocation(10,10);
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/aymii2.jpeg"));
       JLabel image =new JLabel(i1);
       image.setBounds(100,100,466,265);
       add(image);
       
       JLabel text = new JLabel("WELCOME TO THE GRAND HOTEL");
       text.setBounds(100,0,850,85);
       text.setForeground(Color.BLACK);
       text.setFont(new Font("serif", Font.ITALIC, 50));
       image.add(text);
       
//       JButton next = new JButton("NEXT");
//       next.setBounds(1200,700,230,60);
//       next.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
//       next.setBackground(Color.WHITE);
//       next.setForeground(Color.BLACK);
//       next.setFont(new Font("Serif", Font.ITALIC, 24));
JButton next = new JButton("NEXT") {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Background color based on button state
        Color bgColor = this.getBackground();
        if(getModel().isPressed()) {
            bgColor = new Color(0, 64, 128);  // Darker pressed state
        } else if(getModel().isRollover()) {
            bgColor = new Color(0, 86, 179);  // Hover state
        }
        
        // Draw rounded background
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(g2);
        g2.dispose();
    }
};

// Basic styling
next.setBounds(1200, 700, 230, 60);
next.setContentAreaFilled(false);
next.setBorderPainted(false);
next.setOpaque(false);
next.setFocusPainted(false);
next.setCursor(new Cursor(Cursor.HAND_CURSOR));
next.addActionListener(this);
// Color scheme
next.setBackground(new Color(52, 58, 64));  // Dark gray (Bootstrap's "dark" color) // Bootstrap primary blue
next.setForeground(Color.WHITE);

// Typography
next.setFont(new Font("Tahoma", Font.BOLD , 24));

// Padding and spacing
next.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(new Color(0, 86, 179), 2),  // Border color
    BorderFactory.createEmptyBorder(10, 25, 10, 25)            // Padding
));

// Shadow effect
next.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0, 86, 179)),  // Bottom shadow
    next.getBorder()
));

// Hover effects
next.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        next.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 86, 179), 2),
            BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        next.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(0, 123, 255), 2),
            BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
    }
});

       image.add(next);
       setVisible(true);

         while(true){
             text.setVisible(true);
             try{
                 Thread.sleep(1000);
             }catch (Exception e) {
                 e.printStackTrace();
             }
             text.setVisible(true);
         }
         
}
public void actionPerformed(ActionEvent ae)  
{
    setVisible(false);
    new Login();
    
}
    
    public static void main(String[] args) 
    {
         new HotelManagementSystem();
    
        }
    }
                 

