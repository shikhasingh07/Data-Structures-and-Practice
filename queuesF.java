import java.util.*;

public class queuesF {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> newq = new ArrayDeque<>();
        Stack<Integer> st = new Stack<>();
        int le = q.size();
        for (int i = 0; i < k; i++) {
            st.push(q.peek());
            q.remove(); 
        }
        while(!st.isEmpty()){
            newq.add(st.peek()); 
            st.pop(); 
        }
        for (int i = 0 ; i < le - k ; i ++){
            newq.add(q.peek());
            q.remove();
        }
        // add code here.
        return newq;
    }

    public static void fun() {
        Queue<Integer> qu;
        qu = new ArrayDeque<>();

        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        int k = 3;
        Queue<Integer> ans = modifyQueue(qu, k);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        fun();
    }
}