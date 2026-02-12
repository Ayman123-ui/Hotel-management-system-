
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideAnimationDemo extends JFrame {

    private JLabel slidingLabel;
    private int xPosition = 0; // Initial X position of the label
    private final int SLIDE_DISTANCE = 5; // Distance to move in each step
    private final int DELAY = 50; // Delay between animation steps (in milliseconds)

    public SlideAnimationDemo() {
        setTitle("Slide Animation Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a JLabel to animate
        slidingLabel = new JLabel("Sliding Text");
        slidingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        slidingLabel.setBounds(xPosition, 50, 150, 30); // Set initial position

        // Add the label to the JFrame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(slidingLabel);

        // Create a Timer to control the animation
        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPosition += SLIDE_DISTANCE; // Update the X position
                if (xPosition > getWidth()) {
                    xPosition = -slidingLabel.getWidth(); // Reset position if it goes off-screen
                }
                slidingLabel.setLocation(xPosition, 50); // Move the label
            }
        });

        timer.start(); // Start the animation
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SlideAnimationDemo().setVisible(true);
            }
        });
    }
}


