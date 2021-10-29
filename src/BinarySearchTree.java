import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    // TODO: initialisation
    public BinarySearchTree(T item) { root = new BinaryNode(item); }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) { root.insert(item); }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) { return root != null && root.contains(item); }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        int height = root.getHeight();
        return Math.max(height, 0);
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> result = new ArrayList<BinaryNode<T>>();
        root.fillListInOrder(result);
        return result;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        List<BinaryNode<T>> list = getItemsInOrder();
        StringBuilder result = new StringBuilder("[");
        int i = list.size();

        for (BinaryNode<T> node : list){
            result.append(node.getData());
            if (--i != 0) result.append(", ");
        }
        result.append("]");

        return result.toString();
        /*T[] array = (T[]) new Object[list.size()];
        int i = 0;
        for (BinaryNode<T> node : list){
            array[i++] = node.getData();
        }

        return Arrays.toString(array);*/
    }
}