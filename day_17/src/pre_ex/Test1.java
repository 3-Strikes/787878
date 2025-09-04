package pre_ex;

public class Test1 {
    public static void main(String[] args) {
        int v = method();
        System.out.println(v);
    }

    private static int method() {
        int a = 1;

        try {
            a++;
//            int b = 1/0;
            return a;
        }catch (Exception e){
            a++;
        }finally {
            a++;
//            return a;
        }
        return 0;
    }

}
