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
public class MenuRiwayatController extends MouseAdapter implements ActionListener{
    private GUI.MenuRiwayat riwayat;
    private Model.Application app;
    
    
    public MenuRiwayatController(Model.Application app){
        this.app = app;
        riwayat = new GUI.MenuRiwayat();
        riwayat.setVisible(true);
        riwayat.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(riwayat.getDokumen())){
            riwayat.setVisible(false);
            RiwayatDokumenController doc = new RiwayatDokumenController(app);
        }
        
        if(src.equals(riwayat.getBarang())){
            riwayat.setVisible(false);
            RiwayatBarangController riwyt = new RiwayatBarangController(app);
        }
        
        if(src.equals(riwayat.getSurat())){
            riwayat.setVisible(false);
            RiwayatSuratController surat = new RiwayatSuratController(app);
        }
        
        if(src.equals(riwayat.getUang())){
            riwayat.setVisible(false);
            RiwayatUangController uang = new RiwayatUangController(app);
        }
        
        if(src.equals(riwayat.getMenuAwal())){
            riwayat.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
}