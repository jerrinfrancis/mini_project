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
    private int priority;
    private String [] month={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    private int del_day,del_month,del_year;
    private int duration;
    private int revenue;    
    public Project(String name,int sy,int sm,int sd,int ey,int em,int ed,int p,
            int dy,int dm,int dd,int due){
      
        proj_name = name;
        start_year=sy;
        start_month=sm;
        start_day=sd;
        end_year=ey;
        end_month=em;
        end_day=ed;
        del_day=dd;
        del_month=dm;
        del_year=dy;
        duration=due;
        priority = p;
    }
    
   
    public String getProName(){
        return proj_name;
    }
    
    public int getProPriority(){
        return priority;
    }
     public String get_Startdate(){
        String temp = start_day + "-" + month[start_month-1] +"-" + start_year ;
        return temp;
        }
     public String get_Enddate(){
        String temp = end_day + "-" + month[end_month-1] +"-" + end_year ;
        return temp;
        }
     public String get_Deldate(){
        String temp = del_day + "-" + month[del_month-1] +"-" + del_year ;
        return temp;
        }
     public int get_duration()
     {
         return duration;
     }
};


