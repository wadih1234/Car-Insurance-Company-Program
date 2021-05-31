
package carinsurancecompany;


public class PersonalPlan extends InsurancePlan {
    
    String damage="Bodily damages";
    Risk2 risk2;
    public PersonalPlan(Customer c,Vehicule v){
            super(v,c);
        risk2=new Risk2();
        damages.put("Bodily damages",2000);
        
    }
    
    public double sommePremium(){
       return  risk2.calculatePremium(v)*v.getValue();
     }
     public double allRisksCoverage(){
         return risk2.calculateCoverage(v)* v.getValue();
     }
     public double sommeCoveragePourcentage() {
       return risk2.coverage;
    }
}
