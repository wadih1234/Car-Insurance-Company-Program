
package carinsurancecompany;

import java.util.*;
public class Customer{
   private int id=0;
   private String firstName;
   private String lastName;
   private String FatherName;
   private char gender;
   private String dateBirth;
   private String mobile;
   private String city;
   private String job;
   Set<Vehicule> vehicules;
   private ArrayList<Policy> p;
   private static int number=0;
   public Customer(){
       
   }
   
   public Customer(String f,String l,String fa,char g,String d,String m,String c,String j){
       this.id=++this.number;
      this.firstName=f;
      this.lastName=l;
      this.FatherName=fa;
      this.gender=g;
      this.dateBirth=d;
      this.mobile=m;
      this.city=c;
      this.job=j;
      this.vehicules=new HashSet<Vehicule>();
      this.p=new ArrayList<Policy>();
   }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
    public void addVehicule(Vehicule v) {
        this.vehicules.add(v);
    }

    public ArrayList<Policy> getPolicies() {
        return p;
    }

    public void addPolicy(Policy p) {
        this.p.add(p);
    }
    
   public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setPolicy(Policy p){
        this.p.add(p);
    }
    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public char getGender() {
        return this.gender;
    }

    public String getDateBirth() {
        return this.dateBirth;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getCity() {
        return this.city;
    }

    public String getJob() {
        return job;
    }

    
    

    public Set<Vehicule> getVehicules() {
        return this.vehicules;
    }

    public boolean equals(Customer c){
        if(this==null || c==null) return false;
        if(this.FatherName.equals(c.FatherName) && this.firstName.equals(c.firstName) && this.lastName.equals(c.lastName)
              &&  this.dateBirth.equals(c.dateBirth) && this.mobile.equals(c.mobile)
                ) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", FatherName=" + FatherName + ", gender=" + gender + ", dateBirth=" + dateBirth + ", mobile=" + mobile + ", city=" + city + ", job=" + job + ", vehicules=" + vehicules + ", p=" + p + '}';
    }
    

    
    

    
       
}
