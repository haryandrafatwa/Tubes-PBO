/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GantiPasswordController extends MouseAdapter implements ActionListener{
    private GUI.GantiPassword ganti;
    private Model.Application app;
    private Model.User user;

    public GantiPasswordController(Model.Application app) {
        this.app = app;
        ganti = new GUI.GantiPassword();
        ganti.setVisible(true);
        ganti.addActionListener(this);
        app.loadAllCust();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(ganti.getBtnUpdate())){
            try{
                String password = String.valueOf(ganti.getPassword());
                String ReTypePassword = String.valueOf(ganti.getReTypePassword());
                user = new Model.User(Model.GantiPassword.username,password);
                app.gantiPassword(user);
                ganti.setVisible(false);
                ProfileUser profile = new ProfileUser(app);
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "1"+ex.getMessage());
            }
        }
        
        if (source.equals(ganti.getMenuAwal())){
            ganti.dispose();
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (ganti.equals(ganti.getProfile())){
            ganti.dispose();
            try {
                ProfileUser profile = new ProfileUser(app);
            } catch (IOException ex) {
                Logger.getLogger(GantiPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}