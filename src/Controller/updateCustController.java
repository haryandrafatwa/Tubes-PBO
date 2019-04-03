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
public class updateCustController extends MouseAdapter implements ActionListener{
    private GUI.UpdateCust update;
    private Model.Application app;
    private Model.Customer cust;
    private GUI.RiwayatCustomer riwayat;

    public updateCustController(Model.Application app) {
        this.app = app;
        update = new GUI.UpdateCust();
        update.setVisible(true);
        update.addActionListener(this);
        app.loadAllCust();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(update.getBtnUpdate())){
            try{
                String nama = update.getNama();
                String noKtp = update.getNoKtp();
                String noTelp = update.getNoTelp();
                String provinsi = update.getProvinsi();
                String kota = update.getKota();
                String kecamatan = update.getKecamatan();
                String kelurahan = update.getKelurahan();
                String kodePos = update.getKodePos();
                String alamat = String.valueOf(update.getAlamat());
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
                    app.updateCust(cust);
                }
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "1"+ex.getMessage());
            }
        }
        
        if (source.equals(update.getBtnReset())){
            update.resetView();
        }
        
        if (source.equals(update.getMenuAwal())){
            update.dispose();
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (source.equals(update.getMenuCustomer())){
            update.dispose();
            MenuCustomerController mCust = new MenuCustomerController(app);
        }
    }
    
    
}