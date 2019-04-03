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
public class PengirimanUang extends Layanan{
    private Uang uang;
    private String kategori;

    public PengirimanUang(Customer pengirim, Customer penerima, Uang uang,String kategori) {
        super(pengirim, penerima);
        this.uang = uang;
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
    
    public Uang getUang() {
        return uang;
    }

    public void setUang(Uang uang) {
        this.uang = uang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public int getJumlahUang(){
        return this.uang.getJumlahUang();
    }
    
    public String getDeskripsi(){
        return this.uang.getDeskripsi();
    }
    
    @Override
    public double setBiaya() {
        double biaya;
        if (getKategori().equals("REGULER")){
            biaya = ((0.24*uang.getNilaiBarang())+5000);
        } else {
            biaya = ((1.5*0.24*uang.getNilaiBarang())+5000);
        }
        return biaya;
    }
    
    
}
