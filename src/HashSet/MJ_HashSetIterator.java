package HashSet;

import java.util.Iterator;

/**
 *
 * @author Maisha Jauernig
 * @param <T>
 */
class MJ_HashSetIterator<T> implements Iterator<T> {
    int _arrIdx, _listIdx;
    MJ_HashSet<T> _set;
    
    MJ_HashSetIterator(MJ_HashSet<T> s) {
        _arrIdx = 0;
        _listIdx = 0;
        _set = s;
    }
    
    @Override
    public boolean hasNext() {
        // if the next list index is out of range or the next element is null
        if ( checkRestOfArray() ) {
            if (getNextItemArrayIndex() != null) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        T it = null;
        // if the next list index is not out of range and the next element is not null
        if ( ! checkRestOfArray() ) {
            _listIdx++;
            it = _set.getItem(_arrIdx, _listIdx);
        }
        // if the next list index is out of range or the next element is null
        // check the next list(s) in the array 
        else {
            Integer i = getNextItemArrayIndex();
            if (i != null) {
                _arrIdx = i;
                _listIdx = 0;
                it = _set.getItem(_arrIdx, _listIdx);
            }
        }
        return it;
    }

    @Override
    public void remove() {
        int listLen;
        T item = _set.getItem(_arrIdx, _listIdx);
        _set.remove(item);
        
        // if in the same list there are elements before the one just removed, 
        // set the list index to the previous element's 
        // in order to get correct next element on subsequents calls to next
        if (_listIdx > 0) {  
            _listIdx--;
        }
        // otherwise the one just removed was the first element in this list
        // and if in the same list there are elements after the one just removed,
        // set the indices to the last element of the previous list
        else if (_set.getSizeOfListAtIdx(_arrIdx) > 0) {
            for (int i = _arrIdx-1; i>=0; i--) {
                listLen = _set.getSizeOfListAtIdx(i);
                if (listLen > 0) {
                    _arrIdx = i;
                    _listIdx = listLen - 1;
                    break;
                }
            }
        }
    }
    
    private Integer getNextItemArrayIndex() { 
        for (int i = _arrIdx+1; i<_set.getTrueArraySize(); i++) {
            if (_set.getItem(i, 0) != null) {
                return i;
            }
        }
        return null;
    }
    
    private boolean checkRestOfArray() {
        boolean check = false;
        
        // if the next list index is out of range
        if (_listIdx + 1 >= _set.getSizeOfListAtIdx(_arrIdx)) {
            check = true;
        }
        // if the next list index is not out of range but the next element is null
        else if (_set.getItem(_arrIdx, _listIdx + 1) == null) {
            check = true;
        }
        // otherwise the next list index is not out of range and the next element is not null
        return check;
    }
}
