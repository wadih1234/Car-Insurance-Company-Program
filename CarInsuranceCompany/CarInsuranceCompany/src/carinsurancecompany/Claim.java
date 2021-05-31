
package carinsurancecompany;

import java.util.*;
public class Claim {
    private int id=0;
    private Customer c;
    private Policy p;
    String dateClaim;
    String accidentType;
    String accidentDate;
    ArrayList<String> damages;
    String compensationAmount;
    boolean status=false;
    
    private static int seq=0;
    public Claim(Customer c,Policy p, String dateClaim, String accidentType, String accidentDate,String compensationAmount) {
        this.id=++seq;
        this.c = c;
        this.p=p;
        this.dateClaim = dateClaim;
        this.accidentType = accidentType;
        this.accidentDate = accidentDate;
        this.compensationAmount=compensationAmount; 
         damages=new ArrayList<String>();
        
        
    }
    

    public Customer getC() {
        return c;
    }

    public int getId() {
        return id;
    }

    public Policy getPolicy() {
        return p;
    }

    public ArrayList<String> getDamages() {
        return damages;
    }

   

    public String getDateClaim() {
        return dateClaim;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public String getAccidentDate() {
        return accidentDate;
    }

    public String getCompensationAmount() {
        return compensationAmount;
    }

    public boolean getStatus() {
        return status;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public void setPolicy(Policy p) {
        this.p = p;
    }

    public void setDateClaim(String dateClaim) {
        this.dateClaim = dateClaim;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    public void setAccidentDate(String accidentDate) {
        this.accidentDate = accidentDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Claim{" + "id=" + id + ", client=" + c + ", policy=" + p + ", dateClaim=" + dateClaim + ", accidentType=" + accidentType + ", accidentDate=" + accidentDate + ", damages=" + damages + '}';
    }
    public String damagesString(){
        String s="Damages:\t";;
        for(int i=0;i<damages.size();i++){
            s=damages.get(i)+"     ";
           
        }
        return s;
    }

    

    
    
}
