package school;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericFiltering {

    public static <E> List<E> filterList(List<? extends E> input, Predicate<? super E> criterion) {
        List<E> output = new ArrayList<>();
        for (E s : input) {
            if (criterion.test(s)) {
                output.add(s);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> lStr = Arrays.asList("Fred", "James", "Susanna", "William");
        System.out.println("Names longer than 5: " + filterList(lStr, s -> s.length() > 5));
        
        List<LocalDate> lDat = Arrays.asList(
                LocalDate.of(2016, Month.MARCH, 1),
                LocalDate.of(2006, Month.APRIL, 1),
                LocalDate.of(1999, Month.DECEMBER, 31),
                LocalDate.of(2000, Month.MARCH, 1),
                LocalDate.of(2000, Month.MARCH, 2)
        );
        
        Predicate<Object> testObject = o -> o == lDat.get(0);
        System.out.println("Dates matching object test: " + filterList(lDat, testObject));
        
        
        System.out.println("Dates in March: " + filterList(lDat, d -> d.getMonth() == Month.MARCH));
    }
}
