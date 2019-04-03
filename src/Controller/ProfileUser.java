/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class ProfileUser extends MouseAdapter implements ActionListener{
    private GUI.ProfileUser profile;
    private Model.Application app;
    private Model.User user;
    private LoginController login;

    public ProfileUser(Model.Application app) throws IOException {
        this.app = app;
        profile = new GUI.ProfileUser();
        profile.setVisible(true);
        profile.addActionListener(this);
        user = app.loadUser(Model.LoggedIn.email);
        profile.setNama(user.getNama());
        profile.setUsername(user.getUsername());
        profile.setEmail(user.getEmail());
        profile.setNoTelp(user.getNo_hp());
        profile.setJKelamin(user.getJKelamin());
        
        if (new String(user.getFoto()).isEmpty()){
            Image img = ImageIO.read(getClass().getResource("../Image/Untitled-1.png"));
            ImageIcon resImg = new ImageIcon(profile.ScaledImage(img, 250, 225));
            profile.setFoto(resImg);
        } else {
            java.io.InputStream in = new java.io.ByteArrayInputStream(user.getFoto());
            java.awt.image.BufferedImage image = ImageIO.read(in);
            ImageIcon img = new ImageIcon(profile.ScaledImage(image, 250, 225));
            profile.setFoto(img);
        }
        profile.setBio(user.getBio());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(profile.getBtnUpdate())){
            try{
                
                String nama = profile.getNama();
                String username = profile.getUsername();
                String email = profile.getEmail();
                String notelp = profile.getNoTelp();
                String jKelamin = profile.getJKelamin();
                String bio = profile.getBio();
                
                System.out.println(jKelamin);
                if (profile.getNama().isEmpty() && profile.getJKelamin().isEmpty() && profile.getNoTelp().isEmpty() && profile.getUsername().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill your information completly!");
                } else
                if (profile.getNama().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is empty! Please fill your Name");
                } else
                if (profile.getJKelamin().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Jenis Kelamin is empty! Please fill your Jenis Kelamin");
                } else
                if (profile.getNoTelp().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nomor Telepon is empty! Please fill your Nomor Telepon");
                } else
                if (profile.getUsername().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Username is empty! Please fill your Username");
                } else {
                    Model.User usr = new Model.User(nama, username, email, notelp, bio, jKelamin);
                    app.updateUser(usr);
                }
            } catch(Exception ex){
                System.out.println(ex);;
            }
            
        }    
        
        if (source.equals(profile.getBtnUpload())){
                JFileChooser fc= profile.getFile();
                int ii = profile.getFile().showOpenDialog(profile);
                if(ii == profile.getFile().APPROVE_OPTION){
                    File f=fc.getSelectedFile(); 
                    String path=f.getAbsolutePath(); 
                    profile.getFoto().setIcon(new ImageIcon(path)); 

                    try{ 
                        FileInputStream fin=new FileInputStream(f); 
                        int len=(int)f.length(); Class.forName("com.mysql.jdbc.Driver"); 

                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/postoffice?zeroDateTimeBehavior=convertToNull","root",""); 
                        PreparedStatement ps=con.prepareStatement("update `user` set `foto`=? where `email`='"+user.getEmail()+"';"); 

                        ps.setBinaryStream(1, fin, len); 
                        int status=ps.executeUpdate(); 

                        if(status > 0) { 
                            JOptionPane.showMessageDialog(null,"Successfully inserted in DB"); 
                            profile.getFoto().setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(250, 225, Image.SCALE_SMOOTH)));
                        }else{ 
                            JOptionPane.showMessageDialog(null,"Image not inserted!"); 
                        } 
                    }catch(Exception ex){
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(profile, "Your Image is Too Large! The Image Size Max is 1MB");
                        profile.setVisible(false);
                        MenuAwalController mA = new MenuAwalController(app);
                    }
                } else {
                    JOptionPane.showMessageDialog(profile, "Your Image is Too Large! The Image Size Max is 1MB");
                }
        }
        
        if(source.equals(profile.getBtnGanti())){
            try{
                profile.setVisible(false);
                VerifyUpdateUserController verify = new VerifyUpdateUserController(app);
            } catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        if (source.equals(profile.getMenuAwal())){
            try{
                profile.setVisible(false);
                 MenuAwalController login = new MenuAwalController(app);
            } catch (Exception ex){
                System.out.println(ex);
            }
            
        }
        
        if(source.equals(profile.getLogout())){
            try{
                int pilih = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?","Logout",JOptionPane.YES_NO_OPTION);
                switch(pilih){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(null, "Thanks for using our program :)");
                        app.logout();
                        profile.setVisible(false);
                        LoginController login = new LoginController(app);
                    break;
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    
}
