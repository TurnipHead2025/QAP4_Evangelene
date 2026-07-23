//Sheri Evangelene
// June JUl 23- Aug 3 2026
//Java QAP 4

import java.io.Serializable;

public class Drug implements Serializable {
    private String drugID;
    private String drugName;
    private double drugCost;
    private double drugDosage;

//constructors
    public Drug(){};

    public Drug(String drugID, String drugName, double drugCost, double drugDosage ){
    this.drugID = drugID;
    this.drugName = drugName;
    this.drugCost = drugCost;
    this.drugDosage = drugDosage;
    }

//Methods
    public String getDrugId(){
        return this.drugID;
    }

    public String getDrugName(){
        return this.drugName;
    }

    public double getDrugCost(){
        return this.drugCost;
    }

    public double getDrugDosage(){
        return this.drugDosage;
    }

    public void setDrugId( String drugID){
        this.drugID = drugID;
    }

    public void setDrugName(String drugName){
        this.drugName =drugName;
    }

    public void setDrugCost(double drugCost){
        this.drugCost = drugCost;
    }

    public void setDrugDosage( double drugDosage){
        this.drugDosage =drugDosage;
    }

//toString
    @Override
    public String toString(){
        return ("Drug ID: " + drugID + " Drug Name: " + drugName + " Drug Cost: " + drugCost + " Drug Dosage: " + drugDosage + " ");
    }
}    
