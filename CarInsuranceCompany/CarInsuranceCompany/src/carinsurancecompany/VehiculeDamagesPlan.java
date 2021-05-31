
package carinsurancecompany;


public class VehiculeDamagesPlan extends InsurancePlan {
     String damage="vehiclue damages";
     Risk1 risk1;Risk2 risk2;
    public VehiculeDamagesPlan(Customer c,Vehicule v){
       super(v,c);
        risk1=new Risk1();
        risk2=new Risk2();
        damages.put(damage,3000);
    }

    
    
     public double sommePremium(){
       return  (risk1.calculatePremium(v)+risk2.calculatePremium(v))* v.getValue();
     }
     public double allRisksCoverage(){
         return Math.max(risk1.calculateCoverage(v),risk2.calculateCoverage(v))* v.getValue();
     }

   
    public double sommeCoveragePourcentage() {
       return risk1.coverage+risk2.coverage;
    }
}
