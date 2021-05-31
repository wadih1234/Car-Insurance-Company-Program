
package carinsurancecompany;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class CarInsuranceCompany extends JFrame implements Observer{
   JMenuBar menu;
   JMenu operations;
   JMenu insurance;
   JMenuItem insuranceDashboard,search;
   JFrame f;
   JLabel labelForIcon;
   JPanel mainPanel;
   Icon icon;
   String question,questionResponse;
   Model modelDonnee;
   
   public CarInsuranceCompany(Model m){
       super("Car Insurance Company");
       setSize(850,660);
       modelDonnee=m;
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       menu=new JMenuBar();
       operations=new JMenu("Operations");
       insurance=new JMenu("Insurance");
       insuranceDashboard=new JMenuItem("Dashboard");
       search=new JMenuItem("Search");
       icon=new ImageIcon(getClass().getResource("CarInsuranceImg.jpeg"));
       labelForIcon=new JLabel(icon);
       mainPanel=new JPanel();
       mainPanel.add(labelForIcon);
       getContentPane().add(mainPanel);
       setJMenuBar(menu);
      
      JTextField t=new JTextField(15);
      JButton ok=new JButton("OK");
      JLabel l=new JLabel("Register Policy for new or existing customer?");
       
       menu.add(insurance);
       menu.add(operations);
       insurance.add(insuranceDashboard);
       operations.add(search);
       setVisible(true);
       setResizable(false);
       setLocationRelativeTo(null);
       insuranceDashboard.addActionListener(new ActionListener()
       {
           JFrame dashboard=new Dashboard(modelDonnee);
           String question;
        public void actionPerformed(ActionEvent e){
            
            if(!dashboard.isVisible()){
                dashboard.setVisible(true);
               
            }
            
            
            
        }   
       }
   );
       
       
       search.addActionListener(new ActionListener()
       {
           JFrame search=new SearchPage(m);
        public void actionPerformed(ActionEvent e){
            if(!search.isVisible()){
                search.setVisible(true);
            }
        }   
       }
   );
       modelDonnee.addObserver(this);
   }
    public static void main(String[] args) {
       Model m=new Model();
        new CarInsuranceCompany(m);
        
    }

    @Override
    public void update(Observable o, Object o1) {
      
    }
    
}

class Dashboard extends JFrame implements Observer {
    JTabbedPane tabs;
    Model model;
    public Dashboard(Model m){
       super("Dashboard");
       setSize(900,600);
       model=m;
       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       setLocationRelativeTo(null);
       
       tabs=new JTabbedPane();
       tabs.add("Register Policy",new RegisterPolicyPanel(model));
       tabs.add("Register Claim",new RegisterClaimPanel(model));
       tabs.add("Pay Settlements",new SettlementsPanel(model));
       getContentPane().add(tabs);
       setResizable(false);
       model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
