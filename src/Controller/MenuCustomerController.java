/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author User
 */
public class MenuCustomerController extends MouseAdapter implements ActionListener{
    private GUI.MenuCustomer customer;
    private Model.Application app;
    
    
    public MenuCustomerController(Model.Application app){
        this.app = app;
        customer = new GUI.MenuCustomer();
        customer.setVisible(true);
        customer.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(customer.getCustomer())){
            customer.setVisible(false);
            DaftarCustomerController daftar = new DaftarCustomerController(app);
        }
        
        if (src.equals(customer.getRiwayat())){
            customer.setVisible(false);
            RiwayatCustomerController riwayat = new RiwayatCustomerController(app);
        }
        
        if (src.equals(customer.getMenuAwal())){
            customer.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
}
