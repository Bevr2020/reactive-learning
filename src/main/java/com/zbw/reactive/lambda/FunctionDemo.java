package com.zbw.reactive.lambda;

import java.util.function.*;

/**
 * 预置 使用如下类，可以省略函数式接口定义
 * Predictate<T>    输入T，返回boolean   断言
 * Consumer<T>      输入T，返回          消费一个数据
 * Function<T,R>    输入T，返回R         输入T返回R的函数
 * Supplier<T>      输入， 返回T         提供一个数据
 * UnaryOperator<T> 输入T，返回T         一元函数，输入输出相同类型的函数
 * BiFunction<T,U,R>输入（T，U），返回R   两个输入的函数
 * BinaryOperator<T>输入（T，T），返回T   二元函数（输入输出类型相同）
 */
public class FunctionDemo {
    public static void main(String[] args) {
        //断言
//        Predicate<Integer> predicate = i -> i > 0;
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(2));

        //消费
        Consumer<String> consumer = s -> System.out.println(s);
//        IntConsumer
        consumer.accept("zbw");

        IntSupplier supplier = () -> 3;
        System.out.println(supplier.getAsInt());

        UnaryOperator<String> unaryOperator = s -> "中国" + s;
//        IntUnaryOperator
        System.out.println(unaryOperator.apply("加油"));

        BiFunction<Integer,Integer,String> function = (i1,i2) -> {
            return "" + i1 + i2;
        };

        System.out.println(function.apply(1, 2));

        BinaryOperator<Integer> func1 = (i1,i2) -> {
            return i1 + i2;
        };
        System.out.println(func1.apply(1, 2));
    }
}
