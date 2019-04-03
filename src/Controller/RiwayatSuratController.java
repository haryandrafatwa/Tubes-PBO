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
public class RiwayatSuratController extends MouseAdapter implements ActionListener{
    private GUI.RiwayatSurat rwtSurat;
    private Model.Application app;
    private Model.Surat surat;
    
    
    public RiwayatSuratController(Model.Application app){
        this.app = app;
        rwtSurat = new GUI.RiwayatSurat();
        rwtSurat.setVisible(true);
        rwtSurat.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(rwtSurat.getMenuAwal())){
            rwtSurat.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(rwtSurat.getMenuRiwayat())){
            rwtSurat.setVisible(false);
            MenuRiwayatController mCust = new MenuRiwayatController(app);
        }
    }
}
