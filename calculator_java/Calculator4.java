import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Calculator4 {
    public static JTextField tf = new JTextField();
    static String All_input = "";
    static String operator = "";
    //method for adding buttons on jframe, on panel and adding action listener to them   
    static  void addButtonToPanel(String buttonName, ActionListener AL, JPanel panel){
        JButton JB=new JButton(buttonName);
        JB.addActionListener(AL);
        panel.add(JB);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.add(tf, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eVar = e.getActionCommand();
                // (matches()) to determine whether the action command is a digit or an operator??
                if (eVar.matches("\\d")) {
                    All_input = All_input + eVar;
                    tf.setText(All_input);
                // chcking if it matches an opperator
                }else if(eVar.matches("[+\\-*/]")) {
                    operator = eVar;
                    All_input = All_input + operator;
                    tf.setText(All_input);
                //if equal buttonn found 
                } else if(eVar.equals("=")) {
                    handleCompute();
                }
            }
        };
        //adding button on jframe, on panel and adding action listener to them
        for(int i=0;i<=9;i++){
            addButtonToPanel(Integer.valueOf(i).toString(), AL, panel);
        }
        addButtonToPanel("0", AL, panel);
        addButtonToPanel("+", AL, panel);
        addButtonToPanel("-", AL, panel);
        addButtonToPanel("/", AL, panel);
        addButtonToPanel("*", AL, panel);
        addButtonToPanel("=", AL, panel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void handleCompute() {
        String[] parts = All_input.split("[+\\-*/]");
        if (parts.length != 2) {
            // Handle invalid input
            tf.setText("two inputs not found");
            All_input = "0";
            return;
        }
        int operand1 = Integer.parseInt(parts[0]);
        int operand2 = Integer.parseInt(parts[1]);
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                    result = operand1 * operand2;
                    break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    tf.setText("Division by zero ::Error");
                    return;
                }
                break;
        }
        tf.setText(String.valueOf(result));
        All_input = String.valueOf(result);
        operator = "";
    } 
            
}

