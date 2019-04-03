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


/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class PengirimanBarangController extends MouseAdapter implements ActionListener {
    private Model.Application app;
    private GUI.PengirimanBarang pb;
    private Model.PengirimanBarang barang;
    private Model.Barang brg;
    private Model.Customer pengirim;

    public PengirimanBarangController(Model.Application app) {
        this.app = app;
        pb = new GUI.PengirimanBarang();
        pb.setVisible(true);
        pb.addActionListener(this);
        pb.addMouseAdapter(this);
        app.loadAllCust();
        pb.setListPengirim(app.getListPengirimPenerima());
        pb.setListPenerima(app.getListPengirimPenerima());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(pb.getOk())){
            String namaK = pb.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = pb.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            double berat = pb.getBerat();
            String deskripsi = pb.getDeskripsi();
            String kategori = pb.getKategori();
            brg = new Model.Barang(pb.getBerat(),pb.getDeskripsi());
            brg.setNilaiBarang();
            double harga = pb.getHarga();
            barang = new Model.PengirimanBarang(pengirim, penerima,brg,kategori);
            app.addPengirimanBrg(barang);
            pb.resetView();
        }
        
        if(src.equals(pb.getCek())){
            String namaK = pb.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = pb.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            double berat = pb.getBerat();
            String deskripsi = pb.getDeskripsi();
            String kategori = pb.getKategori();
            brg = new Model.Barang(pb.getBerat(),pb.getDeskripsi());
            brg.setNilaiBarang();
            barang = new Model.PengirimanBarang(pengirim, penerima,brg,kategori);
            if (pb.getKategori().isEmpty()){
                pb.setHarga(0);
            } else {
                pb.setHarga(barang.setBiaya());    
            }
            double harga = pb.getHarga();
        }
        
        if(src.equals(pb.getReset())){
            pb.resetView();
        }
        
        if (src.equals(pb.getMenuLayanan())){
            pb.setVisible(false);
            MenuLayananController layanan = new MenuLayananController(app);
        }
        
        if (src.equals(pb.getMenuAwal())){
            pb.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(pb.getListPengirim())){
            String i=pb.getSelectedPengirim();
            pb.setAlamatPengirim(app.getAlamat(i));
        }
        
        if(src.equals(pb.getListPenerima())){
            String i=pb.getSelectedPenerima();
            pb.setAlamatPenerima(app.getAlamat(i));
        }
    }
    
}
