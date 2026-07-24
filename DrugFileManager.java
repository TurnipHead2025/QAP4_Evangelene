//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DrugFileManager {

//constructors
    public DrugFileManager(){}    
    
//methods
    public void saveDrugToFile(Drug drug){
       
        try {
            FileOutputStream fos = new FileOutputStream("drugs.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(drug); 
            oos.close();          

    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
        }
        

    public void readDrug(){
        try {
            FileInputStream fis = new FileInputStream("drugs.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Drug drug = (Drug) ois.readObject();
            ois.close();
            System.out.println(drug.toString());
            
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
