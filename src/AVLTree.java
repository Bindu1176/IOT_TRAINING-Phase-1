public class AVLTree {

    static class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            height = 1;
        }
    }

    static int height(Node node) {
        return node == null ? 0 : node.height;
    }

    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    static Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {30, 20, 10, 25, 28, 27};
        for (int value : values) {
            root = insert(root, value);
        }
        System.out.print("AVL inorder: ");
        inorder(root);
    }
}