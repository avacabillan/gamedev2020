
package javaapplication1;
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

public abstract class Main2 {
    String name;
    String user;
    String pass;
    int workhour;

    abstract public String Identify();
    
    public void salary(){
        System.out.println(this.name+ " your salary is P");
    }
}
class Justine extends Main2{
    public Justine(String n, String p, int w){
     this.user=n;
     this.pass=p;
     this.workhour=w;
    }
    String name ="Justine Tumabang";

    

    public String Identify(){
     return name;  
    }
    public void salary(){
        System.out.println(this.name+ " your salary is P");
    }
}
class Varron extends Justine{
  public Varron(String n, String p, int w){
    super(n,p,w);
    }

    String name ="Marc Varron";

     @Override
    public String Identify(){
     return name;  
    }
    public void salary(){
        System.out.println(this.name+ " your salary is P");
    }
}
class Larangan extends Justine{
  public Larangan(String n, String p, int w){
     super(n,p,w);
    }
    String name ="Christian Larangan";

    @Override
    public String Identify(){
     return name;  
    }
    public void salary(){
        System.out.println(this.name+ " your salary is P");
    }
}
class Michael extends Justine{
  public Michael(String n, String p, int w){
    super(n,p,w);
    }
    String name ="Michael Harrid";
    
    @Override
    public String Identify(){
     return name;  
    }
    public void salary(){
        System.out.println(this.name+ " your salary is P");
    }
}
class Show{
    public void frame(String n){
			    String name = n;
				JFrame jframe = new JFrame("");
				jframe.setSize(400, 400);
                              
				
				JPanel jpanel = new JPanel();
				jpanel.setSize(100, 100);
                                
                                JLabel jlabel = new JLabel();
				jlabel.setText(name);
 
                                
                                JLabel jlabel1 = new JLabel();
				jlabel1.setText("hours");
                                
                                JLabel jlabel2 = new JLabel();
				jlabel2.setText("pay per hour");
                                
                                JLabel jlabel3 = new JLabel();
				jlabel3.setText("late per hour");
                                
                                JLabel jlabel4 = new JLabel();
				jlabel4.setText("over time");
                                
                              
                                
                              
				jpanel.setBorder(new EmptyBorder(100,10, 100, 10));
				
				JTextField num1text = new JTextField();
				num1text.setPreferredSize(new Dimension(100, 30));
                                num1text.setEditable(true);
                                
                                
				JTextField num2text = new JTextField();
				num2text.setPreferredSize(new Dimension(100, 30));
                                
                                
				JTextField num3text = new JTextField();
				num3text.setPreferredSize(new Dimension(100, 30));
                                
                                
				JTextField num4text = new JTextField();
				num4text.setPreferredSize(new Dimension(100, 30));
				
				JButton compute = new JButton("Compute");
				compute.setSize(20, 30);
                                
                                jframe.add(jlabel);
                                
                                jpanel.add(jlabel1);
				jpanel.add(num1text);
                                jpanel.add(jlabel2);
				jpanel.add(num2text);
                                jpanel.add(jlabel3);
                                jpanel.add(num3text);
                                jpanel.add(jlabel4);
                                jpanel.add(num4text);
				jpanel.add(compute);
                                jframe.add(jpanel);
                                
		
				jframe.setVisible(true);
				
				compute.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					float num1 =Integer.parseInt(num1text.getText());
					float num2 =Integer.parseInt(num2text.getText());	
                                        float num3 =Integer.parseInt(num3text.getText());
				        float num4 =Integer.parseInt(num4text.getText());
                                        float ans = 0;
                                        
                                                        ans+=(num1*num2)-(num2*num3)+(num2*num4);
                                                        JOptionPane.showMessageDialog(jframe, ans);
                                                        }
					
				});
				
		}
    
}
