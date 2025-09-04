package _zuoye;

import java.util.ArrayList;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) throws UserNameRegisterException {
        ArrayList<String> list = new ArrayList<>();
        list.add("lucy");
        list.add("lily");
        list.add("Li");
        list.add("Zhao");
        list.add("Qian");
        list.add("Sun");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("欢迎来到用户注册系统，按q退出：");
            System.out.println("请输入你要注册的用户名：");
            String s = sc.next();
            if(s.equals("q")){
                break;
            }
            checkUserName1(s,list);
        }
    }

    private static void checkUserName1(String s, ArrayList<String> list) throws UserNameRegisterException{
        for (int i = 0; i < list.size(); i++) {
            try {
                if(list.get(i).equals(s)){
                    throw new UserNameRegisterException();
                }
            }catch (UserNameRegisterException u){
                System.out.println("非常抱歉用户名:"+s+"已存在");
                return;
            }
        }
        list.add(s);
        System.out.println("恭喜你，用户名："+s+"注册成功");
    }
}
