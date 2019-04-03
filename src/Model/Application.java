package Model;

import Controller.LoginController;
import Controller.MenuAwalController;
import Controller.VerifyUpdateCustController;
import Controller.VerifyUpdateUserController;
import Controller.updateCustController;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
public class Application {
    private ArrayList<User> userList;
    private ArrayList<Customer> custList;
    private ArrayList<PengirimanDokumen> pengirimanDocList;
    private ArrayList<PengirimanBarang> pengirimanBrgList;
    private ArrayList<PengirimanSurat> pengirimanSuratList;
    private ArrayList<PengirimanUang> pengirimanUangList;
    private Database.Database db;

    public Application() {
        userList = new ArrayList();
        custList = new ArrayList();
        pengirimanDocList = new ArrayList();
        pengirimanBrgList = new ArrayList();
        pengirimanSuratList = new ArrayList();
        pengirimanUangList = new ArrayList();
        db = new Database.Database();
        db.connect();
    }
    
    public void login(Model.User u){
        if (db.Login(u)){
            Controller.MenuAwalController menu = new MenuAwalController(this);
        } else {
            Controller.LoginController login = new LoginController(this);
        }
    }
    
    public Model.User getUser(Model.User u){
        return db.getUser(u);
    }
    
    public void logout(){
        db.disconnect();
    }
    
    public void addUser(User u){
        if(db.verifyUser(u)){
            if( db.saveUser(u)){
                GUI.DaftarUser daftar = new GUI.DaftarUser();
                daftar.resetView();
            }
            userList.add(u);    
        }
        
    }
    
    public void updateUser(User u){
        //System.out.println(u.getUsername());
        //if (db.verifyUpdate(u)){
            if (userList.contains(u)){
                userList.remove(u);
            }
            userList.add(u);
            db.updateUser(u);
            JOptionPane.showMessageDialog(null, "Success!");
        //}
    }
    
    public void resetPasword(User u){
        boolean verify = db.verifyReset(u);
        System.out.println(verify);
        if (db.verifyReset(u)){
            if (userList.contains(u)){
                userList.remove(u);
            }
            userList.add(u);
            db.resetPassword(u);
            JOptionPane.showMessageDialog(null, "Success!");
        } else {
            JOptionPane.showMessageDialog(null, "Your Data are Wrong!");
        }
    }
    
    public void addCust(Customer c){
        db.saveCustomer(c);
        custList.add(c);
    }
    
    public void gantiPassword(User u){
        db.gantiPassword(u);
    }
    
    public void removeUser(User u){
        userList.remove(u);
    }
    
    public void removeCust(String ktp){
        Customer c = db.loadKtp(ktp);
        custList.remove(c);
        db.removeCust(c);
    }
    
    public void updateCust(Customer c){
            if (custList.contains(c)){
                custList.remove(c);
            }
            custList.add(c);
            db.updateCust(c);
            JOptionPane.showMessageDialog(null, "Success!");
    }
    
    public void verifyUpdate(Customer c){
        if (db.verifyUpdate(c)){
            Controller.updateCustController update = new Controller.updateCustController(this);
        } else {
            Controller.VerifyUpdateCustController verifyUpdate = new VerifyUpdateCustController(this);
        }
    }
    
    public void verifyUserUpdate(User u){
        if (db.verifyGanti(u)){
            Controller.GantiPasswordController ganti = new Controller.GantiPasswordController(this);
        } else {
            Controller.VerifyUpdateUserController verifyUpdate = new VerifyUpdateUserController(this);
        }
    }
    
    public String getAKtp(String noKtp){
        Customer c = db.loadKtp(noKtp);
        return c.toString();
    }
    
    public Customer loadCust(String nama){
        Customer c = db.loadCust(nama);
        return c;
    }
    
    public User loadUser(String email){
        User u = db.loadUsertByEmail(email);
        return u;
    }
    
    public void loadAllCust(){
        custList = db.loadAllCust();
    } 
    
    public String[] getListCustKtp(){
        String[] ktpList = new String[custList.size()];
        for (int i = 0; i < ktpList.length; i++) {
            ktpList[i] = custList.get(i).getNo_ktp();
        }
        return ktpList;
    }
    
    public String getListCust(){
        String sCustList = "";
        for (int i = 0; i < custList.size(); i++) {
            sCustList = sCustList+custList.get(i).toString()+"\n\n";
            System.out.println(i);
        }
        return sCustList;
    }
    
    public String[] getListPengirimPenerima(){
        String[] pengirimList = new String[custList.size()];
        for (int i = 0; i < pengirimList.length; i++) {
            pengirimList[i] = custList.get(i).getNama();
        }
        return pengirimList;
    }
    
    public String getAlamat(String aPengirim){
        Customer c = db.loadCust(aPengirim);
        return c.alamat();
    }
    
    public Customer getACust(String s){
        return db.loadCust(s);
    }
    
    public void addPengirimanDoc(PengirimanDokumen p){
        pengirimanDocList.add(p);
        db.savePengiriman(p);
    }
    
    public void addPengirimanBrg(PengirimanBarang p){
        pengirimanBrgList.add(p);
        db.savePengiriman(p);
    }
    
    public void addPengirimanSurat(PengirimanSurat p){
        pengirimanSuratList.add(p);
        db.savePengiriman(p);
    }
    
    public void addPengirimanUang(PengirimanUang p){
        pengirimanUangList.add(p);
        db.savePengiriman(p);
    }
    
}
