import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginform{
    public static void main(String[] args){
        JFrame frame = new JFrame("Login Form");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(null);
        

        JLabel usernameLabel = new JLabel("username");
        usernameLabel.setBounds(10,10,150,30);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(100,10,150,30);

        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setBounds(10,40,150,30);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(100,40,150,30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(40,80,100,30);

        JButton resetButton = new JButton("reset");
        resetButton.setBounds(150,80,100,30);

        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(10,120,200,40);

        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(passwordField);

        frame.add(submitButton);
        frame.add(resetButton);
        frame.add(messageLabel);


        submitButton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){

                String userTf = usernameField.getText();
                String passwordTf = passwordField.getText();

                if(userTf.equals("username") && passwordTf.equals("1234")){
                    messageLabel.setText("Login Successfull");
                }else{
                    messageLabel.setText("Wrong Credentials");
                }

            }
        });

        resetButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e ){
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        frame.setVisible(true); 
    }
}