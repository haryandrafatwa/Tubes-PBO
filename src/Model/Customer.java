package Model;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class Customer {
    private int id;
    private String nama;
    private String no_ktp;
    private String provinsi;
    private String kota;
    private String kecamatan;
    private String kelurahan;
    private String kodePos;
    private String Alamat;
    private String no_telp;

    public Customer(String nama, String no_ktp, String provinsi, String kota, String kecamatan,
            String kelurahan, String kodePos, String Alamat, String no_telp) {
        this.id++;
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.provinsi = provinsi;
        this.kota = kota;
        this.kecamatan = kecamatan;
        this.kelurahan = kelurahan;
        this.kodePos = kodePos;
        this.Alamat = Alamat;
        this.no_telp = no_telp;
    }
    
    public Customer(String nama, String noKtp, String noHp){
        this.nama = nama;
        this.no_ktp = noKtp;
        this.no_telp = noHp;
    }
    
    public int getId(){
        return id;
    }
    
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKota() {
        return kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    @Override
    public String toString(){
        return "Nama: "+getNama()+"\nNo KTP: "+getNo_ktp()+ 
                "\nProvinsi: "+getProvinsi()+"\nKota: "+
                getKota()+"\nKecamatan: "+getKecamatan()+
                "\nKelurahan: "+getKelurahan()+"\nKode Pos: "+getKodePos()
                +"\nAlamat: "+getAlamat()+"\nNo Telp: "+getNo_telp();
    }
    
    public String alamat(){
        return "Provinsi: "+getProvinsi()+"\nKota: "+
                getKota()+"\nKecamatan: "+getKecamatan()+
                "\nKelurahan: "+getKelurahan()+"\nKode Pos: "+getKodePos()
                +"\nAlamat: "+getAlamat()+"\nNo Telp: "+getNo_telp();
    }
}
