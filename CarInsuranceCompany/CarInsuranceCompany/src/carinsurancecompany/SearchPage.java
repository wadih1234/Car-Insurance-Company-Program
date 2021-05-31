
package carinsurancecompany;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
public class SearchPage extends JFrame implements Observer {
    JLabel title,search,information,ViewDetails,Option1,Option2,output;
    JTextArea txt;
    JTable tab;
    JScrollPane scroll,scroll2;
    DefaultTableModel tableModel;
    JRadioButton allCustomers,allVehicules,allPolicies,allclaims,allReceiptionsCustomers,allReceiptionsCompany;
    JButton searchbtn,searchtabbtn,updateBtn,writeToFile,viewDetails;
    ButtonGroup group;
    JPanel titlePanel,tablePanel,firstLinePanel,secondLinePanel,RadiosPanel,updatePanel;
    Font titleFont,informationsFont;
    Model dataModel;
    public SearchPage(Model m){
         super("Search Page");
        setSize(850,570);
        dataModel=m;
        setLocationRelativeTo(null);
        setResizable(false);
       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);
       output=new JLabel("Output Area");
        title=new JLabel("Search Page");
        titleFont=new Font("Arial",Font.BOLD+Font.ITALIC,23);
        title.setFont(titleFont);
        title.setForeground(Color.red);
        
        informationsFont=new Font("Arial",Font.ITALIC,13);
        information=new JLabel("Press a Radio button to show data in the table");
        information.setFont(informationsFont);
        
        search=new JLabel("Search");
        
       
        
        Option1=new JLabel("Option 1:");
        Option2=new JLabel("Option 2:");
        Option1.setForeground(Color.blue);
        Option2.setForeground(Color.blue);
        ViewDetails=new JLabel("Choose 1 row press view details ");
        ViewDetails.setFont(informationsFont);
        
        txt=new JTextArea(600,400);
        txt.setEditable(false);
        allCustomers=new JRadioButton("All Customers");
        allCustomers.addActionListener(new RadiosAction());
        
        allVehicules=new JRadioButton("All Vehicules");
        allVehicules.addActionListener(new RadiosAction());
        allPolicies=new JRadioButton("All Policies");
        allPolicies.addActionListener(new RadiosAction());
        allclaims=new JRadioButton("All Claims");
        allclaims.addActionListener(new RadiosAction());
        allReceiptionsCustomers=new JRadioButton("CustomersReceiptions");
        allReceiptionsCustomers.addActionListener(new RadiosAction());
        allReceiptionsCompany=new JRadioButton("CompanyReceiptions");
        allReceiptionsCompany.addActionListener(new RadiosAction());
        group=new ButtonGroup();
        group.add(allCustomers);group.add(allVehicules);group.add(allPolicies);group.add(allclaims);
        group.add(allReceiptionsCustomers);group.add(allReceiptionsCompany);
        
        writeToFile=new JButton("Write to File");
         viewDetails=new JButton("View Details");
        RadiosPanel=new JPanel(new FlowLayout());
        RadiosPanel.add(allCustomers);RadiosPanel.add(allVehicules);RadiosPanel.add(allPolicies);RadiosPanel.add(allReceiptionsCustomers);RadiosPanel.add(allReceiptionsCompany);
        RadiosPanel.add(allclaims);
        RadiosPanel.add(viewDetails);
              
       
        
        
        
        
        
        tableModel=new DefaultTableModel();
       
        tab=new JTable(tableModel);
        ListSelectionModel model=tab.getSelectionModel();
        scroll=new JScrollPane(tab);
       
        scroll.setPreferredSize(new Dimension(830,70));
       scroll2=new JScrollPane(txt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        updateBtn=new JButton("Update");
       
       
        
        
       
     
        titlePanel=new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        titlePanel.add(title);
        
        tablePanel=new JPanel();
        tablePanel.add(scroll);
        
        titlePanel.setBounds(250,10,300,50);
        add(titlePanel);
        output.setBounds(350,75,150,50);
        add(output);
        tablePanel.setBounds(0,450,850,300);
        add(tablePanel);
       
        scroll2.setBounds(200,120,400,130);
        add(scroll2);
        writeToFile.setBounds(450,89,110,20);
        add(writeToFile);
        
        information.setBounds(300,300,300,50);
        add(information);
        Option1.setBounds(230,300,130,50);
        add(Option1);
        Option2.setBounds(230,345,130,50);
        add(Option2);
        RadiosPanel.setBounds(0,400,850,150);
        add(RadiosPanel);
       ViewDetails.setBounds(300,320,300,100);
        add(ViewDetails);
        dataModel.addObserver(this);
       viewDetails.addActionListener(new ViewDetails());
       writeToFile.addActionListener(new ActionListener()
       {
       public void actionPerformed(ActionEvent e)
       {
       if(txt.getText().length()==0) JOptionPane.showMessageDialog(null,"Empty textArea!","Error",JOptionPane.ERROR_MESSAGE);
       else
       {
           try{
       writeToFile(txt);
       JOptionPane.showMessageDialog(null,"File is writen successfully in the project folder!","File successfully",JOptionPane.INFORMATION_MESSAGE);
           }catch(IOException e1){JOptionPane.showMessageDialog(null,"Something wrong happened","Error", JOptionPane.ERROR_MESSAGE);}
       
       
       }
       
       
       }
       
       }
       
       );
        
    }

    
    public void update(Observable o, Object o1) {
        
    }
  private class RadiosAction implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
           int id=1;
          
          if(e.getSource()==allCustomers){
              
             tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
              tableModel.addColumn("Customer id"); tableModel.addColumn("Customer name");
              tableModel.addColumn("Customer vehicules numbers"); tableModel.addColumn("Customer policies number");
             
           
for(Customer c : dataModel.allCustomers.values){
              
          Object o[]={c.getId(),c.getFirstName(),c.vehicules.size(),c.getPolicies().size()};
               
                tableModel.addRow(o);
              
              
          }
      }
         if(e.getSource()==allVehicules){
             tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
              tableModel.addColumn("vehicule id"); tableModel.addColumn("Vehicule owner id");
              tableModel.addColumn("Vehicule Owner name"); tableModel.addColumn("Vehicule value");
         
         for(Vehicule v :dataModel.allVehicules.values){
         Object o[]={v.getId(),v.getC().getId(),v.getC().getFirstName(),v.getValue()};
         tableModel.addRow(o);
         
         }
         
         }
        if(e.getSource()==allclaims){
            tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
              tableModel.addColumn("claim id"); tableModel.addColumn("Customer id");
              tableModel.addColumn("Policy id");tableModel.addColumn("Claim date"); tableModel.addColumn("compensation value");
              tableModel.addColumn("status");
          for(Claim c : dataModel.allClaims)
          {
              String status="";
              if(c.getStatus()==true) status="Paid";
           else if(c.getStatus()==false) status="Unpaid";
          Object o[]={c.getId(),c.getC().getId(),c.getPolicy().getId(),c.getDateClaim(),c.getCompensationAmount(),status};
          tableModel.addRow(o);
          
          }
        } 
        if(e.getSource()==allPolicies)
        {
           tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
              tableModel.addColumn("policy id"); tableModel.addColumn(" For customer id");
              tableModel.addColumn("For vehicule id");tableModel.addColumn("Start date"); 
              tableModel.addColumn("End date");
              tableModel.addColumn("Premium");
              tableModel.addColumn("Coverage");
              tableModel.addColumn("status");
       for(Policy p : dataModel.allPolicies){
           String status="";
           if(p.getStatus()==true) status="Paid";
           else if(p.getStatus()==false) status="Unpaid";
           Object o[]={p.getId(),p.getPolicyHolder().getId(),p.getVehiculeConcerned().getId(),p.getStartDate(),p.getEndDate(),p.getPremium(),p.getCoverage(),status};
           tableModel.addRow(o);
       }
        
        }
        if(e.getSource()==allReceiptionsCustomers){
             tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
          tableModel.addColumn("Receiption id");   tableModel.addColumn("Customer id");tableModel.addColumn("Policy id");
             tableModel.addColumn("Payment Date"); tableModel.addColumn("valueToPay");
             tableModel.addColumn("Status");
             for(Payment P : dataModel.allPayments){
                   String status="paid";
                 if(P instanceof CustomerPayment){
               
             
                Object o[]={P.getId(),P.getCustomer().getId(),P.getPolicy().getId(),P.getDatePayment(),P.getValueToPay()+"",status};
               tableModel.addRow(o);
                 
                 }
             }
        }
        if(e.getSource()==allReceiptionsCompany){
            tableModel=new DefaultTableModel();
             tab.setModel(tableModel);
              tableModel.addColumn("Receiption id");   tableModel.addColumn("Customer id");tableModel.addColumn("Claim id");
             tableModel.addColumn("Payment Date"); tableModel.addColumn("valueToPay");tableModel.addColumn("PayFor");
             tableModel.addColumn("Status");
             
             for(Payment P : dataModel.allPayments){
                 String status="Paid";
                  
                
                 if(P instanceof CompanyPayment){
                      id++;
                 Object o[]={id,P.getCustomer().getId(),((CompanyPayment) P).getClaim().getId(),P.getDatePayment(),P.getValueToPay(),((CompanyPayment) P).getPayFor(),status};     
                 tableModel.addRow(o);
                 
             }
             }
        }
         
          
  }
}
  
  private class ViewDetails implements ActionListener{

        String details="";
        public void actionPerformed(ActionEvent ae) {
           if(allCustomers.isSelected())
           {
           
           DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
           String customerId=d.getValueAt(row, 0).toString();
           String customerName=d.getValueAt(row,1).toString();
           String nbCustomerVehicules=d.getValueAt(row,2).toString();
           String nbCustomerPolicies=d.getValueAt(row, 3).toString();
           Customer c=getCustomerById(dataModel.allCustomers.values,customerId);
           details="      Customer Details:\n"
                   + "           -----------------\n"
                   + "  Customer id                        : "+c.getId()+"\n"
                   + "  Customer First name                : "+c.getFirstName()+"\n"
                   + "  Customer Last name                 : "+c.getLastName()+"\n"
                   + "  Customer Father name               : "+c.getFatherName()+"\n"
                   + "  Customer Gender                    : "+c.getGender()+"\n"
                   + "  Customer Date of birth             : "+c.getDateBirth()+"\n"
                   + "  Customer Mobile                    : "+c.getMobile()+"\n"
                   + "  Customer City                      : "+c.getCity()+"\n"
                   + "  Customer Job                       : "+c.getJob()+"\n";
           for(int i=0;i<c.getPolicies().size();i++){
               details+="Policy id                         : "+c.getPolicies().get(i).getId()+"\n"
                       +"He have to pay                    :"+c.getPolicies().get(i).getPremium()+"\n"
                       +"This policy has coverage amount   : "+c.getPolicies().get(i).getCoverage()+"\n"
                       +"This policy ends in:"+c.getPolicies().get(i).getEndDate()+"\n"
                       +"Vehicule concerned by this policy : "+c.getPolicies().get(i).getVehiculeConcerned().getId()+"\n\n\n";
           }
           txt.setText("");
           txt.append(details);
           }
           }
           
           if(allVehicules.isSelected())
           
           {
           
            DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
           String vehiculeId=d.getValueAt(row, 0).toString();
           String ownerId=d.getValueAt(row,1).toString();
           String ownerName=d.getValueAt(row, 2).toString();
           Vehicule v=getVehiculeById(dataModel.allVehicules.values,vehiculeId);
           details="      Vehiclue details:"
                   + "    ================"
                   + "    id    : "+v.getId()+"\n"
                   + "     model : "+v.getModel()+"\n"
                   + "     brand : "+v.getBrand()+"\n"
                   + "    body : "+v.getBody()+"\n"
                   + "     value: "+v.getValue()+"\n"
                   + "     engine : "+v.getEngine()+"\n"
                   + "     year: "+v.getYear()+"\n"
                   + "     plateNo : "+v.getPlateNo()+"\n"
                   + "     horsePower: "+v.getHorsePower()+"\n"
                   + "    usage: "+v.getUsage()+"\n"
                   + "    Nombre passengers: "+v.getNbPassengers()+"\n"
                   + "    Vehicule Owner id:"+ownerId+"\n"
                   + "    Vehicule Owner name:"+ownerName;
                   
           txt.setText(""); txt.append(details);
           }
           }
           
           if(allclaims.isSelected()){
               DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
           String claimId=d.getValueAt(row,0).toString();
           Claim c=getClaimById(dataModel.allClaims,claimId);
           String clientId=d.getValueAt(row,1).toString();
           String policyId=d.getValueAt(row,2).toString();
           String compensationValue=d.getValueAt(row,3).toString();
           String status=d.getValueAt(row,4).toString();
           
           details="       Claim details:      \n"
                   +"      ==============        "
                   +"      Claim id:  "+claimId+"\n"
                   +"      on Policy Id; "+policyId+"\n"
                   +"      for client Id:"+clientId+"\n"
                   +"      accident Type: "+c.getAccidentType()+"\n"
                   +"      Accident Date:"+c.getAccidentDate()+"\n"
                   +"      Claim Date:"  + c.getDateClaim()+"\n"
                   +"      Damages: "+c.damagesString()+"\n"
                   +"      compensation Amout:"+compensationValue+"\n"
                   +"      Claim status:   " +status;
                   
                   
           txt.setText("");txt.append(details);
           
           }
           
           }
           if(allPolicies.isSelected())
           {
           DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
           String policyId=d.getValueAt(row,0).toString();
           String customerId=d.getValueAt(row,1).toString();
           String vehiculeId=d.getValueAt(row,2).toString();
           String startDate=d.getValueAt(row, 3).toString();
           String endDate=d.getValueAt(row, 4).toString();
           String premium=d.getValueAt(row, 5).toString();
           String coverage=d.getValueAt(row,6).toString();
           String status=d.getValueAt(row, 7).toString();
           Policy p=getPolicyById(dataModel.allPolicies,policyId);
           details= "      Policy details:\n"
                   +"      ==============="
                   +"      Policy Id: "+policyId+"\n"
                   +"      Customer registred on this policy:"+customerId+"  his name is:"+p.getPolicyHolder().getFirstName()+"\n"
                   +"      Vehicule registred on this policy:"+vehiculeId+"\n"
                   +"      Policy start Date:"+startDate+"\n"
                   +"      Policy end Date :"+endDate+"\n"
                   +"      Premium to be paid by Customer:"+premium+"\n"
                   +"      This policy covers (amount):"+coverage+"\n"
                   +"      Policy status:"+status;
           txt.setText(""); txt.append(details);
           }
           }
         if(allReceiptionsCustomers.isSelected()){
             DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
               String receiptionId=d.getValueAt(row,0).toString();
               String customerId=d.getValueAt(row,1).toString();
               String PolicyId=d.getValueAt(row,2).toString();
               String paymentDate=d.getValueAt(row,3).toString();
               String valueToPay=d.getValueAt(row,4).toString();
               String status=d.getValueAt(row, 5).toString();
            details="             Receiption Details:\n"
                    + "          ====================\n"
                    + "          Receiption Id:"+receiptionId+"\n"
                    +"           Customer Id  :"+customerId+"\n"
                    +"           Vehicule Id  :"+PolicyId+"\n"
                    +"           Payment  Date :"+paymentDate+"\n"
                    +"           ValueToPay   :"+valueToPay+"\n"
                    +"           Status       :"+status+"\n";
            txt.setText(""); txt.append(details);
                    
           }
         }
         if(allReceiptionsCompany.isSelected()){
            DefaultTableModel d=(DefaultTableModel)tab.getModel();
           int row=tab.getSelectedRow();
           if(row!=-1){
                String receiptionId=d.getValueAt(row,0).toString();
               String customerId=d.getValueAt(row,1).toString();
               String claimId=d.getValueAt(row,2).toString();
              String paymentDate=d.getValueAt(row,3).toString();
              String valueToPay=d.getValueAt(row,4).toString();
              String payFor=d.getValueAt(row,5).toString();
              String status=d.getValueAt(row,6).toString();
             details="               Receiption Details:\n"
                     + "            ====================\n "
                     +"             Receiption Id :"+receiptionId+"\n"
                     +"             Customer Id   :"+customerId+"\n"
                     +"             Claim  Id     :"+claimId+"\n"
                     +"             Payment  Date :"+paymentDate+"\n"
                     +"             ValueToPay    :"+valueToPay+"\n"
                     +"             PayFor        :"+payFor+"\n"
                     +"             Status        :"+status+"\n";
             txt.setText("");txt.append(details);
                     
               
           }
         }
           
        }
      
  }
   public Customer getCustomerById(ArrayList<Customer> customers,String s){
        Customer c=new Customer();
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getId()==Integer.parseInt(s)) return customers.get(i);
        }
        return null;
    }
   public Vehicule getVehiculeById(ArrayList<Vehicule> vehicules,String s){
        Vehicule v=new Vehicule();
        for(int i=0;i<vehicules.size();i++){
            if(vehicules.get(i).getId()==Integer.parseInt(s)) return vehicules.get(i);
        }
        return null;
    }
   public Claim getClaimById(ArrayList<Claim> claims,String s){
        Claim c;
        for(int i=0;i<claims.size();i++){
            if(claims.get(i).getId()==Integer.parseInt(s)) return claims.get(i);
        }
        return null;
    }
   public Policy getPolicyById(ArrayList<Policy> policies,String s){
       Policy p;
       for(int i=0;i<policies.size();i++){
            if(policies.get(i).getId()==Integer.parseInt(s)) return policies.get(i);
        }
        return null;
   }
   
   public void writeToFile(JTextArea t) throws IOException{
       //create File
           File f=new File("output.txt");
           
       //create file writer class
       FileWriter filewriter=new FileWriter(f);
       //create print writer class
       PrintWriter printwriter=new PrintWriter(filewriter); 
       printwriter.write(t.getText());
       printwriter.close();
       
       
   }
}
