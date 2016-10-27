package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

interface StudentCriterion extends Predicate<Student> {

    boolean test(Student s);
}

public class TryStudent {

 
    public static List<Student> getSubListOfStudent(List<Student> ls, StudentCriterion criterion) {
        List<Student> output = new ArrayList<>();
        for (Student s : ls) {
            if (criterion.test(s)) {
                output.add(s);
            }
        }
        return output;
    }

//    public static List<Student> getSmartStudent(List<Student> ls) {
//        List<Student> output = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getGpa() > 3.0F) {
//                output.add(s);
//            }
//        }
//        return output;
//    }
//    
//    public static List<Student> getEnthusiasticStudent(List<Student> ls) {
//        List<Student> output = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getCourses().size() > 2) {
//                output.add(s);
//            }
//        }
//        return output;
//    }
    public static void main(String[] args) {
//        Student s = new Student(null, 0.0F, "Math");

//        List<Student> roster = new ArrayList<>();
//        roster.add(new Student("Jim", 3.9F, "Astronomy", "Astro-physics"));
//        roster.add(new Student("Sheila", 3.7F, "Math", "Statistics", "Physics", "Mechanical Engineering"));
//        roster.add(new Student("Fred", 2.9F, "Math", "Physics", "Chemistry"));
        List<Student> roster = Arrays.asList(
                new Student("Fred", 2.9F, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.9F, "Astronomy", "Astro-physics"),
                new Student("Sheila", 3.7F, "Math", "Statistics", "Physics", "Mechanical Engineering"),
                new Student("Toni", 3.3F, "Art", "History"),
                new Student("Sarah", 1.9F, "Gymnastics"),
                new Student("Toby", 2.2F, "Art", "Philosophy", "Journalism")
        );
        System.out.println("> " + roster);

        // is "Fred" in the list?
        System.out.println("Contains fred? " + roster.contains(new Student("Fred", 2.9F, "Math", "Physics", "Chemistry")));

        // HashSet depends on working equals and hashcode methods
        Set<Student> studentSet = new HashSet<>();
        studentSet.addAll(roster);
        System.out.println("Contains fred? " + studentSet.contains(new Student("Fred", 2.9F, "Math", "Physics", "Chemistry")));

        // TreeSet demands implementation of Comparable
        studentSet = new TreeSet<>();
        studentSet.addAll(roster);
        System.out.println("Contains fred? " + studentSet.contains(new Student("Fred", 2.9F, "Math", "Physics", "Chemistry")));
        System.out.println("Contains other fred? " + studentSet.contains(new Student("Fred", 3.9F, "Journalism")));

        System.out.println("unsorted: " + roster);
        roster.sort(null);
        System.out.println("Sorted:   " + roster);
        roster.sort(Student.getGPAComparator());
        System.out.println("Sorted by gpa:   " + roster);
//        roster.sort(/*new Comparator<Student>() {*/
//            /*@Override
//            public int compare*/(Student o1, Student o2) -> {
//                return o1.getCourses().size() - o2.getCourses().size();
//            }
//        /*}*/);

        Comparator<String> cs = (s1, s2) -> s1.compareTo(s2);
        cs.compare("Fred", "Jim");
        roster.sort((o1, o2) -> o1.getCourses().size() - o2.getCourses().size());

        System.out.println("Sorted by course count:   " + roster);

//        System.out.println("Smart Students: " + getSmartStudent(roster));
        System.out.println("Smart students: " + getSubListOfStudent(roster, s->s.getGpa()>3.0F));
        System.out.println("Enthusiastic: " + getSubListOfStudent(roster, s->s.getCourses().size()>2));
    }
}
