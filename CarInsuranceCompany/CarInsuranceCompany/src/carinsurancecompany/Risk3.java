
package carinsurancecompany;


public class Risk3 implements CalculateRisks {

    double premium,coverage;
    public double calculatePremium(Vehicule v) {
       if(v.getValue()<=10000) premium=0.012;
       else if(v.getValue()<=20000) premium=0.014;
       else premium=0.016;
       return premium;
    }

   
    public double calculateCoverage(Vehicule v) {
        if(v.getValue()<=10000) coverage=0.37;
        else if(v.getValue()<=20000) coverage=0.40;
        else coverage=0.45;
        return coverage;
    }
    
}
