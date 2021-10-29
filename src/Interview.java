public class Interview {

    //TODO: completer
    public static TreeNode solution (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode result = new TreeNode();

        result.val = Math.min(t1.val, t2.val);

        if (t1.left == null && t2.left != null) result.left = t2.left;
        else if (t1.left != null && t2.left == null) result.left = t1.left;
        else if (t1.left != null) result.left = solution(t1.left, t2.left);

        if (t1.right == null && t2.right != null) result.right = t2.right;
        else if (t1.right != null && t2.right == null) result.right = t1.right;
        else if (t1.right != null) result.right = solution(t1.right, t2.right);

        return result;
    }
}