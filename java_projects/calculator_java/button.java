import java.awt.*;
import java.awt.gridlayout;
import java.util.EventListener;
import java.awt.*;
import java.awt.borderlayout;


public class button{   
    //method
    public static void main(String[] args){
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();
    JButton jb5 = new JButton();
    JButton jb6 = new JButton();
    JButton jb7 = new JButton();
    JButton jb8 = new JButton();
    JButton jb9 = new JButton();
    JButton jb0 = new JButton();
    JButton jbplus = new JButton();
    JButton jbminus = new JButton();
    JButton jbstar = new JButton();
    jb1.add("1");
    jb2.add("2");
    jb3.add("3");
    jb4.add("4");
    jb5.add("5");
    jb6.add("6");
    jb7.add("7");
    jb8.add("8");
    jb9.add("9");
    jb0.add("0");

    jbplus.add("+");
    jbminus.add("-");
    jbstar.add("*");
    jbslash.add("/");
    jbequal.add("=");
     JPanel panel = new JPanel();
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
     panel.add(jbplus);
     panel.add(jbminus);
     panel.add(jbstar);
     panel.add(jbslash);
    panel.add(jbequal);
    
    frame.add(panel, BorderLayout.CENTER);
    setVisible(true);
    
        

    }
}
