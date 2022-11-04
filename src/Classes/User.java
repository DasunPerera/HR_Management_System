/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedReader;

/**
 *
 * @author Dasun
 */
public class User implements LoginController{
    
    FileSystem fs = new FileSystem("user.txt");
  
    //declare variables to get user details
   public String name1 ;
   public String EPF1; 
   private String username;
   private String Password;
   private String Role;
    
    public User(){}
     
  
     public User(String username, String password) {
        this.username = username;
        this.Password = Password;
    }
    
    public User( String username,  String Password, String Role)
    {
     this.username = username;
     this.Password = Password;
     this.Role = Role;
    }
    
    
  //use get and set methods to access private variables  
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

     public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    //add new user details in the file
      public boolean addNewUser() {
        if(!fs.createANewFile()){
            String record = name1 + " "+EPF1+ " "+ username + " " + Password+ " " + Role ;
            
            return fs.writeDataToFile(record);
        }

        return false;
    }

      //check validation of user details
       public boolean validateLogin() {
        try {
            String[] words = null;
             
            BufferedReader users = fs.readAFile();
            String user;

            while ((user = users.readLine()) != null) {              
                words = user.split(" ");

                if (words[2].equals(username) && words[3].equals(Password)&& words[4].equals(Role)) {
                    this.setusername(words[0]);
                    this.setPassword(words[1]);
                    this.setRole(words[2]);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        
        return false;
    }
   
}
