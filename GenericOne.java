import java.util.*;

public class GenericOne {
    public static class Node {
        int data;
        ArrayList<Node> children;

        public Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node root) {
        int sz = 0;
        for (Node child : root.children) {
            sz += size(child);
        }
        return sz + 1;
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (data != -1) {
                Node nn = new Node(data);
                if (st.size() == 0) {
                    root = nn;
                    st.push(nn);
                } else {
                    st.peek().children.add(nn);
                    st.push(nn);
                }
            } else {
                st.pop();
            }
        }

        return root;
    }

    // /29/05/2021
    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;
        boolean res = false;
        for (Node child : node.children) {
            res = find(child, data);
            //
            if (res == true)
                return true;
        }

        return res;
    }

    /// Second
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(node.data);
            return res;
        }
        for (Node child : node.children) {
            ArrayList<Integer> rres = nodeToRootPath(child, data);
            if (rres.size() > 0) {
                rres.add(node.data);
                return rres;

            }
        }
        return new ArrayList<>();
    }

    // third
    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1); //
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return p1.get(i);
    }

    // 30/05/2021
    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static Node getTail(Node node) {
        Node Tail = node; //
        while (Tail.children.size() != 0) {
            Tail = Tail.children.get(0);
        }

        return Tail;
    }

    public static void lin(Node node) {
        for (Node child : node.children) {
            lin(child);
        }
        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node last = node.children.get(i + 1); //
            Node slast = node.children.get(i);

            node.children.remove(last); //
            Node tail = getTail(slast); //
            tail.children.add(last);
        }
    }

    // 31/05/2021
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> dis1 = nodeToRootPath(node, d1);
        ArrayList<Integer> dis2 = nodeToRootPath(node, d2);//

        int di1 = dis1.size() - 1;
        int di2 = dis2.size() - 1;

        while (di1 >= 0 && di2 >= 0 && dis1.get(di1) == dis2.get(di2)) {
            di1--;
            di2--;
        }

        di1++;
        di2++;
        return di1 + di2;
        // write your code here
    }

    // Second
    public static boolean areSimilar(Node n1, Node n2) {

        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (areSimilar(c1, c2) == false) {
                return false;
            }
        }

        return true; // write your code here
    }

    // travel and change
    // Third
    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - i - 1);
            if (areMirror(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    // fouth
    public static boolean IsSymmetric(Node node) {
        // write your code here
        boolean res = areMirror(node, node);
        return res;
    }

    // five
    static int height = 0;
    static int size = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void multiSolver(Node node, int depth) {
        size++;
        height = Math.max(height, depth);
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        for (Node child : node.children) {
            multiSolver(child, depth + 1);
        }

    }

    // 6/02/2021
    static Node predecessor;
    static Node successor;
    static int state = 0;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        for (Node child : node.children) {
            predecessorAndSuccessor(child, data);
        }
    }

    // second
    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
        // Write your code here
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    // third
    public static int kthLargest(Node node, int k) {
        int data = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node, data);
            data = floor;
        }
        return data;
        // write your code here
    }

    // fouth
    static int maxsu = 0;
    static int ms = Integer.MIN_VALUE;

    public static int subTreeSum(Node root) {
        int sum = 0;
        for (Node child : root.children) {
            sum += subTreeSum(child);
        }
        sum += root.data;
        if (sum > ms) {
            maxsu = root.data;
            ms = sum;
        }
        // System.out.print(root.data + " @ " + sum);
        return sum;
    }

    // 6/03/2021
    static int dia = 0;

    public static int calcul(Node node) {
        int dch = -1;
        int sdch = -1;
        for (Node child : node.children) {
            int ch = calcul(child);
            if (ch > dch) {
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
        }

        if (dch + sdch + 2 > dia) {
            dia = dch + sdch + 2;
        }
        dch += 1;
        return dch;
    }

    // Second
    public static class pair {
        Node node;
        int state;

        public pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<pair> st = new Stack<>();
        st.push(new pair(node, -1));

        String pre = "";
        String post = "";
        while (st.size() > 0) {
            pair top = st.peek();
            if (top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += top.node.data + " ";
                st.pop();
            } else {
                pair cp = new pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    public static void fun() {
        int[] data = { 10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1 };
        int[] data2 = { 1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, -1, -1, };

        Node root = construct(data);
        IterativePreandPostOrder(root);
        // int ro = calcul(root);
        // System.out.println(dia);
        // subTreeSum(root);
        // System.out.println(maxsu + " @ " + ms);
        // int daa = 70;
        // int k = 5;
        // ceil = Integer.MAX_VALUE;
        // floor = Integer.MIN_VALUE;
        // int kth = kthLargest(root, k);
        // System.out.println(kth);
        // ceilAndFloor(root, daa);
        // System.out.println("CEIL = " + ceil);
        // System.out.println("FLOOR = " + floor);
        // root2 = construct(data2);
        // int daa = 70;
        // ecessorAndSuccessor(root, daa);
        // if (predecessor == null) {
        // System.out.println("Predecessor = Not found");
        // } else {
        // System.out.println("Predecessor = " + predecessor.data);
        // }

        // if (successor == null) {
        // System.out.println("Successor = Not found");
        // } else {
        // System.out.println("Successor = " + successor.data);
        // }
        // multiSolver(root, 0);
        // System.out.println("Height :- > " + height);
        // System.out.println("Size :->" + size);
        // System.out.println("Max :->" + max);
        // System.out.println("Min :-> " + min);
        // Boolean getNum = IsSymmetric(root);
        // boolean getNum = areMirror(root, root2);
        // boolean getNum = areSimilar(root, root2);
        // lin(root);
        // display(root);
        // int d1 = 70;
        // int d2 = 110;
        // int getNum = distanceBetweenNodes(root, d1, d2); // ;
        // System.out.println(getNum);
        // display(root);
        // System.out.println("Before");
        // removeLeaves(root);
        // System.out.println("After");
        // display(root);
    }

    public static void main(String[] args) {
        fun();
    }
}