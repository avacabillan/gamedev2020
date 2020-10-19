package pink;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;

public class Pink {

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in); 
    
    Student student = new Student("phoebe", "1111");
    Faculty faculty = new Faculty ("merose", "2222");
    Staff staff = new Staff ("gen", "3333");
    Admin admin = new Admin ("ryan", "4444");
    show Show=new show();
    
    String username =JOptionPane.showInputDialog("Enter username: ");
    String password = JOptionPane.showInputDialog("Enter Password: ");
    
    if(username.equals(student.username) & password.equals(student.password)){
                        String n=student.Identify();
                        Show.frame(student.name);
                        }
                        
                        
    else if(username.equals(faculty.username) & password.equals(faculty.password)){
                        String n=faculty.Identify();
                        Show.frame(faculty.name);
                        }
                        
    else if(username.equals(staff.username) & password.equals(staff.password)){
                        String n=staff.Identify();
                        Show.frame(staff.name);
                         }
    
    else if(username.equals(admin.username) & password.equals(admin.password)){
                        String n=admin.Identify();
                        Show.frame(admin.name);
                        }
                        
    else{
                            JOptionPane.showMessageDialog(null, "Sorry, you are not yet registered!");
                        }	
    }}

    
