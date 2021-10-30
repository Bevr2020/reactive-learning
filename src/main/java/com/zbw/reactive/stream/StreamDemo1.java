package com.zbw.reactive.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamDemo1 {
    public static void main(String[] args) {
        //外部迭代
        int[] nums = {1,2,3,4};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println("结果为： " + sum);

        //内部迭代
        //map就是中间操作，返回stream对象
        //sum就是终止操作
//        int sum1 = IntStream.of(nums).map(i->i*2).sum();
        int sum1 = IntStream.of(nums).map(StreamDemo1::doubleNum).sum();
        System.out.println("外部迭代结果： " + sum1);

        System.out.println("惰性操作就是终止操作没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(StreamDemo1::doubleNum);
    }

    public static int doubleNum(int i){
        return i * 2;
    }
}
