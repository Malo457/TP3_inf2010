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
       if (data.compareTo(item) < 0) {
           if (left == null) left = new BinaryNode<T>(item);
           else left.insert(item);
       }

       if (data.compareTo(item) > 0) {
           if (right == null) right = new BinaryNode<T>(item);
           else right.insert(item);
       }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        boolean itemFound = false;
        while (this != null && !itemFound) {
            if (data == item) itemFound = true;
            if (data.compareTo(item) < 0) left.contains(item);
            if (data.compareTo(item) > 0) right.contains(item);
        }
        return itemFound;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() { // notes de cours
        if (this == null) return -1;
        else return 1 + Math.max(left.getHeight(), right.getHeight());
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        result.add(left);
        result.add(this);
        result.add(right);
    }
}