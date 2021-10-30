package com.zbw.reactive.lambda;

import java.util.function.Function;

/**
 * lambda表达式
 * 级联表达式与柯里化
 * 柯里化：把多个参数的函数转化为只有一个参数的函数
 * 柯里化的目标：函数标准化
 */
public class CurryDemo {
    public static void main(String[] args) {
        //实现了x+y的级联表达式
        Function<Integer, Function<Integer,Integer>> func = x ->y -> x + y;
        System.out.println(func.apply(2).apply(3));
    }
}
