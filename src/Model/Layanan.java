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
public abstract class Layanan {
    private Customer pengirim;
    private Customer penerima; 

    public Layanan(Customer pengirim, Customer penerima) {
        this.pengirim = pengirim;
        this.penerima = penerima;
    }

    public Customer getPengirim() {
        return pengirim;
    }

    public void setPengirim(Customer pengirim) {
        this.pengirim = pengirim;
    }

    public Customer getPenerima() {
        return penerima;
    }

    public void setPenerima(Customer penerima) {
        this.penerima = penerima;
    }
 
    public abstract double setBiaya();
}
