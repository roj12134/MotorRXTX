/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motordrivertxrx.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.experimental.chart.plot.dial.DialBackground;
import org.jfree.experimental.chart.plot.dial.DialCap;
import org.jfree.experimental.chart.plot.dial.DialPlot;
import org.jfree.experimental.chart.plot.dial.DialPointer;
import org.jfree.experimental.chart.plot.dial.DialTextAnnotation;
import org.jfree.experimental.chart.plot.dial.DialValueIndicator;
import org.jfree.experimental.chart.plot.dial.SimpleDialFrame;
import org.jfree.experimental.chart.plot.dial.StandardDialScale;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

/**
 *
 * @author giovannirojas
 */
public class MainView extends javax.swing.JFrame {

    // Supossed to be in model
    /** The first dataset. */
    private DefaultValueDataset dataset1;
    
    /** The second dataset. */
    private DefaultValueDataset dataset2;
    
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        
        this.dataset1 = new DefaultValueDataset(10.0);
        this.dataset2 = new DefaultValueDataset(50.0);
        
        // get data for diagrams
        DialPlot plot = new DialPlot();
        plot.setView(0.0, 0.0, 1.0, 1.0);
        plot.setDataset(0, this.dataset1);
        plot.setDataset(1, this.dataset2);
        SimpleDialFrame dialFrame = new SimpleDialFrame();
        dialFrame.setBackgroundPaint(Color.lightGray);
        dialFrame.setForegroundPaint(Color.DARK_GRAY);
        plot.setDialFrame(dialFrame);
        /*
        GradientPaint gp = new GradientPaint(new Point(), 
                new Color(255, 255, 255), new Point(), 
                new Color(170, 170, 220));
        */
        GradientPaint gp = new GradientPaint(new Point(), 
                new Color(255, 255, 255), new Point(), 
                Color.ORANGE);
        
        DialBackground db = new DialBackground(gp);
        db.setGradientPaintTransformer(new StandardGradientPaintTransformer(
                GradientPaintTransformType.CENTER_HORIZONTAL));
        plot.setBackground(db);
        
        DialTextAnnotation annotation1 = new DialTextAnnotation("Velocidad");
        annotation1.setFont(new Font("Dialog", Font.BOLD, 14));
        annotation1.setRadius(0.7);
        
        plot.addLayer(annotation1);

        DialValueIndicator dvi = new DialValueIndicator(0, "c");
        dvi.setFont(new Font("Dialog", Font.PLAIN, 10));
        dvi.setOutlinePaint(Color.darkGray);
        dvi.setRadius(0.60);
        dvi.setAngle(-103.0);
        plot.addLayer(dvi);
        
        DialValueIndicator dvi2 = new DialValueIndicator(1, "c");
        dvi2.setFont(new Font("Dialog", Font.PLAIN, 10));
        dvi2.setOutlinePaint(Color.red);
        dvi2.setRadius(0.60);
        dvi2.setAngle(-77.0);
        plot.addLayer(dvi2);
        
        StandardDialScale scale = new StandardDialScale(0, 127, -120, -300);
        scale.setTickRadius(0.88);
        scale.setTickLabelOffset(0.15);
        scale.setTickLabelFont(new Font("Dialog", Font.PLAIN, 14));
        plot.addScale(0, scale);

        StandardDialScale scale2 = new StandardDialScale(0, 100, -120, -300);
        scale2.setTickRadius(0.50);
        scale2.setTickLabelOffset(0.15);
        scale2.setTickLabelFont(new Font("Dialog", Font.PLAIN, 10));
        scale2.setMajorTickPaint(Color.red);
        plot.addScale(1, scale2);
        plot.mapDatasetToScale(1, 1);
        
        DialPointer needle2 = new DialPointer.Pin(1);
        needle2.setRadius(0.55);
        plot.addLayer(needle2);

        DialPointer needle = new DialPointer.Pointer(0);
        plot.addLayer(needle);
        
        DialCap cap = new DialCap();
        cap.setRadius(0.10);
        plot.setCap(cap);
        
        JFreeChart chart1 = new JFreeChart(plot);
        chart1.setTitle("Velocidad motor");
        ChartPanel cp1 = new ChartPanel(chart1);
        cp1.setPreferredSize(new Dimension(400, 400));
        
        /*JPanel sliderPanel = new JPanel(new GridLayout(2, 2));
        sliderPanel.add(new JLabel("Outer Needle:"));
        sliderPanel.add(new JLabel("Inner Needle:"));
        this.slider1 = new JSlider(-40, 60);
        this.slider1.setMajorTickSpacing(20);
        this.slider1.setPaintTicks(true);
        this.slider1.setPaintLabels(true);
        this.slider1.addChangeListener(this);
        sliderPanel.add(this.slider1);
        sliderPanel.add(this.slider1);
        this.slider2 = new JSlider(0, 100);
        this.slider2.setMajorTickSpacing(20);
        this.slider2.setPaintTicks(true);
        this.slider2.setPaintLabels(true);
        this.slider2.addChangeListener(this);
        sliderPanel.add(this.slider2);*/
        
        velocimetroPanel.add(cp1);
        
    
    }

    public DefaultValueDataset getDataset1() {
        return dataset1;
    }

    public void setDataset1(int dato) {
        dataset1.setValue(new Integer(dato));
    }

    public DefaultValueDataset getDataset2() {
        return dataset2;
    }

    public void setDataset2(int dato) {
        dato = dato-10;
        dataset2.setValue(new Integer(dato));
    }

    public JSlider getSliderVelocimeter() {
        return sliderVelocimeter;
    }

    public void setSliderVelocimeter(JSlider sliderVelocimeter) {
        this.sliderVelocimeter = sliderVelocimeter;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        velocimetroPanel = new javax.swing.JPanel();
        chartPanel = new javax.swing.JPanel();
        sliderVelocimeter = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Motor RX TX ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        velocimetroPanel.setBackground(new java.awt.Color(255, 255, 255));
        velocimetroPanel.setLayout(new java.awt.BorderLayout());

        chartPanel.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sliderVelocimeter.setMajorTickSpacing(5);
        sliderVelocimeter.setMaximum(127);
        sliderVelocimeter.setMinorTickSpacing(1);
        sliderVelocimeter.setPaintLabels(true);
        sliderVelocimeter.setPaintTicks(true);
        sliderVelocimeter.setSnapToTicks(true);
        sliderVelocimeter.setValue(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(velocimetroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sliderVelocimeter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(velocimetroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderVelocimeter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider sliderVelocimeter;
    private javax.swing.JPanel velocimetroPanel;
    // End of variables declaration//GEN-END:variables
}
