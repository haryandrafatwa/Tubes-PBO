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
public class VerifyUpdateUserController extends MouseAdapter implements ActionListener{
    private GUI.VerifyUpdateUser verify;
    private Model.Application app;
    private Model.User user;

    public VerifyUpdateUserController(Model.Application app) {
        this.app = app;
        verify = new GUI.VerifyUpdateUser();
        verify.setVisible(true);
        verify.addActionListener(this);
        app.loadAllCust();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(verify.getBtnVerify())){
            try{
                String username = verify.getUsername();
                String email = verify.getEmail();
                String noHp = verify.getNoTelp();
                user = new Model.User(username, noHp, email);
                app.verifyUserUpdate(user);
                Model.GantiPassword.username = username;
                verify.setVisible(false);
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "1"+ex.getMessage());
            }
        }
        
        if (source.equals(verify.getBtnReset())){
            verify.resetView();
        }
        
        if (source.equals(verify.getMenuAwal())){
            verify.dispose();
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (source.equals(verify.getProfile())){
            verify.dispose();
            try {
                ProfileUser profile = new ProfileUser(app);
            } catch (IOException ex) {
                Logger.getLogger(VerifyUpdateUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}