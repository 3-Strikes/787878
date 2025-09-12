package _02_单元测试;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class t21 {
    @Test
    public void a(){
        System.out.println("aA..");
    }
    @Test
    public void b(){
        System.out.println("bB..");
    }
    @Test
    public void c(){
        System.out.println("cC..");
    }
    @BeforeClass
    public static void d(){
        System.out.println("dD..");
    }
    @AfterClass
    public static void e(){
        System.out.println("eE..");
    }
    @Before
    public void f(){
        System.out.println("fF..");
    }



}
