
import Controller.LoginController;
import Model.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATIHAH RAHMADAYANA
 */
public class Driver {
    public static void main(String[]args){
        Model.Application app = new Application();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }Controller.LoginController login = new LoginController(app);
    }
}
