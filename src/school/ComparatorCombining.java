package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorCombining {
    
    public static <E> Comparator<? super E> andThenComparing(Comparator<? super E> first, Comparator<? super E> second) {
        return (a, b) -> {
            int rv = first.compare(a, b);
            if (rv == 0) {
                rv = second.compare(a, b);
            }
            return rv;
        };
    }
    
    public static void main(String[] args) {
         List<Student> roster = Arrays.asList(
                new Student("Fred", 2.9F, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.9F, "Astronomy", "Astro-physics"),
                new Student("Alan", 3.9F, "Astronomy", "Astro-physics"),
                new Student("Susan", 3.9F, "Astronomy", "Astro-physics"),
                new Student("Sheila", 3.7F, "Math", "Statistics", "Physics", "Mechanical Engineering"),
                new Student("Toni", 3.3F, "Art", "History"),
                new Student("Sarah", 1.9F, "Gymnastics"),
                new Student("Sarah", 2.9F, "Gymnastics"),
                new Student("Sarah", 2.0F, "Gymnastics"),
                new Student("Toby", 2.2F, "Art", "Philosophy", "Journalism")
        );
//        roster.sort(Student.getGPAComparator());
//        System.out.println("Sorted by gpa: ");
//        roster.forEach(s->System.out.println("> " + s));
//        System.out.println("------------------------------------");
//
//        roster.sort(Student.getNameComparator());
//        System.out.println("Sorted by name: " + roster);
//        roster.forEach(s->System.out.println("> " + s));
//        System.out.println("------------------------------------");
//
//        roster.sort(andThenComparing(Student.getGPAComparator(), Student.getNameComparator()));
//        System.out.println("By gpa, then name: ");
//        roster.forEach(s->System.out.println("> " + s));
        
        roster.sort(andThenComparing(Student.getNameComparator(), Student.getGPAComparator()));
        System.out.println("By name, then gpa: ");
        roster.forEach(s->System.out.println("> " + s));
        
        System.out.println("------------------------------------");
        List<Student> ls = new ArrayList<>();
        ls.addAll(roster);
        ls.removeIf(Student.getSmartnessPredicate(3.0F));
        System.out.println("Not so smart: ");
        ls.forEach(s->System.out.println("> " + s));

        System.out.println("------------------------------------");
        ls = new ArrayList<>();
        ls.addAll(roster);
        ls.removeIf(Student.getSmartnessPredicate(2.0F));
        System.out.println("Really not so smart: ");
        ls.forEach(s->System.out.println("> " + s));

    }
}
