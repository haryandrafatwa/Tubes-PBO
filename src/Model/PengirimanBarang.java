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
public class PengirimanBarang extends Layanan{
    private Barang barang;
    private String kategori;

    public PengirimanBarang(Customer pengirim, Customer penerima,Barang barang,String kategori) {
        super(pengirim, penerima);
        this.barang = barang;
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
    
    public double getBerat(){
        return this.barang.getBerat();
    }
    
    public String getDeskripsi(){
        return this.barang.getDeskripsi();
    }
    
    @Override
    public double setBiaya() {
        double biaya;
        if (getKategori().equals("REGULER")){
            biaya = ((barang.getNilaiBarang())+5000);
        } else {
            biaya = ((barang.getNilaiBarang())+10000);
        }
        return biaya;
    }


}
