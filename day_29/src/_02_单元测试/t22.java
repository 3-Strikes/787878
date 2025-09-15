package _02_单元测试;

import org.junit.Assert;
import org.junit.Test;

public class t22 {
    @Test
    public void a(){
        int arr[] = {3,6,9};

        int sum = sum(arr);
        Assert.assertEquals(18,sum);
    }


    public int sum(int[] arr){
        if(arr==null||arr.length==0){
            throw new RuntimeException("数据异常");
        }
        int sum = 0;

        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
}
