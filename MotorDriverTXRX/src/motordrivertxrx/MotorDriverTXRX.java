/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motordrivertxrx;

import motordrivertxrx.Controller.MainController;
import motordrivertxrx.Model.MainModel;
import motordrivertxrx.View.MainView;

/**
 *
 * @author giovannirojas
 */
public class MotorDriverTXRX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainView mv = new MainView ();
        mv.setExtendedState(6);
        MainModel mm = new MainModel ();
        MainController mc = new MainController(mv, mm);
        mv.setVisible(true);
    }
    
}
