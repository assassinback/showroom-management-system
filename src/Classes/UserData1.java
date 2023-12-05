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
public class UserData1 {
    
    public String name;
    public String UserName;
    public String Password;
    public String EmailAddress;
    public String Address;
    public String CNIC;
    public String ContactNumber;
    public String BookedCar;
    public String PaymentHistory;

    public UserData1() {
    }
    
    public UserData1( String name, String UserName, String Password, String EmailAddress, String Address, String CNIC, String ContactNumber, String BookedCar, String PaymentHistory) {
        this.name = name;
        this.UserName = UserName;
        this.Password = Password;
        this.EmailAddress = EmailAddress;
        this.Address = Address;
        this.CNIC = CNIC;
        this.ContactNumber = ContactNumber;
        this.BookedCar = BookedCar;
        this.PaymentHistory = PaymentHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getBookedCar() {
        return BookedCar;
    }

    public void setBookedCar(String BookedCar) {
        this.BookedCar = BookedCar;
    }

    public String getPaymentHistory() {
        return PaymentHistory;
    }

    public void setPaymentHistory(String PaymentHistory) {
        this.PaymentHistory = PaymentHistory;
    }
    
    
    
}
