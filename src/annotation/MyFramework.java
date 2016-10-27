package annotation;

import java.lang.reflect.Method;

public class MyFramework {
    public static void main(String[] args) throws Throwable {
//        System.setSecurityManager(new SecurityManager());
        String name = "annotation.TargetClass";
        Class cl = Class.forName(name);
        Object obj = cl.newInstance();
        System.out.println("Found: " + cl.getName() + " which is: " + obj);
        
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("> " + m);
            RunMe annot = m.getAnnotation(RunMe.class);
            if (annot != null) {
                System.out.println("****** ANNOTATION FOUND! name is " + annot.name());
                m.setAccessible(true);
                m.invoke(obj);
            }
        }
    }
        
}
