package _05_作业_02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        BookService proxy = getProxy(new BookServiceImpl());
        proxy.borrowBook("PPt");
        proxy.borrowBook("Java");
    }

    private static BookService getProxy(BookServiceImpl bookService) {
        return (BookService) Proxy.newProxyInstance(bookService.getClass().getClassLoader(), bookService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object invoke = method.invoke(bookService, args);
                return invoke;
            }
        });
    }
}
