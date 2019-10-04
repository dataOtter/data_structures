package HashSet;

import java.util.Iterator;

/**
 *
 * @author Maisha Jauernig
 */
public class Main {
    public static void main(String[] args){
        MJ_HashSet<Integer> s = new MJ_HashSet<>(10, 5);
        s.add(3);
        s.add(46);
        s.add(89);
        s.add(435345);
        s.add(4);
        s.add(-98);
        s.add(245);
        System.out.println(s.contains(89));
        s.remove(4);
        
        Iterator it = s.iterator();
        Integer item;
        while (it.hasNext()){
            item = (Integer) it.next();
            System.out.println(item);
            if (item == 245){
                it.remove();
            }
        }
        it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
