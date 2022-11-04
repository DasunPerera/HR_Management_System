/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.io.*;
import java.util.ArrayList;

// Create Employee class using extends. EmployeeContoller class is abstract class
public class Employee extends EmployeeController{
     FileSystem fs = new FileSystem("eeee.txt");
  
  //declare valiables for get employee details  
  private String EPF_Number;
  private String Employee_Name;
  private String Contact_Number;
  private String Birth_Day;
  private String Employee_Address;
  private String Department;
  private String Designation;
  private String Gender;
   private int EmployeeCount;
  
  public Employee(){
      
  }
  
  //create a constractor 
  public Employee(String EPF_Number,String Employee_Name,String Contact_Number,String Birth_Day,String Gender,
           String Employee_Address,String Department,String Designation)
  {
      this.EPF_Number = EPF_Number;
      this.Employee_Name=Employee_Name;
      this.Contact_Number=Contact_Number;
      this.Birth_Day=Birth_Day;
      this.Gender=Gender;
      this.Employee_Address=Employee_Address;
      this.Department= Department;
      this.Designation=Designation;
  }

    

 //use Encapsulation methods(get and set methods) to access private variables   
  
   public String getEPF_Number(){ 
      return EPF_Number;
  }
  public void setEPF_Number(String EPF_Number){
      this.EPF_Number = EPF_Number;
  }
  
  
   public String getEmployee_Name(){ 
      return Employee_Name;
  }
  public void setEmployee_Name(String Employee_Name){
      this.Employee_Name = Employee_Name;
  }
  
  
   public String getContact_Number(){ 
      return Contact_Number;
  }
  public void setContact_Number(String Contact_Number){
      this.Contact_Number = Contact_Number;
  }
  
   public String getBirth_Day(){ 
      return Birth_Day;
  }
  public void setBirth_Day(String Birth_Day){
      this.Birth_Day = Birth_Day;
  }
  
   public String getGender(){ 
      return Gender;
  }
  public void setGender(String Gender){
      this.Gender = Gender;
  }
  
   public String getEmployee_Address(){ 
      return Employee_Address;
  }
  public void setEmployee_Address(String Employee_Address){
      this.Employee_Address = Employee_Address;
  }
  
  
   public String getDepartment(){ 
      return Department;
  }
  public void setDepartment(String Department){
      this.Department = Department;
  }
  
  
   public String getDesignation(){ 
      return Designation;
  }
  public void setDesignation(String Designation){
      this.Designation = Designation;
  }
    public int getEmployeeCount() {
        return EmployeeCount;
    }

    public void setEmployeeCount(int EmployeeCount) {
        this.EmployeeCount = EmployeeCount;
    }


    //createa method to add employee details to the file
  public boolean addEmployee(){
      if(!fs.createANewFile()){
          String record =EPF_Number+ " "+ Employee_Name + " " +Contact_Number+ " "+ Birth_Day + " "+ Gender
                  + " "+ Employee_Address + " "+ Department+ " " +Designation;

          System.err.println(EPF_Number+ " "+ Employee_Name + " " +Contact_Number+ " "+ Birth_Day +" "+ Gender
                  + " "+ Employee_Address + " "+ Department+ " " +Designation);
          return fs.writeDataToFile(record);
      }
      return false;
    }
  
  
  //check EPF availability to avoid duplicate data
    public boolean checkIdAvailability(String EPF_Number){
      boolean IdFound = false;
      try{
          String[] words = null; //Initialize the word array
          BufferedReader brEmp = fs.readAFile();
          String FindLine;
         
          
          while((FindLine = brEmp.readLine())!=null)//Reading content from the file
          {
              words = FindLine.split(""); //Split the word using space 
              for(String word : words){
                  if(word.equals(EPF_Number)){ //Search for the given word 
                      IdFound = true; 
                  } 
              }
          }
          
      }
      catch(IOException e){
          System.out.println("An error occured "+e);
      }
      return IdFound;
  }
    
    //create method to view employee details
      public String viewAllEmployee () 
      {
        String Employee, allEmployee = " ";
       String[] words = null;
        int count = 0;

        BufferedReader brEmp = fs.readAFile();
            
        
        try {
            while ((Employee = brEmp.readLine()) != null)
            {     
                words = Employee.split(" "); 
                allEmployee = allEmployee+words[0]+"\t"+words[1]+"\t"+ words[2]+"\t"+words[3]+"\t"+words[4] 
                        +"\t"+ words[5]+"\t"+words[6]+"\t"+ words[7]+"\n";
                           
                count++; 
                
            }
        } catch (Exception e) {
        }

        setEmployeeCount(count);
        return allEmployee;
    }
      

   //create a method to search employee details  
    public boolean searchEmployee(String keyword)
    {
        boolean isFound= false;
    
        try
        {
            String [] words =null;
            
            
            BufferedReader brEmp = fs.readAFile();
            String employee;
            
          outerloop:
            while ((employee =brEmp.readLine())!=null)// read file details
            {
                words=employee.split(" ");//split the word using space
                
                for (String word:words)
                {
                    if(word.equals(keyword))
                    {
                        isFound =true;
                     Employee em = new Employee();
                        this.setEPF_Number(words[0]);
                        this.setEmployee_Name(words[1]);
                        this.setContact_Number(words[2]);
                        this.setBirth_Day(words[3]);
                        this.setGender(words[4]);
                        this.setEmployee_Address(words[5]);
                        this.setDepartment(words[6]);
                        this.setDesignation(words[7]);
                      
                        
                      break outerloop;
                        
                        
                    }
                     
                }
            }
        } catch(Exception e)
        {
            
        }
        return isFound;
    }
    
    
   

  
}
