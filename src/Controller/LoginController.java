/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class LoginController extends MouseAdapter implements ActionListener{
    private Model.Application app;
    private GUI.LoginUser login;
    
    public LoginController(Model.Application app){
        
        this.app = app;
        login = new GUI.LoginUser();
        login.setVisible(true);
        login.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(login.getBtnLogin())){
            try{
                String username = login.getUsername();
                String password = login.getPassword();
                Model.User u = new Model.User(login.getUsername(), login.getPassword());
                if(login.getVerify() == false){
                    JOptionPane.showMessageDialog(null, "Checklist the Verify Box!");
                } else {
                    app.login(u);
                    login.setVisible(false);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if(src.equals(login.getBtnReset())){
            try{
                login.setVisible(false);
                ResetController reset = new ResetController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
        if (src.equals(login.getBtnDaftar())){
            login.setVisible(false);
            DaftarController dft = new DaftarController(app);
        }
        
        if (src.equals(login.getDaftar())){
            try{
                login.setVisible(false);
                DaftarController dft = new DaftarController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
            
        }
        
        if(src.equals(login.getExit())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Are you sure want to exit program?","Exit Program",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(null, "Thanks for using our program :)");
                        System.exit(0);
                    break;
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
}
