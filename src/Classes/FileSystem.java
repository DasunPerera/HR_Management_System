/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileSystem {
    
    
        private static String Link = "C:\\Users\\Dasun\\Desktop\\oooooooo\\";
    
    File file;
    private String fileName;
    
    public FileSystem(String fileName){
        this.fileName = fileName;
    
    
    createANewFile();
 
}

    // create files for data storing process
public boolean createANewFile(){
    try{
        file = new File(Link + fileName);
        if (file.createNewFile()){
            System.out.println("File created: "+ file.getName());
            return true;
        }
        
        System.out.println("File already exxist!");
        return false;       
    }

    catch(IOException e){
    System.out.println("Something went wrong creating file"+e);
    return false;
    }
};

//read files to access data
public BufferedReader readAFile(){
  if(!createANewFile()){   
    try{
  
      FileReader reader = new FileReader(file);
      BufferedReader buffer = new BufferedReader(reader);
      return buffer;
    }
  catch(IOException e){
        System.out.println("Something went wrong with Reading the file");  
        }
    }
   return null; 
};


//write data in files
public boolean writeDataToFile(String record){
 try{
     file.createNewFile();
     FileWriter newWriter = new FileWriter(file, true);
     BufferedWriter newBuffer = new BufferedWriter(newWriter);
     
     newBuffer.write(record);
     newBuffer.newLine();
     newBuffer.close();
     newWriter.close();
     
     return true;
  }
 catch(IOException e){
     System.out.println("Something went wrong");
     return false;
 }
    
};
}
