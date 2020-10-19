
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;

public class Main {
    public static void main(String[] args) {
			Scanner in = new Scanner(System.in); 
                        Justine justine=new Justine("justine","111000",38);
                        Varron varron=new Varron("marc","222000",37);
                        Larangan larangan=new Larangan("christian","333000",36);
                        Michael michael=new Michael("michael","444000",35);
                        Show show=new Show();
                        String user =JOptionPane.showInputDialog("Enter user: ");
                        String id = JOptionPane.showInputDialog("Enter ID: ");
                   
                        if(user.equals(justine.user) & id.equals(justine.pass)){
                         if(justine.workhour<=40){
                            String n=justine.Identify();
                          show.frame(justine.name);
                         }
                         else{
                             JOptionPane.showMessageDialog(null, "Workhours is not belivable");
                         }  
                        }
                        
                        else if(user.equals(varron.user) & id.equals(varron.pass)){
                        if(varron.workhour<=40){
                            String n=varron.Identify();
                          show.frame(varron.name);
                         }
                         else{
                             JOptionPane.showMessageDialog(null, "Workhours is not belivable");
                         }  
                        }
                        
                        else if(user.equals(larangan.user) & id.equals(larangan.pass)){
                         if(larangan.workhour<=40){
                            String n=larangan.Identify();
                          show.frame(larangan.name);
                         }
                         else{
                             JOptionPane.showMessageDialog(null, "Workhours is not belivable");
                         }  
                        }
                        
                        else if(user.equals(michael.user) & id.equals(michael.pass)){
                          if(michael.workhour<=40){
                            String n=michael.Identify();
                          show.frame(michael.name);
                         }
                         else{
                             JOptionPane.showMessageDialog(null, "Workhours is not belivable");
                         }  
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(null, "Not found");
                        }
				
		}

}
