package annotation;

//@RunMe
public class TargetClass {
    
//    @RunMe
    private int value;
    
    @RunMe("1235")
    public void doStuff() {
        System.out.println("in TargetClass.doStuff()");
    }
    
    public void dontDoStuff() {
        System.out.println("Should not see this...");
    }
    
    @RunMe(name="Fred", value="Something!")
    private void doMoreStuff() {
        System.out.println("Should see this too...");
    }
    
    @Override
    public String toString() {
        return "Hello, I'm a TargetClass!";
    }
}
