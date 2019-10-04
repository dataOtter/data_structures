package HashSet;

import Assert.Assertion;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import orderedcollection.*;

/**
 *
 * @author Maisha Jauernig
 * @param <E>
 */
public class MJ_HashSet <E> implements Set <E> {
    private int _numItems;
    private final int _maxListLen;
    private final int _intialArrLen;
    private int _actualArrLen;
    private IMJ_OC<IMJ_OC<E>> _data;  // should be array of lists
    
    MJ_HashSet(int arrLen, int listLen) {
        _numItems = 0;
        _intialArrLen = arrLen;
        _actualArrLen = arrLen;
        _maxListLen = listLen;
        makeNew_data(_actualArrLen);
    }
    
    @Override
    public boolean add(E item) {
        IMJ_OC<E> list = getListForItem(item);
        list.prepend(item);
        _numItems++;
        if (_numItems/_actualArrLen > _maxListLen) {
            doubleSizeOfArray();
        }
        return true;
    }

    @Override
    public void clear() {
        _numItems = 0;
        _actualArrLen = _intialArrLen;
        makeNew_data(_actualArrLen);
    }
    
    @Override
    public boolean contains(Object item) {
        @SuppressWarnings("unchecked")
		Integer listIdx = this.getItemListIndex((E) item);
        return listIdx != null;
    }
    
    public E get(int idx) {
        Assertion.test(idx < _numItems, "Index out of range");
        int cumListLen = 0;
        int curListLen = _data.get(0).size();
        int arrIdx = 0;
        
        while (cumListLen < _numItems) {
            // if the given index is bigger than the last index of the current list
            // move to the next list and update the array index, length of the next "current" list, 
            // and the cumulative length of all previous lists
            if (cumListLen <= idx) {
                cumListLen += curListLen;
                arrIdx++;
                curListLen = _data.get(arrIdx).size();
            }
            // if the given index is within the current list, get the item
            else{
                idx = idx - (cumListLen - 1);  // to get the true index and not length position
                return _data.get(arrIdx).get(idx);
            }
        }
        return null;
    }
    
    public MJ_HashSet<E> getDeepCopy() {
    	MJ_HashSet<E> copy = new MJ_HashSet_Factory<E>().create();
    	Iterator<E> iter = this.iterator();
    	while (iter.hasNext()) {
    		copy.add(iter.next());
    	}
    	return copy;
    }

    @Override
    public boolean isEmpty() {
        return _numItems == 0;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new MJ_HashSetIterator<E>(this);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public boolean remove(Object item) {
		Integer listIdx = this.getItemListIndex((E) item);
        if (listIdx != null) {
            IMJ_OC<E> list = this.getListForItem((E) item);
            list.remove(listIdx);
            _numItems--;
        }
        return true;
    }
    
    @Override
    public int size() {
        return _numItems;
    }
    
    E getItem(int arrIdx, int listIdx) {
        IMJ_OC<E> list = _data.get(arrIdx);
        if (listIdx >= list.size()){
            return null;
        }
        return list.get(listIdx);
    }
    
    int getSizeOfListAtIdx(int idx) {
        return _data.get(idx).size();
    }
    
    int getTrueArraySize() {
        return _actualArrLen;
    }
    
    private void makeNew_data(int arrLen) {
        _data = new MJ_OC_Factory<IMJ_OC<E>>().createArrayOc(arrLen);  // array of lists
        for (int i = 0; i<arrLen; i++) {
            _data.add(new MJ_OC_Factory<E>().createListOc());
        }
    }
    
    private Integer getItemListIndex(E item) {
        IMJ_OC<E> list = getListForItem(item);
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i) == item) {
                return i;
            }
        }
        return null;
    }
    
    private IMJ_OC<E> getListForItem(E item) {
        int hash = item.hashCode();
        int idx = Math.abs(hash % _actualArrLen);  // might need -1? 
        IMJ_OC<E> list = _data.get(idx);
        return list;
    }
    
    private IMJ_OC<E> getListForItem(E item, IMJ_OC<IMJ_OC<E>> data) {
        int hash = Math.abs(item.hashCode());
        int idx = hash % _actualArrLen;
        IMJ_OC<E> list = data.get(idx);
        return list;
    }
    
    private void doubleSizeOfArray() {
        int len = _data.size();
        IMJ_OC<IMJ_OC<E>> data2 = new MJ_OC_Factory<IMJ_OC<E>>().createArrayOc(len * 2);
        IMJ_OC<E> list;
        E item;
        _actualArrLen *= 2;
        
        for (int i = 0; i<len; i++) {
            list = _data.get(i);
            for (int j = 0; j<list.size(); j++) {
                item = list.get(j);
                IMJ_OC<E> listCopy = this.getListForItem(item, data2);
                listCopy.prepend(item);
            }
        }
        _data = data2;
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
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
