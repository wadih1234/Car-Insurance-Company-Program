
package carinsurancecompany;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.event.*;
public class RegisterClaimPanel extends JPanel implements Observer {
    JLabel title,accidentDate,clientId,accidentType,damages,dateClaim,formatDate1,formatDate2,vehiculeId,compensationAmount;
    JTextField accidentDateTxt,dateClaimTxt,damagesTxt,clientIdTxt,compensationAmountTxt;
    JComboBox accidentTypes,times1Combo,times2Combo,policiesCombo;
    JButton clear,register;
    Font f,f2;
    JCheckBox damage1,damage2,damage3;
    Model dataModel;
     String customerIds[];
    String[] carParts={"Front WindScreen","Rear WindScreen","Left rear door glass","Driver front door glass",
   "Right rear door glass","Right-Front door glass","Driver front door","Left rear door","Right-front door",
   "Right rear door","2 WindScreensWipers","1 WindScreenWiper","bumper","Left Mirror","Right Mirror",
   "Front-Left turn signal","Front-Right turn signal","Back-Left turn signal","Back-Right turn signal",
   "Front-Left tire","Front-Right tire","Back-Left tire","Back-Right tire","Hood"};
    String time1[]={"MORNING","NOON","AFTER NOON","NIGHT"}; 
    String time2[]={"MORNING","NOON","AFTER NOON","NIGHT"}; 
    String [] types={"vehicule roll-over","side impact collision","head-on collision","rear-End collision"};
    JPanel mainPanel,westPanel,eastPanel,northPanel,southPanel,datePanel1,datePanel2,claimComboPanel,accidentDatePanel,damagesPanel;
    public RegisterClaimPanel(Model m){
        dataModel=m;
        setSize(900,600);
        setLayout(new BorderLayout());
        f=new Font("Arial",Font.BOLD+Font.ITALIC,23);
        f2=new Font("Arial",Font.BOLD+Font.ITALIC,13);
        title=new JLabel("Register Claim");
        title.setFont(f);
        title.setForeground(Color.RED);
        clientId =new JLabel("Client Id:");
        accidentType=new JLabel("Accident Type:");
        accidentDate=new JLabel("Accident Date:");
        damages =new JLabel("Damages");
        dateClaim=new JLabel("Date Claim:");
        formatDate1=new JLabel("(dd/mm/yyyy hh:mm)");
        formatDate2=new JLabel("(dd/mm/yyyy hh:mm)");
        formatDate1.setFont(f2);formatDate2.setFont(f2);
        formatDate1.setForeground(Color.BLUE);formatDate2.setForeground(Color.BLUE);
        clear=new JButton("Clear");
        register=new JButton("Register");
        vehiculeId=new JLabel("Client policies:");
        compensationAmount=new JLabel("Compensation amount(MAX):");
        
       accidentDateTxt=new JTextField(15);
        
        
        clientIdTxt=new JTextField(15);
       
        
        dateClaimTxt=new JTextField(15);
        damagesTxt=new JTextField(15);
        compensationAmountTxt=new JTextField();
        
        accidentTypes=new JComboBox(types);
        times1Combo=new JComboBox(time1);
        times2Combo=new JComboBox(time2);
        policiesCombo=new JComboBox();
       
        
        damage1=new JCheckBox("Bodily");
        damage2=new JCheckBox("Vehicule");
        damage3=new JCheckBox("From others");
        
        
        
        
        datePanel1=new JPanel(new GridLayout(2,1));
        datePanel1.add(dateClaim);datePanel1.add(formatDate1);
        
        datePanel2=new JPanel(new GridLayout(2,1));
        datePanel2.add(accidentDate);datePanel2.add(formatDate2);
        
        
        claimComboPanel=new JPanel();
        claimComboPanel.add(dateClaimTxt);claimComboPanel.add(times1Combo);
        
        accidentDatePanel=new JPanel();
        accidentDatePanel.add(accidentDateTxt);accidentDatePanel.add(times2Combo);
        
        damagesPanel=new JPanel();
        damagesPanel.add(damage1);damagesPanel.add(damage2);damagesPanel.add(damage3);
        mainPanel=new JPanel(new GridLayout(7,2,10,30));
        mainPanel.add(clientId);mainPanel.add(clientIdTxt);
        mainPanel.add(vehiculeId);mainPanel.add(policiesCombo);
        mainPanel.add(datePanel1);mainPanel.add(claimComboPanel);
        mainPanel.add(accidentType);mainPanel.add(accidentTypes);
        mainPanel.add(datePanel2);mainPanel.add(accidentDatePanel);
        mainPanel.add(damages);mainPanel.add(damagesPanel);
        mainPanel.add(compensationAmount);mainPanel.add(compensationAmountTxt);
        
        
        add(mainPanel,BorderLayout.CENTER);
               
       
        westPanel=new JPanel();
        westPanel.setPreferredSize(new Dimension(70,0));
   
        add(westPanel,BorderLayout.WEST);
        eastPanel=new JPanel();
        eastPanel.setPreferredSize(new Dimension(200,0));
        
        add(eastPanel,BorderLayout.EAST);
        northPanel=new JPanel();
        northPanel.add(title);
        add(northPanel,BorderLayout.NORTH);
        northPanel.setPreferredSize(new Dimension(0,70));
        southPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,150,20));
        southPanel.setPreferredSize(new Dimension(0,90));
        southPanel.add(clear);southPanel.add(register);
        add(southPanel,BorderLayout.SOUTH);
        dataModel.addObserver(this);
        clear.addActionListener(new ButtonsActions());
        register.addActionListener(new ButtonsActions());  
        
        clientIdTxt.addFocusListener(new Focus());
        policiesCombo.addItemListener(new ItemListener(){
             

           
            public void itemStateChanged(ItemEvent ie) {
                               Policy policy = null;
                 if(clientIdTxt.getText().length()!=0){
                Customer c=getCustomerById(dataModel.allCustomers.values,clientIdTxt.getText());
                for(int i=0;i<dataModel.allCustomers.getElement(c).getPolicies().size();i++){
                    if(policiesCombo.getSelectedIndex()!=-1){
                    if(dataModel.allCustomers.getElement(c).getPolicies().get(i).getId() == Integer.parseInt(policiesCombo.getSelectedItem().toString().substring(10,11)))
                         policy=dataModel.allCustomers.getElement(c).getPolicies().get(i);
                }
                }
                if(policy!=null)
                compensationAmountTxt.setText(calculateDamages(policy)+"");
            }
            }
        
        });
     
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public class ButtonsActions extends UtilitiesFunctions implements ActionListener{
        String errorTxt="";
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==clear){
                dateClaimTxt.setText("");accidentTypes.setSelectedIndex(-1);
                accidentDateTxt.setText("");damagesTxt.setText("");compensationAmountTxt.setText("");
            }

            if(e.getSource()==register){
                errorTxt="";
                if(!checkStringNumberFormat(clientIdTxt.getText())) errorTxt+="Invalid clientId\n"; 
                if(!checkStringNumberFormat(compensationAmountTxt.getText())) errorTxt+="Invalid amount\n";
                if(!checkDateTime(dateClaimTxt.getText())) errorTxt+="Invalid date"+"\n";
                if(accidentTypes.getSelectedIndex()==-1) errorTxt+="Please choose accident type"+"\n";
                if(!checkDateTime(accidentDateTxt.getText())) errorTxt+="Invalid accident date"+"\n";
                if(!damage1.isSelected() && !damage2.isSelected() && !damage3.isSelected()) errorTxt+="Invalid damages";
                if(checkDueDate(dateClaimTxt.getText(),accidentDateTxt.getText())<0) errorTxt+="claim date should be greater than accident date ";
                if(errorTxt.length()!=0) JOptionPane.showMessageDialog(null, errorTxt, "Error", JOptionPane.ERROR_MESSAGE);
            
            if(errorTxt.length()==0){
              Claim m=null;
                 Customer c=getCustomerById(dataModel.allCustomers.values,clientIdTxt.getText());
                ArrayList<Policy> policies=new ArrayList<Policy>();
                Policy p=null;
                policies=dataModel.allCustomers.getElement(c).getPolicies();
                for(int i=0;i<policies.size();i++){
                if(policies.get(i).getId()==Integer.parseInt(policiesCombo.getSelectedItem().toString().substring(10, 11)))
                {
               p=policies.get(i);break;
                
                }
            }
                
               
                    
                 m=new Claim(c,p,dateClaimTxt.getText(),accidentTypes.getSelectedItem()+"",accidentDateTxt.getText(),compensationAmountTxt.getText());
                if(damage1.isSelected()) m.damages.add(damage1.getText());
               if(damage2.isSelected()) m.damages.add(damage2.getText());
                if(damage3.isSelected()) m.damages.add(damage3.getText());
                dataModel.allClaims.add(m);
                
                JOptionPane.showMessageDialog(null,"Claim registered successfully!","Registred claim",JOptionPane.INFORMATION_MESSAGE);
            
               
          
            }
        }
    }
    }
    
    public class Focus implements FocusListener{

        
        public void focusGained(FocusEvent e) {
           clientIdTxt.setText("");
           policiesCombo.removeAllItems();
        }

        
        public void focusLost(FocusEvent fe) {
           if(clientIdTxt.getText().length()==0 || !checkStringNumberFormat(clientIdTxt.getText())){ JOptionPane.showMessageDialog(null,"Please enter valid client Id", "Error", JOptionPane.ERROR_MESSAGE);
           
           policiesCombo.removeAllItems();
           }
          //get the client by his Id
         if(clientIdTxt.getText().length()!=0) 
          if(getCustomerById(dataModel.allCustomers.values,clientIdTxt.getText()) ==null) JOptionPane.showMessageDialog(null,"Customer not exist", "Error", JOptionPane.ERROR_MESSAGE);
          else{
              if(clientIdTxt.getText().length()!=0){
          Customer c=getCustomerById(dataModel.allCustomers.values,clientIdTxt.getText());
          //get all his vehicule ids
          ArrayList<Policy> policies=new ArrayList<Policy>();
          policies.addAll(dataModel.allCustomers.getElement(c).getPolicies());
          //add vehicules to combo
          policiesCombo.removeAllItems();
         for(int i=0;i<policies.size();i++){
             policiesCombo.addItem("Policy Id:"+policies.get(i).getId()+" HolderName:"+policies.get(i).getPolicyHolder().getFirstName()+" Vehicule id:"+policies.get(i).getVehiculeConcerned().getId());
         }
          
              }
              
          }
         
    }
    
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
    
    public Customer getCustomerById(ArrayList<Customer> customers,String s){
        Customer c=new Customer();
        for(int i=0;i<customers.size();i++){
            if(!checkStringNumberFormat(s)) return null;
            if(customers.get(i).getId()==Integer.parseInt(s)) return customers.get(i);
        }
        return null;
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
    public boolean checkStringNumberFormat(String s){
          if(s.length()==0) return false;
               char[] tab=s.toCharArray();
               
               for(int i=0;i<tab.length;i++){
                   int toInt=tab[i];
                 if(toInt<48 || toInt>57) return false;
               }
               return true;
      }
    
}






class InsurancePlansPanel extends JPanel{
 JLabel insurancePlan,startDate,endDate,formatDate1,formatDate2;
 JTextField insurancePlanTxt,startDateTxt,endDateTxt;
 JCheckBox obligatory,allRisks,personal,vehiculeDamage;
 String time1[]={"MORNING","NOON","AFTER NOON","NIGHT"};
 String time2[]={"MORNING","NOON","AFTER NOON","NIGHT"};
 JComboBox time1Combo,time2Combo;
 JPanel checkboxPanel,mainPanel,startDatePanel,endDatePanel,formatPanel1,formatPanel2;
 Font f;
    public InsurancePlansPanel(){
     setSize(830,570);
     setLayout(new BorderLayout());
     f=new Font("Arial",Font.BOLD+Font.ITALIC,13);
     insurancePlan=new JLabel("Insurance Plans:");
     startDate=new JLabel("Policy Start Date:");
     endDate=new JLabel("Policy End Date:");
     formatDate1=new JLabel("(dd/mm/yyyy hh:mm)");
     formatDate2=new JLabel("(dd/mm/yyyy hh:mm)");
     formatDate1.setFont(f);formatDate2.setFont(f);
     formatDate1.setForeground(Color.blue);formatDate2.setForeground(Color.blue);
     insurancePlanTxt=new JTextField(15);
     startDateTxt=new JTextField(15);
     endDateTxt=new JTextField(15);
    
     
     time1Combo=new JComboBox(time1);
     time2Combo=new JComboBox(time2);
     
     obligatory=new JCheckBox("Obligatory");
     allRisks=new JCheckBox("All-risks");
     personal=new JCheckBox("Personal");
     vehiculeDamage=new JCheckBox("Vehicule damage");
     
    startDatePanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,15));
    startDatePanel.add(startDateTxt);startDatePanel.add(time1Combo);
    endDatePanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,15));
      endDatePanel.add(endDateTxt);endDatePanel.add(time2Combo);
    
      checkboxPanel=new JPanel(new GridLayout(2,4,0,15));
    checkboxPanel.add(obligatory);checkboxPanel.add(allRisks);
    checkboxPanel.add(personal);checkboxPanel.add(vehiculeDamage);
    
    formatPanel1=new JPanel(new GridLayout(2,1));
    formatPanel2=new JPanel(new GridLayout(2,1));
    formatPanel1.add(startDate);formatPanel1.add(formatDate1);
    formatPanel2.add(endDate);formatPanel2.add(formatDate2);
    
    mainPanel=new JPanel(new GridLayout(3,2,0,50));
    mainPanel.add(insurancePlan);mainPanel.add(checkboxPanel);
    mainPanel.add(formatPanel1);mainPanel.add(startDatePanel);
    mainPanel.add(formatPanel2);mainPanel.add(endDatePanel);
    add(mainPanel,BorderLayout.CENTER);
    setVisible(true);
    
   
     
 }
    
 
   
    
}
