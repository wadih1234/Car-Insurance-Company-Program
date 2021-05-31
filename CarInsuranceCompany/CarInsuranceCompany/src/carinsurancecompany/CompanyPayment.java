
package carinsurancecompany;


public class CompanyPayment extends Payment {
    Claim claim;
    String payFor;
   String valueToPay;
   
    public CompanyPayment(Customer c, String datePayment, Policy p,Claim claim, String payFor) {
        super(c,datePayment,p);
        this.claim = claim;
        this.payFor = payFor;
    }
public CompanyPayment(Customer c, String datePayment,Claim claim, String payFor) {
        
        this.claim = claim;
        this.payFor = payFor;
    }
    public Claim getClaim() {
        return this.claim;
    }

    public String getPayFor() {
        return this.payFor;
    }

    public void setC(Customer c) {
        this.c = c;
    }
public Customer getC(){
    return c;
}
    public void setValueToPay(String valueToPay) {
        this.valueToPay = valueToPay;
    }

    public String getValue() {
        return valueToPay;
    }

    public void setDate(String s){
        datePayment=s;
    }
    public String getDate(){
        return datePayment;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public void setPayFor(String payFor) {
        this.payFor = payFor;
    }

    
    
   
}
