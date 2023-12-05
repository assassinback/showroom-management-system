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
public class ViewAllCarInfo {
    JTable x;

    public ViewAllCarInfo(JTable x) {
        this.x = x;
        ViewCars();
    }
    public void ViewCars()
    {
        connect x=new connect();
        x.ViewCars(this.x);
        
        
        
    }
    
    
    
}
