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
import javax.swing.JTable;
public class SeeStock {
    private JTable x;
    public SeeStock(JTable x) {
        this.x = x;
        check();
    }
    public void check()
    {
        connect x=new connect();
        x.ViewCars(this.x);
    }
    
}
