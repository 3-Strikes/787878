package _05_作业_02;

public class BookServiceImpl implements BookService{

    @Override
    public void borrowBook(String bookName) {
        if(bookName.contains("Java")){
            System.out.println("已记录JAVA书籍借阅");
            return;
        }
        System.out.println("已记录普通书籍借阅");
    }
}
