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

    public static void iterativePrePostInTraversal(Node node) {
        // write your code here
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 0));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> In = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                pre.add(p.node.data);
                p.state++;
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
            } else if (p.state == 1) {
                In.add(p.node.data);
                p.state++;
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
            } else {
                post.add(p.node.data);
                st.pop();
            }
        }
        for (int val : pre) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : In) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (int val : post) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static boolean find(Node node, int find) {
        if (node == null) {
            return false;
        }
        if (find == node.data) {
            return true;
        }
        boolean f1 = find(node.left, find);
        if (f1) {
            return true;
        }
        boolean f2 = find(node.right, find);
        if (f2) {
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> nodeTopath(Node node, int fin) {
        if (node == null) {
            return new ArrayList<>();
        }

        if (node.data == fin) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }

        ArrayList<Integer> lres = nodeTopath(node.left, fin);
        if (lres.size() > 0) {
            lres.add(node.data);
            return lres;
        }

        ArrayList<Integer> rres = nodeTopath(node.right, fin);
        if (rres.size() > 0) {
            rres.add(node.data);
            return rres;
        }
        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static void fun() {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        int find = 87;
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
        // levelOrder(root);
        // iterativePrePostInTraversal(root);
        // boolean fin = find(root, find);
        // System.out.println(fin);
        // ArrayList<Integer> ans = nodeTopath(root, find);
        // System.out.println(ans);
        int k = 1;
        printKLevelsDown(root, k);

    }

    public static void main(String[] args) {
        fun();
    }
}