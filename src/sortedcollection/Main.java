package sortedcollection;

/**
 *
 * @author Maisha Jauernig
 */
public class Main {
    public static void main(String[] args){
        
        // this factory creates IMJ_SC of (IMJ_SC<Integer>)
        MJ_SC_Factory<IMJ_SC<Integer>> fact1 = new MJ_SC_Factory<>();
        
        // this factory creates IMJ_SC of (Integer)
        MJ_SC_Factory<Integer> fact2 = new MJ_SC_Factory<>();
        
       IMJ_SC<IMJ_SC<Integer>> list = fact1.create();
               
        for (int i = 1; i<11; i++){
            
            IMJ_SC<Integer> subList = fact2.create();
            list.add(subList);
            
            for (int j = 10; j>0; j--){
                subList.add(i*j);
            }
        }
        for (int i = 0; i<10; i++){
            IMJ_SC<Integer> subList = list.get(i);
            subList.printAll();
        }
        System.out.println(list.size());
        
        /*IMJ_SC<String> l = new MJ_SC_Factory<String>().create();
        l.add("hi");
        l.printAll();
        l.add("there");
        l.printAll();
        l.add("what");
        l.printAll();
        l.add("is your name");
        l.printAll();*/
        
        /*MJ_SC<Integer> l = new MJ_SC();
        l.add(2);
        l.printAll();
        l.add(5);
        l.printAll();
        l.add(1);
        l.printAll();
        l.add(3);
        l.printAll();
        l.add(0);
        l.printAll();
        l.add(7);
        l.printAll();
        l.add(2);
        l.printAll();
        l.add(9);
        l.printAll();
        l.add(-1);
        l.printAll();
        l.add(4);
        l.printAll();
        l.add(3);
        l.printAll();
        l.add(-4);
        l.printAll();
        l.add(1);
        l.printAll();*/
    }
}
