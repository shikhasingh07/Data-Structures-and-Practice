import java.util.*;

public class Rfun {

    public static int digitf(int number, int k) {
        if (number == 0 || number < 0) {
            return 0;
        }
        int count = 0;
        while (number != 0) {
            int n = number % 10;
            if (n == k) {
                count++;
            }
            number = number / 10;
        }
        return count;
    }

    public static int decimaltoanybase(int num, int k) {
        if (num == 0 || num < 0) {
            return 0;
        }

        int count = 0;
        int pow = 1;
        while (num != 0) {
            int dig = num % k;
            count += (dig * pow);
            pow *= 10;
            num = num / k;
        }
        return count;
    }

    public static int AnyBasetodecimal(int num, int b) {
        if (num == 0 || num < 0) {
            return 0;
        }
        int count = 0;
        int pow = 1;
        while (num != 0) {
            int dig = num % 10;
            count += dig * pow;
            pow *= b;
            num = num / 10;
        }
        return count;
    }

    public static int anyBase(int n, int k, int l) {
        if (n == 0 || n < 0) {
            return 0;
        }

        int ds = AnyBasetodecimal(n, k);
        int dec = decimaltoanybase(ds, l);
        return dec;
    }

    public static int sub(int b, int n1, int n2) {
        int rev = 0;
        int p = 1;
        int c = 0;

        while (n2 != 0) {
            int d1 = n1 % 10;
            n1 /= 10;
            int d2 = n2 % 10;
            n2 /= 10;
            int digit = 0;
            d2 = d2 + c;
            if (d2 >= d1) {
                c = 0;
                digit = d2 - d1;
            } else {
                c = -1;
                digit = d2 + b - d1;
            }
            rev = rev + digit * p;
            p *= 10;
        }
        return rev;
    }

    public static void fun() {
        // int number = 797549767;
        // int k = 7;
        // int n = 111001;
        int k = 8;
        int n1 = 1;
        int n2 = 100;
        // int count = digitf(number, k);
        // int count = anybase(an, k);
        // int count = AnyBasetodecimal(an, k);
        // int count = anyBase(an, k, l);
        int count = sub(k, n1, n2);
        System.out.println(count);
    }

    public static void main(String[] args) {
        fun();
    }
}