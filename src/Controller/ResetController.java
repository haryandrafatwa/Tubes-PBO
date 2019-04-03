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
public class ResetController extends MouseAdapter implements ActionListener{
    private GUI.ResetPassword reset;
    private Model.Application app;
    private Model.User user;

    public ResetController(Model.Application app) {
        this.app = app;
        reset = new GUI.ResetPassword();
        reset.setVisible(true);
        reset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(reset.getBtnReset())){
            try{
                String nama = reset.getNama();
                String username = reset.getUsername();
                String password = String.valueOf(reset.getPassword());
                String repassword = String.valueOf(reset.getReTypePassword());
                String email = reset.getEmail();
                String notelp = reset.getNoTelp();
                if (reset.getNama().isEmpty() && reset.getEmail().isEmpty() && reset.getNoTelp().isEmpty() && reset.getUsername().isEmpty() && reset.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Please fill your information completly!");
                } else
                if (reset.getNama().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is empty! Please fill your Name");
                } else
                if (reset.getEmail().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Email is empty! Please fill your Email");
                } else
                if (reset.getNoTelp().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nomor Telepon is empty! Please fill your Nomor Telepon");
                } else
                if (reset.getUsername().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Username is empty! Please fill your Username");
                } else
                if (reset.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Password is empty! Please fill your Password");
                } else 
                if (password.equals(repassword)){
                    if (reset.getPassword().length < 8 ){
                        JOptionPane.showMessageDialog(null, "Password Minimal 8 Karakter!");
                    } else {
                        user = new Model.User(nama, username, password , notelp, email);
                        app.resetPasword(user);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password Tidak Konsisten!");
                }
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "1"+ex.getMessage());
            }
        }
        
        if(source.equals(reset.getDaftar())){
            try{
                reset.setVisible(false);
                DaftarController dft = new DaftarController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
        
        if (source.equals(reset.getLogin())){
            try{
                reset.setVisible(false);
                LoginController login = new LoginController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
            
        }
        
        if(source.equals(reset.getExit())){
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