/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class Uang {
    private int jumlahUang;
    private String deskripsi;
    private int nilaiBarang;

    public int getNilaiBarang() {
        return nilaiBarang;
    }

    public void setNilaiBarang() {
        if (this.deskripsi.equals("Dollar")){
            this.nilaiBarang = (int) (jumlahUang*15000*0.1);
        }
        else if (this.deskripsi.equals("Real")){
            this.nilaiBarang = (int)(jumlahUang*3500*0.1);              
        }
        else if (this.deskripsi.equals("Won")) {
            this.nilaiBarang = (int)(jumlahUang*13*0.1);
        }
        else if (this.deskripsi.equals("Rupiah")){
             this.nilaiBarang = (int)(jumlahUang*0.05);
        }
        else {
            this.nilaiBarang = (int)(jumlahUang*0);
        }
    }

    public Uang(int jumlahUang, String Deskripsi) {
        this.jumlahUang = jumlahUang;
        this.deskripsi = Deskripsi;
    }

    public int getJumlahUang() {
        return jumlahUang;
    }

    public void setJumlahUang() {
        this.jumlahUang = jumlahUang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.deskripsi = Deskripsi;
    }
}
