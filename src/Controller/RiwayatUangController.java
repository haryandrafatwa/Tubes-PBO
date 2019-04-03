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
public class RiwayatUangController extends MouseAdapter implements ActionListener{
    private GUI.RiwayatUang rwtUang;
    private Model.Application app;
    private Model.Uang uang;    
    
    public RiwayatUangController(Model.Application app){
        this.app = app;
        rwtUang = new GUI.RiwayatUang();
        rwtUang.setVisible(true);
        rwtUang.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src.equals(rwtUang.getMenuAwal())){
            rwtUang.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
        
        if (src.equals(rwtUang.getMenuRiwayat())){
            rwtUang.setVisible(false);
            MenuRiwayatController mCust = new MenuRiwayatController(app);
        }
    }
}
