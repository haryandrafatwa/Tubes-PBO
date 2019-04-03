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
public class RiwayatBarangController extends MouseAdapter implements ActionListener{
    private GUI.RiwayatBarang rwtBarang;
    private Model.Application app;
    private Model.Barang barang;
    
    
    public RiwayatBarangController(Model.Application app){
        this.app = app;
        rwtBarang = new GUI.RiwayatBarang();
        rwtBarang.setVisible(true);
        rwtBarang.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(rwtBarang.getMenuAwal())){
            rwtBarang.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(rwtBarang.getMenuRiwayat())){
            rwtBarang.setVisible(false);
            MenuRiwayatController mCust = new MenuRiwayatController(app);
        }
    }
}
