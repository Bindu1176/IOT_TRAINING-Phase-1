public class TreeProperties {
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
        }
    }
    static int diameter = 0;
    static int height(Node root) {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter,leftHeight+rightHeight);
        return 1 + Math.max(leftHeight,rightHeight);
    }
    static int maxSum = Integer.MIN_VALUE;
    static int maxPathSum(Node root) {
        if(root==null)
            return 0;
        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));
        int current = root.data+left+right;
        maxSum = Math.max(maxSum,current);
        return root.data+Math.max(left,right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        height(root);
        System.out.println("Tree Diameter : "+diameter);
        maxPathSum(root);
        System.out.println("Maximum Path Sum : "+maxSum);
    }
}