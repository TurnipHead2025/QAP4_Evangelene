//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.util.Date;

public class Patient {
    private String patientID;
    private String patientFName;
    private String patientLName;
    private Date  patientDOB;

//Constructors
    public Patient(){}
    
    public Patient(String ID, String FName, String LName, Date DOB){
        this.patientID = ID;
        this.patientFName = FName;
        this.patientLName = LName;
        this.patientDOB = DOB;
    }


//Methods
    public String getPatientID(){
        return this.patientID;
    }

    public String getPatientFName(){
        return this.patientFName;
    }

    public String getPatientLName(){
        return this.patientLName;
    }

    public Date getPatientDOB(){
        return this.patientDOB;
    }

    public void setPatientID(String ID){
        this.patientID = ID;
    }

    public void setPatientFName(String FName){
        this.patientFName = FName;
    }

    public void setPatientLName(String LName){
        this.patientLName = LName;
    }

    public void setPatientDOB(Date DOB){
        this.patientDOB = DOB;
    }

//toString
    public String toString(){
        return ("Patient ID: " + patientID + " Patient First Name: " + patientFName + " Patient Last Name: " + patientLName + " Patient DOB: " + patientDOB + " ");
    }
}   