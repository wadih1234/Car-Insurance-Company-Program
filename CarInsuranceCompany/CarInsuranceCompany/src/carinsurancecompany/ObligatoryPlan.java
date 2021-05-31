
package carinsurancecompany;

public class ObligatoryPlan extends InsurancePlan{
    String damage="From others";
    Risk1 risk1;Risk3 risk3;
    public ObligatoryPlan(Customer c,Vehicule v){
        super(v,c);
        risk1=new Risk1();
        risk3=new Risk3();
        damages.put(damage,1000);
    }
    public double sommePremium(){
       return  (risk1.calculatePremium(v)+risk3.calculatePremium(v))*v.getValue();
     }
     public double allRisksCoverage(){
         return Math.max(risk1.calculateCoverage(v),risk3.calculateCoverage(v))* v.getValue();
     }
    
    
    public double sommeCoveragePourcentage() {
       return risk1.coverage+risk3.coverage;
    }
   
   
}