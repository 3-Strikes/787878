package 用户反馈管理系统;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Feedback类：封装反馈信息
class Feedback {
    private int id;
    private String username;
    private String type;
    private String content;
    private String submitTime;

    // 构造方法
    public Feedback(int id, String username, String type, String content, String submitTime) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.content = content;
        this.submitTime = submitTime;
    }

    // Getter方法
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    // 重写toString方法，方便打印
    @Override
    public String toString() {
        return "ID: " + id +
                "\n用户名: " + username +
                "\n类型: " + type +
                "\n内容: " + content +
                "\n提交时间: " + submitTime +
                "\n------------------------";
    }
}

// 主程序类
public class FeedbackManagementSystem {
    // 存储所有反馈的列表
    private static List<Feedback> feedbackList = new ArrayList<>();
    // 用于生成唯一ID
    private static int nextId = 1;
    // 反馈类型数组
    private static String[] feedbackTypes = {"建议", "投诉", "表扬", "疑问"};
    // 用于生成随机数据的名字和内容
    private static String[] firstNames = {"张", "李", "王", "赵", "刘", "陈", "杨", "黄", "周", "吴"};
    private static String[] lastNames = {"伟", "芳", "娜", "秀英", "敏", "静", "强", "磊", "军", "洋"};
    private static String[] suggestionContents = {
            "希望增加夜间模式", "建议优化搜索功能", "希望支持更多支付方式",
            "建议增加多语言支持", "希望添加数据备份功能"
    };
    private static String[] complaintContents = {
            "系统经常崩溃", "加载速度太慢", "界面设计不友好",
            "客服响应不及时", "收费不合理"
    };
    private static String[] praiseContents = {
            "使用体验非常好", "功能很实用", "客服态度很好",
            "更新很及时", "界面设计美观"
    };
    private static String[] questionContents = {
            "如何修改个人信息？", "会员有什么特权？", "数据如何导出？",
            "如何找回密码？", "是否支持离线使用？"
    };

    public static void main(String[] args) {
        // 生成初始的10条随机反馈数据
        generateRandomFeedbacks(10);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // 显示菜单
            System.out.println("\n===== 用户反馈管理系统 =====");
            System.out.println("1. 添加新的用户反馈");
            System.out.println("2. 查看所有反馈列表");
            System.out.println("3. 按反馈类型筛选查看");
            System.out.println("4. 统计不同类型反馈的数量");
            System.out.println("5. 分析反馈中出现频率最高的关键词");
            System.out.println("6. 退出系统");
            System.out.print("请选择操作(1-6): ");

            // 获取用户选择
            try {
                choice = Integer.parseInt(scanner.nextLine());

                // 根据用户选择执行相应操作
                switch (choice) {
                    case 1:
                        addNewFeedback(scanner);
                        break;
                    case 2:
                        viewAllFeedbacks();
                        break;
                    case 3:
                        filterByType(scanner);
                        break;
                    case 4:
                        countByType();
                        break;
                    case 5:
                        analyzeKeywords();
                        break;
                    case 6:
                        System.out.println("谢谢使用，再见！");
                        break;
                    default:
                        System.out.println("无效的选择，请输入1-6之间的数字。");
                }
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请输入数字。");
                choice = 0; // 重置选择，继续循环
            }
        } while (choice != 6);

        scanner.close();
    }

    // 生成随机反馈数据
    private static void generateRandomFeedbacks(int count) {
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < count; i++) {
            // 生成随机用户名
            String username = firstNames[random.nextInt(firstNames.length)] +
                    lastNames[random.nextInt(lastNames.length)];

            // 随机选择反馈类型
            String type = feedbackTypes[random.nextInt(feedbackTypes.length)];

            // 根据类型生成相应的内容
            String content;
            switch (type) {
                case "建议":
                    content = suggestionContents[random.nextInt(suggestionContents.length)];
                    break;
                case "投诉":
                    content = complaintContents[random.nextInt(complaintContents.length)];
                    break;
                case "表扬":
                    content = praiseContents[random.nextInt(praiseContents.length)];
                    break;
                case "疑问":
                    content = questionContents[random.nextInt(questionContents.length)];
                    break;
                default:
                    content = "无内容";
            }

            // 生成随机的提交时间（最近30天内）
            long now = System.currentTimeMillis();
            long randomTime = now - (long)(random.nextDouble() * 30 * 24 * 60 * 60 * 1000);
            String submitTime = sdf.format(new Date(randomTime));

            // 创建反馈对象并添加到列表
            Feedback feedback = new Feedback(nextId++, username, type, content, submitTime);
            feedbackList.add(feedback);
        }
    }

    // 添加新的用户反馈
    private static void addNewFeedback(Scanner scanner) {
        System.out.println("\n----- 添加新反馈 -----");

        // 获取用户名
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine().trim();
        while (username.isEmpty()) {
            System.out.print("用户名不能为空，请重新输入: ");
            username = scanner.nextLine().trim();
        }

        // 获取反馈类型
        System.out.println("请选择反馈类型:");
        System.out.println("1. 建议");
        System.out.println("2. 投诉");
        System.out.println("3. 表扬");
        System.out.println("4. 疑问");
        System.out.print("请选择(1-4): ");

        String type = "";
        try {
            int typeChoice = Integer.parseInt(scanner.nextLine());
            switch (typeChoice) {
                case 1:
                    type = "建议";
                    break;
                case 2:
                    type = "投诉";
                    break;
                case 3:
                    type = "表扬";
                    break;
                case 4:
                    type = "疑问";
                    break;
                default:
                    System.out.println("无效的选择，默认设为'建议'");
                    type = "建议";
            }
        } catch (NumberFormatException e) {
            System.out.println("输入错误，默认设为'建议'");
            type = "建议";
        }

        // 获取反馈内容
        System.out.print("请输入反馈内容: ");
        String content = scanner.nextLine().trim();
        while (content.isEmpty()) {
            System.out.print("反馈内容不能为空，请重新输入: ");
            content = scanner.nextLine().trim();
        }

        // 获取当前时间作为提交时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String submitTime = sdf.format(new Date());

        // 创建反馈对象并添加到列表
        Feedback feedback = new Feedback(nextId++, username, type, content, submitTime);
        feedbackList.add(feedback);

        System.out.println("反馈添加成功！");
    }

    // 查看所有反馈列表
    private static void viewAllFeedbacks() {
        System.out.println("\n----- 所有反馈列表 -----");
        if (feedbackList.isEmpty()) {
            System.out.println("暂无反馈数据。");
            return;
        }

        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }

    // 按反馈类型筛选查看
    private static void filterByType(Scanner scanner) {
        System.out.println("\n----- 按类型筛选反馈 -----");
        System.out.println("请选择要查看的反馈类型:");
        System.out.println("1. 建议");
        System.out.println("2. 投诉");
        System.out.println("3. 表扬");
        System.out.println("4. 疑问");
        System.out.print("请选择(1-4): ");

        String type = "";
        try {
            int typeChoice = Integer.parseInt(scanner.nextLine());
            switch (typeChoice) {
                case 1:
                    type = "建议";
                    break;
                case 2:
                    type = "投诉";
                    break;
                case 3:
                    type = "表扬";
                    break;
                case 4:
                    type = "疑问";
                    break;
                default:
                    System.out.println("无效的选择");
                    return;
            }
        } catch (NumberFormatException e) {
            System.out.println("输入错误");
            return;
        }

        System.out.println("\n----- " + type + " 类型的反馈 -----");
        boolean hasFeedback = false;
        for (Feedback feedback : feedbackList) {
            if (feedback.getType().equals(type)) {
                System.out.println(feedback);
                hasFeedback = true;
            }
        }

        if (!hasFeedback) {
            System.out.println("没有找到" + type + "类型的反馈。");
        }
    }

    // 统计不同类型反馈的数量
    private static void countByType() {
        System.out.println("\n----- 反馈类型统计 -----");
        int[] counts = new int[4]; // 对应：建议、投诉、表扬、疑问

        for (Feedback feedback : feedbackList) {
            String type = feedback.getType();
            switch (type) {
                case "建议":
                    counts[0]++;
                    break;
                case "投诉":
                    counts[1]++;
                    break;
                case "表扬":
                    counts[2]++;
                    break;
                case "疑问":
                    counts[3]++;
                    break;
            }
        }

        System.out.println("建议: " + counts[0] + " 条");
        System.out.println("投诉: " + counts[1] + " 条");
        System.out.println("表扬: " + counts[2] + " 条");
        System.out.println("疑问: " + counts[3] + " 条");
        System.out.println("总计: " + feedbackList.size() + " 条");
    }

    // 分析反馈中出现频率最高的关键词
    private static void analyzeKeywords() {
        System.out.println("\n----- 关键词分析 -----");
        if (feedbackList.isEmpty()) {
            System.out.println("暂无反馈数据，无法进行分析。");
            return;
        }

        // 简单的关键词提取：将所有内容按空格和标点符号分割
        Map<String, Integer> keywordCount = new HashMap<>();

        for (Feedback feedback : feedbackList) {
            String content = feedback.getContent();
            // 去除标点符号并转换为小写
            content = content.replaceAll("[^a-zA-Z0-9\u4e00-\u9fa5]", " ").toLowerCase();
            // 分割为单词/词语
            String[] words = content.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty() && word.length() > 1) { // 过滤太短的词语
                    keywordCount.put(word, keywordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // 将关键词按出现次数排序
        List<Map.Entry<String, Integer>> sortedKeywords = new ArrayList<>(keywordCount.entrySet());
        sortedKeywords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 显示出现频率最高的前5个关键词
        System.out.println("出现频率最高的关键词:");
        int limit = Math.min(5, sortedKeywords.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = sortedKeywords.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue() + " 次");
        }
    }
}

