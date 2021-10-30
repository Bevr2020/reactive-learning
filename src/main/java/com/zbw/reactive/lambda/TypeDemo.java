package com.zbw.reactive.lambda;

@FunctionalInterface
interface IMath{
    int add(int x,int y);
}

@FunctionalInterface
interface IMath2{
    int sub(int x,int y);
}

public class TypeDemo {
    public static void main(String[] args) {
        //1:变量类型定义
        IMath math = (x,y) -> x + y;

        //2：数组
        IMath[] maths = {(x,y) -> x + y};

        //3：强转
        Object obj = (IMath)(x,y) -> x + y;

        //4:通过方法返回
        IMath math1 = createMathLambda();

//        TypeDemo typeDemo = new TypeDemo();
//        typeDemo.test((x,y) -> x + y);

        TypeDemo typeDemo = new TypeDemo();
        //当有二义性时，需要强转接口来消除
        typeDemo.test((IMath2) (x,y) -> x + y);
    }

    public void test(IMath math){

    }

    public void test(IMath2 math){

    }

    public static IMath createMathLambda(){
        return (x,y) -> x + y;
    }
}
