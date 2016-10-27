package generics;

// constrained type-variable declaration, must be both
// Sized and Colored
public class Pair<E extends Sized & Colored> {
    private E left;
    private E right;

    public Pair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public E getRight() {
        return right;
    }

    public void setRight(E right) {
        this.right = right;
    }

    public boolean isMatched() {
        return left.getSize() == right.getSize()
                && left.getColor().equals(right.getColor());
    }
    @Override
    public String toString() {
        return "Pair{" + "left=" + left + ", right=" + right + '}';
    }
    
}
