package _03_递归;

public class t31 {
    public static void main(String[] args) {
        System.out.println(digui(5));
    }

    public static int digui(int n){
        if(n==1){
            return 1;
        }else {
            return digui(n-1)*n;
        }
    }
}
