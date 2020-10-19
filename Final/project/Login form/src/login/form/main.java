
package login.form;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {
    
    JFrame frame;
    JButton btnCancel, btnLogin, btnRegister;
    
    JTextField tfName;
    JPasswordField tfPassword;
    JLabel lblName, lblPassword;
    JLabel lblEmail, lblContactNo;
    GridBagLayout gbl;
    GridBagConstraints gbc;
 
    public main() {
     try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName())
                .log(Level.SEVERE, null, ex);
     }
 
        frame = new JFrame("Student Account");
        btnCancel = new JButton("Cancel");
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        JTextField tfName = new JTextField(15);
        tfPassword = new JPasswordField(15);
        JLabel lblName = new JLabel("Name");
        lblPassword = new JLabel("Password");
        lblEmail = new JLabel("Email");   
        lblContactNo = new JLabel("ContactNo");        
                
        gbc = new GridBagConstraints();
        gbl = new GridBagLayout();
 
        frame.setLayout(gbl);
        layoutComponents(0, 0, 1, 1, lblName, frame);
        layoutComponents(0, 1, 3, 1, tfName, frame);
        layoutComponents(0, 2, 1, 1, lblPassword, frame);
        layoutComponents(0, 3, 3, 1, tfPassword, frame);
        layoutComponents(1, 4, 1, 1, btnCancel, frame);
        layoutComponents(2, 4, 1, 1, btnLogin, frame);
        layoutComponents(3, 4, 1, 1, btnRegister, frame);
        
        
 
        frame.setSize(500, 300);
        frame.getContentPane().setBackground(Color.gray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        frame.setVisible(true);
    }
 
    private void layoutComponents(int x, int y, int width, int height, 
                                  JComponent addThis, JFrame addTo) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addTo.add(addThis, gbc);
    }
 
    public static void main(String args[]) {
 
        main main = new main();
    }
}

