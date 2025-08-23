package String练习;

import java.util.Scanner;

public class exAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段文本（包含字母、数字、空格和标点）：");
        String original = sc.nextLine();

        if(original==null||original.isEmpty()){
            System.out.println("输入不能为空！");
            sc.close();
            return;
        }

        System.out.println("\n===== 原始文本 ====");
        System.out.println(original);

        int length = original.length();
        int upperCount = 0,lowerCount = 0,digitCount = 0;
        int spaceCount = 0,punctuationCount = 0;

        String punctuation = ",.!?;:'\"(){}[]";

        for (int i = 0; i < length; i++) {
            char c = original.charAt(i);
            if(Character.isUpperCase(c)){
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isSpaceChar(c)) {
                spaceCount++;
            } else if (punctuation.indexOf(c)!=-1) {
                punctuationCount++;
            }
        }

        System.out.println("\n==== 字符统计 ====");
        System.out.println("字符串长度："+length);
        System.out.println("大写字母数量："+upperCount);
        System.out.println("小写字母数量："+lowerCount);
        System.out.println("数字字符数量："+digitCount);
        System.out.println("空格数量："+spaceCount);
        System.out.println("标点符号数量："+punctuationCount);

        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if(Character.isUpperCase(c)){
                sbd.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sbd.append(Character.toUpperCase(c));
            }else {
                sbd.append(c);
            }
        }
        System.out.println("\n==== 交换大小写后 ====");
        System.out.println(sbd.toString());

        //3、提前所有数字
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char c =original.charAt(i);
            if(Character.isDigit(c)){
                digits.append(c);
            }
        }
        String digitStr = digits.toString();
        System.out.println("\n==== 提取的数字 ====");
        System.out.println(digitStr.isEmpty()?"无数字":digitStr);

        //4、查找字串出现位置和次数
        String target = "test";
        int count = 0;
        int index = original.indexOf(target);
        System.out.println("\n===== 子串 \"" + target + "\" 出现位置 =====");
        if(index==-1){
            System.out.println("未找到该字串");
        }else {
            while(index != -1){
                count++;
                System.out.println("位置："+index);
                index = original.indexOf(target,index+target.length());
            }
            System.out.println("共出现："+count+" 次");
        }

        //5、替换所有空格为下划线
        String spaceReplaced = original.replace(' ','_');
        System.out.println("\n==== 空格替换为下划线后 ====");
        System.out.println(spaceReplaced);

        //6、使用StringBuilder进行复杂处理
        StringBuilder processed = new StringBuilder(original);

        processed.insert(0,"【开始】");
        processed.append("【结束】");
        System.out.println(processed.toString());
        for (int i = 0; i < processed.length(); i++) {
            if(punctuation.indexOf(processed.charAt(i))!=-1){
                processed.deleteCharAt(i);
                i--;
            }
        }

        processed.reverse();

        System.out.println("\n==== 最终处理结果 ====");
        System.out.println(processed.toString());


        //7、比较原始文本和最终结果
        boolean isEqual = original.equals(processed.toString());
        System.out.println("\n==== 内容比较 ====");
        System.out.println("原始文本与最终处理结果是否相同："+(isEqual?"是":"否"));

        sc.close();
    }
}
