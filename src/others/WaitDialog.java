/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import javax.swing.JOptionPane;

/**
 *
 * @author Apar
 */
public class WaitDialog extends Thread{
    public void run()
    {
        JOptionPane.showMessageDialog(null, "Please wait while reseting");
    }
}
