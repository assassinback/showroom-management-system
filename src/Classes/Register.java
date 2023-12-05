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
public class Register {
private String Name;
private String UserName;
private String password;
private String EmailAddress;
private String Address;
private String CNIC;
private String ContactNumber;
    public Register(String Name, String UserName, String password, String EmailAddress, String Address, String CNIC, String ContactNumber) {
        this.Name = Name;
        this.UserName = UserName;
        this.password = password;
        this.EmailAddress = EmailAddress;
        this.Address = Address;
        this.CNIC = CNIC;
        this.ContactNumber = ContactNumber;
        SaveInfo();
    }
    public void SaveInfo()
    {
        connect x=new connect();
        x.Register(Name, UserName, password, EmailAddress, Address, CNIC, ContactNumber);
    }
    
    
    
    
}
