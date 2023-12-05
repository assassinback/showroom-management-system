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
public class AdminLogin {
private String UserName;
private String password;

    public AdminLogin(String UserName, String password) {
        this.UserName = UserName;
        this.password = password;
        check();
    }
    public void check()
    {
        connect x=new connect();
        x.matchPassword(UserName, password);
        
        
    }
}
