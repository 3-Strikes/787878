package pre_ex;

public class Demo03ExceptionThrow {
    public static void main(String[] args) throws Exception {
//        int[] array = {100, 200, 300};
//        //array = null;
//        int value = getValue(array, 5);
//
//        System.out.println("main方法中正确获取到数组元素值: " + value);

        System.out.println("组长安排程序员跑圈开始....");
        try {
            sports(5);
        }catch (Exception e){
            System.out.println("抓紧来点速效救心丸...");
        }

        System.out.println("组长安排程序员跑圈结束....");

        try{
            int[] arr = {100,200,300};
            arr = null;
            int value = arr[2];
            System.out.println("value"+value);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界异常被处理了....");
            e.printStackTrace();
        }finally {
            System.out.println("老子一定要执行...");
        }

    }

    public static int getValue(int[] array, int index) {
        //如果数组是null,抛出空指针异常
        if (array == null) {
            throw new NullPointerException("数组array是null了,不能获取元素了?");
        }
        //如果索引越界,抛出索引越界异常
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("数组索引越界了: "+index);
        }
        int value = array[index];
        System.out.println("getValue方法中正确获取到数组元素值: " + value);
        return value;
    }
    //模拟程序猿锻炼身体: 跑圈
    public static void sports(int num) throws Exception {
        System.out.println("已经跑了3圈....");
        if (num > 3) {
            throw new Exception("心脏病发作....");
        }
    }
}
