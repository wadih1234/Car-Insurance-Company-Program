
package carinsurancecompany;

import java.util.*;
public abstract class InsurancePlan  {
    Vehicule v;
    Customer c;
    HashMap<String,Integer> damages=new HashMap<String,Integer>();
    public InsurancePlan(Vehicule v,Customer c){
        this.v=v;
        this.c=c;
        damages=new HashMap<String,Integer>();
    }
    abstract public double sommePremium();
    abstract public double allRisksCoverage();
    abstract public double sommeCoveragePourcentage();
}
