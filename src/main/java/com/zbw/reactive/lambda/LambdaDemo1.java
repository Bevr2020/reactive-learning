package com.zbw.reactive.lambda;

//函数式接口 只有一个未实现的方法定义，但可以有其它默认实现的方法
// @FunctionalInterface可省，但是最好加，清晰
@FunctionalInterface
interface Interface1{
    int doubleNum(int i);
    default int add(int x,int y){
        return x + y;
    }
}

@FunctionalInterface
interface Interface2{
    int doubleNum(int i);
    default int add(int x,int y){
        return x + y;
    }
}

@FunctionalInterface
interface Interface3 extends Interface1,Interface2{

    @Override
    default int add(int x, int y) {
        return 0;
    }
}

public class LambdaDemo1 {
    public static void main(String[] args) {
        //lanbda表达式有前提限制：接口定义中只有一个方法
        //4种常见的lambda表达式写法
        Interface1 i1 = (i) -> i*2;

        Interface1 i2 = i -> i*2;

        Interface1 i3 = (int i) -> i*2;

        Interface1 i4 = i -> {
            System.out.println(i);
            return i*2;
        };

        System.out.println(i2.add(3, 4));
    }
}
