package pre_ex;

public class Demo1MyException {
    public static void main(String[] args) {
        try {
            show();
        }catch (UserNameRegisterException e){
            e.printStackTrace();
        }
    }

    private static void show() throws UserNameRegisterException{
        throw new UserNameRegisterException("用户名已经被注册了");
    }
}
