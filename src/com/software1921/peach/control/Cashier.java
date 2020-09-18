package com.software1921.peach.control;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/24
 * @ClassName :收营员
 */

public class Cashier {
    public static void cashierMenu(){
        final int lth = 120;
        for (int i = 0;i < lth;i++){
            System.out.print('=');
        }
        System.out.println();
        System.out.println("\t\t欢迎进入桃饱网收营员界面\t\t");
        System.out.println();
        System.out.println("\t\t1.查找商品\t\t\t");
        System.out.println("\t\t2.购买商品");
        System.out.println("\t\t3.输出所有商品信息");
        System.out.println("\t\t0.返回上一级");
        for (int i = 0;i < lth ; i++){
            System.out.print('=');
        }
        System.out.println();
        System.out.println("请输入命令：");
    }


}
