package pink;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public abstract class Pink2 {

    String name;
    String username;
    String password;
    
    abstract public String Identify();
    
    public void Person(){
        System.out.println("Hello, I am" + this.name);
    }
}
class Student extends Pink2{
    public Student(String un, String p){
        this.username=un;
        this.password=p;
    }
    String name ="";

    public String Identify(){
     return name;  
    }
    public void Person(){
        System.out.println("Hello, I am" + this.name);
    }
    }
class Faculty extends Pink2{
  public Faculty(String un, String p){
    super();
    }

    String name ="";

     @Override
    public String Identify(){
     return name;  
    }
    public void Person(){
        System.out.println("Hello, I am" + this.name);
    }
}
class Staff extends Pink2{
  public Staff(String un, String p){
    super();
    }

    String name ="";

     @Override
    public String Identify(){
     return name;  
    }
    public void Person(){
        System.out.println("Hello, I am" + this.name);
    }
}
class Admin extends Pink2{
  public Admin(String un, String p){
    super();
    }

    String name ="";

     @Override
    public String Identify(){
     return name;  
    }
    public void Person(){
        System.out.println("Hello, I am" + this.name);
    }
}
class show{
    public void frame(String n){
    String name = n;
    JFrame jframe = new JFrame("Body Mass Index");
    jframe.setSize(400, 400);
                                
    JPanel jpanel = new JPanel();
    jpanel.setSize(150, 150);
                                
    JLabel jlabel = new JLabel();
    jlabel.setText(name);                               
                                
    JLabel jlabel2 = new JLabel();
    jlabel2.setText("Weight");
    
    JLabel jlabel3 = new JLabel();
    jlabel3.setText("Height");
                            
    jpanel.setBorder(new EmptyBorder(100,10, 100, 10));
                                
    JTextField num2text = new JTextField();
    num2text.setPreferredSize(new Dimension(100, 30));
                                
    JTextField num3text = new JTextField();
    num3text.setPreferredSize(new Dimension(100, 30));
				
    JButton compute = new JButton("Convert now");
    compute.setSize(20, 30);
    
    JButton exit  = new JButton("exit");
    exit.setSize(20, 30);
                                
        jframe.add(jlabel);       
        jpanel.add(jlabel2);
	jpanel.add(num2text);
        jpanel.add(jlabel3);
        jpanel.add(num3text);
        jpanel.add(compute);
        jpanel.add(exit);
        jframe.add(jpanel);
		
	jframe.setVisible(true);
                                
        compute.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	double num2 =Double.parseDouble(num2text.getText());
        double num3 =Double.parseDouble(num3text.getText());
        
        double BMI = (num3 * num3) ;
        double answer = (num2 / BMI);
        
        JOptionPane.showMessageDialog(jframe, answer + "  That is your Body mass index Phoebe! ");
        
        }});
        
        exit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(jframe,"Thank you!");
            
        }});
    }
}
