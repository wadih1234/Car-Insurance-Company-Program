
package carinsurancecompany;


public class Receipt {
    private  int id=0;
    Policy p;
    private static int seq=0;
    
    public Receipt(Policy p){
        this.p=p;
        this.id=++seq;
    }
  public Receipt(){this.id=++seq;}
    public  int getId() {
        return id;
    }

    public Policy getPolicy() {
        return p;
    }

    public void setPolicy(Policy p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Receipt{" + "id=" + id + ", p=" + p + '}';
    }
    
}
