package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class Student implements Comparable<Student> {

    private String name;
    private float gpa;
    private List<String> courses;

    private Student() {
    }

    public Student(String name, float gpa, String... courses) {
        // should verify "acceptable" (e.g. non-null) arguments!!!!
        assert name != null : "Must provide a student with a real name";
        this.name = name;
        this.gpa = gpa;
        this.courses = Collections.unmodifiableList(Arrays.asList(courses));
    }

    public static Student byNameGpaCourses(String name, float gpa, String... courses) {
        // should verify "acceptable" (e.g. non-null) arguments!!!!
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        self.courses = Collections.unmodifiableList(Arrays.asList(courses));
        return self;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    public Student addCourses(String... moreCourses) {
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        List<String> newCourses = new ArrayList(this.courses);
        newCourses.addAll(Arrays.asList(moreCourses));
        self.courses = Collections.unmodifiableList(newCourses);
        return self;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Float.floatToIntBits(this.gpa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.gpa) != Float.floatToIntBits(other.gpa)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

//    private static final Comparator<Student> gpaComparator = new GPAComparator();
//    public static Comparator<Student> getGPAComparator() {
//        return gpaComparator;
//    }
//    
//    private static class GPAComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            return Float.compare(o1.gpa, o2.gpa);
//        }
//
//    }
    private static final Comparator<Student> gpaComparator = new /*GPAComparator();
   
    private static class GPAComparator implements */ Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return Float.compare(o1.gpa, o2.gpa);
        }

    };

    public static Comparator<Student> getGPAComparator() {
        return gpaComparator;
    }

    private static final Comparator<Student> nameComparator = (a, b) -> a.name.compareTo(b.name);

    public static Comparator<Student> getNameComparator() {
        return nameComparator;
    }

    public static Predicate<Student> getSmartnessPredicate(/* effectively final*/  float t) {
        float[] ta = {t};
        ta[0]++;
//        threshold ++;
        return new Predicate<Student>() {

            @Override
            public boolean test(Student t) {
                return t.getGpa() >= ta[0];
            }
        };
    }
}
