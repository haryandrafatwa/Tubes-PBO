/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Database {
    Connection con;
    Statement stm;
    PreparedStatement ps;
    ResultSet rs;
    private Model.Application app;
    
    public void connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/postoffice?zeroDateTimeBehavior=convertToNull";
            String username = "root";
            String pw = "";
            con = DriverManager.getConnection(url,username,pw);
            System.out.println("Connected!");
        } catch (SQLException ex){
            System.out.println("Connection Error!");
            ex.printStackTrace();
        }
    }
    
    public void disconnect(){
        try{
            con.close();
            connect();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public boolean Login(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from user where username= '"+u.getUsername()+"' AND Password= '"+u.getPassword()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Success!");
                Model.LoggedIn.email = rs.getString("Email");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is Wrong!");
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return false;
        }
    }
    
    public Model.User getUser(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from user where username= '"+u.getUsername()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                return u;
            } else {
                return null;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return null;
        }
    }
    
    public boolean verifyUser(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from user where nama= '"+u.getNama()+"' and username= '"+u.getUsername()+"' and email= '"+u.getEmail()+"' and no_telp= '"+u.getNo_hp()+"'";
            rs = stm.executeQuery(sql);
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Name, Username, Email, and Nomor Telepon Already Taken!");
                return false;
            } else if (stm.executeQuery("select * from user where nama= '"+u.getNama()+"';").next()){
                JOptionPane.showMessageDialog(null, "Nama Already Taken!");
                return false;
            } else if (stm.executeQuery("select * from user where username= '"+u.getUsername()+"';").next()){
                JOptionPane.showMessageDialog(null, "Username Already Taken!");
                return false;
            } else if (stm.executeQuery("select * from user where email= '"+u.getEmail()+"';").next()){
                JOptionPane.showMessageDialog(null, "Email Already Taken!");
                return false;
            } else if (stm.executeQuery("select * from user where no_telp= '"+u.getNo_hp()+"';").next()){
                JOptionPane.showMessageDialog(null, "No Telepon Already Taken!");
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0");
            return false;
        }
    }
    
    public boolean saveUser(Model.User u){
        try{
            if ( verifyUser(u) == true ){
                String query = "INSERT INTO `user`(`Nama`, `Username`, `Password`, `No_Telp`, `Email`, `jKelamin`,`bio`,`foto`) VALUES ("+"\""+u.getNama()+"\""+","+"\""+u.getUsername()+"\""+","+"\""+u.getPassword()+"\""+","+"\""+u.getNo_hp()+"\""+","+"\""+u.getEmail()+"\""+""
                        //+ ","+"\""+3+"\""+","+"\""+3+"\""+","+"\""+3+"\""+");";
                        + ",'','','');";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving User Success!");
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
            return false;
        }
    }
    
    public boolean verifyGanti(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from `user` where `Username`= '"+u.getUsername()+"' AND `Email`= '"+u.getEmail()+"' AND `No_Telp`= '"+u.getNo_hp()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Verify Success!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Your Data are Wrong!");
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return false;
        }
    }
    
    public boolean verifyReset(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from `user` where `Nama`='"+u.getNama()+"' and `Username`= '"+u.getUsername()+"' AND `Email`= '"+u.getEmail()+"' AND "
                    + "`No_Telp`= '"+u.getNo_hp()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return false;
        }
    }
    
    public boolean verifyUpdate(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "select * from `user` where `Username`= '"+u.getUsername()+"' AND `Email`= '"+u.getEmail()+"' AND `No_Telp`= '"+u.getNo_hp()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return false;
        }
    }
    
    public boolean verifyUpdate(Model.Customer c){
        try{
            stm = con.createStatement();
            String sql = "select * from `customer` where `Nama`= '"+c.getNama()+"' AND `NoKTP`= '"+c.getNo_ktp()+"' AND `NoTelp`= '"+c.getNo_telp()+"'";
            rs = stm.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Verify Success!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Your Data are Wrong!");
                return false;
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"00");
            return false;
        }
    }
    
    public void updatePasswordUser(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "update user set password="+"\""+u.getPassword()+"\""+" where username="+"\""+u.getUsername()+"\""+";";
            stm.executeUpdate(sql);
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void gantiPassword(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "update user set password="+"\""+u.getPassword()+"\""+" where username="+"\""+u.getUsername()+"\""+";";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Success!");
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void resetPassword(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "update user set password="+"\""+u.getPassword()+"\""+" where email="+"\""+u.getEmail()+"\""+";";
            stm.executeUpdate(sql);
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void updateUser(Model.User u){
        try{
            stm = con.createStatement();
            String sql = "update `user` set `Nama`="+"\""+u.getNama()+"\""+", `Username`="+"\""+u.getUsername()+"\""+",`No_Telp`="+"\""+u.getNo_hp()+"\""+", "
                    + "`jKelamin`="+"\""+u.getJKelamin()+"\""+", `bio`="+"\""+u.getBio()+"\""+"where `Email`="+"\""+u.getEmail()+"\""+";";
            stm.executeUpdate(sql);
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void saveCustomer(Model.Customer c){
        try{
                String query = "INSERT INTO `customer`(`Nama`, `NoKTP`, `Provinsi`, `Kota`, `Kecamatan`,`Kelurahan`,`KodePos`,`Alamat`,`NoTelp`)"
                        + "values('"+c.getNama()+"','"+c.getNo_ktp()+"','"+c.getProvinsi()+"','"+c.getKota()+"','"+c.getKecamatan()+"',"
                        + "'"+c.getKelurahan()+"','"+c.getKodePos()+"','"+c.getAlamat()+"','"+c.getNo_telp()+"')";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving Customer Success!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
        }
    }
    
    public void removeCust(Model.Customer c){
        try{
            String query = "delete from customer where noKtp='"+c.getNo_ktp()+"'";
            Statement s = con.createStatement();
            s.executeUpdate(query);
            System.out.println("Customer Deletion Succeed!");
        } catch (SQLException ex){
            System.out.println("Customer Deletion Error!");
            ex.printStackTrace();
        }
    }
    
    public void updateCust(Model.Customer c){
        try{
                stm = con.createStatement();
                String sql = "update customer set Nama="+"\""+c.getNama()+"\""+","
                        //+ "NoKTP="+"\""+c.getNo_ktp()+"\""+", "
                        + "Provinsi="+"\""+c.getProvinsi()+"\""+", "
                        + "Kota="+"\""+c.getKota()+"\""+", "
                        + "Kecamatan="+"\""+c.getKecamatan()+"\""+", "
                        + "Kelurahan="+"\""+c.getKelurahan()+"\""+", "
                        + "KodePos="+"\""+c.getKodePos()+"\""+", "
                        + "Alamat="+"\""+c.getAlamat()+"\""+", "
                        + "NoTelp="+"\""+c.getNo_telp()+"\""+""
                        + "where NoKTP="+"\""+c.getNo_ktp()+"\""+";";
                stm.executeUpdate(sql);    
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<Model.Customer> loadAllCust(){
        try{
            ArrayList<Model.Customer> listCust = new ArrayList();
            Statement stmt = con.createStatement();
            String query = "Select * from customer";
            ResultSet rs = stmt.executeQuery(query);
            Model.Customer c = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("Nama");
                String noktp = rs.getString("NoKTP");
                String provinsi = rs.getString("Provinsi");
                String kota = rs.getString("Kota");
                String kecamatan = rs.getString("Kecamatan");
                String kelurahan = rs.getString("Kelurahan");
                String kodePos = rs.getString("KodePos");
                String alamat = rs.getString("Alamat");
                String noTelp = rs.getString("NoTelp");
                c = new Model.Customer(nama, noktp, provinsi, kota, kecamatan, kelurahan, kodePos, alamat, noTelp);
                listCust.add(c);
            }
            return listCust;
            
        } catch (Exception e){
            System.out.println("Error While Loading List of Book!");
            return null;
        }
    }
    
    public Model.Customer loadKtp(String noKtp){
        try{
            Statement stmt = con.createStatement();
            String query = "select * from customer where noKTP='"+noKtp+"'";
            ResultSet rs = stmt.executeQuery(query);
            Model.Customer c = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("Nama");
                String noktp = rs.getString("NoKTP");
                String provinsi = rs.getString("Provinsi");
                String kota = rs.getString("Kota");
                String kecamatan = rs.getString("Kecamatan");
                String kelurahan = rs.getString("Kelurahan");
                String kodePos = rs.getString("KodePos");
                String alamat = rs.getString("Alamat");
                String noTelp = rs.getString("NoTelp");
                c = new Model.Customer(nama, noktp, provinsi, kota, kecamatan, kelurahan, kodePos, alamat, noTelp);
            }
            return c;
        } catch (SQLException e){
            System.out.println("Error While Loading a Book!");
            return null;
        }
        
    }
    
    public Model.Customer loadCust(String Nama){
        try{
            Statement stmt = con.createStatement();
            String query = "select * from customer where Nama='"+Nama+"'";
            ResultSet rs = stmt.executeQuery(query);
            Model.Customer c = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("Nama");
                String noktp = rs.getString("NoKTP");
                String provinsi = rs.getString("Provinsi");
                String kota = rs.getString("Kota");
                String kecamatan = rs.getString("Kecamatan");
                String kelurahan = rs.getString("Kelurahan");
                String kodePos = rs.getString("KodePos");
                String alamat = rs.getString("Alamat");
                String noTelp = rs.getString("NoTelp");
                c = new Model.Customer(nama, noktp, provinsi, kota, kecamatan, kelurahan, kodePos, alamat, noTelp);
            }
            return c;
        } catch (SQLException e){
            System.out.println("Error While Loading a Book!");
            return null;
        }
    }
    
    public Model.User loadUsertByEmail(String email){
        try{
            Statement stmt = con.createStatement();
            String query = "select * from `user` where `Email`='"+email+"';";
            ResultSet rs = stmt.executeQuery(query);
            Model.User u = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("Nama");
                String usrnm = rs.getString("Username");
                String password = rs.getString("Password");
                String eml = rs.getString("Email");
                String noTelp = rs.getString("No_Telp");
                String jKelamin = rs.getString("jKelamin");
                byte[] fotoProfil = rs.getBytes("foto");
                String bio = rs.getString("bio");
                u = new Model.User(nama, usrnm, password, noTelp, eml, bio, jKelamin, fotoProfil);
            }
            return u;
        } catch (SQLException e){
            System.out.println("Error While Loading a user!");
            return null;
        }   
    }
        
    public void savePengiriman(Model.PengirimanDokumen p){
        try{
                //String query = "INSERT INTO `pengiriman`(`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisDokumen`,`Deskripsi`,`Kategori`,`Harga`) VALUES ("+"\""+p.getNamaPengirim()"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","+"\""+p.getJenisDokumen()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.getHarga()+"\""+");";
                String query = "Insert into `pengirimanDoc` (`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisDokumen`,`Deskripsi`,`Kategori`,`Harga`) "
                        + "Values ("+"\""+p.getNamaPengirim()+"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","
                        + ""+"\""+p.getJenisDokumen()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.setBiaya()+"\""+");";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving Pengiriman Success!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
        }
    }
    
    public void savePengiriman(Model.PengirimanBarang p){
        try{
                //String query = "INSERT INTO `pengiriman`(`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisDokumen`,`Deskripsi`,`Kategori`,`Harga`) VALUES ("+"\""+p.getNamaPengirim()"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","+"\""+p.getJenisDokumen()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.getHarga()+"\""+");";
                String query = "Insert into `pengirimanBrg` (`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`Berat`,`Deskripsi`,`Kategori`,`Harga`) "
                        + "Values ("+"\""+p.getNamaPengirim()+"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","
                        + ""+"\""+p.getBerat()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.setBiaya()+"\""+");";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving Pengiriman Success!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
        }
    }
    
    public void savePengiriman(Model.PengirimanSurat p){
        try{
                //String query = "INSERT INTO `pengiriman`(`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisDokumen`,`Deskripsi`,`Kategori`,`Harga`) VALUES ("+"\""+p.getNamaPengirim()"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","+"\""+p.getJenisDokumen()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.getHarga()+"\""+");";
                String query = "Insert into `pengirimansrt` (`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisSurat`,`Deskripsi`,`Kategori`,`Harga`) "
                        + "Values ("+"\""+p.getNamaPengirim()+"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","
                        + ""+"\""+p.getJenisSurat()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.setBiaya()+"\""+");";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving Pengiriman Success!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
        }
    }
    
    public void savePengiriman(Model.PengirimanUang p){
        try{
                //String query = "INSERT INTO `pengiriman`(`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`JenisDokumen`,`Deskripsi`,`Kategori`,`Harga`) VALUES ("+"\""+p.getNamaPengirim()"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","+"\""+p.getJenisDokumen()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.getHarga()+"\""+");";
                String query = "Insert into `pengirimanuang` (`Pengirim`, `AlPengirim`, `Penerima`, `AlPenerima`,`jumlahUang`,`Deskripsi`,`Kategori`,`Harga`) "
                        + "Values ("+"\""+p.getNamaPengirim()+"\""+","+"\""+p.getAlPengirim()+"\""+","+"\""+p.getNamaPenerima()+"\""+","+"\""+p.getAlPenerima()+"\""+","
                        + ""+"\""+p.getJumlahUang()+"\""+","+"\""+p.getDeskripsi()+"\""+","+"\""+p.getKategori()+"\""+","+"\""+p.setBiaya()+"\""+");";
                stm = con.createStatement();
                stm.executeUpdate(query);
                System.out.println("Saving Pengiriman Success!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "0"+ex.getMessage());
        }
    }
}
