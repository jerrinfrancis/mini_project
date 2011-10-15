/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;
import java.sql.*;
/**
 *
 * @author Computer
 */
public class DBquery {
    static String servername;
    static String portno;
    static String SID;
    static String url;
    static String uname;
    static String passwd;
    static Connection conn;
        public DBquery() throws ClassNotFoundException,SQLException{
        servername = "localhost";
        portno = "1521";
        SID = "xe";
        url = "jdbc:oracle:thin:@" + servername + ":" + portno + ":" + SID;
        uname = "system";
        passwd = "fighting7"; 
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,uname,passwd);
         }catch(SQLException ex){
             System.out.println("SQLException in DBinsert object ");
             throw(ex);
         }catch(ClassNotFoundException ex){
             System.out.println("ClassNotFoundException in DBinsert object");
             throw(ex);
         }
    }
    
    public static ResultSet generalQuery(String query) throws SQLException,ClassNotFoundException{
        try{
            /*Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url,uname,passwd);*/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }catch(SQLException ex){
            System.out.println("SQLException in generalQuery()");
            throw(ex);
        }
    }
    
    protected void finalize() throws SQLException{
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("SQLException in DBquery instance");
            throw(ex);
        }
    }
   
}
