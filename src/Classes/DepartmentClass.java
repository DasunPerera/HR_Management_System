/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Dasun
 */
public class DepartmentClass {
    
    //connect FileSystem class and create file to store details
     FileSystem fs = new FileSystem("Department.txt");
    
     //declare variables to get Department details
         private String Department_name ;
         private String Designations;
         private int ECount;
         private String DFunctions;
     
         public DepartmentClass()
                 {
                     
                 }
         
     public DepartmentClass(String Department_name,String Designations,int ECount,String DFunctions )
     {
         this.Department_name= Department_name;
         this.Designations = Designations;
         this.ECount=ECount;
         this.DFunctions = DFunctions ;
     }

 

   //use get and set methods to access private variables
     
  public String getDepartment_name(){ 
      return Department_name;
  }
  public void setDepartment_name(String Department_name){
      this.Department_name = Department_name;
  }
  
   public String getDesignations(){ 
      return Designations;
  }
  public void setDesignations(String Designations){
      this.Designations = Designations;
  }
   public int getECount(){ 
      return ECount;
  }
  public void setECount(int ECount){
      this.ECount = ECount;
  }
  
   public String getDFunctions(){ 
      return DFunctions;
  }
  public void setDFunctions(String DFunctions){
      this.DFunctions = DFunctions;
  }
  
  //create a method to add department details
  public boolean addDepartment(){
      if(!fs.createANewFile()){
          String record = Department_name+" "+Designations+" "
                  +ECount+" "+DFunctions;
          System.err.println(Department_name+" "+Designations+" "
                  +ECount+" "+DFunctions);
          return fs.writeDataToFile(record);
      }
      return false;
    }

      //create method to view Department details
      public String viewAllEmployee () 
      {
        String Employee, allEmployee = " ";
       String[] words = null;
     

        BufferedReader brEmp = fs.readAFile();
            
        
        try {
            while ((Employee = brEmp.readLine()) != null)
            {     
                words = Employee.split(" "); 
                allEmployee = allEmployee+words[0]+"\t"+words[1]+"\t"+ words[2]+"\t"+words[3]+"\n";
                           
                
            }
        } catch (Exception e) {
        }

       
        return allEmployee;
    }
      

  
  

  
  
  
  
}

