import java.util.Arrays;

public class BinarySearcher {

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);

        //=====================

        int[] a0 = {1, 4, 6, 10, 20, 100};
        test(a0, -10, -1);
        test(a0, 0, -1);
        test(a0, 1, 0);
        test(a0, 2, -1);
        test(a0, 4, 1);
        test(a0, 5, -1);
        test(a0, 10, 3);
        test(a0, 12, -1);
        test(a0, 20, 4);
        test(a0, 25, -1);
        test(a0, 100, 5);
        test(a0, 110, -1);

        int[] a1 = {1, 4, 6, 10, 20};
        test(a1, -10, -1);
        test(a1, 0, -1);
        test(a1, 1, 0);
        test(a1, 2, -1);
        test(a1, 4, 1);
        test(a1, 5, -1);
        test(a1, 10, 3);
        test(a1, 12, -1);
        test(a1, 20, 4);
        test(a1, 25, -1);
        test(a1, 100, -1);

        int[] a2 = {1, 4, 6};
        test(a2, -10, -1);
        test(a2, 0, -1);
        test(a2, 1, 0);
        test(a2, 2, -1);
        test(a2, 4, 1);
        test(a2, 5, -1);
        test(a2, 6, 2);
        test(a2, 8, -1);

        int[] a3 = {1, 4};
        test(a3, -10, -1);
        test(a3, 0, -1);
        test(a3, 1, 0);
        test(a3, 2, -1);
        test(a3, 4, 1);
        test(a3, 5, -1);

        int[] a4 = {1};
        test(a4, -10, -1);
        test(a4, 0, -1);
        test(a4, 1, 0);
        test(a4, 2, -1);
    }

    public static int binarySearch(int[] a, int value) {
        if (a.length == 0)
            return -1;
        if (a[0] == value)
            return 0;
        if (a[a.length - 1] == value)
            return a.length - 1;
        int l = 0;
        int r = a.length - 1;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] == value)
                return m;
            else if (a[m] > value)
                r = m;
            else
                l = m;
        }
        return -1;
    }

    public static void test(int[] a, int value, int correctAnswer) {
        System.out.println(
                "Looking for " + value + " in " + Arrays.toString(a)
        );
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println(
                "Got " + actualAnswer + " instead of " + correctAnswer
            );
    }
}
