/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.util.Arrays.sort;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Apar
 */
public class Searching extends JFrame{
    
    private int arraySize=25;
    private boolean init=false;
    int array[]=new int[arraySize];
    int key=225;
    private int max_height=380,min_height=40; 
    //copied variables
    private int x_min=40,y_min=65;
    private int x_window=1100,y_window=700;
    private int window=950;
    private int width=window/arraySize,margin=6;
    private Color background_color=Color.decode("#d6d9e0");
    private Color initial_color=Color.yellow,
            highlighted_color=Color.red,
            secondary_color=Color.magenta,
            final_color=Color.blue,
            temp_color=Color.green,
            key_color=Color.decode("#ff6600");
    private int delay=300;
    private boolean sorted=false;
    private Font font;
    private int keyIndex=-1;
    Graphics graphics;
    static javax.swing.JLabel label;
    
    Searching(Graphics g,int arrSize, javax.swing.JLabel jlabel)
    {
        setSize(x_window,y_window);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Visulaisation of Soritng algorithms");
        this.arraySize=arrSize;
        array=new int[arraySize];
        width=window/arraySize;
        graphics=g;
//        font=new Font(graphics.getFont().getFamily(),Font.ITALIC,15);
//        graphics.setFont(font);
        label=jlabel;
        
        generateArray(); 

        resetBoard();
        try {
            drawArray(g);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }
    
    public void linearSearch() 
    {

        //            try {
//                drawArray(graphics);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
//            }
        boolean found=false;
        int i=0;
        while(array[i]<=key && i<arraySize)
        {
            drawRectangle(i,secondary_color);
            try{
                Thread.sleep(delay);
            }catch(Exception e){System.out.println(e.getMessage());}
            if(array[i]==key)
            {
                drawRectangle(i,temp_color);
                drawNumber(i);
                found=true;
                break;
            }
            resetAndRedraw(i);   
            i++;
        }
        if(!found)
        {
            JOptionPane.showMessageDialog(null, "Element Not Found");
        }
    }
    
    public void binarySearch() 
    {
        boolean found=false;
        int low=0,high=arraySize-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            drawRectangle(mid,highlighted_color);
            try{
                Thread.sleep(delay);
            }catch(Exception e){System.out.println(e.getMessage());}
            if(array[mid]==key)
            {
                drawRectangle(mid,temp_color);
                drawNumber(mid);
                found=true;
                break;
            }
            else if(array[mid]>key)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            resetAndRedraw(mid);
            drawNumber(mid);
        }
        if(!found)
        {
            JOptionPane.showMessageDialog(null, "Element Not Found");
        }     
    }
    
    void generateArray()
    {
        for(int i=0;i<arraySize;i++)
        {
            array[i]=(int)(Math.random()*1000)%max_height+min_height;
//            array[i]=arraySize-i+1;
//            array[i]=(i+1)*2;
        }
        sort(array);     
        printArray();
    }
    void printArray()
    {
        for(int i=0;i<arraySize;i++)
            System.out.print(array[i]+" ");
        System.out.println("END");
    }
    void changeKey(int key)
    {
        this.key=key;
        label.setText("Key Value: "+ key);
        if(keyIndex!=-1)
            drawRectangle(keyIndex, initial_color);
        keyIndex=findElement();
        if(keyIndex!=-1)
            drawRectangle(keyIndex, key_color);
        System.err.println(""+keyIndex);
        
    }
    void autoKey()
    {
        int rnd=(int)(Math.random()*100)%arraySize;
        changeKey(array[rnd]);
//        key=array[rnd];
    }
    void changeDelay(int newTime)
    {
        delay=newTime;
    }
    void resizeArray(int newSize)
    {
        for(int i=0;i<arraySize;i++)
            resetRectangle(i);
//        repaint();
        arraySize=newSize;
        array=new int[arraySize];
        width=window/arraySize;
        resetBoard();
     
    }
    
    void resetBoard()
    {
        for(int i=0;i<arraySize;i++)
            resetRectangle(i);
        sorted=false;
        generateArray();

        try {
            drawArray(graphics);

        } catch (InterruptedException ex) {
            System.err.println(""+ex);
        }
//        autoKey();
    }
    void drawArray(Graphics g) throws InterruptedException
    {
        g=graphics;
        g.setColor(initial_color);
        if(sorted)
           g.setColor(final_color);
        for(int i=0;i<arraySize;i++)
        {
            g.fillRect(x_min+i*width, y_min, width-margin, array[i]);
            
        }
        for(int i=0;i<arraySize;i++)       
            drawNumber(i);
        
        autoKey();

    } 
    
    private int findElement()
    {
        int low=0,high=arraySize-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;         
            if(array[mid]==key)         
                return mid;          
            else if(array[mid]>key)           
                high=mid-1;            
            else
                low=mid+1;
        }
        
        return -1;
    }
    
    void drawNumber(int i)
    {
        graphics.setFont(new Font(graphics.getFont().getFamily(),0,(int)(width*0.4)));
        graphics.setColor(Color.BLACK);
        graphics.drawString(""+array[i], x_min+i*width+(int)(width*0.1), y_min+width);
    }
//    private void drawNumber(int i)
//    {
//        graphics.setColor(final_color);
//        graphics.drawString(""+array[i],x_min+i*width+4 , y_min+min_height/2);
//    }
    private void resetRectangle(int i)
    {
        graphics.setColor(background_color);
        graphics.fillRect(x_min+(i)*width, y_min, width-margin, max_height+min_height); 
//        drawNumber(i);
    }
    void drawRectangle(int index, Color color)
    {
        graphics.setColor(color);
        graphics.fillRect(x_min+index*width, y_min, width-margin, array[index]);
        drawNumber(index);
    }  
    private void resetAndRedraw(int i)
    {
        graphics.setColor(background_color);
        graphics.fillRect(x_min+(i)*width, y_min, width-margin, max_height+5);
        graphics.setColor(initial_color);
        graphics.fillRect(x_min+(i)*width, y_min, width-margin, array[i]);
        drawNumber(i);
    }    
}
