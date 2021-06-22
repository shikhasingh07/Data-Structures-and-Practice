import java.io.*;
import java.util.*;

public class Stackq {

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // i is not celebrity
                st.push(j);
            } else {
                // j is not celebrity
                st.push(i);
            }
        }

        int candidate = st.pop();

        // check its row
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[candidate][c] == 1) {
                System.out.println("none");
                return;
            }
        }
        // check its colum
        for (int r = 0; r < arr.length; r++) {
            if (r != candidate && arr[r][candidate] == 0) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(candidate);
    }

    public static void fun() {

        int[][] arr = { { 0, 0, 0, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };

        findCelebrity(arr);

    }

    public static void main(String[] args) {
        fun();
    }
}