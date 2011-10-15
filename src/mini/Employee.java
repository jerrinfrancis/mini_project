/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mini;
/**
 *
 * @author Computer
 */
public class Employee {
    private String emp_id;
    private String name;
    private String address;
    private int spec_id;
    private String phno;
    private int join_year;
    private int join_month;
    private int join_day;
    private int status;
    private String [] month={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    public Employee(String id,String n,String addr,int sp,String ph,int jy1,int jm1,int jd1,int st){
        emp_id = id;
        name = n;
        address = addr;
        spec_id = sp;
        phno = ph;
        join_year=jy1;
        join_month=jm1;        
        join_day=jd1;
        status = st;
    }
    
    public String getEmpID(){
        return emp_id;
    }
    public String getPhone(){
        return phno;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public int getSpec(){
        return spec_id;
    }
    
    public int getStat(){
        return status;
    }
    public String getdate(){
        String temp = join_day + "-" + month[join_month-1] +"-" + join_year ;
        return temp;
        }
}
