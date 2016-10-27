package generics;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExamples {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Fred");
        ls.add("Jim");
        ls.add("Sheila");

        ls.forEach(s -> System.out.println("Item name is " + s));

        ls.removeIf(s -> s.length() < 4);
        ls.forEach(s -> System.out.println("Long item is " + s));

        System.out.println("------------------------------------------");

        Map<String, LocalDate> map = new HashMap<>();
        map.computeIfAbsent("Fred", s -> LocalDate.of(1999, Month.MARCH, 23));
        map.computeIfAbsent("Fred", s -> {
            System.out.println("unexpectedly in block lambda!!!!");
            return LocalDate.of(2000, Month.DECEMBER, 23);
        });
        
        map.compute("Jim", (k,v)-> LocalDate.of(2015, Month.AUGUST, 23));
        map.put("Sheila", LocalDate.of(2001, Month.FEBRUARY, 28));
        
        map.entrySet().forEach(e->System.out.printf("Key: %10s, Val: %30s\n", e.getKey(), e.getValue()));

    }
}
