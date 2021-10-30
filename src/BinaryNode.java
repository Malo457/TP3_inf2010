import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private final T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // O(1)
    public BinaryNode(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // O(1)
    public T getData()
    {
        return data;
    }

    // O(log(n))
    public void insert(T item) {
        if (data.compareTo(item) >= 0) {
            if (left == null) left = new BinaryNode<>(item);
            else left.insert(item);
        }
        else {
            if (right == null) right = new BinaryNode<>(item);
            else right.insert(item);
        }
    }

    // O(log(n))
    public boolean contains(T item) {
        if (data.compareTo(item) == 0) return true;
        else if (data.compareTo(item) > 0 && left != null) return left.contains(item);
        else if (right != null) return right.contains(item);
        return false;
    }

    // O(n)
    public int getHeight() {
        int heightL = 0;
        int heightR = 0;
        if (left != null) heightL = left.getHeight();
        if (right != null) heightR = right.getHeight();

        return (heightL == 0 && heightR == 0) ? -1 : 1 + Math.max(heightL, heightR);
    }

    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if (left != null) left.fillListInOrder(result);
        result.add(this);
        if (right != null) right.fillListInOrder(result);
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
}