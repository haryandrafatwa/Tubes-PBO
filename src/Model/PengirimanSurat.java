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
public class PengirimanSurat extends Layanan{
    private Surat surat;
    private String kategori;
    
    public PengirimanSurat(Customer pengirim, Customer penerima,Surat surat,String kategori) {
        super(pengirim, penerima);
        this.surat = surat;
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
    
    public String getJenisSurat(){
        return this.surat.getJenisSurat();
    }
    
    public String getDeskripsi(){
        return this.surat.getDeskripsi();
    }
    
    

    @Override
    public double setBiaya() {       
        if (surat.getJenisSurat().equals("Kartu Pos")){
            return 2500;
        }
        else {
            return 4000;
        }
    }
    
}