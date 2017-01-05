package com.nchu.weixin.subscription.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用测试
 * Created by fujianjian on 2017/1/5.
 */
public class CommonTest {

    /***
     * 测试Map变量之间 是传值还是传引用
     */
    @Test
    public void testMapPass(){
        Map<String, Object> sourceMap = new HashMap<String, Object>(){{
           put("123", "test1234");
           put("status", "status");
           put("hello", "hello");
           put("book", new Book());
        }};

        Map<String, Map<String, Object>> secondMap = new HashMap<>();

        secondMap.put("sourceMap", sourceMap);

        System.out.println(sourceMap == secondMap.get("sourceMap"));

        sourceMap.put("world", "world");

        System.out.println(sourceMap.get("world"));
        System.out.println(secondMap.get("sourceMap").get("world"));

        ((Book)sourceMap.get("book")).name = "thinking in java";

        System.out.println(((Book)sourceMap.get("book")).name);
        System.out.println(((Book)secondMap.get("sourceMap").get("book")).name);
    }

    /**
     * 测试对象变量之间是传值 还是 传引用
     */
    @Test
    public void testObjectPass(){
        Book firstBook = new Book();
        Book secondBook = new Book();
        System.out.println(secondBook == firstBook);
        secondBook = firstBook;
        System.out.println(secondBook == firstBook);

        firstBook.name = "hello world";

        System.out.println(firstBook.name);
        System.out.println(secondBook.name);
    }
    @Test
    public void testBaseTypePass(){
        int a =  new Integer(1);
        int b = new Integer(1);
        System.out.println(a==b);

        String stra = new String("hello");
        String strb = new String("hello");

        System.out.println(stra == strb);

        strb = stra;
        System.out.println(stra == strb);
    }

    /***
     * summary
     * java 除了8种基础类型的传递是 传值
     * 其他对象类型的传递都是 传引用
     */


    public class Book{
        private String name;
        private Double price;

        public Book(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public Book() {
        }
    }

}
