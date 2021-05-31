
package carinsurancecompany;

public abstract class Payment {
  private int id=0;
  Customer c;
  String datePayment;
  Policy p;
  double valueToPay;
   boolean status=false;
  private static int seq=0;
    public Payment(Customer c, String datePayment, Policy p) {
        this.id=++seq;
        this.c = c;
        this.datePayment = datePayment;
        this.p = p;
        
    }
public Payment(){



}

    public void setStatus(boolean status) {
        this.status = status;
    }

   

    public void setC(Customer c) {
        this.c = c;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public void setP(Policy p) {
        this.p = p;
    }

    public void setValueToPay(double valueToPay) {
        this.valueToPay = valueToPay;
    }

    public int getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return c;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public Policy getPolicy() {
        return p;
    }

    public double getValueToPay() {
        return valueToPay;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", c=" + c + ", datePayment=" + datePayment + ", p=" + p + ", valueToPay=" + valueToPay + '}';
    }
  
  
}
