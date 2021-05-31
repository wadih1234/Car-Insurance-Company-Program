/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carinsurancecompany;

import java.util.*;
public class MyList<E> {
    ArrayList<E> values;
    
    public MyList(){
        values=new ArrayList<E>();
    }
    
    public void add(E e){
        if(!values.contains(e)) values.add(e);
    }
    public void remove(E e){
        values.remove(e);
    }
    public void removeAtIndex(int index){
    values.remove(index);
    }
    public int getSize(){
        return values.size();
    }
    public void clear(){
        values.clear();
    }
    public int size(){
        return values.size();
    }
    public boolean contains(E elem){
        return values.contains(elem);
    }
    public E getElementAt(int index){
        return values.get(index);
    }
    public E getElement (E e){
        return e;
    }
    
    public int getElementIndex(E e){
     for(int i=0;i<values.size();i++){
         if(values.get(i).equals(e)) return i;
     }
     return -1;
    
    }

    @Override
    public String toString() {
        return "MyList{" + "values=" + values + '}';
    }
    
}
