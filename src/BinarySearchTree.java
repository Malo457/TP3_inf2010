import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    public BinarySearchTree(T item) {
        root = new BinaryNode<>(item);
    }

    // O(log(n))
    public void insert(T item) {
        root.insert(item);
    }

    // O(log(n))
    public boolean contains(T item) {
        return root != null && root.contains(item);
    }

    // O(n)
    public int getHeight() {
        int height = root.getHeight();
        return Math.max(height, 0);
    }

    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> result = new ArrayList<>();
        root.fillListInOrder(result);
        return result;
    }

    // O(n)
    public String toStringInOrder() {
        List<BinaryNode<T>> list = getItemsInOrder();
        return "[" + list.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]";
    }
}