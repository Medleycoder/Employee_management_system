import java.sql.*;

public class Conn {
    //Database Connnectivity

    Connection con;
    Statement s;
    Conn(){


        PreparedStatement pst;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
            con = DriverManager.getConnection("jdbc:mysql://localhost/lbs","root","65178299");
             s = con.createStatement();
//            System.out.println("SUCCESS");


        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new Conn();
//    }
}
