import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollegeForm {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JCheckBox Example");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(20, 1));

        JLabel rollnolabel = new JLabel("rollno");

        JLabel namelabel = new JLabel("Name");
        JTextField nametf = new JTextField(10);
        JLabel collegelabel = new JLabel("College");
        JTextField collegetf = new JTextField(20);

        JLabel genderlabel = new JLabel("Gender");
        JRadioButton maleButton = new JRadioButton("male");
        JRadioButton femaleButton = new JRadioButton("female");
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        JLabel favouritelabel = new JLabel("Favourite");
        JCheckBox pizzaBox = new JCheckBox("pizza");
        JCheckBox burgerBox = new JCheckBox("burger");

        JTextField displaytf = new JTextField(10);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nametf.getText();
                String college = collegetf.getText();

                String gender = maleButton.isSelected() ? maleButton.getText() : femaleButton.getText();
                //if male button is selected get male else female

                //to display all selected data of Favourites using StringBuilder
                StringBuilder favorites = new StringBuilder("Favorite Foods: ");
                if (pizzaBox.isSelected())
                    favorites.append("pizza ");//adds pizza to favourites
                if (burgerBox.isSelected())
                    favorites.append("burger ");//adds pizza to favourites

                displaytf.setText(name + " " + college + " " + gender + " " + favorites.toString());
            }
        });

        frame.add(rollnolabel);
        frame.add(namelabel);
        frame.add(nametf);

        frame.add(collegelabel);
        frame.add(collegetf);

        frame.add(genderlabel);
        frame.add(maleButton);
        frame.add(femaleButton);

        frame.add(favouritelabel);
        frame.add(pizzaBox);
        frame.add(burgerBox);

        frame.add(submitButton);
        frame.add(displaytf);
        frame.setVisible(true);
    }
}
