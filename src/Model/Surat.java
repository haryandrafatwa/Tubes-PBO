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
public class Surat {
    private String jenisSurat; //Surat pribadi atau kartu pos
    private int nilaiBarang;
    private String deskripsi;

    public Surat(String deskripsi,String jenisSurat) {
        this.jenisSurat = jenisSurat;
        this.deskripsi = deskripsi;
    }

    public String getJenisSurat() {
        return jenisSurat;
    }

    public void setJenisSurat(String jenisSurat) {
        this.jenisSurat = jenisSurat;
    }

    public int getNilaiBarang() {
        return nilaiBarang;
    }

    public void setNilaiBarang() {
        if(this.jenisSurat.equals("PRIBADI")){
            this.nilaiBarang = 10000;
        } else {
            this.nilaiBarang = 20000;
        }
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    

    
}
