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
public class User {
    private int id;
    private String nama;
    private String email;
    private String no_hp;
    private String username;
    private String password;
    private String bio;
    private String jKelamin;
    private byte[] foto;

    public User(String nama, String username, String password, String no_hp, String email, String bio, String jKelamin,  byte[] foto) {
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.jKelamin = jKelamin;
        this.foto = foto;
    }
    
    public User(String nama, String username, String email, String no_hp, String bio, String jKelamin) {
        this.nama = nama;
        this.no_hp = no_hp;
        this.email = email;
        this.username = username;
        this.bio = bio;
        this.jKelamin = jKelamin;
        this.foto = foto;
    }
    
    public User(String nama, String username, String password, String no_hp, String email) {
        this.id += 1;
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String no_hp, String email) {
        this.username = username;
        this.email = email;
        this.no_hp = no_hp;
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
    
    public void setBio(String s){
        this.bio = s;
    }
    
    public void setJKelamin(String s){
        this.jKelamin = s;
    }
    
    public void setFoto(byte[] s){
        this.foto = s;
    }
    
    public String getBio(){
        return this.bio;
    }
    
    public String getJKelamin(){
        return this.jKelamin;
    }
    
    public byte[] getFoto(){
        return this.foto;
    }
}
