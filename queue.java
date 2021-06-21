public class queue {

    private int[] data;
    private int front = 0;
    private int size = 0;

    // constructor
    public queue(int cap) {
        this.data = new int[cap];
    }

    public void add(int val) {
        // dy
        if (this.size == data.length) {
            int[] tem = data;
            data = new int[2 * tem.length];
            for (int i = 0; i < tem.length; i++) {
                int indx = (front + i) % data.length;
                data[i] = tem[indx];
            }
            front = 0;
            data[this.size] = val;
            this.size++;
            // System.out.println("Queue overflow");
            // return;
        }
        int idx = (this.front + this.size) % data.length;
        data[idx] = val;
        this.size++;
    }

    public int remove() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        int val = data[front];
        this.front = (this.front + 1) % data.length;
        this.size--;
        return val;
    }

    public int peek() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
            return -1;
        }
        return data[this.front];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        String str = "";
        str += "[";
        for (int i = 0; i < size - 1; i++) {
            int indx = (i + front) % data.length;
            str += data[indx] + ",";
        }
        str += data[(size - 1 + front) % data.length] + "]";
        return str;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            int indx = (i + front) % data.length;
            System.out.print(data[indx] + " ");
        }
        System.out.println();
    }
}

class queuecheck {
    public static void fun() {
        queue qu = new queue(5);
        qu.add(10);
        qu.add(20);
        qu.add(30);
        qu.add(40);
        qu.add(50);
        qu.add(90);
        qu.add(990);
        qu.add(150);
        System.out.println(qu);
        qu.remove();
        qu.remove();
        System.out.println(qu.peek());
        System.out.println(qu.size());
    }

    public static void main(String[] args) {
        fun();
    }
}
