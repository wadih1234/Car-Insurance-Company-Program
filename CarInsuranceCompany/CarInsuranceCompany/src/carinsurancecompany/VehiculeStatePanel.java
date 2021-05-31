
package carinsurancecompany;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class VehiculeStatePanel extends JPanel{
  
   String[] carParts={"Front WindScreen","Rear WindScreen","Left rear door glass","Driver front door glass",
   "Right rear door glass","Right-Front door glass","Driver front door","Left rear door","Right-front door",
   "Right rear door","2 WindScreensWipers","1 WindScreenWiper","bumper","Left Mirror","Right Mirror",
   "Front-Left turn signal","Front-Right turn signal","Back-Left turn signal","Back-Right turn signal",
   "Front-Left tire","Front-Right tire","Back-Left tire","Back-Right tire","Hood"};
   String time[]={"MORNING","NOON","AFTER NOON","NIGHT"};
   JList carPartsList,damagedPartsList;
   DefaultListModel list1Model,list2Model;
   JComboBox timeCombo;
   JButton toTheList2,toTheList1;
   JLabel details,carPartsLabel,carDamagedLabel;
   JPanel list1Panel,list2Panel,eastPanel,westPanel,northPanel,southPanel,mainPanel,buttonsPanel;
   JScrollPane scroll,scroll2;
   Font f=new Font("Arial",Font.BOLD+Font.ITALIC,12);
    public VehiculeStatePanel(){
        setLayout(null);
        setSize(830,570);
       carPartsList=new JList(carParts);
        damagedPartsList=new JList();
        
        toTheList2=new JButton(" >> ");
        toTheList1=new JButton(" << ");
        details=new JLabel("Choose the damaged parts(0 or many)from the car Parts and press >> to add it to the damaged Parts List:");
        details.setFont(f);
        carPartsLabel=new JLabel("Car Parts:");
        carDamagedLabel=new JLabel("Car Damaged Parts:");
        scroll=new JScrollPane(carPartsList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
         scroll2=new JScrollPane(damagedPartsList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        carPartsLabel.setBounds(100,50,70,57);
        carDamagedLabel.setBounds(400,50,150,57);
        scroll.setBounds(75,110,200,180);
        scroll2.setBounds(365,110,200,180);
        toTheList2.setBounds(280,150,75,50);
         toTheList1.setBounds(280,225,75,50);
         details.setBounds(0,15,1150,50);
        add(carPartsLabel);add(scroll);add(carDamagedLabel);add(scroll2);add(toTheList2);add(toTheList1);add(details);
        list1Model=new DefaultListModel();
        for(int i=0;i<carParts.length;i++){
            list1Model.addElement(carParts[i]);
        }
        list2Model=new DefaultListModel();
       carPartsList.setModel(list1Model); damagedPartsList.setModel(list2Model);
      toTheList2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(carPartsList.getSelectedIndex()==-1) JOptionPane.showMessageDialog(null,"No value selected!");
              int indexList1=carPartsList.getSelectedIndex();
            list2Model.addElement(carPartsList.getSelectedValue());
            if(indexList1!=-1)
             list1Model.remove(indexList1);
              
          }
      });
      toTheList1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              if(damagedPartsList.getSelectedIndex()==-1) JOptionPane.showMessageDialog(null,"No value selected!");
              int indexList2=damagedPartsList.getSelectedIndex();
            list1Model.addElement(damagedPartsList.getSelectedValue());
            if(indexList2!=-1)
             list2Model.remove(indexList2); 
          }
     
      });
        
         setVisible(true);
         
         
    }
    public static void main(String[] args){
        new VehiculeStatePanel();
    }
}
