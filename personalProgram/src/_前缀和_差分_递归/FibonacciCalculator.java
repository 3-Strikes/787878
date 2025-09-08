package _前缀和_差分_递归;

public class FibonacciCalculator {
    public static void main(String[] args) {
        int limit = 10;

        long start1 = System.currentTimeMillis();
        System.out.println("递归法计算一千以内的斐波那契数列:");
        printFibonacciRecursive(limit);
        long end1 = System.currentTimeMillis();
        System.out.println("递归法运行时间："+(end1-start1));

        long start2 = System.currentTimeMillis();
        System.out.println("\n前缀和法计算一千以内的斐波那契数列:");
        printFibonacciPrefixSum(limit);
        long end2 = System.currentTimeMillis();
        System.out.println("前缀和方法运行时间："+(end2-start2));
    }

    /**
     * 递归方法计算斐波那契数
     */
    public static int fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    /**
     * 使用递归法打印一千以内的斐波那契数列
     */
    public static void printFibonacciRecursive(int limit) {
        int n = 0;
        while (true) {
            int fib = fibonacciRecursive(n);
            if (fib > limit) {
                break;
            }
            System.out.print(fib + " ");
            n++;
        }
    }

    /**
     * 使用前缀和法打印一千以内的斐波那契数列
     * 前缀和法本质上是迭代法，通过保存前两项的和来计算下一项
     */
    public static void printFibonacciPrefixSum(int limit) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");

        while (true) {
            int c = a + b; // 前缀和计算
            if (c > limit) {
                break;
            }
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}

