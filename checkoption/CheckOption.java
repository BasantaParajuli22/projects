import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//using JCheckBox, Jbutton, JOptionPane, and StringBuilder
public class CheckOption {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JCheckBox Example");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");

        JButton button = new JButton("Submit");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                StringBuilder result = new StringBuilder("Selected Options: ");
                if (checkBox1.isSelected()) {
                    result.append("Option 1, ");
                }
                if (checkBox2.isSelected()) {
                    result.append("Option 2, ");
                }
                if (checkBox3.isSelected()) {
                    result.append("Option 3");
                }
                JOptionPane.showMessageDialog(frame, result.toString());
            }
        });

        frame.add(checkBox1);
        frame.add(checkBox2);
        frame.add(checkBox3);
        frame.add(button);

        frame.setVisible(true);
    }
}