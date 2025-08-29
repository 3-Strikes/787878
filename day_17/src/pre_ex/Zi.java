package pre_ex;

public class Zi extends Fu{
    public void method(){
        System.out.println("Zi...method");
        try {
            throw new Exception("子类重写后出问题了！！！！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
