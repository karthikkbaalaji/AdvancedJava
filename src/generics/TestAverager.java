package generics;

public class TestAverager {

    public static <E extends Number> double divide(E dividend, E divisor) {
        return dividend.doubleValue() / divisor.doubleValue();
    }

    public static void main(String[] args) {
        Averager<Integer> ai = new Averager<>();
        ai.include(1);
        ai.include(3);
        ai.include(5, 7, 9);

        System.out.println("Average of ints is " + ai.getMean());

        // should fail
//        ai.include(3.3);
        Averager<Double> ad = new Averager<>();
        ad.include(3.1);
        ad.include(4.1);
        ad.include(5.1);
        System.out.println("Average of doubles is " + ad.getMean());

        // Constrained invocation of the generic method rejects mixed types
//        System.out.println("3.2 / 6.4 is " + TestAverager.<Double>divide(new Double(3.2), new Integer(6)));
        System.out.println("3.2 / 6.4 is " + TestAverager.<Double>divide(new Double(3.2), new Double(6)));
        // Unconstrained invocation infers a common parent for <E> in this case.
        System.out.println("3.2 / 6.4 is " + TestAverager.divide(new Double(3.2), new Integer(6)));

    }
}
