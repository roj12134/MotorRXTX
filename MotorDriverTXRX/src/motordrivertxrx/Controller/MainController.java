/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motordrivertxrx.Controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import motordrivertxrx.Model.MainModel;
import motordrivertxrx.View.MainView;
import org.jfree.data.general.DefaultValueDataset;

/**
 *
 * @author giovannirojas
 */
public class MainController implements ChangeListener {

    MainView view = null;
    MainModel model = null;
    
    

    public MainController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
        
        // For the velocimeter change 
       view.getSliderVelocimeter().addChangeListener(this);
        
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource()== view.getSliderVelocimeter()){
            view.setDataset1(view.getSliderVelocimeter().getValue());
            view.setDataset2(view.getSliderVelocimeter().getValue());
        }
        
        
    }

}
