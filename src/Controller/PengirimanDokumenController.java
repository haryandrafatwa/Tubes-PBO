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
public class PengirimanDokumenController extends MouseAdapter implements ActionListener {
    private Model.Application app;
    private GUI.PengirimanDokumen doc;
    private Model.PengirimanDokumen dokumen;
    private Model.Dokumen dok;
    private Model.Customer pengirim;

    public PengirimanDokumenController(Model.Application app) {
        this.app = app;
        doc = new GUI.PengirimanDokumen();
        doc.setVisible(true);
        doc.addActionListener(this);
        doc.addMouseAdapter(this);
        app.loadAllCust();
        doc.setListPengirim(app.getListPengirimPenerima());
        doc.setListPenerima(app.getListPengirimPenerima());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(doc.getOk())){
            String namaK = doc.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = doc.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            String jenisDokumen = doc.getJenisDokumen();
            String deskripsi = doc.getDeskripsi();
            String kategori = doc.getKategori();
            dok = new Model.Dokumen(deskripsi, jenisDokumen);
            dok.setNilaiBarang();
            double harga = doc.getHarga();
            dokumen = new Model.PengirimanDokumen(pengirim, penerima, dok, kategori);
            app.addPengirimanDoc(dokumen);
            doc.resetView();
        }
        
        if(src.equals(doc.getCek())){
            String namaK = doc.getSelectedPengirim();
            Model.Customer pengirim = app.getACust(namaK);
            String namaP = doc.getSelectedPenerima();
            Model.Customer penerima = app.getACust(namaP);
            String jenisDokumen = doc.getJenisDokumen();
            String deskripsi = doc.getDeskripsi();
            String kategori = doc.getKategori();
            dok = new Model.Dokumen(doc.getDeskripsi(), doc.getJenisDokumen());
            dok.setNilaiBarang();
            dokumen = new Model.PengirimanDokumen(pengirim, penerima, dok, kategori);
            if (doc.getKategori().isEmpty()){
                doc.setHarga(0);
            } else {
                doc.setHarga(dokumen.setBiaya());    
            }
            double harga = doc.getHarga();
        }
        
        if(src.equals(doc.getReset())){
            doc.resetView();
        }
        
        if (src.equals(doc.getMenuLayanan())){
            doc.setVisible(false);
            MenuLayananController layanan = new MenuLayananController(app);
        }
        
        if (src.equals(doc.getMenuAwal())){
            doc.setVisible(false);
            MenuAwalController mAwal = new MenuAwalController(app);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object src = me.getSource();
        if(src.equals(doc.getListPengirim())){
            String i=doc.getSelectedPengirim();
            doc.setAlamatPengirim(app.getAlamat(i));
        }
        
        if(src.equals(doc.getListPenerima())){
            String i=doc.getSelectedPenerima();
            doc.setAlamatPenerima(app.getAlamat(i));
        }
    }
}
