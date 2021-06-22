import java.util.*;

//Push Efficient
class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
        // write your code here
    }

    void push(int val) {
        mainQ.add(val);
        // write your code here
    }

    int pop() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.peek();
        mainQ.remove();
        Queue<Integer> tem = mainQ;
        mainQ = helperQ;
        helperQ = tem;

        return val;
    }

    int top() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        int val = mainQ.peek();
        helperQ.add(mainQ.remove());
        Queue<Integer> tem = mainQ;
        mainQ = helperQ;
        helperQ = tem;

        return val;
        // write your code here
    }
}

// Pop Efficient
class QueueToStackAdapterpop {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapterpop() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
        // write your code here
    }

    void push(int val) {
        while (mainQ.size() > 0) {
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);

        while (helperQ.size() > 0) {
            mainQ.add(helperQ.remove());
        }
        // write your code here
    }

    int pop() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        // write your code here
        return mainQ.remove();
    }

    int top() {
        if (mainQ.size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return mainQ.peek();
        // write your code here
    }
}

class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        return mainS.size();
        // write your code here
    }

    void add(int val) {
        mainS.push(val);
        // write your code here
    }

    int remove() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }
        int val = mainS.pop();

        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
        return val;
        // write your code here
    }

    int peek() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }
        int val = mainS.peek();
        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
        return val;
        // write your code here
    }
}

class StackToQueueAdapterpop {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapterpop() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        return mainS.size();
        // write your code here
    }

    void add(int val) {
        while (mainS.size() > 0) {
            helperS.push(mainS.pop());
        }
        mainS.push(val);

        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
        // write your code here
    }

    int remove() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return mainS.pop();
        // write your code here
    }

    int peek() {
        if (mainS.size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return mainS.peek();
        // write your code here
    }
}

class TwoStack {
    int[] data;
    int tos1;
    int tos2;

    public TwoStack(int cap) {
        data = new int[cap];
        tos1 = -1;
        tos2 = cap;
        // write your code here
    }

    int size1() {
        return tos1 + 1;
        // write your code here
    }

    int size2() {
        // write your code here
        return data.length - tos2;
    }

    void push1(int val) {
        if (tos1 + 1 < tos2) {
            data[tos1 + 1] = val;
            tos1++;
        } else {
            System.out.println("Stack overflow");
        }
        // write your code here
    }

    void push2(int val) {
        if (tos1 + 1 < tos2) {
            data[tos2 - 1] = val;
            tos2--;
        } else {
            System.out.println("Stack overflow");
        }
        // write your code here
    }

    int pop1() {
        if (tos1 == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = data[tos1];
            tos1--;
            return val;
        }
        // write your code here
    }

    int pop2() {
        if (tos2 == data.length) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = data[tos2];
            tos2++;
            return val;
        }
        // write your code here
    }

    int top1() {
        if (tos1 == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = data[tos1];
            return val;
        }
        // write your code here
    }

    int top2() {
        if (tos2 == data.length) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int val = data[tos2];
            return val;
        }
        //
        // write your code here
    }
}

public class queuesF {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> newq = new ArrayDeque<>();
        Stack<Integer> st = new Stack<>();
        int le = q.size();
        for (int i = 0; i < k; i++) {
            st.push(q.peek());
            q.remove();
        }
        while (!st.isEmpty()) {
            newq.add(st.peek());
            st.pop();
        }
        for (int i = 0; i < le - k; i++) {
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