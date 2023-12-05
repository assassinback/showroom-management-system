/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JTable;

/**
 *
 * @author moiza
 */
public class SearchDataCar {
 JTable x;
    String id;

    public SearchDataCar(JTable x,String id) {
        this.x = x;
        this.id=id;
        generate();
    }
    public void generate()
    {
        connect x=new connect();
        x.searchDataCar(id, this.x);
    }   
}
