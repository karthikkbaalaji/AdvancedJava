package generics;

import java.awt.Color;

public class TheStore {
    public static void main(String[] args) {
        // Cannot do "constrained" type declarations for variables, only for Type-variables in generics
//        Sized & Colored shoe = new Shoe(8, Color.RED);
        Pair<Shoe> pShoe = new Pair<Shoe>(new Shoe(8, Color.RED), new Shoe(9, Color.RED));
        System.out.println("Shoes are " + pShoe);
        System.out.println("The shoes are a pair? " + pShoe.isMatched());
        pShoe = new Pair<>(new Shoe(9, Color.BLACK), new Shoe(9, Color.BLUE));
        System.out.println("The shoes are a pair? " + pShoe.isMatched());
        Pair<Sock> pSock = new Pair<>(new Sock(6, Color.GREEN), new Sock(6, Color.RED));
        System.out.println("Socks match? " + pSock.isMatched());
    }
}
