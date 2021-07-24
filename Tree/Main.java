//binary tree
import java.io.*;
import java.util.*;
public class Main{
   public static class Node {
	int data;
	Node left;
	Node right;
	Node(int data, Node left, Node right) {
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
public static void display(Node node) {
	if (node == null) {
		return;
	}

	String str = "";
	str += node.left == null ? "." : node.left.data + "";
	str += "<- " + node.data + " -> ";
	str += node.right == null ? "." : node.right.data + "";
	System.out.println(str);
	display(node.left);
	display(node.right);
}
    public static int size(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	int sl = size(node.left);
    	int sr = size(node.right);
    	return 1 + sl + sr;
    }
    public static int sum(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	int lsum = sum(node.left);
    	int rsum = sum(node.right);
    	return lsum + rsum + node.data;
    }
    public static int max(Node node) {
    	if (node == null) {
    		return Integer.MIN_VALUE;
    	}
    	int lmax = max(node.left);
    	int rmax = max(node.right);
    	int bmax = Math.max(lmax, rmax);
    	int maxi = Math.max(node.data, bmax);
    	return maxi;
    }
    public static int height(Node node) {
    	if (node == null) {
    		return -1;
    	}
    	int hl = height(node.left);
    	int hr = height(node.right);

    	return 1 + Math.max(hl, hr);
    }
    public static void levelOrder(Node node) {
    	// write your code here

    	Queue<Node> qe = new ArrayDeque<>();
    	qe.add(node);

    	while (qe.size() > 0) {
    		int si = qe.size();
    		for (int i = 0; i<si; i++) {
    			node = qe.remove();
    			System.out.print(node.data + " ");
    			if (node.left != null) {
    				qe.add(node.left);
    			}
    			if (node.right != null) {
    				qe.add(node.right);
    			}
    		}
    		System.out.println();
    	}

    }
    public static void iterativePrePostInTraversal(Node node) {
    	// write your code here
    	if (node == null) {
    		return;
    	}
    	System.out.println(node.data + " pre ");
    	iterativePrePostInTraversal(node.left);
    	System.out.println(node.data + " in ");
    	iterativePrePostInTraversal(node.right);
    	System.out.println(node.data + " Post ");
    }
    public static boolean find(Node node, int data) {
    	// write your code here
    	if (node == null) return false;
    	if (node.data == data) return true;

    	boolean fi = find(node.left, data);
    	if (fi) return true;
    	boolean fr = find(node.right, data);
    	if (fr) return true;

    	return false;
    }
    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
    	if (node == null) return new ArrayList<>();
    	if (node.data == data) {
    		ArrayList<Node> bres = new ArrayList<>();
    		bres.add(node);
    		return bres;
    	}
    	ArrayList<Node> les = nodeToRootPath(node.left, data);
    	if (les.size() > 0) {
    		les.add(node);
    		return les;
    	}

    	ArrayList<Node> res = nodeToRootPath(node.right, data);
    	if (res.size() > 0) {
    		res.add(node);
    		return res;
    	}
    	return new ArrayList<>();
    }
    public static void printKLevelsDown(Node node, int k) {
    	if (node == null) return;

    	if (k == 0) {
    		System.out.println(node.data);
    		return;
    	}
    	printKLevelsDown(node.left, k - 1);
    	printKLevelsDown(node.right, k - 1);
    }
    public static void printKNodesFar(Node node, int data, int k) {
    	ArrayList<Node> path = nodeToRootPath(node, data);
    	for (int i = 0; i<path.size() && i<= k; i++) {
    		printKLevelsDown(path.get(i), k - 1);
    	}
    }
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
    	if (node == null) return;
    	if (node.left != null && node.right != null) {
    		pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
    		pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    	} else if (node.left != null) {
    		pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
    	} else if (node.right != null) {
    		pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    	} else {
    		sum += node.data;
    		path += node.data;
    		if (lo<= sum && sum<= hi) {
    			System.out.println(path);
    		}
    	}
    }
    public static Node createLeftCloneTree(Node node) {
    	if (node == null) return null;
    	Node lcr = createLeftCloneTree(node.left);
    	Node rcr = createLeftCloneTree(node.right);

    	Node nn = new Node(node.data, lcr, null);
    	node.left = nn;
    	node.right = rcr;
    	return node;
    }
	public static void main(String[] args) {
		Integer[] arr = {50 , 25 , 12 , null , null , 37 , 30 , null , null ,40,null,null , 75 , 62 , 60,null,null, 70 , null ,null ,80, null ,null};
		Node root = new Node(arr[0] , null , null); 
		Stack<Pair> st = new Stack<>(); 
		Pair rtp = new Pair(root , 1); 
		st.push(rtp); 
		int idx = 0; 
		while(st.size()>0){
		    Pair top = st.peek();
		    if(top.state == 1){
		        idx++; 
		        if(arr[idx] != null){
		            Node left = new Node(arr[idx] , null , null); 
		            top.node.left = left; 
		            Pair lp = new Pair(left , 1); 
		            st.push(lp); 
		        }else{
		            top.node.left = null;
		        }
		        top.state++; 
		    }else if(top.state == 2){
		        idx++; 
		        if (arr[idx] != null){
		            Node right = new Node(arr[idx] , null , null); 
		            top.node.right = right; 
		            Pair rp = new Pair(right , 1); 
		            st.push(rp); 
		        }else{
		            top.node.right = null ;
		        }
		        top.state++; 
		    }else{
		        st.pop(); 
		    }
		}
// 		int sum = sum(root);
// 		System.out.println(sum);
// 		int size = size(root);
// 		System.out.println(size);
// 		int max = max(root);
// 		System.out.println(max);
// 		int ht = height(root);
// 		System.out.println(ht);
// 		display(root);
//      iterativePrePostInTraversal(root); 
//      levelOrder(root);
//      int data = 70; 
//      boolean found = find(root, data);
//      System.out.println(found);
//      ArrayList<Integer> path = nodeToRootPath(root, data);
//      System.out.println(path);
//      int k = 2; 
//      printKLevelsDown(root, k);
        // int lo = 150;
        // int hi = 250;
        // pathToLeafFromRoot(root," ", 0 ,lo,hi); 
        // createLeftCloneTree(root);
}
}
