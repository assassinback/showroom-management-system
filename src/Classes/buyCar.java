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
import java.util.LinkedList;
import javax.swing.*;
public class buyCar {
    private String id;
    private String CarName;
    private JLabel x;
    boolean h;
    connect j=new connect();
    public buyCar(String id, String CarName,JLabel x) {
        this.id = id;
        this.CarName = CarName;
        this.x=x;
    }

    public buyCar(String id, String CarName) {
        this.id = id;
        this.CarName = CarName;
    }

    
    
    public boolean buy()
    {
        h=j.buy1(id, CarName, this.x);
        return h;
    }
    public void pay()
    {
        if(h==true)
        {
            j.pay(id, CarName, x.getText());
        }
    }
    public void generate()
    {
        j.GenerateReceipt(id, CarName);
    }
    
    
    
    
}
