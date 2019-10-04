package sortedcollection;

import static java.lang.Math.*;
import orderedcollection.*;

/**
 *
 * @author Maisha Jauernig
 */
public class Deprecated_SC_String implements Deprcated_ISC_String {
    private IMJ_OC<String> _oc;
    
    Deprecated_SC_String(){
        _oc = new MJ_OC_Factory<String>().create();
    }
    
    /*public static void main(String[] args){
        SC_String l = new SC_String();
        System.out.println(l.string1SmallerThanString2("there", "is your name?"));
    }*/
    
    @Override
    public String getItem(int index){
        return _oc.get(index);
    }
    
    @Override
    public void add(String s){
        int leftMost = 0;
        int rightMost = _oc.size();
        int center = rightMost/2;  // this is floor
        boolean added = false;
        
        if (rightMost == 0){
            _oc.add(s);
            added = true;
        }
        
        while (!added){  // binary search
            // if the given string is smaller than the string in oc at index center
            // if (string1SmallerThanString2(s, _oc.getItem(center))){  
            if (s.compareTo(_oc.get(center)) < 0) {
                rightMost = center-1;  // drop the right side beyond the new section we will look at
                center = center/2;  // set the new center point
                if (rightMost == leftMost){  // if we have narrowed it down to one spot
                    // put s into the place of element at leftMost or rightMost
                    _oc.add(leftMost, s);
                    added = true;
                }
            }
            else{  // else if the given string is bigger than or equal to the string in oc at index center
                leftMost = center;  // drop the left side beyond the new section we will look at
                center = center + (rightMost-center)/2;  // set the new center point
                if (leftMost == center){  // if we have narrowed it down to one spot
                    if (rightMost == _oc.size()){
                        _oc.add(rightMost, s);
                    }
                    else{
                        _oc.add(rightMost+1, s);
                    }
                    added = true;
                }
            }
        }
    }
    
    private boolean string1SmallerThanString2(String s1, String s2){
        int x = min(s1.length(), s2.length());
        char c1, c2;
        
        for (int i = 0; i<x; i++){
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            
            if (c1 < c2){
                return true;
            }
            else if (c2 < c1){
                return false;
            }
            else{}
        }
        
        if (s1.length() < s2.length()){
            return true;
        }
        else if (s1.length() > s2.length()){
            return false;
        }
        return false;
    }
    
    @Override
    public void clear(){
        _oc = new MJ_OC_Factory<String>().create();
    }
    
    @Override
    public int length(){
        return _oc.size();
    }
    
    @Override
    public void printAll(){
        _oc.printAll();
    }
}
