package com.zbw.reactive.lambda;


import java.util.function.Consumer;

/**
 * lambda表达式的变量引用
 */
public class VarDemo {
    public static void main(String[] args) {
        //应该要加final，但是jdk8可以不加
        final String str = "our time!";
        //但不能修改
//        str = "hello world";
        Consumer<String> consumer = s -> System.out.println(s + str);
//        Consumer<String> consumer = System.out::println;
        consumer.accept("1123");
    }
}
