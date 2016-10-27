package streamexample;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import school.Student;

public class StreamsOne {

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

        roster.stream()
                .filter(s -> s.getCourses().size() > 2)
                .map(s -> s.getName() + ", has gpa " + s.getGpa())
                .forEach(s -> System.out.println("Student: " + s));

        System.out.println("-------------------------------------");

        roster.stream()
                .filter(s -> s.getGpa() > 3.0F)
                .flatMap(s -> s.getCourses().stream())
                .distinct()
                .sorted()
                .forEach(s -> System.out.println(s));

        System.out.println("-------------------------------------");
//       ^ roster.add(new Student("Latecomer", 2.8F, "Math"));
        roster.stream()
                .peek(s -> System.out.println("peek: " + s))
                .filter(s -> s.getGpa() > 2.0F) //                .forEach(s->System.out.println("forEach: " + s))
                ;

        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(s -> System.out.println(s));
        System.out.println("--------------------------------------");

        OptionalInt res = IntStream.iterate(1, i -> i + 2)
                .limit(20)
                //                .forEach(i-> System.out.println(i))
                .reduce((i, j) -> i + j);

        res.ifPresent(v -> System.out.println("Sum is " + v));
        System.out.println("--------------------------------------");

        Stream.iterate("A", v -> {
            int seq = v.charAt(0) - 'A';
            seq = (++seq) % 26;
            seq += 'A';
            return "" + ((char) seq);
        })
                .parallel()
                .unordered()
                .limit(120)
                .reduce((i, j) -> i + j)
                .ifPresent(s->System.out.println(s));
                ;
                
    }
}
