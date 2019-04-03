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
public class PengirimanSuratController extends MouseAdapter implements ActionListener {
    private Model.Application app;
    private GUI.PengirimanSurat srt;
    private Model.PengirimanSurat surat;
    private Model.Surat sur;
    private Model.Customer pengirim;

    public PengirimanSuratController(Model.Application app) {
        this.app = app;
        srt = new GUI.PengirimanSurat();
        srt.setVisible(true);
        srt.addActionListener(this);
        srt.addMouseAdapter(this);
        app.loadAllCust();
        srt.setListPengirim(app.getListPengirimPenerima());
        srt.setListPenerima(app.getListPengirimPenerima());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(srt.getOk())){
            String namaK = srt.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = srt.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            String jenisDokumen = srt.getJenisSurat();
            String deskripsi = srt.getDeskripsi();
            String kategori = srt.getKategori();
            sur = new Model.Surat(srt.getDeskripsi(), srt.getJenisSurat());
            sur.setNilaiBarang();
            double harga = srt.getHarga();
            surat = new Model.PengirimanSurat(pengirim, penerima, sur, kategori);
            app.addPengirimanSurat(surat);
            srt.resetView();
        }
        
        if(src.equals(srt.getCek())){
            String namaK = srt.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = srt.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            String jenisSurat = srt.getJenisSurat();
            String deskripsi = srt.getDeskripsi();
            String kategori = srt.getKategori();
            sur = new Model.Surat(srt.getDeskripsi(), srt.getJenisSurat());
            sur.setNilaiBarang();
            surat = new Model.PengirimanSurat(pengirim, penerima, sur, kategori);
            if (srt.getKategori().isEmpty()){
                srt.setHarga(0);
            } else {
                srt.setHarga(surat.setBiaya());    
            }
            double harga = srt.getHarga();
        }
        
        if(src.equals(srt.getReset())){
            srt.resetView();
        }
        
        if (src.equals(srt.getMenuLayanan())){
            srt.setVisible(false);
            MenuLayananController layanan = new MenuLayananController(app);
        }
        
        if (src.equals(srt.getMenuAwal())){
            srt.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(srt.getListPengirim())){
            String i=srt.getSelectedPengirim();
            srt.setAlamatPengirim(app.getAlamat(i));
        }
        
        if(src.equals(srt.getListPenerima())){
            String i=srt.getSelectedPenerima();
            srt.setAlamatPenerima(app.getAlamat(i));
        }
    }

}
