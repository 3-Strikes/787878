package _前缀和_差分_递归;

import java.util.ArrayList;
import java.util.List;

public class EnhancedFibonacci {
    // 存储斐波那契数列，避免重复计算
    private static List<Integer> fibSequence = new ArrayList<>();
    // 存储斐波那契数列的前缀和
    private static List<Integer> prefixSum = new ArrayList<>();
    // 斐波那契数列的差分数组
    private static List<Integer> diffArray = new ArrayList<>();
    
    static {
        // 初始化斐波那契数列、前缀和和差分数组（1000以内）
        initFibonacci(1000);
        initPrefixSum();
        initDiffArray();
    }
    
    public static void main(String[] args) {
        // 测试区间查询功能
        int l = 2;
        int r = 5;
        
        System.out.println("斐波那契数列(索引0开始): " + fibSequence);
        
        System.out.println("\n区间 [" + l + ", " + r + "] 的查询结果:");
        System.out.println("递归法求和: " + recursiveRangeSum(l, r));
        System.out.println("前缀和法求和: " + prefixSumRangeSum(l, r));
        System.out.println("差分法求和: " + diffRangeSum(l, r));
        
        // 测试区间更新后再查询（差分法优势）
        int updateL = 2;
        int updateR = 4;
        int value = 3;
        System.out.println("\n对区间 [" + updateL + ", " + updateR + "] 每个元素加 " + value + " 后:");
        rangeUpdate(updateL, updateR, value);
        System.out.println("更新后的斐波那契数列: " + getUpdatedFibSequence());
        System.out.println("更新后区间 [" + l + ", " + r + "] 的和: " + diffRangeSum(l, r));
    }
    
    /**
     * 初始化斐波那契数列（1000以内）
     */
    private static void initFibonacci(int limit) {
        fibSequence.clear();
        fibSequence.add(0); // F(0) = 0
        if (limit >= 1) {
            fibSequence.add(1); // F(1) = 1
            
            int next;
            int i = 2;
            do {
                next = fibSequence.get(i - 1) + fibSequence.get(i - 2);
                if (next <= limit) {
                    fibSequence.add(next);
                } else {
                    break;
                }
                i++;
            } while (true);
        }
    }
    
    /**
     * 初始化前缀和数组
     */
    private static void initPrefixSum() {
        prefixSum.clear();
        prefixSum.add(0); // 前缀和的第0项为0
        
        int sum = 0;
        for (int num : fibSequence) {
            sum += num;
            prefixSum.add(sum);
        }
    }
    
    /**
     * 初始化差分数组
     */
    private static void initDiffArray() {
        diffArray.clear();
        if (fibSequence.isEmpty()) return;
        
        // 差分数组的第一个元素等于原数组的第一个元素
        diffArray.add(fibSequence.get(0));
        
        // 计算差分数组的其他元素
        for (int i = 1; i < fibSequence.size(); i++) {
            diffArray.add(fibSequence.get(i) - fibSequence.get(i - 1));
        }
        
        // 最后添加一个0，方便区间更新
        diffArray.add(0);
    }
    
    /**
     * 递归计算第n个斐波那契数
     */
    private static int fibonacciRecursive(int n) {
        if (n < 0) return 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    /**
     * 递归法实现区间[l, r]求和（包含l和r）
     */
    public static int recursiveRangeSum(int l, int r) {
        // 检查区间有效性
        if (l < 0 || r < l || r >= fibSequence.size()) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += fibonacciRecursive(i);
        }
        return sum;
    }
    
    /**
     * 前缀和法实现区间[l, r]求和（包含l和r）
     */
    public static int prefixSumRangeSum(int l, int r) {
        // 检查区间有效性
        if (l < 0 || r < l || r >= fibSequence.size()) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        
        // 前缀和公式：sum(l, r) = prefixSum[r+1] - prefixSum[l]
        return prefixSum.get(r + 1) - prefixSum.get(l);
    }
    
    /**
     * 差分法实现区间[l, r]求和（包含l和r）
     */
    public static int diffRangeSum(int l, int r) {
        // 检查区间有效性
        if (l < 0 || r < l || r >= fibSequence.size()) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        
        // 先通过差分数组还原出原数组
        List<Integer> currentFib = getUpdatedFibSequence();
        
        // 计算区间和
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += currentFib.get(i);
        }
        return sum;
    }
    
    /**
     * 差分法实现区间[l, r]所有元素加value
     */
    public static void rangeUpdate(int l, int r, int value) {
        // 检查区间有效性
        if (l < 0 || r < l || r >= fibSequence.size()) {
            throw new IllegalArgumentException("无效的区间范围");
        }
        
        // 差分法更新：只需要修改两个位置
        diffArray.set(l, diffArray.get(l) + value);
        if (r + 1 < diffArray.size()) {
            diffArray.set(r + 1, diffArray.get(r + 1) - value);
        }
    }
    
    /**
     * 通过差分数组获取更新后的斐波那契数列
     */
    public static List<Integer> getUpdatedFibSequence() {
        List<Integer> result = new ArrayList<>();
        if (diffArray.isEmpty()) return result;
        
        // 对差分数组求前缀和，得到更新后的数组
        int current = 0;
        for (int i = 0; i < fibSequence.size(); i++) {
            current += diffArray.get(i);
            result.add(current);
        }
        return result;
    }
}
    