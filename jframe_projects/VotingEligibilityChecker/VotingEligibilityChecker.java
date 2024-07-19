import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotingEligibilityChecker {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Checking for voting");
        JFrame frame2 = new JFrame("Checking for voting");

        // Set the size of the frame
        //300 pixels wide and 250 pixels tall.
        frame.setSize(250, 250); 
        frame2.setSize(250, 250); 

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        frame.add(panel);
        frame2.add(panel);

        placeComponents(panel);

        // Set the frame visibility to true
        frame.setVisible(true);
        frame2.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a JLabel for age input
        JLabel ageLabel = new JLabel("Enter your age:");
        //x-coordinate,y-coordinate,width,height
        ageLabel.setBounds(10, 20, 120, 25);
        panel.add(ageLabel);

        // Create a JTextField for age input
        JTextField ageText = new JTextField(20);
        ageText.setBounds(130, 20, 50, 25);
        panel.add(ageText);

        // Create a JButton for checking eligibility
        JButton checkButton = new JButton("Check");
        checkButton.setBounds(60, 70, 80, 25);
        panel.add(checkButton);

        // Create a JLabel for displaying the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(30, 100, 260, 25);
        panel.add(resultLabel);

        // Add an ActionListener to the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int age = Integer.parseInt(ageText.getText());
                    if (age >= 18) {
                        resultLabel.setText("You are eligible to vote.");
                    } else {
                        resultLabel.setText("You are not eligible to vote.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid age.");
                }
            }
        });
    }
}
