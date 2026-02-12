
package hotel.management.system;
import java.sql.*;
   public class Conn
{
    Connection c;
    Statement s;
    Conn()
    {
     try 
     {
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem" ,"root" ,"Aymanshaikh@123");
    s = c.createStatement();
}    
     catch (Exception e) 
       {
     e.printStackTrace();
       }
     }
    public static void Main(String args[])
    {
        new Conn();
    }
   }
























