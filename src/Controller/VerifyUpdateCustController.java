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
public class VerifyUpdateCustController extends MouseAdapter implements ActionListener{
    private GUI.VerifyUpdate verify;
    private Model.Application app;
    private Model.Customer cust;

    public VerifyUpdateCustController(Model.Application app) {
        this.app = app;
        verify = new GUI.VerifyUpdate();
        verify.setVisible(true);
        verify.addActionListener(this);
        app.loadAllCust();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(verify.getBtnVerify())){
            try{
                String nama = verify.getNama();
                String noKtp = verify.getNoKtp();
                String noHp = verify.getNoTelp();
                cust = new Model.Customer(nama, noKtp, noHp);
                app.verifyUpdate(cust);
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
        
        if (source.equals(verify.getMenuCustomer())){
            verify.dispose();
            MenuCustomerController mCust = new MenuCustomerController(app);
        }
    }
    
    
}