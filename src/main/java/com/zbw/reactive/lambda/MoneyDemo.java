package com.zbw.reactive.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

//interface IMoneyFormat{
//    String format(int i);
//}

class MyMoney{
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

//    public void printMoney(IMoneyFormat moneyFormat){
//        System.out.println("存款： " + moneyFormat.format(money));
//    }
    public void printMoney(Function<Integer,String> moneyFormat){
        System.out.println("存款： " + moneyFormat.apply(money));
    }
}

public class MoneyDemo {
    public static void main(String[] args) {
        MyMoney me = new MyMoney(9999999);
//        me.printMoney(i -> new DecimalFormat("#,###").format(i));
        Function<Integer, String> fun = i -> new DecimalFormat("#,###").format(i);
        //函数接口链式操作 减少接口定义
        me.printMoney(fun.andThen(s -> "人民币 " + s));
    }
}
