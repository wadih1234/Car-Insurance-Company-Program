
package carinsurancecompany;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class SettlementsPanel extends JPanel implements Observer {
    JLabel title,customerCustomerId,customerDatePayement,customerPrime,customerPolicy,claimId,
           policyId,payementValue,payementFor,companyCustomerId,companyDatePayement,prime,formatDate,formatDate2;
    JTextField customerDatePayementTxt,companyDatePayementTxt,
            PrimeTxt,payementValueTxt,payementForTxt,customerCustomerIdTxt,companyCustomerIdTxt;
    JComboBox claims,policiesCombo1,policiesCombo2,timeCombo1,timeCombo2;
    JButton PayBtn,clearBtn;
    JRadioButton customerRadio,CompanyRadio;
    ButtonGroup groupRadio;
    Font fontTitle,f2;
    Model dataModel;
    JPanel titlePanel,southPanel,westPanel,eastPanel,customerPanel,companyPanel,titleRadioPanel,radioPanel,customerDatePanel,companyDatePanel,datePanel,datePanel2;
   String time1[]={"MORNING","NOON","AFTER NOON","NIGHT"};
 String time2[]={"MORNING","NOON","AFTER NOON","NIGHT"};
    public SettlementsPanel(Model m){
        dataModel=m;
        setSize(900,600);
        setLayout(new BorderLayout());
        fontTitle=new Font("Arial",Font.BOLD+Font.ITALIC,23);
        title=new JLabel("Pay Settlements Page");
        title.setFont(fontTitle);
        title.setForeground(Color.RED);
        f2=new Font("Arial",Font.BOLD+Font.ITALIC,13);
        
        customerCustomerId=new JLabel("Customer ID:");
        customerDatePayement=new JLabel("Date of Payement:");
        companyCustomerId=new JLabel("Customer ID:");
        companyDatePayement=new JLabel("Date of Payement:");
        prime=new JLabel("Value to Pay:");
        
        formatDate=new JLabel("(dd/mm/yyyy hh:mm)");
        formatDate.setFont(f2);
        formatDate.setForeground(Color.blue);
        
        formatDate2=new JLabel("(dd/mm/yyyy hh:mm)");
        formatDate2.setFont(f2);
        formatDate2.setForeground(Color.blue);
        
        customerPolicy=new JLabel("Policy ID:");
        payementValue=new JLabel("Value to Pay:");
         payementFor=new JLabel("Pay For:");
         claimId=new JLabel("Claim ID:");
         
         
         
        payementValueTxt=new JTextField(15);
        
        customerDatePayementTxt=new JTextField(15);
        customerCustomerIdTxt=new JTextField(15);
        
        companyCustomerIdTxt=new JTextField(15);
       
        
        companyDatePayementTxt=new JTextField(15);
        PrimeTxt=new JTextField(15);
        PrimeTxt.setEditable(false);
        payementForTxt=new JTextField(15);
        
       
        claims=new JComboBox();
        
        
        
        
        timeCombo1=new JComboBox(time1);
        timeCombo2=new JComboBox(time2);
        policiesCombo1=new JComboBox();
       
        
        PayBtn=new JButton("Pay To Company");
        clearBtn=new JButton("Clear");
        
        
        customerRadio=new JRadioButton("Customer Payment");
        CompanyRadio=new JRadioButton("Company Payment");
        customerRadio.setSelected(true);
        groupRadio=new ButtonGroup();
        groupRadio.add(CompanyRadio);groupRadio.add(customerRadio);
        customerRadio.addActionListener(new RadiosAction());
        CompanyRadio.addActionListener(new RadiosAction());
        radioPanel=new JPanel();
        radioPanel.add(customerRadio);radioPanel.add(CompanyRadio);
        
        titlePanel=new JPanel();
        titlePanel.add(title,FlowLayout.LEFT);
        titlePanel.setPreferredSize(new Dimension(0,70));
 
        titleRadioPanel=new JPanel(new GridLayout(2,1));
        titleRadioPanel.add(titlePanel);titleRadioPanel.add(radioPanel);
        
        datePanel=new JPanel(new GridLayout(2,1));
        datePanel.add(customerDatePayement);datePanel.add(formatDate);
        
        
        
        customerDatePanel=new JPanel();
        customerDatePanel.add(customerDatePayementTxt);customerDatePanel.add(timeCombo1);
        
        companyDatePanel=new JPanel();
        companyDatePanel.add(companyDatePayementTxt);companyDatePanel.add(timeCombo2);
        add(titleRadioPanel,BorderLayout.NORTH);
        westPanel=new JPanel();eastPanel=new JPanel();southPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        westPanel.setPreferredSize(new Dimension(110,0));
        add(westPanel,BorderLayout.WEST);
        eastPanel.setPreferredSize(new Dimension(110,0));
        add(eastPanel,BorderLayout.EAST);
        southPanel.setPreferredSize(new Dimension(0,70));
        southPanel.add(clearBtn);southPanel.add(PayBtn);
        add(southPanel,BorderLayout.SOUTH);
        
        customerPanel=new JPanel(new GridLayout(4,2,10,50));        
        customerPanel.add(customerCustomerId);customerPanel.add(customerCustomerIdTxt);
        customerPanel.add(datePanel);customerPanel.add(customerDatePanel);
        customerPanel.add(customerPolicy);customerPanel.add(policiesCombo1);
        customerPanel.add(prime);customerPanel.add(PrimeTxt);
       
        add(customerPanel,BorderLayout.CENTER);
        
        datePanel2=new JPanel(new GridLayout(2,1));
        datePanel2.add(companyDatePayement);datePanel2.add(formatDate2);
        
        companyPanel=new JPanel(new GridLayout(6,2,20,30));
        companyPanel.add(companyCustomerId);companyPanel.add(companyCustomerIdTxt);
        companyPanel.add(claimId);companyPanel.add(claims);
        
        companyPanel.add(datePanel2);companyPanel.add(companyDatePanel);
        companyPanel.add(payementValue);companyPanel.add(payementValueTxt);
        companyPanel.add(payementFor);companyPanel.add(payementForTxt);
      //add(companyPanel,BorderLayout.CENTER);
     clearBtn.addActionListener(new RadiosAction());
     PayBtn.addActionListener(new RadiosAction());
     customerCustomerIdTxt.addFocusListener(new Focus2());
     companyCustomerIdTxt.addFocusListener(new Focus());
        dataModel.addObserver(this);
       //Pour Client Page
        policiesCombo1.addItemListener(new ItemListener(){
             

           
            public void itemStateChanged(ItemEvent ie) {
                               Policy policy = null;
                 if(customerCustomerIdTxt.getText().length()!=0){
                Customer c=getCustomerById(dataModel.allCustomers.values,customerCustomerIdTxt.getText());
                for(int i=0;i<dataModel.allCustomers.getElement(c).getPolicies().size();i++){
                    if(policiesCombo1.getSelectedIndex()!=-1){
                    if(dataModel.allCustomers.getElement(c).getPolicies().get(i).getId() == Integer.parseInt(policiesCombo1.getSelectedItem().toString()))
                         policy=dataModel.allCustomers.getElement(c).getPolicies().get(i);
                }
                }
                if(policy!=null)
                PrimeTxt.setText(policy.getPremium()+"");
            }
            }
        
        });
        
        claims.addItemListener(new ItemListener()
        
        {
        
        
         public void itemStateChanged(ItemEvent ie) {
           
                         
                      Customer c=null;
                      Claim claim=null;
                     
               if(companyCustomerIdTxt.getText().length()!=0){
                 c=getCustomerById(dataModel.allCustomers.values,companyCustomerIdTxt.getText());
                
                  if(claims.getSelectedIndex()!=-1)
                   claim=getClaimById(dataModel.allClaims,claims.getSelectedItem().toString());
                
             if(claim!=null){
                 
                 payementValueTxt.setText(getValueToPayByCompany(claim.getPolicy(),claim)+"");
             }   
               }
            }
        
        
        
        }
        );
        
        
        
        
        
        
       
    }
    public void update(Observable o,Object o1){
        
    }
    int counter=0;
    public class RadiosAction extends UtilitiesFunctions implements ActionListener{
        String errorTxt="";  int id=1;
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==CompanyRadio){
                if(counter==0){
                customerPanel.setVisible(false);
                add(companyPanel,BorderLayout.CENTER);
                counter++;
                }
                if(counter>0){
                  customerPanel.setVisible(false);
                  companyPanel.setVisible(true);
                }
                PayBtn.setText("Pay to Customer");
            }
            if(e.getSource()==customerRadio){
                companyPanel.setVisible(false);
                customerPanel.setVisible(true);
            PayBtn.setText("Pay to Company");
            }
            
            if(e.getSource()==clearBtn){
                if(customerPanel.isVisible()){
                    customerDatePayementTxt.setText("");
                    policiesCombo1.setSelectedIndex(-1);PrimeTxt.setText("");
                }
                else{
                    claims.setSelectedIndex(-1);
                    companyDatePayementTxt.setText("");payementValueTxt.setText("");payementForTxt.setText("");
                }
                
            }
            
            
            
            
           
            
            
            
            
           if(e.getSource()==PayBtn){
               if(customerPanel.isVisible()){
                   errorTxt="";
                   companyPanel.setVisible(false);
                   
                   if(!checkDateTime(customerDatePayementTxt.getText())) errorTxt+="Invalid date of payement"+"\n";
                   if(policiesCombo1.getSelectedIndex()==-1) errorTxt+="Please choose policy id"+"\n";
                   Policy policy=getPolicyById(dataModel.allPolicies,policiesCombo1.getSelectedItem().toString());
                   if(checkDueDate(customerDatePayementTxt.getText(),policy.getStartDate())<0) errorTxt+="Date of payment should be greater or equal than policy start date!";
            
               if(errorTxt.length()!=0) JOptionPane.showMessageDialog(null, errorTxt, "Error", JOptionPane.ERROR_MESSAGE);
               
              
               if(errorTxt.length()==0)
               {
               if(customerCustomerIdTxt.getText().length()!=0){
               Customer c=getCustomerById(dataModel.allCustomers.values,customerCustomerIdTxt.getText());
               String datePayment=customerDatePayementTxt.getText();
               
               ArrayList<Policy> policies=new ArrayList<Policy>();
                Policy p=null;
                policies=dataModel.allCustomers.getElement(c).getPolicies();
                for(int i=0;i<policies.size();i++){
                if(policies.get(i).getId()==Integer.parseInt(policiesCombo1.getSelectedItem().toString()))
                {
               p=policies.get(i);break;
                
                }
                
              
            }
                if(p.getStatus()==false){
               p.setStatus(true);
               Payment cPay=new CustomerPayment(c,datePayment,p);
               if(cPay!=null)
               cPay.setValueToPay(Double.parseDouble(PrimeTxt.getText()));
              dataModel.allPayments.add(cPay);
               Receipt r=new Receipt(p);
               dataModel.allReceipts.add(r);
               JOptionPane.showMessageDialog(null,"Payment successfull!\n Receipt Id:"+cPay.getId()+"\nPlease go to search frame for more informations","Payment successfull",JOptionPane.INFORMATION_MESSAGE);
               
               }
                else{
                    JOptionPane.showMessageDialog(null,"Policy already paid!");
                }
               }
               }
               
               
               
               
               
               
               
               }
              if(companyPanel.isVisible()){
                  customerPanel.setVisible(false);
                  
                  errorTxt="";
                  if(!checkStringNumberFormat(companyCustomerIdTxt.getText())) errorTxt+="invalid Customer Id"+"\n";
                   if(claims.getSelectedIndex()==-1) errorTxt+="Please choose claim Id"+"\n";         
              
                  if(!checkDateTime(companyDatePayementTxt.getText())) errorTxt+="Invalid date of Payement"+"\n" ;
                   if(!checkString(payementForTxt.getText())) errorTxt+="Invalid third-party"+"\n";
                   Claim cla=getClaimById(dataModel.allClaims,claims.getSelectedItem().toString());
                   if(checkDueDate(companyDatePayementTxt.getText(),cla.getDateClaim())<0) errorTxt+="Date of payment should be equal or greater to claim date";
                   
                   
                   
                   if(errorTxt.length()!=0) JOptionPane.showMessageDialog(null, errorTxt, "Error", JOptionPane.ERROR_MESSAGE);
              
              
              if(errorTxt.length()==0){
                
                 if(companyCustomerId.getText().length()!=0){
                Customer c=getCustomerById(dataModel.allCustomers.values,companyCustomerIdTxt.getText());
                String datePayment=companyDatePayementTxt.getText();
                String valueToPay=payementValueTxt.getText();
                String payFor=payementForTxt.getText();
                Claim claim=getClaimById(dataModel.allClaims,claims.getSelectedItem().toString());
                    if(claim.getStatus()==false){
                    Payment p=new CompanyPayment(c,datePayment,claim, payFor);
                    p.setValueToPay(Double.parseDouble((valueToPay)));
                    p.setDatePayment(datePayment);
                    p.setC(c);
                    claim.setStatus(true);
                    dataModel.allPayments.add(p);
                    Receipt r=new Receipt();
                    dataModel.allReceipts.add(r);
                    id++;
                    JOptionPane.showMessageDialog(null,"Payment successfull!\n Receipt Id:"+id +"\nPlease go to search frame for more informations","Payment successfull",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"This claim is paid!","error", JOptionPane.INFORMATION_MESSAGE);
                    }
                
                
                 }
              }
              
              
              
              
              
              
              
              
              
              
              } 
               
           } 
            
    
        }
     
    
}
    public class Focus2 implements FocusListener{

       
        public void focusGained(FocusEvent fe) {
            if(customerPanel.isVisible()){
                policiesCombo1.removeAllItems();
                PrimeTxt.setText("");
            }
           
        
        }
        public void focusLost(FocusEvent fe){
            if(customerPanel.isVisible()){
              
             if(customerCustomerIdTxt.getText().length()==0 || !checkStringNumberFormat(customerCustomerIdTxt.getText())) { JOptionPane.showMessageDialog(null,"Please Enter valid customer Id","Error",JOptionPane.ERROR_MESSAGE);
               policiesCombo1.removeAllItems();
             }
              
              if(customerCustomerIdTxt.getText().length() !=0) 
                if(getCustomerById(dataModel.allCustomers.values,customerCustomerIdTxt.getText())==null) JOptionPane.showMessageDialog(null,"Customer not exist", "Error", JOptionPane.ERROR_MESSAGE);
                else{
                if(customerCustomerIdTxt.getText().length()!=0) {
                //get the customer by his id
                Customer c=getCustomerById(dataModel.allCustomers.values,customerCustomerIdTxt.getText());
                ArrayList<Policy> policies=new ArrayList<Policy>();
                policies.addAll(dataModel.allCustomers.getElement(c).getPolicies());
                //add policies to combo
                policiesCombo1.removeAllItems();
                for(int i=0;i<policies.size();i++){
                    policiesCombo1.addItem(policies.get(i).getId()+"");
                }
               
                
                }    
                
                
                
                
                }
             
           
           }
        }
    
    }
    public class Focus implements FocusListener{

       
        public void focusGained(FocusEvent fe) {
            
            if(companyPanel.isVisible()){
               
                claims.removeAllItems();
                PrimeTxt.setText("");
            }
            
        }

        @Override
        public void focusLost(FocusEvent fe) {
           
            if(companyPanel.isVisible()){
              
               if(companyCustomerIdTxt.getText().length()==0 || !checkStringNumberFormat(companyCustomerIdTxt.getText())) JOptionPane.showMessageDialog(null,"Please enter customer Id","error", JOptionPane.ERROR_MESSAGE);
               else{
                   
               Customer c=getCustomerById(dataModel.allCustomers.values,companyCustomerIdTxt.getText());
               ArrayList<Claim> customerClaims=getCustomerClaims(c);
               
               for(int i=0;i<customerClaims.size();i++){
                   claims.addItem(customerClaims.get(i).getId()+"");
               }
               
               
               
               }
           
             
         }
                   
      }
        
    }
    
    
    


public int getCustomerId(ArrayList<Customer> customers,String s){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getId()==Integer.parseInt(s)) return customers.get(i).getId();
        }
        return 0;
    }
     
   public int getVehiculeId(ArrayList<Customer> customers,String s){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getId()==Integer.parseInt(s)) return customers.get(i).getId();
        }
        return 0;
    }
   public Claim getClaimById(ArrayList<Claim> claims,String s){
       for(int i=0;i<claims.size();i++){
           if(claims.get(i).getId()==Integer.parseInt(s)) return claims.get(i);
       }
       return null;
   }
   public Policy getPolicyById(ArrayList<Policy> policies,String s){
       for(int i=0;i<policies.size();i++){
           if(policies.get(i).getId()==Integer.parseInt(s)) return policies.get(i);
       }
       return null;
   }
    
    public Customer getCustomerById(ArrayList<Customer> customers,String s){
        Customer c=new Customer();
        for(int i=0;i<customers.size();i++){
            if(!checkStringNumberFormat(s)) return null;
            if(customers.get(i).getId()==Integer.parseInt(s)) return customers.get(i);
        }
        return null;
    }
   public boolean checkStringNumberFormat(String s){
          if(s.length()==0) return false;
               char[] tab=s.toCharArray();
               
               for(int i=0;i<tab.length;i++){
                   int toInt=tab[i];
                 if(toInt<48 || toInt>57) return false;
               }
               return true;
      }
    
    public ArrayList<Claim> getCustomerClaims(Customer c){
        ArrayList<Claim> allClaims=dataModel.allClaims;
        ArrayList<Claim> customerClaims=new ArrayList<Claim>();
        for(int i=0;i<allClaims.size();i++){
            if(!customerClaims.contains(allClaims.get(i))){  
            if(allClaims.get(i).getC().getId() == c.getId() ){customerClaims.add(allClaims.get(i));}
        }
        
        }
        return customerClaims;
        
        
    }
    
    public double getValueToPayByCompany(Policy p,Claim c){
        double compensationAmount=Double.parseDouble(c.getCompensationAmount());
        double coveragePourcentage=0.0;
        double valuePourcentage=0.0;
        ArrayList<InsurancePlan> policyPlans=p.getPlan();
           for(int i=0;i<policyPlans.size();i++){
               if(policyPlans.get(i) instanceof AllRisksPlan) {coveragePourcentage=1;break;}
               coveragePourcentage+=policyPlans.get(i).sommeCoveragePourcentage();
           }
           valuePourcentage=(compensationAmount*coveragePourcentage)/p.getVehiculeConcerned().getValue();
           return p.getVehiculeConcerned().getValue() * valuePourcentage;
           
    }
   
    public int calculateDamages(Policy p){
       ArrayList<InsurancePlan> plans=p.getPlan();
       int result=0;
       HashMap<String,Integer> allPlansDamages=new HashMap<String,Integer>();
       for(int i=0;i<plans.size();i++){
           
           allPlansDamages.putAll(plans.get(i).damages);
         
       }
      for(Map.Entry<String,Integer> set : allPlansDamages.entrySet())
      {
          result+=set.getValue();
      }        
       return result;
        
    }
    
    public int checkDueDate(String d1,String d2){
        
        int res=0;
        SimpleDateFormat sdFormat=new SimpleDateFormat("dd/mm/yyyy");
       try{
           Date date11=sdFormat.parse(d1);
           Date date12=sdFormat.parse(d2);
           res=date11.compareTo(date12);
           
       }catch(Exception e){
           
       }
       return res;
    }
    


}
