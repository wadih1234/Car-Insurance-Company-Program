
package carinsurancecompany;


public class UtilitiesFunctions {
    
    public  boolean checkString(String s){
               if(s.length()==0) return false;
               char[] tab=s.toCharArray();
               for(int i=0;i<tab.length;i++){
                   int toInt=tab[i];
                   if(toInt<32 || toInt>122) return false;
               }
               return true;
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
    public boolean checkMobile(String s){
        if(!checkStringNumberFormat(s)) return false;
        if(s.length()<8) return false;
        return true;
    }
    
    public boolean checkDate(String s){
         if(s.length()==0 || s.length()>10) return false;
        String dateParts[]=s.split("/");
        if(dateParts.length<3) return false;
        if(dateParts[0].length()<2 || dateParts[0].length()>2 ) return false;
        if(dateParts[1].length()<2 || dateParts[1].length()>2 ) return false;
        if(dateParts[2].length()<=2 || dateParts[2].length()>4) return false;
        if(!s.contains("/")) return false;
        
        for(int i=0;i<dateParts.length;i++){
            if(Integer.parseInt(dateParts[0])<=0 || Integer.parseInt(dateParts[0])>31 ) return false;
            if(Integer.parseInt(dateParts[1])<=0 || Integer.parseInt(dateParts[1])>12 ) return false;
            if(Integer.parseInt(dateParts[2])<=0) return false;
        }
        
        
          
      
        
        return true;
    }
    
    public boolean checkDateTime(String s){
        if(s.length()==0) return false;
        String dateTimeParts[]=s.split("[ ]");
        if(dateTimeParts.length<2) return false;
        if(dateTimeParts[0].length()<10 || dateTimeParts[0].length()>10 ) return false;
        if(dateTimeParts[1].length()<5 || dateTimeParts[1].length()>5 ) return false;
        if(!s.contains("/") || !s.contains(":")) return false;
        String dateParts[]=dateTimeParts[0].split("[/]");
        
        String timeParts[]=dateTimeParts[1].split("[:]");
       
        for(int i=0;i<dateParts.length;i++){
            if(Integer.parseInt(dateParts[0])<=0 || Integer.parseInt(dateParts[0])>31 ) return false;
            if(Integer.parseInt(dateParts[1])<=0 || Integer.parseInt(dateParts[1])>12 ) return false;
            if(Integer.parseInt(dateParts[2])<=0) return false;
        }
        for(int i=0;i<timeParts.length;i++){
            if(Integer.parseInt(timeParts[0])<=0 || Integer.parseInt(timeParts[0])>23 ) return false;
            if(Integer.parseInt(timeParts[1])<0 || Integer.parseInt(timeParts[1])>59 ) return false;
        }
        return true;
    }
}
