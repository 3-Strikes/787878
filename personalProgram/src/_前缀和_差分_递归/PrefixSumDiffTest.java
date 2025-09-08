package _前缀和_差分_递归;

import java.util.ArrayList;
import java.util.List;

public class PrefixSumDiffTest {
    // 原始数组
    private static List<Integer> originalArray;
    // 前缀和数组
    private static List<Integer> prefixSum;
    // 差分数组
    private static List<Integer> diffArray;
    
    public static void main(String[] args) {
        // 初始化一个简单的测试数组
        originalArray = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("原始数组: " + originalArray);
        
        // 初始化前缀和与差分数组
        initPrefixSum();
        initDiffArray();
        
        System.out.println("前缀和数组: " + prefixSum);
        System.out.println("差分数组: " + diffArray);
        
//        // 测试区间查询
//        int l = 2, r = 5;
//        System.out.println("\n区间 [" + l + ", " + r + "] 的和:");
//        System.out.println("直接计算: " + directRangeSum(l, r));
//        System.out.println("前缀和计算: " + prefixSumRangeSum(l, r));
//        System.out.println("差分还原后计算: " + diffRangeSum(l, r));
//
//        // 测试区间更新
//        int updateL = 1, updateR = 4;
//        int value = 2;
//        System.out.println("\n对区间 [" + updateL + ", " + updateR + "] 每个元素加 " + value);
//        rangeUpdate(updateL, updateR, value);
//
//        System.out.println("更新后的差分数组: " + diffArray);
//        System.out.println("更新后的数组: " + getUpdatedArray());
//
//        // 测试更新后的区间查询
//        System.out.println("\n更新后区间 [" + l + ", " + r + "] 的和:");
//        System.out.println("差分还原后计算: " + diffRangeSum(l, r));
    }
    
    /**
     * 初始化前缀和数组
     */
    private static void initPrefixSum() {
        prefixSum = new ArrayList<>();
        prefixSum.add(0); // 前缀和的第0项为0
        
        int sum = 0;
        for (int num : originalArray) {
            sum += num;
            prefixSum.add(sum);
        }
    }
    
    /**
     * 初始化差分数组
     */
    private static void initDiffArray() {
        diffArray = new ArrayList<>();
        if (originalArray.isEmpty()) return;
        
        // 差分数组的第一个元素等于原数组的第一个元素
        diffArray.add(originalArray.get(0));
        
        // 计算差分数组的其他元素
        for (int i = 1; i < originalArray.size(); i++) {
            diffArray.add(originalArray.get(i) - originalArray.get(i - 1));
        }
        
        // 最后添加一个0，方便区间更新
        diffArray.add(0);
    }
    
    /**
     * 直接计算区间和（作为对照）
     */
    public static int directRangeSum(int l, int r) {
        checkRangeValidity(l, r);
        
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += originalArray.get(i);
        }
        return sum;
    }
    
    /**
     * 前缀和法计算区间和
     */
    public static int prefixSumRangeSum(int l, int r) {
        checkRangeValidity(l, r);
        
        // 前缀和公式：sum(l, r) = prefixSum[r+1] - prefixSum[l]
        return prefixSum.get(r + 1) - prefixSum.get(l);
    }
    
    /**
     * 差分法计算区间和
     */
    public static int diffRangeSum(int l, int r) {
        checkRangeValidity(l, r);
        
        // 先通过差分数组还原出当前数组
        List<Integer> currentArray = getUpdatedArray();
        
        // 计算区间和
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += currentArray.get(i);
        }
        return sum;
    }
    
    /**
     * 差分法实现区间更新
     */
    public static void rangeUpdate(int l, int r, int value) {
        checkRangeValidity(l, r);
        
        // 差分法更新：只需要修改两个位置
        diffArray.set(l, diffArray.get(l) + value);
        if (r + 1 < diffArray.size()) {
            diffArray.set(r + 1, diffArray.get(r + 1) - value);
        }
    }
    
    /**
     * 通过差分数组获取更新后的数组
     */
    public static List<Integer> getUpdatedArray() {
        List<Integer> result = new ArrayList<>();
        if (diffArray.isEmpty()) return result;
        
        // 对差分数组求前缀和，得到当前数组
        int current = 0;
        for (int i = 0; i < originalArray.size(); i++) {
            current += diffArray.get(i);
            result.add(current);
        }
        return result;
    }
    
    /**
     * 检查区间有效性
     */
    private static void checkRangeValidity(int l, int r) {
        if (l < 0 || r < l || r >= originalArray.size()) {
            throw new IllegalArgumentException("无效的区间范围: [" + l + ", " + r + "]");
        }
    }
}
    