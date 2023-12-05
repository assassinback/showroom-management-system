/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author moiza
 */
import javax.swing.*;
public class ViewAlluserInfo {
    JTable x;

    public ViewAlluserInfo(JTable x) {
        this.x = x;
        showinfo();
    }

    public void showinfo()
    {
        connect x=new connect();
        x.showinfo(this.x);
    }
    
    
    
    
    
}
