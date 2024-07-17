import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class VotingEligibilityChecker2 {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Checking for voting");

        // Set the size of the frame
        frame.setSize(300, 150);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //grid layout is not good at responsiveness when maximized the screen

        // Create a panel to hold the components
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        frame.add(panel);
        placeComponents(panel);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Create sub-panels for each row
        JPanel row1 = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();

        // Create a JLabel for age input
        JLabel ageLabel = new JLabel("Enter your age:");
        row1.add(ageLabel);

        // Create a JTextField for age input
        JTextField ageText = new JTextField(20);
        row1.add(ageText);

        // Create a JButton for checking eligibility
        JButton checkButton = new JButton("Check");
        row2.add(checkButton);

        // Create a JLabel for displaying the result
        JLabel resultLabel = new JLabel("");
        row3.add(resultLabel);

        // Add rows to the main panel
        panel.add(row1);
        panel.add(row2);
        panel.add(row3);

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
