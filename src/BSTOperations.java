import java.util.stream.StreamSupport;

public class BSTOperations {
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data=data;
        }
    }
    static Node insert(Node root,int value) {
        if(root==null) {
            return new Node(value);
        }
        if(value<root.data) {
            root.left = insert(root.left,value);
        }
        else if(value>root.data) {
            root.right = insert(root.right,value);
        }
        return root;
    }
    static boolean search(Node root , int value) {
        if(root==null)
            return false;
        if(root.data==value)
            return true;
        if(value<root.data)
            return search(root.left,value);
        return search(root.right,value);
    }
    static Node findMin(Node root) {
       while(root.left!=null) {
           root=root.left;
       }
       return root;
    }
    static Node delete(Node root,int value) {
        if(root==null)
            return null;
        if(value<root.data) {
            root.left = delete(root.left,value);
        } else if(value > root.data) {
            root.right = delete(root.right,value);
        }
        else {
            if(root.left==null && root.right==null) {
                return null;
            }
            if(root.left==null) {
                return root.right;
            }
            if(root.right==null) {
                return root.left;
            }
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right,successor.data);
        }
        return root;
    }
    static void inorder(Node root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+"");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = null;
        int[] values = {50,30,70,20,40,60,80};
        for(int value : values) {
            root = insert(root,value);
        }
        System.out.print("BST Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Search 40 : "+search(root,40));
        System.out.println("Search 90 : "+search(root,90));
        root = delete(root,30);
        System.out.print("After deleting 30 : ");
        inorder(root);
    }
}
