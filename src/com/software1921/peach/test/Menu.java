package com.software1921.peach.test;

import java.util.Scanner;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/24
 * @ClassName :菜单
 */

public class Menu {
    public static void menu(){
        System.out.println("欢迎登陆桃饱网购物系统！");
        System.out.println("----------------------");
        System.out.println("1.管理员登录");
        System.out.println("2.收银员登录");
        System.out.println("3.游客登录");
        System.out.println("0.退出");
        System.out.println("----------------------");
        System.out.println("请选择，或按0退出:");
    }
    public static void administrator(){

        System.out.println("请输入管理员用户名：");
        Scanner scan=new Scanner(System.in);
        while (true) {
            String name = scan.next();
            if (name.equals("admin")) {
                break;
            } else {
                System.out.println("用户名错误，请重新输入用户名：");
            }
        }
        System.out.println("请输入密码：");
        while (true) {
            String password = scan.next();
            if (password.equals("123456")) {
                break;
            } else {
                System.out.println("密码错误，请重新输入密码：");
            }
        }
        System.out.println("管理员,欢迎您的登录");
    }

    public static void cashier(){
        System.out.println("请输入收银员用户名：");
        while(true) {
            Scanner scan=new Scanner(System.in);
            String name=scan.next();
            if(name.equals("cashier")) {
                break;
            }else {
                System.out.println("输入错误，请重新输入：");
            }
        }
        System.out.println("请输入密码");
        while(true) {
            String password;
            Scanner input= new Scanner(System.in);
            password=input.next();

            if(password.equals("123456")) {
                break;
            }
            else {
                System.out.println("密码错误，请重新输入：");
            }
        }
        System.out.println("欢迎您，收银员");

    }

    public static void customer(){
        System.out.println(" 请输入游客用户名：");
        while(true) {
            Scanner scan=new Scanner(System.in);
            String name=scan.next();
            if(name.equals("蔡徐坤")) {
                break;
            }else {
                System.out.println("输入错误，请重新输入：");
            }
        }
        System.out.println(" 请输入密码：");
        while(true) {
            String password;
            Scanner input= new Scanner(System.in);
            password=input.next();

            if(password.equals("123456")) {
                break;
            }
            else {
                System.out.println("密码错误，请重新输入：");
            }
        }
        System.out.println("欢迎您，蔡徐坤");
    }
}
