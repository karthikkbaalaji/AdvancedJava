package generics;

import java.time.LocalDateTime;

public class TestPair {
    public static void modifyPair(Pair p) {
        p.setRight(LocalDateTime.now());
    }
    
    public static void main(String[] args) {
        Pair<String> pStr = new Pair<>("Fred", "Jones");
        Pair<String> pStr1 = new Pair<String>("Fred", "Smith");
        
        modifyPair(pStr1);
        String s = pStr1.getRight();
    }
}
