package orderedcollection;

import java.util.List;

/**
 * An ordered collection that extends the Java List and Iterable interfaces.
 * @author Maisha Jauernig
 * @param <E>
 */
public interface IMJ_OC <E> extends Iterable <E>, List<E> {
	
    /**
     * @return Returns a deep copy of this collection.
     */
    IMJ_OC <E> getDeepCopy();
    
    /**
     * Prepends the specified element to the beginning of this collection.
     * @param e
     */
    void prepend(E e);
    
    /**
     * Pretty prints all elements in this collection.
     */
    void printAll();
}
