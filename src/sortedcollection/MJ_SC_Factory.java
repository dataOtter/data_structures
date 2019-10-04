package sortedcollection;

/**
 *
 * @author Maisha
 * @param <T>
 */
public class MJ_SC_Factory <T extends Comparable> {
    
    public IMJ_SC<T> create(){
        return new MJ_SC<>();
    }
}
