import java.util.*;

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
        System.out.print(node.data + "first" + " ");
        display(node.left);
        System.out.print(node.data + "Mid" + " ");
        display(node.right);
        System.out.print(node.data + "Last" + " ");

    }

    public static void fun() {
        int[] data = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };

        Node root = construct(data, 0, data.length - 1);
        display(root);
    }

    public static void main(String[] args) {

        fun();
    }
}
