package streamexample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import school.Student;

public class StudentGradification {

    private static final String[] grades = {"D", "C", "B", "A"};

    public static void main(String[] args) {
        List<Student> roster = Arrays.asList(
                new Student("Fred", 2.9F, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.9F, "Astronomy", "Astro-physics"),
                new Student("Sheila", 3.7F, "Math", "Statistics", "Physics", "Mechanical Engineering"),
                new Student("Toni", 3.3F, "Art", "History"),
                new Student("Julian", 3.8F, "Astronomy", "Statistics"),
                new Student("Sarah", 1.9F, "Gymnastics"),
                new Student("Sally", 3.9F),
                new Student("Toby", 2.2F, "Art", "Philosophy", "Journalism")
        );

        Map<String, List<Student>> result = roster.stream()
                .collect(Collectors.groupingBy(s -> grades[(int) (s.getGpa())]));

        result.entrySet()
                .forEach(e
                        -> System.out.println(e.getKey() + " : "
                                + e.getValue()
                                .stream()
                                .map(s -> s.getName())
                                .reduce("", (s, t) -> s + ", " + t)));

        System.out.println("----------------------------------------------");

        roster.stream()
                .collect(Collectors.groupingBy(s -> grades[(int) (s.getGpa())], Collectors.counting()))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        System.out.println("----------------------------------------------");

        roster.stream()
                .collect(Collectors.groupingBy(s -> grades[(int) (s.getGpa())],
                                    Collectors.mapping(s->s.getName(), 
                                            Collectors.joining(", "))))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
