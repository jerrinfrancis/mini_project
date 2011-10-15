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
public class Resource {
    
    private String res_name;
    private int instances;
    
    
    public Resource(String name,int i){
        
        res_name = name;
        instances = i;
       
    }
    
 
    public String getResName(){
        return res_name;
    }
    
    public int getResInstances(){
        return instances;
    }
};
