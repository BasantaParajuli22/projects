import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Calculator3 {
    public static JTextField tf = new JTextField();
    static String firstoperand = "";
    static String secondoperand = "";
    static boolean OperatorSelected = false;
    static String operator = "";

        static void addButtonToPanel(String buttonName, ActionListener al, JPanel panelVar){
            //creating new button using loop
            JButton buttonVar = new JButton(buttonName);
            //al is an instance of an 'anonymous inner class (addActionListener)
            //that implements the ActionListener interface.
            buttonVar.addActionListener(al);
            //here looping button name for panel
            panelVar.add(buttonVar);
            //same as 
            /**
             *  panel.add(b1);
                panel.add(b2);
                panel.add(b3);
                panel.add(b4);
             * 
             *while adding panel only button names are changed so
             * 
             */

        }
     
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.add(tf, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        //panel same in method
        JPanel panel = new JPanel(new GridLayout(4, 4));

        ActionListener alObject = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                switch(e.getActionCommand()){
                    //same as other case of hanlding numbers
                    case "1":
                        if (!OperatorSelected) {
                            firstoperand = firstoperand + "1";
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + "1";
                            tf.setText(tf.getText()+"1");
                        }
                        break;
                    case "2":
                        handleNumber(e.getActionCommand());
                        
                        break;
                    case "3":
                        handleNumber(e.getActionCommand());
                        break;
                    case "4":
                        handleNumber(e.getActionCommand());
                        break;
                    case "5":
                         handleNumber(e.getActionCommand());
                        break;
                    case "6":
                         handleNumber(e.getActionCommand());
                        break;
                    case "7":
                         handleNumber(e.getActionCommand());
                        break;
                    case "8":
                         handleNumber(e.getActionCommand());
                        break;
                    case "9":
                         handleNumber(e.getActionCommand());
                        break;
                    case "0":
                         handleNumber(e.getActionCommand());
                        break;

                    case"+":
                     if (!OperatorSelected) {
        		        operator= "+";
        		        tf.setText(firstoperand + operator);
        		        OperatorSelected = true;
                     }
                        break;   
                    case"-":
                        handleoperator(e.getActionCommand());
                        break;
                    case"*":
                       handleoperator(e.getActionCommand());
                        break;
                    case"/":
                        handleoperator(e.getActionCommand());
                        break;
                    case"=":
                        handleCompute();
                        break;
                    case"ac":
                        handleAC();
                        break;

                        
                }
            } 
        };

        //adding button action listener and to panel
        for(int i=0;i<=9;i++){
            addButtonToPanel(Integer.valueOf(i).toString(), alObject, panel);
        }
        addButtonToPanel("+",alObject,panel);
        addButtonToPanel("-",alObject,panel);
        addButtonToPanel("*",alObject,panel);
        addButtonToPanel("/",alObject,panel);
        addButtonToPanel("=",alObject,panel);
        addButtonToPanel("ac",alObject,panel);
        
        
        frame.add(panel);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    //method for handling number
    static  void handleNumber(String eVar){
               if (!OperatorSelected) {
                            firstoperand = firstoperand + eVar;
                            tf.setText(firstoperand);
                        } else {
                            secondoperand = secondoperand + eVar;
                            tf.setText(tf.getText() + eVar);
                        }
    }
    //method for handling operator
    static void handleoperator(String eVar){
        //operator is used in compute method in switch (operator)
        if (!OperatorSelected) {
                            operator = eVar; 
                            tf.setText(firstoperand + operator);
                            OperatorSelected = true;
                        }
                        
    }
    //method for handling computing
        private static void handleCompute() {
           try{
            int result = 0;
            //changing the string to integer
            int first = Integer.parseInt(firstoperand);
            int second = Integer.parseInt(secondoperand);
            //performing various operation based on operator
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
            //displaying result on text field
            tf.setText(String.valueOf(result));
            //resetting variables
            firstoperand = String.valueOf(result);
            secondoperand = "";
            OperatorSelected = false;
            }
            catch(Exception e){
                System.out.println(e + " Error found ::");
                tf.setText("Error: Invalid input or two input not found");
            }
        }

        //method for clearing the textfield
        public static void handleAC(){
           firstoperand = "";
            secondoperand = "";
            operator = "";
            OperatorSelected = false;
            tf.setText("");
        }
}