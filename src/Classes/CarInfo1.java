/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Zia-ur-Rehman Khan
 */
public class CarInfo1 {
    public int id;
    public String carname;
    public String carprice;
    public String carcompany;
    public String CarReleaseYear;

    public CarInfo1() {
    }

    public CarInfo1(String carname, String carprice, String carcompany, String CarReleaseYear) {
        this.carname = carname;
        this.carprice = carprice;
        this.carcompany = carcompany;
        this.CarReleaseYear = CarReleaseYear;
    }
    
    public CarInfo1(int id, String carname, String carprice, String carcompany, String CarReleaseYear) {
        this.id = id;
        this.carname = carname;
        this.carprice = carprice;
        this.carcompany = carcompany;
        this.CarReleaseYear = CarReleaseYear;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarprice() {
        return carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice;
    }

    public String getCarcompany() {
        return carcompany;
    }

    public void setCarcompany(String carcompany) {
        this.carcompany = carcompany;
    }

    public String getCarReleaseYear() {
        return CarReleaseYear;
    }

    public void setCarReleaseYear(String CarReleaseYear) {
        this.CarReleaseYear = CarReleaseYear;
    }
    
}
