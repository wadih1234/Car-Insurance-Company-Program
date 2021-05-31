
package carinsurancecompany;

import java.util.*;
public class Model extends Observable {
    MyList<Customer> allCustomers=new MyList<Customer>();
    MyList<Vehicule> allVehicules=new MyList<Vehicule>();
    ArrayList<Claim> allClaims=new ArrayList<Claim>();
    ArrayList<Policy> allPolicies=new ArrayList<Policy>();
    List<Payment> allPayments=new ArrayList<Payment>();
    List<Receipt> allReceipts=new ArrayList<Receipt>();
    public Model(){
        this.notifyObservers();
        this.setChanged();
    }
    public void setAllCustomers(MyList<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }

    public void setAllClaims(ArrayList<Claim> allClaims) {
        this.allClaims = allClaims;
    }

    public void setAllVehicules(MyList<Vehicule> allVehicules) {
        this.allVehicules = allVehicules;
    }

    

    public MyList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public MyList<Vehicule> getAllVehicules() {
        return allVehicules;
    }
    
    

      


}
