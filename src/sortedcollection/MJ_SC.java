package sortedcollection;

import Assert.Assertion;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import orderedcollection.*;

/**
 *
 * @author Maisha Jauernig
 * @param <E>
 */
public class MJ_SC <E extends Comparable> implements IMJ_SC <E> {
    private IMJ_OC<E> _oc;
    
    MJ_SC(){
        _oc = new MJ_OC_Factory<E>().create();
    }
    
    @Override
    public boolean add(E t){
        int leftMost = 0;
        int rightMost = _oc.size();
        int center = rightMost/2;  // this is floor
        boolean added = false;
        
        if (rightMost == 0){
            _oc.add(t);
            added = true;
        }
        
        while (!added){
            // if the given string is smaller than the string in oc at index center
            if (item1SmallerThanItem2(t, _oc.get(center))){  
                rightMost = center-1;  // drop the right side beyond the new section we will look at
                center = center/2;  // set the new center point
                if (rightMost <= leftMost){  // if we have narrowed it down to one spot
                    // put s into the place of element at leftMost or rightMost
                    _oc.add(leftMost+center, t);  // this is sometimes wrong and should be leftMost + 1
                    added = true;
                }
            }
            else{  // else if the given string is bigger than or equal to the string in oc at index center
                leftMost = center;  // drop the left side beyond the new section we will look at
                center = center + (rightMost-center)/2;  // set the new center point
                if (leftMost == center){  // if we have narrowed it down to one spot
                    // put s into the place of element at rightMost
                    if (rightMost == _oc.size()){
                        _oc.add(rightMost, t);
                    }
                    else{
                        _oc.add(rightMost+1, t);
                    }
                    added = true;
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // have to check that elements in c are the same type as the elements in this
        Iterator iter = c.iterator();
        while (iter.hasNext()){
            add((E) iter.next());
        }
        return true;
    }
    
    @Override
    public void clear(){
        _oc = new MJ_OC_Factory<E>().create();
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i<_oc.size(); i++){
            if (_oc.get(i) == o){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public E get(int index){
        Assertion.test(_oc != null, "Collection is empty");
        return _oc.get(index);
    }

    @Override
    public IMJ_SC<E> getDeepCopy() {
        MJ_SC<E> copy = new MJ_SC<>();
        copy.setOc(_oc.getDeepCopy());
        return copy;
    }
    
    @Override
    public void printAll(){
        _oc.printAll();
    }

    @Override
    public E remove(int index) {
        return _oc.remove(index);
    }
    
    @Override
    public int size(){
        return _oc.size();
    }
    
    private void setOc(IMJ_OC<E> oc){
        _oc = oc;
    }
    
    private boolean item1SmallerThanItem2(E t1, E t2){ 
        
        if (t1.compareTo(t2) < 0) {
            return true;
        }
        return false;
        /* if (t1 instanceof String && t2 instanceof String){
            return string1SmallerThanString2((String) t1, (String) t2); }

        else if (isSimpleComparisonClass(t1) && isSimpleComparisonClass(t1)){
            if (t1 <= t2){ return true; } }
        
        else{  // need try
            Class<T> tt1, tt2;
            tt1 = (Class<T>) t1;
            tt2 = (Class<T>) t2;
            // catch
            if (tt1.isPrimitive() && tt2.isPrimitive()){
                if (t1 <= t2){ return true; } }
            else{ Assertion.test(false, "Not a sortable type"); } }
        return false; */
    }
    
    /*private boolean isSimpleComparisonClass(T t){
        return t instanceof Integer || t instanceof Double || t instanceof Float 
                || t instanceof Short || t instanceof Long || t instanceof Byte
                || t instanceof Character;
    } 
    private boolean string1SmallerThanString2(String s1, String s2){
        int x = min(s1.length(), s2.length());
        char c1, c2; 
        for (int i = 0; i<x; i++){
            c1 = s1.charAt(i);
            c2 = s2.charAt(i); 
            if (c1 <= c2){ return true; }
            else if (c1 > c2){ return false; } }
        return false; }*/


    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
