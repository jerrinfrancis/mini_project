/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mini;

import java.util.Date;

/**
 *
 * @author Computer
 */
public class Project {
    
    private String proj_name;
    private int start_year;
    private int start_month;
    private int start_day;
    private int end_year;
    private int end_month;
    private int end_day;
    private short priority;
    public java.util.Date startdate;
    public java.util.Date enddate;
    public java.util.Date deldate;
    
    public Project(String name,int sy,int sm,int sd,int ey,int em,int ed,short p,
            int dy,int dm,int dd){
      
        proj_name = name;
        startdate = new Date(sy,sm,sd);
        enddate = new Date(ey,em,ed);
        deldate = new Date(dy,dm,dd);
        priority = p;
    }
    
   
    public String getProName(){
        return proj_name;
    }
    
    public int getProPriority(){
        return priority;
    }
};


