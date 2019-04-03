package Model;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class Barang {
    private double berat;
    private double nilaiBarang;
    private String deskripsi;

    public Barang(double berat) {
        this.berat = berat;
    }

    public Barang(double berat,String deskripsi) {
        this.berat = berat;
        this.deskripsi = deskripsi;
    }   

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public double getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public double getNilaiBarang() {
        return nilaiBarang;
    }

    public void setNilaiBarang() {
        this.nilaiBarang = this.berat * 5000;
    }
}
