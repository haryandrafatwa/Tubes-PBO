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
public class Dokumen {
    private int nilaiBarang; //Harga barang, misal kirim SIM, SIM harganya 250.000 makanya nilai barangnya 250.000
    private String jenisDokumen;
    private String deskripsi;

    public Dokumen(String Deskripsi, String jenisDokumen) {
        this.deskripsi = Deskripsi;
        this.jenisDokumen = jenisDokumen;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    
    public int getNilaiBarang() {
        return nilaiBarang;
    }

    public void setNilaiBarang() {
        if(this.deskripsi.equals("SIM")){
            this.nilaiBarang = 250000;
        } else if (this.deskripsi.equals("STNK")){
            this.nilaiBarang = 300000;
        } else if(this.deskripsi.equals("BPKB")){
            this.nilaiBarang = 350000;
        } else if (this.deskripsi.equals("Sertifikat Tanah")){
            this.nilaiBarang = 1000000;
        } else if (this.deskripsi.equals("Sertifikat Rumah")){
            this.nilaiBarang = 1500000;
        } else {
            this.nilaiBarang = 50000;
        }
    }

    public String getJenisDokumen() {
        return jenisDokumen;
    }

    public void setJenisDokumen(String jenisDokumen) {
        this.jenisDokumen = jenisDokumen;
    }    
}
