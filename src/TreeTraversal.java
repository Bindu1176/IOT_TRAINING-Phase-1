import java.util.SplittableRandom;

public class TreeTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    static void preorder(Node root) {
        if(root==null)
            return;
        System.out.println(root.data+"");
        preorder(root.left);
        preorder(root.right);
    }
    static void inorder(Node root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data+"");
        inorder(root.right);
    }
    static void postorder(Node root) {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+"");
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        System.out.print("Preorder :");
        preorder(root);
        System.out.print("\nInorder : ");
        inorder(root);
        System.out.print("\nPostorder : ");
        postorder(root);
    }
}
