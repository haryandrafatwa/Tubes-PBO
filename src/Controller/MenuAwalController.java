/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MenuCustomerController;
import Controller.MenuLayananController;
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
public class MenuAwalController extends MouseAdapter implements ActionListener{
    private GUI.MenuAwal menu;
    private Model.Application app;
    
    
    public MenuAwalController(Model.Application app) {
        this.app = app;
        menu = new GUI.MenuAwal();
        menu.setVisible(true);
        menu.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(menu.getCustomer())){
            menu.setVisible(false);
            MenuCustomerController customer = new MenuCustomerController(app);
        }
        
        if (src.equals(menu.getLayanan())){
            menu.setVisible(false);
            MenuLayananController layanan = new MenuLayananController(app);
        }
        
        if(src.equals(menu.getRiwayat())){
            menu.setVisible(false);
            MenuRiwayatController riwayat = new MenuRiwayatController(app);
        }
        
        if (src.equals(menu.getProfile())){
            menu.setVisible(false);
            try {
                ProfileUser prof = new ProfileUser(app);
            } catch (IOException ex) {
                Logger.getLogger(MenuAwalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(src.equals(menu.getAboutUs())){
            try{
                menu.setVisible(false);
                AboutUsController abt = new  AboutUsController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
        
        if(src.equals(menu.getLogout())){
            int pilih = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?","Logout User",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(null, "Thanks for using our program :)");
                        menu.setVisible(false);
                        app.logout();
                        LoginController login = new LoginController(app);
                    break;
                }
        }
    }
    
}
