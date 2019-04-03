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
public class RiwayatDokumenController extends MouseAdapter implements ActionListener{
    private GUI.RiwayatDokumen rwtDokumen;
    private Model.Application app;
    private Model.Dokumen dokumen;
    
    
    public RiwayatDokumenController(Model.Application app){
        this.app = app;
        rwtDokumen = new GUI.RiwayatDokumen();
        rwtDokumen.setVisible(true);
        rwtDokumen.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(rwtDokumen.getMenuAwal())){
            rwtDokumen.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(rwtDokumen.getMenuRiwayat())){
            rwtDokumen.setVisible(false);
            MenuRiwayatController mCust = new MenuRiwayatController(app);
        }
    }
}
