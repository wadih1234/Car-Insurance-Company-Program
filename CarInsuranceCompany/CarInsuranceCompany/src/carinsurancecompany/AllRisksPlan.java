
package carinsurancecompany;


public class AllRisksPlan extends InsurancePlan{
  
    Risk1 risk1;Risk2 risk2;Risk3 risk3;
   public AllRisksPlan(Customer c,Vehicule v){
        super(v,c);
        risk1=new Risk1();
        risk2=new Risk2();
        risk3=new Risk3();
       damages.put("Bodily damages",2000);
       damages.put("vehicule damages",3000);
       damages.put("From others",1000);
   
   }
    
    public double sommePremium(){
       return  (risk1.calculatePremium(v)+risk2.calculatePremium(v)+risk3.calculatePremium(v))* v.getValue();
     }
     public double allRisksCoverage(){
         double result=0.0;
         return (risk1.calculateCoverage(v)+risk2.calculateCoverage(v)+risk3.calculateCoverage(v)) * v.getValue();
     }
     public double sommeCoveragePourcentage() {
       return risk1.coverage+risk2.coverage+risk3.coverage;
    }
}
