
package carinsurancecompany;


public class Risk1 implements CalculateRisks {

    double premium,coverage;
    public double calculatePremium(Vehicule v) {
       if(v.getValue()<=10000) premium=0.025;
       else if(v.getValue()<=20000) premium=0.027;
       else premium=0.029;
       return premium;
    }

   
    public double calculateCoverage(Vehicule v) {
        if(v.getValue()<=10000) coverage=0.18;
        else if(v.getValue()<=20000) coverage=0.30;
        else coverage=0.20;
        return coverage;
    }
    
}
