package com.zbw.reactive.lambda;

import java.util.function.Function;

/**
 * lambda表达式
 * 级联表达式与柯里化
 */
public class CurryDemo {
    public static void main(String[] args) {
        //级联表达式
        Function<Integer, Function<Integer,Integer>> func = x ->y -> x + y;
    }
}
