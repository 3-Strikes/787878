package _内部类;

public class MemberInner {
    private int outerVar = 100;
    class Inner{
        void accessOuter(){
            System.out.println(outerVar);
        }
    }

    void method(){
        int localVar = 50;

        class LocalInner{
            void access(){
                System.out.println(outerVar);
                System.out.println(localVar);
            }
        }

        LocalInner inner = new LocalInner();
        inner.access();
    }
    public static void main(String[] args) {
        //创建内部类实例：外部类实例。new内部类（）
        MemberInner outer = new MemberInner();
        MemberInner.Inner inner = outer.new Inner();
        inner.accessOuter();

        new MemberInner().method();
    }
}
