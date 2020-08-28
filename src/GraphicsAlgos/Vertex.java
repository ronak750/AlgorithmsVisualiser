/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicsAlgos;

/**
 *
 * @author Apar
 */
public class Vertex {
    private int x;
    private int y;
    
    public Vertex(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    int getX()
    {
        return x;
    }
    int getY()
    {
        return y;
    }
    void setX(int x)
    {
        this.x=x;
    }
    void setY(int y)
    {
        this.y=y;
    }
}
