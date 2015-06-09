/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motordrivertxrx.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import motordrivertxrx.Model.MainModel;
import motordrivertxrx.View.MainView;

/**
 *
 * @author giovannirojas
 */
public class MainController implements ChangeListener, MouseListener {

    MainView view = null;
    MainModel model = null;
    RXTX serial = null;
    String status = "Derecha";

    public MainController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;

        // For the velocimeter change 
        view.getSliderVelocimeter().addChangeListener(this);
        view.getExitLabel().addMouseListener(this);
        view.getDirectionLabel().addMouseListener(this);

        serial = new RXTX();
        try {
            serial.connect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar serial " + ex, "Error en serial", 0);

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == view.getSliderVelocimeter()) {
            view.setDataset1(view.getSliderVelocimeter().getValue());
            view.setDataset2(view.getSliderVelocimeter().getValue());
            
            int data = 127 - view.getSliderVelocimeter().getValue();
            
            
            if (status.equalsIgnoreCase("Derecha")) {
                data+=128;
            } else if (status.equalsIgnoreCase("Izquierda")) {
                //data;
            }
            serial.serialWriter(data);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.getExitLabel()) {
            System.exit(0);  // Sale del sistema sin error 
        } else if (e.getSource() == view.getDirectionLabel()) {
            if (status.equalsIgnoreCase("Derecha")) {
                status = "Izquierda";
            } else if (status.equalsIgnoreCase("Izquierda")) {
                status = "Derecha";
            }
            view.getDirectionLabel().setText(status);
            
            int data = 127 - view.getSliderVelocimeter().getValue();
            
            
            if (status.equalsIgnoreCase("Derecha")) {
                data+=128;
            } else if (status.equalsIgnoreCase("Izquierda")) {
                //data;
            }
            serial.serialWriter(data);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    void receiveData() {
        // Receive Data 

    }

}
