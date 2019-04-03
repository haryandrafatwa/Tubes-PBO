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
public class DaftarController extends MouseAdapter implements ActionListener{
    private GUI.DaftarUser daftar;
    private Model.Application app;
    private Model.User user;

    public DaftarController(Model.Application app) {
        this.app = app;
        daftar = new GUI.DaftarUser();
        daftar.setVisible(true);
        daftar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(daftar.getBtnBuat())){
            try{
                String nama = daftar.getNama();
                String username = daftar.getUsername();
                String password = String.valueOf(daftar.getPassword());
                String repassword = String.valueOf(daftar.getReTypePassword());
                String email = daftar.getEmail();
                String notelp = daftar.getNoTelp();
                if (daftar.getNama().isEmpty() && daftar.getEmail().isEmpty() && daftar.getNoTelp().isEmpty() && daftar.getUsername().isEmpty() && daftar.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Please fill your information completly!");
                } else
                if (daftar.getNama().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is empty! Please fill your Name");
                } else
                if (daftar.getEmail().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Email is empty! Please fill your Email");
                } else
                if (daftar.getNoTelp().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nomor Telepon is empty! Please fill your Nomor Telepon");
                } else
                if (daftar.getUsername().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Username is empty! Please fill your Username");
                } else
                if (daftar.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Password is empty! Please fill your Password");
                }
                if (password.equals(repassword)){
                    if (daftar.getPassword().length < 8 ){
                        JOptionPane.showMessageDialog(null, "Password Minimal 8 Karakter!");
                    } else {
                        user = new Model.User(nama, username, password , notelp, email);
                        app.addUser(user);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password Tidak Konsisten!");
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
            
        }    
        
        if (source.equals(daftar.getBtnReset())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Are you sure want to reset field?","Reset Field",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        daftar.resetView();
                    break;
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
        
        if (source.equals(daftar.getLogin())){
            try{
                daftar.setVisible(false);
                LoginController login = new LoginController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
            
        }
        
        if(source.equals(daftar.getExit())){
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
