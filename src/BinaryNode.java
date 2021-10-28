import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() { return data; }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item)
    {
       if (data.compareTo(item) >= 0) {
           if (left == null) left = new BinaryNode<T>(item);
           else left.insert(item);
       }

       if (data.compareTo(item) < 0) {
           if (right == null) right = new BinaryNode<T>(item);
           else right.insert(item);
       }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        if (data == item) return true;
        if (data.compareTo(item) > 0 && left != null) return left.contains(item);
        if (data.compareTo(item) < 0 && right != null) return right.contains(item);
        return false;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        int heightL = 0;
        int heightR = 0;
        if (left != null) heightL = left.getHeight();
        if (right != null) heightR = right.getHeight();

        return (heightL == 0 && heightR == 0) ? -1 : 1 + Math.max(heightL, heightR);
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) { // intra 18a
        if (this != null) {
            if (left != null) left.fillListInOrder(result);
            result.add(this);
            if (right != null) right.fillListInOrder(result);
        }
    }
}