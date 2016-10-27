package generics;

import java.awt.Color;

public class Shoe implements Sized, Colored {
    private int size;
    private Color color;

    public Shoe(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Shoe{" + "size=" + size + ", color=" + color + '}';
    }
 
}
