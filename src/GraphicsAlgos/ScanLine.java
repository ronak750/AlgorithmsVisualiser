/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsAlgos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Apar
 */
public class ScanLine extends JFrame{
    
    private int x_min=50,y_min=50;
    private int x_window=1250,y_window=700;
    private int window=950;
    static Graphics graphics;
    int delay=40;
    
    // specific variables
    private int width=25;
    private final Color final_color=Color.YELLOW,
                        path_color=Color.ORANGE ;
    private final java.awt.Color initial_color=java.awt.Color.yellow,
                   source_color=java.awt.Color.decode("#EE82EE"),
                   background_color=java.awt.Color.decode("#d6d9e0"),
                   dest_color=Color.green,
                   temp_color=Color.decode("#A2B582"),
                   black_color=Color.BLACK;
    private int sourceX=0,sourceY=0;
    private int destX=0,destY=0;
    private int max_x=window/width,max_y=y_window/width;
    private int board[][]=new int[max_x][max_x];
    private int visited[][]=new int[max_x][max_x];
    private int cost[][]=new int[max_x][max_x];
    private boolean isFound=false;
    private boolean srcChange=false,destChange=false;
    private static int algoIndex=-1;
    
    public static void main(String args[])
    {
        ScanLine sl=new ScanLine();
        sl.setVisible(true);
    }
    public void paint(Graphics g)
    {
            
    }
}
