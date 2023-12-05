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
public class DeleteDataCar {
    String id;
    public DeleteDataCar(String id) {
        this.id = id;
        check();
    }
    public void check()
    {
        connect x=new connect();
        x.Deletecar(id);
    }
    
    
    
}
