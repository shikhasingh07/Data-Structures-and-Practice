import java.util.*;

public class BinaryTree {
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

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));
        int index = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 0) {
                index++;
                if (arr[index] != null) {
                    Node newNode = new Node(arr[index]);
                    top.node.left = newNode;
                    st.push(new Pair(newNode, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    Node newNode = new Node(arr[index]);
                    top.node.right = newNode;
                    st.push(new Pair(newNode, 0));
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static int size(Node root) {
        if (root == null)
            return 0;
        int ls = size(root.left);
        int rs = size(root.right);
        return ls + rs + 1;
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int lmax = max(root.left);
        int rmax = max(root.right);
        int tm = Math.max(lmax, rmax);
        return Math.max(tm, root.data);
    }

    public static int min(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int lmin = min(root.left);
        int rmin = min(root.right);
        int tmin = Math.min(lmin, rmin);
        return Math.min(tmin, root.data);
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int th = Math.max(leftHeight, rightHeight) + 1;
        return th;
    }

    public static void display(Node root) {
        if (root == null)
            return;

        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public static void travelsal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " Pre ");
        travelsal(node.left);
        System.out.println(node.data + " In Order ");
        travelsal(node.right);
        System.out.println(node.data + " Post ");
    }

    public static void levelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // display(root);
        // int size = size(root);
        // System.out.println(size);
        // int sum = sum(root);
        // System.out.println(sum);
        // int max = max(root);
        // System.out.println(max);
        // int min = min(root);
        // System.out.println(min);
        // int height = height(root);
        // System.out.println(height);
        // travelsal(root);
        levelOrder(root);
    }

    public static void main(String[] args) {
        fun();
    }
}