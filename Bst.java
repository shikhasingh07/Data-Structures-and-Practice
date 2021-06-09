// import java.util.*;

public class Bst {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int arr[], int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node ntobuild = new Node(arr[mid]);

        ntobuild.left = construct(arr, left, mid - 1);
        ntobuild.right = construct(arr, mid + 1, right);
        return ntobuild;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String res = node.left != null ? node.left.data + " " : " . ";
        res += node.data + " ";
        res += node.right != null ? node.right.data + " " : " . ";
        System.out.println(res + " ");
        display(node.left);
        display(node.right);

    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int left = size(root.left);
        int right = size(root.right);

        return left + right + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        return left + right + root.data;
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.right == null) {
            return root.data;
        }
        int max = max(root.right);
        return max;
    }

    public static int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.right == null) {
            return root.data;
        }
        int min = min(root.left);
        return min;
    }

    public static boolean find(Node root, int num) {
        if (root == null) {
            return false;
        }

        if (root.data == num) {
            return true;
        }
        boolean f1 = find(root.left, num);
        if (f1) {
            return true;
        }
        boolean f2 = find(root.right, num);
        if (f2) {
            return true;
        }
        return false;
    }

    public static Node add(Node root, int newNumber) {
        if (root == null) {
            Node nn = new Node(newNumber);
            return nn;
        }
        if (root.data > newNumber) {
            root.right = add(root.left, newNumber);
        } else if (root.data < newNumber) {
            root.left = add(root.right, newNumber);
        }
        return root;
    }

    // 10/6/2021
    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null) {
            return;
        }
        rwsol(node.right);
        int data = node.data;
        node.data = sum;
        sum += data;
        rwsol(node.left);
    }
    public static int lca (Node )
    public static void fun() {
        int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        Node root = construct(data, 0, data.length - 1);
        // display(root);
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        int num = 57;
        int newNumber = 61;
        boolean find = find(root, num);
        Node add = add(root, newNumber);
        rwsol(root);
        // System.out.println(
        // "size :- " + size + " sum :- " + sum + " max :- " + max + " min :- " + min +
        // " find :- " + find);
        display(root);
    }

    public static void main(String[] args) {

        fun();
    }
}
