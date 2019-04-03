/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class AboutUsController extends MouseAdapter implements ActionListener{
    private GUI.AboutUs about;
    private Model.Application app;
    private Model.User user;

    public AboutUsController(Model.Application app) {
        this.app = app;
        about = new GUI.AboutUs();
        about.setVisible(true);
        about.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source.equals(about.getMenuAwal())){
            try{
                about.setVisible(false);
                MenuAwalController mA = new MenuAwalController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    
}
