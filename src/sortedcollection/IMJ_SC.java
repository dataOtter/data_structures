package sortedcollection;

import java.util.List;

/**
 *
 * @author Maisha Jauernig
 * @param <E>
 */
public interface IMJ_SC <E>  extends Comparable, List <E> {
    /**
     * @return Returns a deep copy of this collection.
     */
    IMJ_SC <E> getDeepCopy();
    
    /**
     * Pretty prints all elements in this collection.
     */
    void printAll();
}
