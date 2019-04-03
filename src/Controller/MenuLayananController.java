/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 *
 * @author User
 */
public class MenuLayananController extends MouseAdapter implements ActionListener{
    private GUI.MenuLayanan layanan;
    private Model.Application app;
    
    
    public MenuLayananController(Model.Application app){
        this.app = app;
        layanan = new GUI.MenuLayanan();
        layanan.setVisible(true);
        layanan.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(layanan.getDokumen())){
            layanan.setVisible(false);
            PengirimanDokumenController dkmn = new PengirimanDokumenController(app);
        }
        
        if(src.equals(layanan.getBarang())){
            layanan.setVisible(false);
            PengirimanBarangController brg = new PengirimanBarangController(app);
        }
        
        if(src.equals(layanan.getSurat())){
            layanan.setVisible(false);
            PengirimanSuratController surat = new PengirimanSuratController(app);
        }
        
        if(src.equals(layanan.getUang())){
            layanan.setVisible(false);
            PengirimanUangController uang = new PengirimanUangController(app);
        }
        
        if(src.equals(layanan.getMenuAwal())){
            layanan.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
}