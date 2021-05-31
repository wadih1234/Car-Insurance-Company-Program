
package carinsurancecompany;

import java.util.*;
public class Vehicule {
    private int id=0;
    private String model;
    private String brand;
    private String body;
    private double value;
    private String engine;
    private String year;
    private String plateNo;
    private String horsePower;
    private String usage;
    private int nbPassengers;
    private static int counter=0;
    private ArrayList<String> state;
    private Customer c;
    public Vehicule(){}
    public Vehicule(String m,String b,String bo,double v,String e,String y,String p,String h,String u,int n,Customer c){
        this.id=++this.counter;
        this.model=m;
        this.brand=b;
        this.body=bo;
        this.value=v;
        this.engine=e;
        this.year=y;
        this.plateNo=p;
        this.horsePower=h;
        this.usage=u;
        this.nbPassengers=n;
        this.state=new ArrayList<String>();
        this.c=c;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setNbPassengers(int nbPassengers) {
        this.nbPassengers = nbPassengers;
    }

    

    public void setState(ArrayList<String> state) {
        this.state = state;
    }

    public  int getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getBody() {
        return this.body;
    }

    public double getValue() {
        return this.value;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getYear() {
        return this.year;
    }

    public String getPlateNo() {
        return this.plateNo;
    }

    public String getHorsePower() {
        return this.horsePower;
    }

    public String getUsage() {
        return this.usage;
    }

    public int getNbPassengers() {
        return this.nbPassengers;
    }

    public Customer getC() {
        return c;
    }
    
    public ArrayList<String> getState() {
        return this.state;
    }
    public boolean equals(Vehicule v){
        if(this==null || v==null) return false;
        if(this.body.equals(v.body) && this.brand.equals(v.brand) && this.engine.equals(v.engine) && this.horsePower.equals( v.horsePower)
           && this.model.equals(v.model) && this.nbPassengers==v.nbPassengers  && this.usage.equals(v.usage)
            && this.plateNo.equals(v.plateNo) && this.year.equals(v.year) && this.value==v.value && this.c.equals(v.c)) return true;
   return false;
    }
    @Override
    public String toString() {
        return "Vehicule{" +"id"+id+ "model=" + model + ", brand=" + brand + ", body=" + body + ", value=" + value + ", engine=" + engine + ", year=" + year + ", plateNo=" + plateNo + ", horsePower=" + horsePower + ", usage=" + usage + ", nbPassengers=" + nbPassengers + ", state=" + state + '}';
    }
    
}
