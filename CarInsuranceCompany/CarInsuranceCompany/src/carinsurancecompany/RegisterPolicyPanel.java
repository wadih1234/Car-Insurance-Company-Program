
package carinsurancecompany;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
public class RegisterPolicyPanel extends JPanel implements Observer{
    JLabel title,customerFirstName,customerLastName,customerFatherName,customerGender,customerMobile,
            customerCity,customerDate,customerJob,pageNumber,formatDate,questionLabel,question2Label;
    
    JTextField customerFirstNameTxt,customerLastNameTxt,customerFatherNameTxt,customerGenderTxt,
               customerMobileTxt,customerCountryTxt,customerDateTxt,customerJobTxt,questionTxt;
    LinkedList<JPanel> lesPanels =new LinkedList<JPanel>();
    
    JComboBox customerCityCombo,timeCombo;
    JRadioButton male,female,check;
    ButtonGroup genderGroup;
    JButton registerPolicy,clearData,back,next,newButton,existButton,okButton;
      String cities[]={"Aakkar","Achrafieh","Antelias","Amchit","Batroun","Baalbek","Baabda","Beirut","Beit ed-dine","Byblos","Chouf","Chtoura","Halba","Jbeil","Jdeideh",
"Jounieh","Nabatieh","Naqoura","Rachaiya","Sidon","Tripoli","Tyre","Zahle","Zgharta"};
     
      
     int pageNb=1;
      Font fontTitle,fontPageNb,f3;
    JPanel titlePanel,titlePagePanel,buttonsPanel,westPanel,eastPanel,customerDetailsPanel
           ,genderPanel,malePanel,femalePanel,datePanel;
   Customer c;Vehicule v;
   JFrame questionframe,question2frame;
   Model modelDonnee;
    public RegisterPolicyPanel(Model m){
     modelDonnee=m;
     
        setSize(830,570);
      fontTitle=new Font("Arial",Font.BOLD+Font.ITALIC,23);
      fontPageNb=new Font("Arial",Font.BOLD,19);
      f3=new Font("Arial",Font.BOLD+Font.ITALIC,13);
     setLayout(new BorderLayout());
      title=new JLabel("Register Policy");
      title.setFont(fontTitle);
      title.setForeground(Color.RED);
      customerFirstName=new JLabel("Customer First Name:");
      customerLastName=new JLabel("Customer Last Name:");
      customerFatherName=new JLabel("Customer Father Name:");
      customerGender=new JLabel("Customer Gender:");
      customerMobile=new JLabel("Customer Mobile:");
      customerCity=new JLabel("Customer City:");
      customerDate=new JLabel("Customer Date of birth:");
      customerJob=new JLabel("Customer Job:");
      pageNumber=new JLabel("Page "+pageNb+" of 4 (Customer Details):");
      formatDate=new JLabel("(dd/mm/yyyy)");
      
      formatDate.setFont(f3);
      formatDate.setForeground(Color.blue);
      
      
      pageNumber.setFont(fontPageNb);
      customerFirstNameTxt=new JTextField(15);
      customerLastNameTxt=new JTextField(15);
      customerFatherNameTxt=new JTextField(15);
      customerGenderTxt=new JTextField(15);
      customerMobileTxt=new JTextField(15);
      customerCountryTxt=new JTextField(15);
      customerJobTxt=new JTextField(15);
      
      customerDateTxt=new JTextField(15);
      
      
      
    customerCityCombo=new JComboBox(cities);
    customerCityCombo.setMaximumRowCount(3);
    customerCityCombo.setSelectedIndex(-1);
    
    genderGroup=new ButtonGroup();
     male=new JRadioButton("Male");
     female=new JRadioButton("Female");
     check=new JRadioButton("check");
     genderGroup.add(male);genderGroup.add(female);
     
     
     
    registerPolicy=new JButton("Register");
    clearData=new JButton("Clear");
    back=new JButton("Back");
    next=new JButton("Next");
    
   
   questionframe=new JFrame();
   questionframe.setSize(310,120);
   questionframe.setLocationRelativeTo(null);
   questionframe.setLayout(new BorderLayout());
   questionLabel=new JLabel("Register policy for new or existing customer?");
   questionTxt=new JTextField(15);
   questionframe.add(questionLabel,BorderLayout.CENTER);
   
   question2frame=new JFrame();
   question2frame.setLayout(new BorderLayout());
   question2frame.setSize(310,120);
   question2frame.setLocationRelativeTo(null);
   question2Label=new JLabel("Please enter customer Id:");
   questionTxt=new JTextField(15);
   okButton=new JButton("Ok");
   okButton.addActionListener(new NextPage());
   question2frame.add(question2Label,BorderLayout.NORTH);
   question2frame.add(questionTxt,BorderLayout.CENTER);
   question2frame.add(okButton,BorderLayout.SOUTH);
   
   
   JPanel buttonsPanel=new JPanel();
   newButton=new JButton("New");existButton=new JButton("Exist");
    buttonsPanel.add(newButton);buttonsPanel.add(existButton);
    questionframe.add(buttonsPanel,BorderLayout.SOUTH);
    newButton.addActionListener(new NextPage());
   existButton.addActionListener(new NextPage());
    next.addActionListener(new NextPage());
    back.addActionListener(new NextPage());
    clearData.addActionListener(new NextPage());
    check.addActionListener(new NextPage());
  
    titlePanel=new JPanel(new FlowLayout());
    titlePanel.add(title,new FlowLayout(FlowLayout.CENTER));
    titlePagePanel=new JPanel(new GridLayout(2,1));
    titlePagePanel.add(titlePanel);titlePagePanel.add(pageNumber);
    titlePagePanel.setPreferredSize(new Dimension(0,100));
    buttonsPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,30,10));
    
   buttonsPanel.add(back);buttonsPanel.add(clearData); buttonsPanel.add(check);buttonsPanel.add(next);
   buttonsPanel.setPreferredSize(new Dimension(0,50));
   add(titlePagePanel,BorderLayout.NORTH);
   add(buttonsPanel,BorderLayout.SOUTH);
     westPanel=new JPanel();
     eastPanel=new JPanel();
     westPanel.setPreferredSize(new Dimension(110,0));
     
     eastPanel.setPreferredSize(new Dimension(110,0));
     
     add(westPanel,BorderLayout.WEST);
     add(eastPanel,BorderLayout.EAST);
     
    
     genderPanel=new JPanel(new GridLayout(1,2,0,30));
     malePanel=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
     malePanel.add(male);
     femalePanel=new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
     femalePanel.add(female);
     genderPanel.add(malePanel);genderPanel.add(femalePanel);
     
     datePanel=new JPanel(new GridLayout(2,1,0,5));
     datePanel.add(customerDate);datePanel.add(formatDate);
     
     customerDetailsPanel=new JPanel();
     
     customerDetailsPanel.setLayout(new GridLayout(8,2,0,16));
     customerDetailsPanel.add(customerFirstName);customerDetailsPanel.add(customerFirstNameTxt);
     customerDetailsPanel.add(customerLastName);customerDetailsPanel.add(customerLastNameTxt);
     customerDetailsPanel.add(customerFatherName);customerDetailsPanel.add(customerFatherNameTxt);
     customerDetailsPanel.add(customerGender);customerDetailsPanel.add(genderPanel);
     customerDetailsPanel.add(customerJob);customerDetailsPanel.add(customerJobTxt);
     customerDetailsPanel.add(datePanel);customerDetailsPanel.add(customerDateTxt);
     customerDetailsPanel.add(customerMobile);customerDetailsPanel.add(customerMobileTxt);
     customerDetailsPanel.add(customerCity);customerDetailsPanel.add(customerCityCombo);
     customerDetailsPanel.setPreferredSize(new Dimension(0,100));
    add(customerDetailsPanel,BorderLayout.CENTER);
   

VehiculePanel vPanel=new VehiculePanel();
VehiculeStatePanel  vState  = new VehiculeStatePanel();
 InsurancePlansPanel iPlans=new InsurancePlansPanel();
lesPanels.add(0, customerDetailsPanel);lesPanels.add(1,vPanel);
       lesPanels.add(2,vState);lesPanels.add(3,iPlans);
      modelDonnee.addObserver(this);
     setVisible(true);
     
       
    }

   
    
   
   
   public class NextPage extends UtilitiesFunctions implements ActionListener{
  
         int counterPage1=0,counterPage2=0,counterPage3=0,counterPage4=0;
         InsurancePlan Plan;
         String valeurQuestion="";
       public void actionPerformed(ActionEvent e){
           VehiculePanel vPan=(VehiculePanel)lesPanels.get(1);
            VehiculeStatePanel vState=(VehiculeStatePanel)lesPanels.get(2);
             InsurancePlansPanel iPan=(InsurancePlansPanel) lesPanels.getLast();
             String txtError;
           if(e.getSource()==next){
               txtError="";
            switch(pageNb){
                 case 1:  
                     
                     String FirstName,LastName,FatherName,job,date,mobile;
                     char gender;
                  
                    
 
               
                           
                       if(!checkString(customerFirstNameTxt.getText()) ||  checkStringNumberFormat(customerFirstNameTxt.getText())) txtError+="Customer First name not valid!"+"\n";
                       if(!checkString(customerLastNameTxt.getText()) ||  checkStringNumberFormat(customerLastNameTxt.getText()))   txtError+="Customer Last name not valid!"+"\n";
                        
                       if(!checkString(customerFatherNameTxt.getText()) ||  checkStringNumberFormat(customerFatherNameTxt.getText())) txtError+="Customer Father name not valid!"+"\n";
                       if(!checkString(customerJobTxt.getText()) || checkStringNumberFormat(customerJobTxt.getText()))   txtError+="Customer Job not valid!"+"\n";
                       if(!checkDate(customerDateTxt.getText()))    txtError+="Customer Date not valid!"+"\n";
                       if(!checkMobile(customerMobileTxt.getText()))    txtError+="Mobile not valid!"+"\n";
                       if(!male.isSelected() && !female.isSelected())  txtError+="Gender not selected!"+"\n";
                        
                       if(customerCityCombo.getSelectedIndex()==-1) txtError+="City not selected!"+"\n";
                       if(txtError.length()!=0) JOptionPane.showMessageDialog(null,txtError,"Error",JOptionPane.ERROR_MESSAGE);                  
                       if(txtError.length()==0){
                             FirstName=customerFirstNameTxt.getText();
                           LastName =customerLastNameTxt.getText();
                           FatherName=customerFatherNameTxt.getText();
                           mobile=customerMobileTxt.getText();
                           date=customerDateTxt.getText();
                           job=customerJobTxt.getText();
                           if(male.isSelected()) gender='M';
                           else gender='F';
                           pageNb++;
                          counterPage1++;
                      lesPanels.getFirst().setVisible(false);
                            pageNumber.setText("Page "+pageNb+" of 4 (Vehicule Details):");
                            if(counterPage1==1) add(lesPanels.get(1),BorderLayout.CENTER);
                            else lesPanels.get(1).setVisible(true);
                            
                                
                                Customer temp=new Customer(FirstName,LastName,FatherName,gender,date,mobile,customerCityCombo.getSelectedItem()+"",job);
                               
                                if(!customerExist(modelDonnee.getAllCustomers(),temp))
                            c=temp;
                                else JOptionPane.showMessageDialog(null,"This customer exists");
                                 
                       }
                     
                     break;
                     
                case 2: 
                   
                    String model=vPan.modelTxt.getText();
                    String brand=vPan.brandCombo.getSelectedItem()+"";
                    String body=vPan.bodyTxt.getText();
                    String usage=vPan.usageTxt.getText();
                    String value=vPan.valueTxt.getText();
                    String engine=vPan.engineTxt.getText();
                    String year=vPan.yearTxt.getText();
                    String horsePower=vPan.horsePowerTxt.getText();
                    String plateNo=vPan.plateNoTxt.getText();
                    String nbPassengers=vPan.passengersTxt.getText();
                  
               
                 if(!checkString(model)) txtError+="Model not valid!"+"\n";
                  if(!checkString(body)) txtError+="Body not valid!"+"\n";
                    if(!checkString(usage)) txtError+="Usage not valid!"+"\n";
                    if(!checkStringNumberFormat(vPan.valueTxt.getText())) txtError+="Vehicule value not valid!"+"\n";
                    if(!checkStringNumberFormat(engine)) txtError+="Engine number not valid!"+"\n";
                    if(!checkStringNumberFormat(year)) txtError+="year not valid!"+"\n";
                    if(!checkStringNumberFormat(horsePower)) txtError+="horse Power not valid!"+"\n";
                    if(!checkString(plateNo)) txtError+="Plate No not valid!"+"\n";
                    if(!checkStringNumberFormat(vPan.passengersTxt.getText())
                        || Integer.parseInt(vPan.passengersTxt.getText()) >15) txtError+="Passengers number not valid!"+"\n";
                    if(vPan.brandCombo.getSelectedIndex()==-1)  txtError+="Choose a brand!"+"\n";
                 
                 if(txtError.length()!=0) JOptionPane.showMessageDialog(null,txtError,"Error", JOptionPane.ERROR_MESSAGE);
                 if(txtError.length()==0){
                    pageNb++;
                    counterPage2++;
                    pageNumber.setText("Page "+pageNb+" of 4 (Vehicule State):");
                  lesPanels.get(1).setVisible(false); 
                  if(counterPage2==1) add(lesPanels.get(2),BorderLayout.CENTER);
                            else lesPanels.get(2).setVisible(true);
                    
                   
                      
                       Vehicule temp=new Vehicule(model,brand,body,Double.parseDouble(value),engine,year,plateNo,horsePower,usage,Integer.parseInt(nbPassengers),c);
                        if(!vehiculeExist(c,temp))
                 v=temp;
                        else JOptionPane.showMessageDialog(null,"this vehicule exist for this customer");
                  
                  
                 
                 }
                 
                 
                break;
                 case 3:
                
                 
                  
                       pageNb++;
                 counterPage3++;
                lesPanels.get(2).setVisible(false);
                pageNumber.setText("Page "+pageNb+" of 4 (Policy terms / Insurance Plans):");
                  if(counterPage3==1) add(lesPanels.get(3),BorderLayout.CENTER);
                            else lesPanels.get(3).setVisible(true);
                 
                
                  if(!vState.list2Model.isEmpty()){
                      ArrayList<String> lesDamagedParts=new ArrayList<String>();
                      
                      for(int i=0;i<vState.list2Model.getSize();i++){
                          lesDamagedParts.add(vState.list2Model.getElementAt(i)+"");
                      }
                     
                    v.setState(lesDamagedParts);
                    
                  }
                  
                  
                break;
               
               case 4:
                   
                   String startDate=iPan.startDateTxt.getText();
                   String endDate=iPan.endDateTxt.getText();
                    if(!iPan.allRisks.isSelected() && !iPan.obligatory.isSelected() && !iPan.vehiculeDamage.isSelected()
                     && !iPan.personal.isSelected()) txtError="Please choose one or more plans"+"\n";
                  if(!checkDateTime(startDate)) txtError+="Invalid start Date"+"\n";
                  if(!checkDateTime(endDate)) txtError+="Invalid end Date"+"\n";
                  if(checkDueDate(endDate,startDate)<0) txtError+="End date should be greater than start date"+"\n";
                  
                  if(txtError.length()!=0) JOptionPane.showMessageDialog(null,txtError,"Error",JOptionPane.ERROR_MESSAGE);
                   
                  
                  if(txtError.length()==0){ 
                       ArrayList<String> boxsSelected=new ArrayList<String>();
                       if(iPan.obligatory.isSelected()) boxsSelected.add(iPan.obligatory+"");
                       if(iPan.personal.isSelected()) boxsSelected.add(iPan.personal+"");
                       if(iPan.vehiculeDamage.isSelected()) boxsSelected.add(iPan.vehiculeDamage+"");
                       if(iPan.allRisks.isSelected()) boxsSelected.add(iPan.allRisks+"");
                     
                     
                    
                    if(!customerExist(modelDonnee.allCustomers,c)){
                                
                              modelDonnee.allCustomers.add(c);
                            
                            }  
                     if(!vehiculeExist(modelDonnee.allCustomers.getElement(c),v)){ 
                        
                   modelDonnee.allCustomers.getElement(c).addVehicule(v);
                  
                  
                  }
                   ArrayList<InsurancePlan> plans=new ArrayList<InsurancePlan>();
                   if(iPan.obligatory.isSelected()) 
                      
                       plans.add(new ObligatoryPlan(c,v));
                   if(iPan.allRisks.isSelected()) plans.add(new AllRisksPlan(c,v));
                 if(iPan.vehiculeDamage.isSelected()) plans.add(new VehiculeDamagesPlan(c,v));
                   if(iPan.personal.isSelected()) plans.add(new PersonalPlan(c,v));
                   
                   double premium=0.0,coverage=0.0;
                   for(int i=0;i<plans.size();i++){
                                            premium+=plans.get(i).sommePremium();
                      coverage+=plans.get(i).allRisksCoverage();

                       if(plans.get(i) instanceof AllRisksPlan){
                       premium=plans.get(i).sommePremium();
                       coverage=plans.get(i).allRisksCoverage();
                       break;
                       }
                       
                   }
                   
                   Policy p=new Policy(c,v,startDate,endDate,premium,coverage);
                      p.setPlan(plans);
                     modelDonnee.allCustomers.getElement(c).addPolicy(p);
                     modelDonnee.allPolicies.add(p);
                      
                     
                    
                     
                    if(modelDonnee.allVehicules.values.size() == 0) modelDonnee.allVehicules.add(v);
                    else
                    {
                        
                    
                     if(!vehiculeExistCompany(modelDonnee.allVehicules.values,v)) modelDonnee.allVehicules.add(v);
                    
                    
                    
                  }
                     new RegistrationCompletedPanel(); break;
                  }
             }
            
           }
             
             
             if(e.getSource()==check){
                 questionframe.setVisible(true);
             }
            if(e.getSource()==existButton)
            {
            questionframe.setVisible(false);
            question2frame.setVisible(true);
            
            } 
            
         if(e.getSource()==okButton)
         {
             Customer c=getCustomerById(modelDonnee.allCustomers.values,questionTxt.getText());
         if(questionTxt.getText().length()!=0 && c!=null){
             for(int i=0;i<modelDonnee.allCustomers.values.size();i++){
                  customerFirstNameTxt.setText(modelDonnee.allCustomers.values.get(i).getFirstName());
                       customerLastNameTxt.setText(modelDonnee.allCustomers.values.get(i).getLastName());
                       customerFatherNameTxt.setText(modelDonnee.allCustomers.values.get(i).getFatherName());
                       
                        customerJobTxt.setText(modelDonnee.allCustomers.values.get(i).getJob());
                        customerDateTxt.setText(modelDonnee.allCustomers.values.get(i).getDateBirth());
                        customerMobileTxt.setText(modelDonnee.allCustomers.values.get(i).getMobile());
                        customerCityCombo.setSelectedItem(modelDonnee.allCustomers.values.get(i).getCity()+"");
             question2frame.setVisible(false);
             }
             
              
  }
         
         else {
         
         JOptionPane.showMessageDialog(null,"Customer id not exist!","Error",JOptionPane.ERROR_MESSAGE);
         question2frame.setVisible(false);
         customerFirstNameTxt.setText("");customerLastNameTxt.setText("");customerFatherNameTxt.setText("");
                        genderGroup.clearSelection();customerJobTxt.setText("");customerDateTxt.setText("");
                        customerMobileTxt.setText("");customerCityCombo.setSelectedIndex(-1);
         }
         }
             
       if(e.getSource()==newButton)
       {
       customerFirstNameTxt.setText("");customerLastNameTxt.setText("");customerFatherNameTxt.setText("");
                        genderGroup.clearSelection();customerJobTxt.setText("");customerDateTxt.setText("");
                        customerMobileTxt.setText("");customerCityCombo.setSelectedIndex(-1);
           questionframe.setVisible(false);
       }      
             
             
             
             
   
           if(e.getSource()==clearData){
               switch(pageNb){
                   case 1:
                        customerFirstNameTxt.setText("");customerLastNameTxt.setText("");customerFatherNameTxt.setText("");
                        genderGroup.clearSelection();customerJobTxt.setText("");customerDateTxt.setText("");
                        customerMobileTxt.setText("");customerCityCombo.setSelectedIndex(-1);
                   break;
                                         
                   case 2: 
                          
                          vPan.modelTxt.setText("");vPan.bodyTxt.setText("");vPan.engineTxt.setText("");
                          vPan.plateNoTxt.setText("");vPan.usageTxt.setText("");vPan.brandCombo.setSelectedIndex(-1);
                          vPan.valueTxt.setText("");vPan.yearTxt.setText("");vPan.passengersTxt.setText("");vPan.horsePowerTxt.setText("");
                   break;
                   
                   case 3:
                          
                          vState.carPartsList.setListData(vState.carParts);vState.list2Model.clear();
                   break;
                   
                   case 4:
                        
                         iPan.allRisks.setSelected(false);iPan.obligatory.setSelected(false);
                         iPan.personal.setSelected(false);iPan.vehiculeDamage.setSelected(false);
                         iPan.startDateTxt.setText("");iPan.endDateTxt.setText("");
               }
           }
           
           
           
 
           
           
           
           
           
           
           
           
           if(e.getSource()==back){
               switch(pageNb){
                   case 4: pageNb--;
                          pageNumber.setText("Page "+pageNb+" of 4 (Vehicule State):");
                          lesPanels.getLast().setVisible(false);
                          lesPanels.get(2).setVisible(true);
                          break;
                          
                   case 3:        
                          pageNb--;
                          pageNumber.setText("Page "+pageNb+" of 4 (Vehicule Details):");
                          lesPanels.get(2).setVisible(false);
                          lesPanels.get(1).setVisible(true);
                          break;
                   case 2:
                         pageNb--;
                          pageNumber.setText("Page "+pageNb+" of 4 (Customer Details):");
                          lesPanels.get(1).setVisible(false);
                          lesPanels.getFirst().setVisible(true); 
                          break;
                         
               }
           }
         
        
           
           
           
           
           
           
           
           
           
           
           
           
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
            

   

   }}
  
         
   public void update(Observable o, Object o1) {
       modelDonnee.setAllCustomers(modelDonnee.allCustomers);
       modelDonnee.setAllVehicules(modelDonnee.allVehicules);
    }
     public boolean customerExist(MyList<Customer> clients,Customer c1){
         for(int i=0;i<clients.getSize();i++){
            Customer c2=clients.getElementAt(i);
           if(c2.equals(c1)) return true;
           
         }
        
         return false;
      
     }
      public boolean vehiculeExist(Customer c,Vehicule v){
         Set<Vehicule> vehiculesClient=c.vehicules;
        ArrayList<Vehicule> vehicules=new ArrayList<Vehicule>();
        for(Vehicule v1 : vehiculesClient) vehicules.add(v1);
        for(int i=0;i<vehicules.size();i++){
            if(vehicules.get(i).equals(v)) return true;
        }
         return false;
      
     }
     
public boolean vehiculeExistCompany(ArrayList<Vehicule> v,Vehicule vehicule){
    for(int i=0;i<v.size();i++)
    {
    if(v.equals(vehicule)) return true;
    }
    return false;
}
     
     public Customer getCustomerById(ArrayList<Customer> customers,String s){
        Customer c=new Customer();
        for(int i=0;i<customers.size();i++){
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
      
}
class RegistrationCompletedPanel extends JFrame{
    JLabel labelForTruthImg,details;
    JPanel p;
    Icon icon;
    Font f;
    public RegistrationCompletedPanel(){
        super("Registration Completed Page");
        setSize(830,570);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);
        f=new Font("Arial",Font.BOLD,23);
        icon=new ImageIcon(getClass().getResource("truth.png"));
        setBackground(Color.WHITE);
        labelForTruthImg=new JLabel(icon);
        labelForTruthImg.setBounds(230,60,290,310);
        add(labelForTruthImg);
        
       details=new JLabel("Registration Completed Successfully!");
        details.setBounds(180,290,700,210);
        details.setForeground(new Color(0,153,0));
        details.setFont(f);
        add(details);
        setVisible(true);
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

