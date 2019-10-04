package HashSet;

/**
 *
 * @author Maisha Jauernig
 * @param <T>
 */
public class MJ_HashSet_Factory <T> {
    
    public MJ_HashSet<T> create(){
        return new MJ_HashSet<>(5, 5);
    }
}
