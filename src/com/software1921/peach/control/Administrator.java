package com.software1921.peach.control;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/24
 * @ClassName :管理员
 */

public class Administrator {

    public static void administratorMenu() {
        final int lth = 100;
        for (int i = 0; i < lth; i++) {
            System.out.print('=');
        }
        System.out.println();
        System.out.println("\t\t欢迎进入桃饱网管理员界面\t\t");
        System.out.println();
        System.out.println("\t\t1.添加商品\t\t\t");
        System.out.println("\t\t2.输出商品信息");
        System.out.println("\t\t3.删除商品");
        System.out.println("\t\t4.修改商品");
        System.out.println("\t\t0.返回上一级");
        for (int i = 0; i < lth; i++) {
            System.out.print('=');
        }
        System.out.println();
        System.out.println("请输入命令：");

    }
}
