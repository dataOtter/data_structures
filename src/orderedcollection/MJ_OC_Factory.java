package orderedcollection;

/**
 * A factory class to create instances of IMJ_OC<T>
 * @author Maisha Jauernig
 * @param <T>
 */
public class MJ_OC_Factory <T> {
    
    /**
     * @return an instance of IMJ_OC<T>
     */
    public IMJ_OC<T> create() {
        //return new MJ_OC_Array<>(5);
        return new MJ_OC_List<>();
    }
    
    /**
     * @return an array instance of IMJ_OC<T>
     */
    public IMJ_OC<T> createArrayOc(int len) {
        return new MJ_OC_Array<>(len);
    }
    
    /**
     * @return a list instance of IMJ_OC<T>
     */
    public IMJ_OC<T> createListOc() {
        return new MJ_OC_List<>();
    }
}
