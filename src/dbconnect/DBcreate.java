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
public class DBcreate {
    static String servername;
    static String portno;
    static String SID;
    static String url;
    static String uname;
    static String passwd;
    static Connection conn;
    
    public DBcreate() throws ClassNotFoundException,SQLException{
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
    
    public static void Create_Project_Table() throws SQLException{
        //Connection conn = DriverManager.getConnection(url,uname,passwd);
        try{
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE SEQUENCE pid_seq INCREMENT BY 1 MINVALUE 1 START WITH 1");
            stmt.executeUpdate("CREATE TABLE project " +
                    " (proj_id number(8) PRIMARY KEY,proj_name varchar2(30),startdate date," + 
                    " enddate date,priority number(2),deliv_date date,revenue_gen number(5),status number(1))");
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Project_Table()");
            throw(ex);
        }
    }
    
    public static void Create_Resource_Table() throws SQLException{
        //Connection conn = DriverManager.getConnection(url,uname,passwd);
        try{
            
            Statement stmt = conn.createStatement();
            Statement stmt_1=conn.createStatement();
            stmt_1.executeUpdate("CREATE SEQUENCE rid_seq INCREMENT BY 1 MINVALUE 1 START WITH 1");
            stmt.executeUpdate("CREATE TABLE phy_resource " + 
                    " (res_id number(8)PRIMARY KEY,res_name varchar2(30),insta number(5))");
            conn.commit();
            
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Resource_Table()");
            throw(ex);
        }
    }
    
    public static void Create_Physical_Res_Avail_Table() throws SQLException{
        //Connection conn = DriverManager.getConnection(url,uname,passwd);
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE available_phy " +
                                "(avail_resid number(8) REFERENCES phy_resource(res_id),qty number(5))");
            conn.commit();
            
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Physical_Res_Avail_Table()");
            throw(ex);
        }
      }
    public static void Create_Physical_Res_Alloc_Table() throws SQLException{
        //Connection conn = DriverManager.getConnection(url,uname,passwd);
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE allocated_phy_resource (pid number(8) REFERENCES project(proj_id)" +
                               ",rid number(8) REFERENCES phy_resource(res_id),qty number(5))");
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Physical_Res_Alloc_Table()");
            throw(ex);
        }
      }
    public static void Create_Physical_Res_Waiting_Alloc_Table() throws SQLException{
        //Connection conn = DriverManager.getConnection(url,uname,passwd);
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE waiting_alloc_phy (pid number(8) REFERENCES project(proj_id)" +
                               ",rid number(8) REFERENCES phy_resource(res_id),qty number(5))");
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Physical_Res_Waiting_Alloc_Table()");
            throw(ex);
        }
      }
    
    public static void Create_Specialisation_Table() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE specialisation (spec_id number(8) PRIMARY KEY" +
                               ",spec_name varchar2(30))");
            conn.commit();
           }
        catch(SQLException ex){
            System.out.println("SQLException in Create_Specialisation_Table");
            throw(ex);
                    }
    }
    public static void Create_Employee_Table() throws SQLException{
        try{
           // Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
           // stmt1.executeUpdate("CREATE SEQUENCE eid_seq INCREMENT BY 1 MINVALUE 1 START WITH 1");
            stmt2.executeUpdate("CREATE TABLE employee (emp_id varchar2(10) PRIMARY KEY ," +
                    "emp_name varchar2(30)," +
                    "addr varchar2(50),spec_id number(8) REFERENCES specialisation(spec_id),"+
                    "phone varchar2(10),status number(1),joindate date)");
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Employee_Table()");
           // ex.printStackTrace();
            throw(ex);
        }
    }
    public static void Create_Self_Updated_HR_Total_Avail() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            String tablename = "hr_total_avail";
            String query = "CREATE TABLE " + tablename + " (specid number(8) REFERENCES " + 
                    "specialisation(spec_id),tot_qty number(3) DEFAULT 0,avail_qty number(3))";
            stmt.executeUpdate(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Self_Updated_HR_Total_Avail()");
            throw(ex);
        }
    }
    
      public static void Create_Allocated_Employees() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            String tablename = "allocated_employees";
            String query = "CREATE TABLE " + tablename + " (pid number(8) REFERENCES " + 
                    "project(proj_id),empid varchar2(10) REFERENCES employee(emp_id))";
            stmt.executeUpdate(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Allocated_Employees()");
            throw(ex);
           
        }
    }
    
    public static void Create_Allocated_HR_Pattern() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            String tablename = "allocated_HR";
            String query = "CREATE TABLE " + tablename + " (pid number(8) REFERENCES " + 
                    "project(proj_id),specid number(8) REFERENCES specialisation(spec_id),qty number(8))";
            stmt.executeUpdate(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Allocated_HR_Pattern()");
            throw(ex);
        }
    }
    
 
    public static void Create_Waiting_HR() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            String tablename = "waiting_HR";
            String query = "CREATE TABLE " + tablename + " (pid number(8) REFERENCES project(proj_id),spec_id number(8) REFERENCES " + 
                    "specialisation(spec_id),qty number(8))";
            stmt.executeUpdate(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in Create_Waiting_HR()");
            throw(ex);
        }
    }
    
     public static void Create_Other_Table(String query) throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
        }catch(SQLException ex){
            System.out.println("SQLException in createOtherTable()");
            throw(ex);
        }
    }
    public static void Set_Database_Creation_Tables() throws SQLException{
        try{
        Create_Project_Table();
        Create_Resource_Table();
        Create_Physical_Res_Avail_Table();
        Create_Physical_Res_Alloc_Table();
        Create_Physical_Res_Waiting_Alloc_Table();
        Create_Specialisation_Table();
        Create_Employee_Table();
        Create_Self_Updated_HR_Total_Avail();
        Create_Allocated_Employees();
        Create_Allocated_HR_Pattern();
        Create_Waiting_HR();
        System.out.println("Creation succesful");
            }
        catch(SQLException ex)
        {
        System.out.println("SQLEXception in Set_Database_Creation_Tables()");
        throw(ex);
        }
    } 
    public static void Destroy_Entire_Database() throws SQLException{
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE waiting_HR ");
            stmt.executeUpdate("DROP TABLE allocated_HR ");
            stmt.executeUpdate("DROP TABLE allocated_employees ");
            stmt.executeUpdate("DROP TABLE hr_total_avail ");
            stmt.executeUpdate("DROP TABLE employee ");
            stmt.executeUpdate("DROP TABLE specialisation ");
            stmt.executeUpdate("DROP TABLE waiting_alloc_phy ");
            stmt.executeUpdate("DROP TABLE allocated_phy_resource ");
            stmt.executeUpdate("DROP TABLE available_phy ");
            stmt.executeUpdate("DROP TABLE phy_resource ");
            stmt.executeUpdate("DROP SEQUENCE rid_seq ");
            stmt.executeUpdate("DROP TABLE project ");
            stmt.executeUpdate("DROP SEQUENCE pid_seq ");
            System.out.println("DROP SUCCESSFUL");
        }
        catch(SQLException ex){
            System.out.println("SQLException in Destroy_Entire_Database()");
            throw(ex);
        }
    
    }
  
    protected void finalize() throws SQLException{
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("SQLException in destroying DBcreate object");
            throw(ex);
        }
    }
}
class tes{
    public static void main(String args[]) throws Throwable {
        try{
        DBcreate Db = new DBcreate();
        Db.Set_Database_Creation_Tables();
  //   Db.Destroy_Entire_Database();      
            }
        catch(ClassNotFoundException e)
        {
            System.out.print("Class DBcreate not found");
            throw(e);
            
        }
}
}