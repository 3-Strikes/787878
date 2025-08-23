package _正则表达式练习;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        //1、匹配邮箱地址
        String email = "test@example.com";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isEmailValid = Pattern.matches(emailRegex,email);
        System.out.println("邮箱是否有效:"+isEmailValid);

        //2、查找字符串中的数字
        String text = "年龄：25，身高：180cm，体重：70kg";
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(text);

        System.out.println("提前的数字：");
        while(numberMatcher.find()){
            System.out.print(numberMatcher.group()+" ");
        }
        System.out.println();

        //3、替换操作
        String dirtyText = "Hello! <script>恶意代码</script> world!";
        Pattern scriptPattern = Pattern.compile("<script>.*?</script>");
        Matcher scriptMatcher = scriptPattern.matcher(dirtyText);
        String cleanText = scriptMatcher.replaceAll("[被过滤的内容]");
        System.out.println("过滤后："+cleanText);

        //4、分隔字符串
        String csvText = "apple,banana,orange,grape";
        String[] fruits = csvText.split(",");
        System.out.println("分割结果：");
        for(String fruit:fruits){
            System.out.println(fruit+" ");
        }
        System.out.println();

        //5、复杂模式匹配 - 提取URL中的域名
        String url = "https://www.example.com/path?query=123";
        Pattern domainPattern = Pattern.compile("https?://(wwww\\.)?([^/]+)");

        // 例子：匹配固定长度的数字
        String regex1 = "\\d{3}"; // 匹配3位数字
        System.out.println("123".matches(regex1)); // true
        System.out.println("12".matches(regex1));  // false

        String regex2 = "\\d{2,4}"; // 匹配2-4位数字
        System.out.println("12".matches(regex2));   // true
        System.out.println("1234".matches(regex2)); // true
        System.out.println("12345".matches(regex2));// false


        // 例子：匹配手机号（11位数字，以1开头）
        String phoneRegex = "1\\d{10}";
        System.out.println("13800138000".matches(phoneRegex)); // true

// 例子：匹配邮箱的简单格式（xxx@xxx.xxx）
        emailRegex = "\\w+@\\w+\\.\\w+";
        System.out.println("test@example.com".matches(emailRegex)); // true

// 例子：用 | 实现"或"逻辑（匹配手机号或邮箱）
        String regex = "(1\\d{10})|(\\w+@\\w+\\.\\w+)";
        System.out.println("13800138000".matches(regex)); // true（匹配手机号）
        System.out.println("a@b.com".matches(regex));    // true（匹配邮箱）

    }
}
