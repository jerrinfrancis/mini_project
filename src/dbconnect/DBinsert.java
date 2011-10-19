/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.*;
import mini.*;
import java.util.*;
/**
 *
 * @author Computer
 */
public class DBinsert {
    static String servername;
    static String portno;
    static String SID;
    static String url;
    static String uname;
    static String passwd;
    static Connection conn;
    
    public DBinsert() throws ClassNotFoundException,SQLException{
         servername  = "localhost";
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
    
    public static void addProject(Project p) throws SQLException{
        try{
            Statement ap = conn.createStatement();
            String st="INSERT INTO project VALUES(pid_seq.nextval,'"+ p.getProName()
                    + "','" + p.get_Startdate() + "','" + p.get_Enddate() + "'," + p.getProPriority()
                    + ",'" + p.get_Deldate() +"'," + p.get_revenue() +"," + p.get_status() + ")";
            ap.executeUpdate(st);
            System.out.println(ap);        
            conn.commit();
            
        }catch(SQLException ex){
            System.out.println("SQLException in addProject()");
            throw(ex);
        }
    }
    
    public static void addResource(Resource r) throws SQLException{
        try{
            
           Statement ps = conn.createStatement();
           String st="INSERT INTO phy_resource VALUES(rid_seq.nextval,'"+
                      r.getResName() + "'," + r.getResInstances() +")";
           ps.executeUpdate(st);
           System.out.println(st);       
           conn.commit();
           
            
        }catch(SQLException ex){
            System.out.println("SQLException in addResource()");
            throw(ex);
        }    
    }
    
    public static void addEmployee(Employee e) throws SQLException{
        try{
            String st =  "INSERT INTO employee VALUES ('" +
                         e.getEmpID() + "','" + e.getName() + "','" +
                    e.getAddress() + "'," + e.getSpec() +",'" + e.getPhone()+ "',"
                    + e.getStat() + ",'" + e.getdate() + "')";
            Statement stat = conn.createStatement();
            System.out.println(st);
            stat.executeQuery(st);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in addEmployee()");
            throw(ex);
        }
    }
    
    public static void generalInsert(String query) throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in generalInsert()");
            throw(ex);
        }
    }
    
    protected void finalize() throws SQLException{
        
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("SQLException in destructing DBinsert object");
            throw(ex);
        }
    
    }
    
}
