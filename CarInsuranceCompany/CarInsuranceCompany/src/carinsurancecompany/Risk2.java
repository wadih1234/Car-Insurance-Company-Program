
package carinsurancecompany;


public class Risk2 implements CalculateRisks {

    double premium,coverage;
    public double calculatePremium(Vehicule v) {
       if(v.getValue()<=10000) premium=0.030;
       else if(v.getValue()<=20000) premium=0.032;
       else premium=0.034;
       return premium;
    }

   
    public double calculateCoverage(Vehicule v) {
        if(v.getValue()<=10000) coverage=0.45;
        else if(v.getValue()<=20000) coverage=0.30;
        else coverage=0.35;
        return coverage;
    }
    
}
