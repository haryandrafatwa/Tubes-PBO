/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DaftarCustomerController extends MouseAdapter implements ActionListener{
    private GUI.DaftarCustomer customer;
    private Model.Application app;
    private Model.Customer cust;
    
    
    public DaftarCustomerController(Model.Application app){
        this.app = app;
        customer = new GUI.DaftarCustomer();
        customer.setVisible(true);
        customer.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(customer.getBtnBuat())){
            try{
                String nama = customer.getNama();
                String noKtp = customer.getNoKtp();
                String noTelp = customer.getNoTelp();
                String provinsi = customer.getProvinsi();
                String kota = customer.getKota();
                String kecamatan = customer.getKecamatan();
                String kelurahan = customer.getKelurahan();
                String kodePos = customer.getKodePos();
                String alamat = String.valueOf(customer.getAlamat());
                if (nama.isEmpty() && noTelp.isEmpty() && provinsi.isEmpty() &&
                        kota.isEmpty() && kecamatan.isEmpty() && kelurahan.isEmpty() &&
                        kodePos.isEmpty() && alamat.isEmpty()&& noKtp.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill the identity!");
                } else if (nama.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is empty! Please fill your Name");
                } else if (noTelp.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nomor Telepon is empty! Please fill your Nomor Telepon");
                } else if ( provinsi.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Province is empty! Please fill your Province");
                } else if (kota.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Kota is empty! Please fill your Kota");
                } else if (kecamatan.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Kecamatan is empty! Please fill your Kecamatan");
                } else if (kelurahan.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Kelurahan is empty! Please fill your Kelurahan");
                } else if (kodePos.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Kode Pos is empty! Please fill your Kode Pos");
                } else if (alamat.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Alamat is empty! Please fill your Alamat");
                } else if (noKtp.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No. KTP is empty! Please fill your No. KTP");
                } else {
                    cust = new Model.Customer(nama, noKtp, provinsi, kota, kecamatan, kelurahan, kodePos, alamat, noTelp);
                    app.addCust(cust);
                    customer.resetView();
                }
            } catch (Exception ex){
                Logger.getLogger(GUI.DaftarCustomer.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        if (src.equals(customer.getBtnReset())){
            customer.resetView();
        }
        
        if (src.equals(customer.getMenuAwal())){
            customer.dispose();
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(customer.getMenuCustomer())){
            customer.dispose();
            MenuCustomerController mCust = new MenuCustomerController(app);
        }
    }
}
