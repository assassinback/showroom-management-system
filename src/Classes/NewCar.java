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
public class NewCar {
    private String carName;
    private String carPrice;
    private String carCompany;
    private String carReleaseyear;

    public NewCar(String carName, String carPrice, String carCompany, String carReleaseyear) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.carCompany = carCompany;
        this.carReleaseyear = carReleaseyear;
        add();
    }
    public void add()
    {
        connect x=new connect();
        x.addCar(carName, carPrice, carCompany, carReleaseyear);
    }
    
    
    
}
