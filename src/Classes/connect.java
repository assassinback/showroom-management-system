/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import GUI.*;
import com.sun.glass.ui.Cursor;
/**
 *
 * @author moiza
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class connect 
{
    Connection conn=null;
    ResultSet rs=null;
    Statement st=null;
    PreparedStatement pstmt=null;
    public Connection setConnection()
    {
        String dataSourceName="Database.accdb";
        String dir = System.getProperty("user.dir");
        String url = "jdbc:ucanaccess://"+dir+"/" + dataSourceName;
        Connection con=null;
        try {
              con = DriverManager.getConnection(url);
              System.out.println("Connection Established 1 ");
        }
        catch(Exception sqlEx){
                    System.out.println(sqlEx);
        } 
        return con;
    }
    public ArrayList<UserData1> getUserInfo()
    {
        ArrayList<UserData1> userinfo=new ArrayList<>();
        try {
            String query="Select * from CustomerInfo";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(query);
            while(rs.next())
            {
                UserData1 x=new UserData1();
                x.Address=rs.getString("Address");
                x.BookedCar=rs.getString("BookedCar");
                x.CNIC=rs.getString("CNIC");
                x.ContactNumber=rs.getString("ContactNumber");
                x.EmailAddress=rs.getString("EmailAddress");
                x.Password=rs.getString("Password");
                x.PaymentHistory=rs.getString("PaymentHistory");
                x.UserName=rs.getString("UserName");
                x.name=rs.getString("Name");
                userinfo.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userinfo;
    }
    public LinkedList<CarInfo1> getCarInfo()
    {
        LinkedList<CarInfo1> carinfo=new LinkedList<>();
        try {
            String query="Select * from CarInfo";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(query);
            while(rs.next())
            {
                CarInfo1 x=new CarInfo1();
                x.id=rs.getInt("ID");
                x.CarReleaseYear=rs.getString("CarReleaseYear");
                x.carcompany=rs.getString("CarCompany");
                x.carname=rs.getString("CarName");
                x.carprice=rs.getString("CarPrice");
                carinfo.add(x);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carinfo;
    }
    public boolean matchPassword(String userName,String Password)
    {
        try {
            String sql="Select UserName,Password from AdminLogin";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
            if(rs.getString("UserName").equals(userName)&&rs.getString("Password").equals(Password))
            {
                JOptionPane.showMessageDialog(null,"Logged in");
                return true;
            }
            else {
                if(rs.isLast())
                {
                    
                    JOptionPane.showMessageDialog(null,"Wrong id or password");
                    return false;
                    
                }
                
                
            }
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void Register(String Name,String UserName,String Password,String EmailAddress,String Address,String CNIC,String contactNumber)
    {
        try {
            String sql="Insert Into CustomerInfo(Name,UserName,Password,EmailAddress,Address,CNIC,ContactNumber) Values(?,?,?,?,?,?,?)";
            conn=setConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, Name);
            pstmt.setString(2, UserName);
            pstmt.setString(3, Password);
            pstmt.setString(4, EmailAddress);
            pstmt.setString(5, Address);
            pstmt.setString(6, CNIC);
            pstmt.setString(7, contactNumber);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registered");
            
        } catch (Exception ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    
    public boolean CustomerLogin(String UserName,String Password)
    {
        try {
            String sql="Select UserName,Password from CustomerInfo";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
            if(rs.getString("UserName").equals(UserName)&&rs.getString("Password").equals(Password))
            {
                JOptionPane.showMessageDialog(null,"Logged in");
                return true;
            }
            else {
                if(rs.isLast())
                {
                JOptionPane.showMessageDialog(null,"UserName or Password is incorrect");    
                return false;
                }
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public void Delete(String id)
    {
        try {
            /*String sql="Delete from CustomerInfo Where ID = "+Integer.parseInt(id);
            conn=setConnection();
            st=conn.prepareStatement(sql);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Deleted");*/   
            String sql="Delete from CustomerInfo Where ID=?";
            conn=setConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void search(String id,JTable x)
    {
        try {
            String sql="Select * From CustomerInfo Where ID="+id;
            conn=setConnection();
            st=conn.createStatement();
            st = conn.createStatement();
            rs=st.executeQuery(sql);            
            x.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Found");   
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Deletecar(String id)
    {
        try {
            /*String sql="Delete from CarInfo Where ID="+id;
            conn=setConnection();
            st=conn.prepareStatement(sql);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Deleted");   */
            String sql="Delete from CarInfo Where ID=?";
            conn=setConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
         catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addCar(String CarName,String CarPrice,String CarCompany,String CarReleaseYear)
    {
        try {
            String sql="Insert into CarInfo(CarName,CarPrice,CarCompany,CarReleaseYear) Values(?,?,?,?)";
            conn=setConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, CarName);
            pstmt.setString(2, CarPrice);
            pstmt.setString(3, CarCompany);
            pstmt.setString(4, CarReleaseYear);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Car info added");
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void searchDataCar(String id,JTable x)
    {
        try {
            String sql="Select * From CarInfo Where ID="+id;
            conn=setConnection();
            st=conn.createStatement();
            st = conn.createStatement();
            rs=st.executeQuery(sql);            
            x.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Found");   
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getCarInfo(JTable x)
    {
        try {
            String sql="Select * From CustomerInfo";
            conn=setConnection();
            st=conn.createStatement();
            st = conn.createStatement();
            rs=st.executeQuery(sql);            
            x.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Found");   
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showinfo(JTable x)
    {
        try {
            String sql="Select * From CustomerInfo";
            conn=setConnection();
            st=conn.createStatement();
            st = conn.createStatement();
            rs=st.executeQuery(sql);            
            x.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Found");   
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ViewCars(JTable x)
    {
        try {
            String sql="Select * From CarInfo";
            conn=setConnection();
            st=conn.createStatement();
            st = conn.createStatement();
            rs=st.executeQuery(sql);            
            x.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Found");   
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean buy1(String PaymentHistory,String BookedCar,JLabel x)
    {
        try {
            String h="";
            String sql="SELECT * FROM CarInfo";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
            if(rs.getString("CarName").equals(BookedCar))
            {
            h=rs.getString("CarPrice");
            x.setText(h);
            JOptionPane.showMessageDialog(null, "Done!");
            return true;
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void pay(String id,String price,String BookedCar)
    {
        try {
            String sql="SELECT * FROM CustomerInfo";
            conn=setConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                if(rs.getString("UserName").equals(id))
                {
                    String query="Update CustomerInfo SET BookedCar=?,PaymentHistory=? Where ID=?";
                    pstmt=conn.prepareStatement(query);
                    pstmt.setString(1, BookedCar);
                    pstmt.setString(2, price);
                    pstmt.setString(3, id);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Payment Done");
                    buyCar x=new buyCar(id,price);
                    x.generate();
                    
                }
            }      
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GenerateReceipt(String ID,String CarName)
    {
        try {
            GenerateReceipt x=new GenerateReceipt();
            String sql="Select * from CustomerInfo";
            String query="Select * from CarInfo";
            conn=setConnection();
            st=conn.createStatement();
            //Statement st1=conn.createStatement();
            rs=st.executeQuery(sql);
            ResultSet rs1=st.executeQuery(query);
            while(rs1.next())
            {
                if(rs1.getString("CarName").equals(CarName))
                {
                    x.jLabel6.setText(rs1.getString("CarCompany"));
                    x.jLabel7.setText(rs1.getString("CarName"));
                    x.jLabel8.setText(rs1.getString("CarPrice"));
                    x.jLabel9.setText(rs1.getString("CarReleaseYear"));
                }
            }
            while(rs.next())
            {
                if(rs.getString("ID").equals(ID))
                {
                    x.jLabel9.setText(rs.getString("ID"));
                    x.jLabel12.setText(rs.getString("Name"));
                }
            }
            x.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GenerateReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
