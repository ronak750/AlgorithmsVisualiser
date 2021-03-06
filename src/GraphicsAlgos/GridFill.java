/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsAlgos;

import static GraphicsAlgos.FillColor.gg;
import searching.*;
import sorting.Main;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JOptionPane;

/**
 *
 * @author Apar
 */
public class GridFill extends javax.swing.JFrame  implements MouseMotionListener, MouseListener{

    /**
     * Creates new form TestForm
     */
    private int x_min=50,y_min=50;
    static Graphics graphics;
    int delay=70;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int x_window=(int) screenSize.getWidth()*90/100;
    private int y_window=(int) screenSize.getHeight()*90/100;
    private int window=x_window*80/100;
    
    // specific variables
    private int width=25;
    private Color final_color=Color.YELLOW,
                  boundary_color=Color.ORANGE ;
    private final java.awt.Color initial_color=java.awt.Color.yellow,                  
                   background_color=java.awt.Color.decode("#d6d9e0"),
                   dest_color=Color.green;
    private Color fill_color = Color.RED;
    private int sourceX=0,sourceY=0;
    private int max_x=window/width,max_y=y_window/width;
    private int visited[][]=new int[max_x][max_x];
    private int colors[][]=new int[max_x][max_x];
    private boolean srcChange=false,destChange=false;
    private boolean first=true, goon=true;
    static private Thread fillThread;
    private int algo=-1;
    //
    
    public GridFill() {
        initComponents();  
        addMouseMotionListener(this);
        setSize(x_window, y_window);
        addMouseListener(this);
        sourceX=max_x/3;sourceY=max_y/2;
        fillThread=new FillThread();
        for(int i=1;i<max_x;i++)
        {
            for(int j=1;j<max_y;j++)
            {
                colors[i][j]=background_color.getRGB();
            }
        }
    }
    
    public void paint(Graphics g)
    {
        
//        if(graphics==null);
//        else return;
        super.paint(g);
        graphics=g;

        for(int i=1;i<max_x;i++)
        {
            for(int j=1;j<max_y;j++)
            {
                 fillCell(new Color(colors[i][j]), i, j);
            }
        }
        for(int i=0;i<max_x;i++)
        {
            g.drawLine(i*width, 0,i*width , y_window);
            fillCell(Color.black,i,1);
            fillCell(Color.black,i,max_y-1);
        }
        for(int i=0;i<max_y;i++)
        {
            g.drawLine(0, i*width,window , i*width);
            fillCell(Color.black,max_x-1,i);
            fillCell(Color.black,0,i);
        }
        fillCell(fill_color,sourceX,sourceY);
    }
    
    void changeInteriorPoint(int x,int y)
    {
        fillCell(new Color(colors[sourceX][sourceY]),sourceX,sourceY);
        sourceX=x;
        sourceY=y;
        fillCell(fill_color,sourceX,sourceY);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Algos");
        setMinimumSize(new java.awt.Dimension(1250, 700));

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 0, 255));
        jButton8.setText("jButton2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 102, 102));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Algorithm", "Boundary Fill", "Flood Fill" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 0, 0));
        jButton11.setText("jButton2");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 153, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Simulate");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 0, 0));
        jButton13.setText("jButton2");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Calligraphy", 1, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Controller");

        jButton14.setBackground(Color.yellow);
        jButton14.setText("jButton2");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Choose Boundary Color");

        jButton15.setBackground(new java.awt.Color(102, 153, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 51, 51));
        jButton15.setText("HOME");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 255));
        jButton3.setText("jButton2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 153, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 51));
        jButton4.setText("RESET");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(Color.yellow);
        jButton6.setText("jButton2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 153));
        jButton16.setText("jButton2");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Choose Fill Color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(872, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 186, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton13))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton8)
                    .addComponent(jButton14)
                    .addComponent(jButton11))
                .addGap(47, 47, 47)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(119, 119, 119)
                .addComponent(jButton15)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boundary_color=Color.decode("#000099");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        fill_color=Color.decode("#cc00ff");
        changeInteriorPoint(sourceX, sourceY);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        algo=jComboBox1.getSelectedIndex();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        fill_color=Color.decode("#ff0000");
        changeInteriorPoint(sourceX, sourceY);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  
        goon=true;
        Thread.State sortThreadState=fillThread.getState();
        if(sortThreadState==Thread.State.RUNNABLE || sortThreadState==Thread.State.TIMED_WAITING) return;
        try{
            fillThread =new FillThread();
            fillThread.start();
        }catch(Exception e){System.err.println(""+e);}
        

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        boundary_color=Color.decode("#ff0000");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        fill_color=Color.ORANGE;
        changeInteriorPoint(sourceX, sourceY);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        Main mn=new Main();
        this.dispose();
        mn.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boundary_color=Color.decode("#cc00ff");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            //        if(sortThread.getState()==Thread.State.RUNNABLE)
            goon=false;
            Thread.sleep(200);
//            fillThread.interrupt();
//            fillThread=new FillThread();

            first=true;
            for(int i=1;i<max_x;i++)
            {
            for(int j=1;j<max_y;j++)
            {
                colors[i][j]=background_color.getRGB();
            }
            }
            repaint();
            
        }catch(Exception e){}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        boundary_color=Color.ORANGE;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        fill_color=Color.decode("#000099");
        changeInteriorPoint(sourceX, sourceY);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(GridFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GridFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GridFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GridFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridFill().setVisible(true);
//                    new Grid().setVisible(true);
            }
        });
    }

    private boolean isSource(int x,int y)
    {
        if(x==sourceX && y==sourceY)
            return true;
        return false;
    }
 
    @Override
    public void mouseDragged(MouseEvent me) {

        int x=me.getX();
        int y=me.getY();
        x/=width; y/=width;
        if(x>=max_x || y>=max_y) return;
        Graphics g=getGraphics();
        
        if(srcChange)
        {
            changeInteriorPoint(x, y);          
        }      
        else{
            if(isSource(x,y)) return;
            colors[x][y]=boundary_color.getRGB();
            fillCell(boundary_color, x, y);
        }

    }

    void boundaryFill4(int x, int y) 
{
    
    if(!goon)  
        return;
    
    if(x<2 || y<2 || x>=max_x-1 || y>=max_y-1)  return;
    if(colors[x][y] != boundary_color.getRGB() &&
       colors[x][y] != fill_color.getRGB())
    {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(GridFill.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillCell(fill_color, x, y);
        colors[x][y]=fill_color.getRGB();
        boundaryFill4(x + 1, y);
        boundaryFill4(x, y + 1);
        boundaryFill4(x - 1, y);
        boundaryFill4(x, y - 1);
    }
}
    void floodFill( int x, int y) 
{ 
    if(!goon) return;
    if (x < 1 || x >= max_x -1 || y < 1 || y >= max_y-1) 
        return; 
    if (colors[x][y] != background_color.getRGB()) 
        return; 
    if (colors[x][y] == fill_color.getRGB())  
        return;  
 
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(GridFill.class.getName()).log(Level.SEVERE, null, ex);
        }
    colors[x][y] = fill_color.getRGB();
    fillCell(fill_color, x, y);
    floodFill(x+1, y); 
    floodFill( x-1, y); 
    floodFill( x, y+1); 
    floodFill(x, y-1); 
}
    
    
    @Override
    public void mouseMoved(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    private void fillCell(Color c,int x,int y)
    {
        Graphics g=getGraphics();
        g.setColor(c);
        g.fillRect(x*width+1, y*width+1, width-1, width-1);
    }
    


    
    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int x=me.getX();
        int y=me.getY();
        x/=width; y/=width;
        if(x>=max_x || y>=max_y) return;
        if(x==sourceX && y==sourceY)        
        {
            srcChange=true;
        }     
        else {
            srcChange=false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class FillThread extends Thread{
        public void run()
        {
            switch(algo)
            {
                case -1:
                case 0: JOptionPane.showMessageDialog(null, "Select An Algorithm");
                    break;
                case 1: boundaryFill4(sourceX,sourceY);   
                        fillCell(dest_color, sourceX, sourceY);
                    break;
                case 2: floodFill(sourceX,sourceY);
                    fillCell(dest_color, sourceX, sourceY);
            }                
        }
    }
     
}

