import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class Calculator2 {
    public static JTextField tf = new JTextField();
    static String firstoperand = "";
    static String secondoperand = "";
    static boolean isOperatorSelected = false;
    static String operator = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.add(tf, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridLayout(4, 4));
        
        //adding button
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton badd = new JButton("+");
        JButton bsub = new JButton("-");
        JButton bmul = new JButton("*");
        JButton bdiv = new JButton("/");
        JButton bcompute = new JButton("=");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b0);
        panel.add(badd);
        panel.add(bsub);
        panel.add(bmul);
        panel.add(bdiv);
        panel.add(bcompute);

   
        //action  listener ko object 
        ActionListener alObject = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                switch(e.getActionCommand()){
                    case "1":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "1";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "1";
                            tf.setText(tf.getText()+"1");
                        }
                        break;
                    case "2":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "2";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "2";
                            tf.setText(tf.getText()+"2");
                        }
                        break;
                    case "3":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "3";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "3";
                            tf.setText(tf.getText()+"3");
                        }
                        break;
                    case "4":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "4";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "4";
                            tf.setText(tf.getText()+"4");
                        }
                        break;
                    case "5":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "5";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "5";
                            tf.setText(tf.getText()+"5");
                        }
                        break;
                    case "6":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "6";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "6";
                            tf.setText(tf.getText()+"6");
                        }
                        break;
                    case "7":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "7";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "7";
                            tf.setText(tf.getText()+"7");   
                        }
                        break;
                    case "8":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "8";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "8";
                            tf.setText(tf.getText()+"8");
                        }
                        break;
                    case "9":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "9";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "9";
                            tf.setText(tf.getText()+"9");
                        }
                        break;
                    case "0":
                        if (!isOperatorSelected) {
                            firstoperand = firstoperand + "0";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "0";
                            tf.setText(tf.getText()+"0");
                        }
                        break;

                        //only setting isOperatorSelected true when operator pressed
                    case"+":
                        if (!isOperatorSelected) {
                            operator = "+";//or// operator = e.getActionCommand();
                            tf.setText(firstoperand + operator);
                            isOperatorSelected = true;
                        }
                        break;

                    case"-":

                        if (!isOperatorSelected) {
                            operator = "-";
                            tf.setText(firstoperand + operator);
                            isOperatorSelected = true;
                        }
                        break;

                    case"*":

                        if (!isOperatorSelected) {
                            operator = e.getActionCommand();
                            tf.setText(firstoperand + operator);
                            isOperatorSelected = true;
                        }
                        break;

                    case"/":
                        if (!isOperatorSelected) {
                            operator = e.getActionCommand();
                            tf.setText(firstoperand + operator);
                            isOperatorSelected = true;
                        }
                        break;

                    case"=":
                        handleCompute();
                        break;
                }
            }
         
        };

        //adding ActionListener to all buttons
        b1.addActionListener(alObject);
        b2.addActionListener(alObject);
        b3.addActionListener(alObject);
        b4.addActionListener(alObject);
        b5.addActionListener(alObject);
        b6.addActionListener(alObject);
        b7.addActionListener(alObject);
        b8.addActionListener(alObject);
        b9.addActionListener(alObject);
        b0.addActionListener(alObject);
        badd.addActionListener(alObject);
        bsub.addActionListener(alObject);
        bmul.addActionListener(alObject);
        bdiv.addActionListener(alObject);
        bcompute.addActionListener(alObject);
        
        frame.add(panel);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    //method for calculating 
        private static void handleCompute() {
            int result = 0;
            int first = Integer.parseInt(firstoperand);
            int second = Integer.parseInt(secondoperand);
            
            switch (operator) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                    break;
                
                }
            //setting on textfield what to display
            tf.setText(String.valueOf(result));

            //for calculating next time
            firstoperand = String.valueOf(result);//first operand will be result
            secondoperand = "";//second null 
            isOperatorSelected = false;// operator not selected

        }
}