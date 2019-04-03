/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RiwayatCustomerController extends MouseAdapter implements ActionListener{
    private GUI.RiwayatCustomer customer;
    private Model.Application app;
    private Model.Customer cust;
    
    
    public RiwayatCustomerController(Model.Application app){
        this.app = app;
        customer = new GUI.RiwayatCustomer();
        customer.setVisible(true);
        customer.addActionListener(this);
        customer.addMouseAdapter(this);
        app.loadAllCust();
        customer.setListKtp(app.getListCustKtp());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(customer.getBtnDelete())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this customer?","Delete Customer",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        String i = customer.getSelectedKtp();
                        app.removeCust(i);
                        app.loadAllCust();
                        customer.setListKtp(app.getListCustKtp());
                    break;
                }
            } catch (Exception ex){
                System.out.println("Deletion Exception: "+ex);
            }
        }
        
        if (src.equals(customer.getBtnUpdate())){
            customer.setVisible(false);
            VerifyUpdateCustController upt = new VerifyUpdateCustController(app);
        }
        
        if (src.equals(customer.getMenuAwal())){
            customer.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(customer.getMenuCustomer())){
            customer.setVisible(false);
            MenuCustomerController mCust = new MenuCustomerController(app);
        }
    }
    
     @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(customer.getListKtp())){
            String i=customer.getSelectedKtp();
            customer.setDetail(app.getAKtp(i));
        }
    }
}
