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
 * @author FATIHAH RAHMADAYANA
 */
public class PengirimanUangController extends MouseAdapter implements ActionListener {
    private Model.Application app;
    private GUI.PengirimanUang ug;
    private Model.PengirimanUang uang;
    private Model.Uang ua;
    private Model.Customer pengirim;

    public PengirimanUangController(Model.Application app) {
        this.app = app;
        ug = new GUI.PengirimanUang();
        ug.setVisible(true);
        ug.addActionListener(this);
        ug.addMouseAdapter(this);
        app.loadAllCust();
        ug.setListPengirim(app.getListPengirimPenerima());
        ug.setListPenerima(app.getListPengirimPenerima());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(ug.getOk())){
            String namaK = ug.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = ug.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            int jumlah = ug.getJumlahUang();
            String deskripsi = ug.getDeskripsi();
            String kategori = ug.getKategori();
            ua = new Model.Uang(ug.getJumlahUang(),ug.getDeskripsi());
            ua.setNilaiBarang();
            double harga = ug.getHarga();
            uang = new Model.PengirimanUang(pengirim, penerima, ua, kategori);
            app.addPengirimanUang(uang);
            ug.resetView();
        }
        
        if(src.equals(ug.getCek())){
            String namaK = ug.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = ug.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            int jumlahUang = ug.getJumlahUang();
            String deskripsi = ug.getDeskripsi();
            String kategori = ug.getKategori();
            ua = new Model.Uang(ug.getJumlahUang(),ug.getDeskripsi());
            ua.setNilaiBarang();
            uang = new Model.PengirimanUang(pengirim, penerima, ua, kategori);
            if (ug.getKategori().isEmpty()){
                ug.setHarga(0);
            } else {
                ug.setHarga(uang.setBiaya());    
            }
            double harga = ug.getHarga();
        }
        
        if(src.equals(ug.getReset())){
            ug.resetView();
        }
        
        if (src.equals(ug.getMenuLayanan())){
            ug.setVisible(false);
            MenuLayananController layanan = new MenuLayananController(app);
        }
        
        if (src.equals(ug.getMenuAwal())){
            ug.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(ug.getListPengirim())){
            String i=ug.getSelectedPengirim();
            ug.setAlamatPengirim(app.getAlamat(i));
        }
        
        if(src.equals(ug.getListPenerima())){
            String i=ug.getSelectedPenerima();
            ug.setAlamatPenerima(app.getAlamat(i));
        }
    }
}
