package com.zbw.reactive.lambda;

import java.util.function.*;

class Dog{
    private String name = "啸天犬";

    private int food=10;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int food) {
        this.name = name;
        this.food = food;
    }

    public static void bark(Dog dog){
        System.out.println(dog + "叫了");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * jdk实例方法 默认将当前对象加入到方法参数列表，位置为第一个，形式如下
     * public int eat(Dog this,int num)
     * @param num
     * @return
     */
    public int eat(int num){
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = s -> System.out.println(s);
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("zbw");

        //静态方法的方法引用
        Consumer<Dog> cons2 = Dog::bark;
        Dog dog = new Dog();
        cons2.accept(dog);

        //非静态方法 使用实例对象的方法
//        Function<Integer,Integer> function = dog::eat;
//        UnaryOperator<Integer> function = dog::eat;
//        IntUnaryOperator function = dog::eat;
        //非静态方法 使用类名来引用实例方法
        BiFunction<Dog,Integer,Integer> function = Dog::eat;
        System.out.println(function.apply(dog,4));

        //构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println(supplier.get());

        //带参数的构造函数的方法引用
        Function<String,Dog> function1 = Dog::new;
        System.out.println(function1.apply("wangcai"));

        //带2个参数的构造函数的方法引用
        BiFunction<String,Integer,Dog> biFunction = Dog::new;
        System.out.println(biFunction.apply("caiwang", 100));
    }
}
