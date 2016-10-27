package generics;

public class Averager<E extends Number> {
    // No runtime type information available for E, so these don't work...
//    private E total = new E();
//    private E[] ea = (E[])new Object[4];

    private double total = 0;
    private int count = 0;
//
//    public void include(E number) {
//        total += number.doubleValue();
//        count++;
//    }

    // varargs work, but have to create array of Object which is unsafe in some
    // situations and might "pollute the heap"
    public void include(E... numbers) {
        for (E e : numbers) {
            total += e.doubleValue();
        }
        count += numbers.length;
    }

    public double getMean() {
        return total / count;
    }

    // This cannot work, because E is associated specifically,
    // and only, with instances (at this point.)
//    public static double divide(E dividend, E divisor) {
//        return dividend.
//    }
}
