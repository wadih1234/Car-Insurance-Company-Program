
package carinsurancecompany;

import java.util.*;


public class Policy {
    private  int id=0;
    private Customer policyHolder;
    private Vehicule vehiculeConcerned;
    private String startDate;
    private String endDate;
    private double premium;
   private double coverage;
   private static int seq=0;
   private boolean status=false;
    private ArrayList<InsurancePlan> plan;
    public Policy(){}

   public Policy(Customer policyHolder, Vehicule vehiculeConcerned, String startDate, String endDate,double premium,double coverage) {
       this.id=++this.seq; 
       this.policyHolder = policyHolder;
        this.vehiculeConcerned = vehiculeConcerned;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = new ArrayList<InsurancePlan>();
        this.premium=premium;
        this.coverage=coverage;
    }

   

    public void setPolicyHolder(Customer policyHolder) {
        this.policyHolder = policyHolder;
    }

    public void setVehiculeConcerned(Vehicule vehiculeConcerned) {
        this.vehiculeConcerned = vehiculeConcerned;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public void setPlan(ArrayList<InsurancePlan> plan) {
        this.plan = plan;
    }

    public  int getId() {
        return this.id;
    }

    public boolean getStatus() {
        return status;
    }
  
    public Customer getPolicyHolder() {
        return this.policyHolder;
    }

    public Vehicule getVehiculeConcerned() {
        return this.vehiculeConcerned;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public double getPremium() {
        return premium;
    }

    public double getCoverage() {
        return coverage;
    }

    public ArrayList<InsurancePlan> getPlan() {
        return plan;
    }

   
//    public String toString() {
//        return "Policy{" + "policyHolder=" + policyHolder + ", vehiculeConcerned=" + vehiculeConcerned + ", startDate=" + startDate + ", endDate=" + endDate + ", premium=" + premium + ", coverage=" + coverage;
//   }
   
    
}
