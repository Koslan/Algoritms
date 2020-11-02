import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {

        Map<Animal, String> enumMap = new EnumMap<Animal, String>(Animal.class);
        enumMap.put(Animal.CAT, "C");
        enumMap.put(Animal.DOG, "D");
        enumMap.put(Animal.BIRD, "B");

        Set set = enumMap.entrySet();

        for(Object o : set ) {
            Map.Entry m  = (Map.Entry) o;
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}


enum Animal {
    CAT, DOG, BIRD
}