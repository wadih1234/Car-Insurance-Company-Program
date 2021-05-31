
package carinsurancecompany;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VehiculePanel extends JPanel {
  JLabel model,brand,body,value,engine,year,plateNo,horsePower,passengers,state,usage;
    JTextField modelTxt,bodyTxt,valueTxt,engineTxt,yearTxt,plateNoTxt,horsePowerTxt,passengersTxt,usageTxt;
   JComboBox brandCombo;
   JPanel vehiculeDetailsPanel,westPanel,eastPanel,TopPanel,DownPanel,
           damagesPanelFirst,damagesPanelSecond,damagesPanelThird,damagePanelMain,vehiculeMainPanel;
     String brands[]={"Audi","BMW","Buick","Cadillac","Chevrolet","Chrysler","Dodge","Ferrari","Ford",
          "GM","GEM","GMC","Honda","Hummer","Hyundai","Jeep","Kia","Lexus",
          "Lincoln","Lotus","Mercedes","Suzuki","Toyota","Volvo","Nissan","Suzuki","Toyota"};
  

    public VehiculePanel(){
        setSize(830,570);
        setLayout(new BorderLayout());
        model=new JLabel("Model:");
        brand=new JLabel("Brand:");
        body=new JLabel("Body:");
        value=new JLabel("Value:");
        engine=new JLabel("Engine:");
        year=new JLabel("Year:");
        plateNo=new JLabel("Plate No:");
        horsePower=new JLabel("Horse Power:");
        passengers=new JLabel("Passsengers:");
        state=new JLabel("State:");
        usage=new JLabel("Usage:");
        
        modelTxt=new JTextField(15);
        bodyTxt=new JTextField(15);
        valueTxt=new JTextField(15);
        engineTxt=new JTextField(15);
        yearTxt=new JTextField(15);
        plateNoTxt=new JTextField(15);
        horsePowerTxt=new JTextField(15);
        passengersTxt=new JTextField(15);
        usageTxt=new JTextField(15);
        
         
        brandCombo=new JComboBox(brands);
        westPanel=new JPanel();
     eastPanel=new JPanel();
     westPanel.setPreferredSize(new Dimension(110,0));
     
     eastPanel.setPreferredSize(new Dimension(110,0));
     TopPanel=new JPanel();DownPanel=new JPanel();
     DownPanel.setPreferredSize(new Dimension(0,120));
     add(TopPanel,BorderLayout.NORTH);
     add(DownPanel,BorderLayout.SOUTH);
      add(westPanel,BorderLayout.WEST);
    add(eastPanel,BorderLayout.EAST);
     vehiculeMainPanel=new JPanel(new BorderLayout());
     vehiculeDetailsPanel=new JPanel(new GridLayout(5,4,15,30));
    vehiculeDetailsPanel.add(model);vehiculeDetailsPanel.add(modelTxt);
        vehiculeDetailsPanel.add(brand);vehiculeDetailsPanel.add(brandCombo);
        vehiculeDetailsPanel.add(body);vehiculeDetailsPanel.add(bodyTxt);
        vehiculeDetailsPanel.add(value);vehiculeDetailsPanel.add(valueTxt);
        vehiculeDetailsPanel.add(engine);vehiculeDetailsPanel.add(engineTxt);
        vehiculeDetailsPanel.add(year);vehiculeDetailsPanel.add(yearTxt);
       vehiculeDetailsPanel.add(plateNo);vehiculeDetailsPanel.add(plateNoTxt);
       vehiculeDetailsPanel.add(horsePower);vehiculeDetailsPanel.add(horsePowerTxt);
       vehiculeDetailsPanel.add(usage);vehiculeDetailsPanel.add(usageTxt);
        vehiculeDetailsPanel.add(passengers);vehiculeDetailsPanel.add(passengersTxt);
        vehiculeDetailsPanel.setPreferredSize(new Dimension(220,350));
        vehiculeMainPanel.add(vehiculeDetailsPanel,BorderLayout.CENTER);
     // vehiculeDetailsPanel.setBounds(55,10,510,275);
      add(vehiculeMainPanel,BorderLayout.CENTER);
     
       setVisible(true);
    }
  
}

