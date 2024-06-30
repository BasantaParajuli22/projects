// first calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator1 {
    static String firstoperand ="";
    static String secondoperand ="";
    static boolean isOperatorSelected = false;
    static String operator = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        public static JTextField tf = new JTextField();
        frame.add(tf, BorderLayout.NORTH);

        
        JButton b1 = new JButton("1");// Adding buttons
        //when clicked button functions like this
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "1";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "1";
                    tf.setText(tf.getText()+"1");
                }
            }
        });
        panel.add(b1);

        JButton b2 = new JButton("2");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "2";
                    tf.setText(firstoperand);
                    } else {
                    secondoperand = secondoperand + "2";
                    tf.setText(tf.getText()+ "2");
                }
            }
        });
        panel.add(b2);
        
        
        JButton b3 = new JButton("3");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "3";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "3";
                    tf.setText(tf.getText()+"3");
                }
            }
        });
        panel.add(b3);
        
        JButton b4 = new JButton("4");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "4";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "4";
                    tf.setText(tf.getText()+"3");
                }
            }
        });
        panel.add(b4);
        
        
        JButton b5 = new JButton("5");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "5";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "5";
                    tf.setText(tf.getText()+"3");
                }
            }
        });
        panel.add(b5);
        
        JButton b6 = new JButton("6");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "6";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "6";
                    tf.setText(tf.getText()+"6");
                }
            }
        });
        panel.add(b6);
        
        JButton b7 = new JButton("7");
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "7";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "7";
                    tf.setText(tf.getText()+"7");
                }
            }
        });
        panel.add(b7);
        
        
        JButton b8 = new JButton("8");
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "8";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "8";
                    tf.setText(tf.getText()+"8");
                }
            }
        });
        panel.add(b8);
        
        

        JButton b9 = new JButton("9");
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "9";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "9";
                    tf.setText(tf.getText()+"9");
                }
            }
        });
        panel.add(b9);
        
        JButton b0 = new JButton("0");
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorSelected) {
                    firstoperand = firstoperand + "0";
                    tf.setText(firstoperand);
                } else {
                    secondoperand = secondoperand + "0";
                    tf.setText(tf.getText()+"0");
                }
            }
        });
        panel.add(b0);
        
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {

        		operator = "+";
        		tf.setText(firstoperand + operator);
        		isOperatorSelected=true;
        		
        	}
        });
        panel.add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		operator= "-";
        		tf.setText(firstoperand + operator);
        		isOperatorSelected=true;
        	}
        });
        panel.add(subtractButton);


        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		operator= "/";
        		tf.setText(firstoperand +  operator);
        		isOperatorSelected=true;
        	}
        });
        panel.add(divideButton);
        
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		operator= "*";
        		tf.setText(firstoperand + operator);
        		isOperatorSelected=true;	
        	}
        });
        panel.add(multiplyButton);


        JButton equalsButton = new JButton("=");
         panel.add(equalsButton);
        equalsButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
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
                tf.setText(String.valueOf(result));
                firstoperand = String.valueOf(result);
                secondoperand = "";

            }
        });
       
        frame.add(panel);
        frame.setVisible(true);
}
}