package Model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class PengirimanDokumen extends Layanan {
    private Dokumen dokumen;
    private String kategori;

    public PengirimanDokumen(Customer pengirim, Customer penerima, Dokumen dokumen,String kategori) {
        super(pengirim, penerima);
        this.dokumen = dokumen;
        this.kategori = kategori;
    }
    
    public String getNamaPengirim(){
        return getPengirim().getNama();
    }
    
    public String getAlPengirim(){
        return getPengirim().alamat();
    }
    
    public String getNamaPenerima(){
        return getPenerima().getNama();
    }
    
    public String getAlPenerima(){
        return getPenerima().alamat();
    }
    
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public String getJenisDokumen(){
        return this.dokumen.getJenisDokumen();
    }
    
    public String getDeskripsi(){
        return this.dokumen.getDeskripsi();
    }
    
    @Override
    public double setBiaya() {
        double biaya;
        if (getKategori().equals("REGULER")){
            biaya = ((0.24*dokumen.getNilaiBarang())+5000);
        } else {
            biaya = ((1.5*0.24*dokumen.getNilaiBarang())+5000);
        }
        return biaya;
    }
}
