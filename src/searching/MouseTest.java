/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author Apar
 */
public class MouseTest extends JFrame implements MouseListener, MouseMotionListener{

    /**
     * @param args the command line arguments
     */
    
    
    public MouseTest() throws HeadlessException {
         setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Visulaisation of Soritng algorithms");
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    
    public void paint(Graphics g)
    {
            
    }

    public static void main(String[] args) {
        // TODO code application logic here
        MouseTest mt=new MouseTest();
        mt.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Graphics graphics = getGraphics();
        graphics.drawOval(me.getX(), me.getY(), 15, 15);
        System.err.println(""+me.getX()+" "+ me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void mouseDragged(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Graphics graphics = getGraphics();
        graphics.drawOval(me.getX(), me.getY(), 15, 15);
//        System.err.println(""+me.getX()+" "+ me.getY());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Graphics graphics = getGraphics();
////        graphics.setColor(Color.yellow);
//        graphics.drawOval(me.getX(), me.getY(), 15, 15);
//        System.err.println(""+me.getX()+" "+ me.getY());
    }
    
}
