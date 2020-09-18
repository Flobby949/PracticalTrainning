package com.software1921.peach.storehouse;

import com.software1921.peach.method.ScanNum;

import java.util.Scanner;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/24
 * @ClassName :商品管理
 */

public class GoodsManager {

    static int[] id = new int[10];
    static String[] name = new String[10];
    static double[] price = new double[10];
    static double[] quality = new double[10];
    static String[] rename = new String[10];
    static double[] reprice = new double[10];
    static double[] requality = new double[10];

    //初始化
    public void Init() {
        for (int i = 0; i < 10; i++) {
            id[i] = i + 1;
            name[i] = " ";
            price[i] = 0.0;
            quality[i] = 0;
        }
    }

        /**
         * 增加商品
         */
        public static void addGoods(){
            loop:
                for (int i = 0; i < 10; i++) {
                    if (name[i] == null) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("现在已上架商品数目为: " + i + "，还有上架商品的空位有" + (10 - i) + "个");
                        System.out.println("现上架商品编号为：" + (i + 1));
                        id[i] = (i+1);
                        System.out.println("请输入上架商品的名称：");
                        name[i] = scanner.next();
                        System.out.println("请输入上架商品的价格: ");
                        price[i] = scanner.nextDouble();
                        System.out.println("请输入上架商品的库存: ");
                        quality[i] = scanner.nextDouble();
                        System.out.println("继续上架商品-->1,结束上架-->0");
                        int a = scanner.nextInt();
                        if (a == 0) {
                            break loop;
                        }
                    }
                }
        }

    /**
     * 展示商品信息
     */
    public static void showInformation() {
        loop:while (true) {
            System.out.println("编号 "+"\t名称 "+"\t单价 "+"\t库存");
            for (int i = 0; i < 10; i++) {
                System.out.println(id[i]+ " \t " + name[i] + " \t " + price[i]+" \t "+quality[i]);
                System.out.println(" ");
            }
            System.out.println("****************************");
            System.out.print("输入“0”退出：");
            Scanner out = new Scanner(System.in);
            int num = out.nextInt();
            if (num == 0) {
                break loop;
            }
        }
    }

    /**
     * 删除商品
     */
    public static void deleteGoods() {
        Scanner scanner = new Scanner(System.in);
        loop:while (true) {
            System.out.print("请输入你想下架商品的编号: ");
            int outid = scanner.nextInt();
            id[outid-1] = 0;

            price[outid - 1] = 0.0;
            quality[outid - 1] = 0.0;
            System.out.println("****************************");
            System.out.print("输入“1”继续，输入“0”退出：");
            int num = scanner.nextInt();
            if (num == 0) {
                break loop;
            }else{
                continue loop;
            }
        }
        System.out.println("****************************");
        GoodsManager.showInformation();
    }

    /**
     * 修改商品
     */
    public static void modifyGoods() {
        Scanner mdid = new Scanner(System.in);
        loop:while (true) {
            System.out.print("请输入想修改的编号：");
            int num = mdid.nextInt();
            System.out.println((num) + "\t\t " + name[num - 1] + "\t " + price[num - 1] + "\t " + quality[num - 1]);
            System.out.println("请输入上架商品的名称：");
            rename[num - 1] = mdid.next();
            System.out.println("请输入上架商品的价格: ");
            reprice[num - 1] = mdid.nextDouble();
            System.out.println("请输入上架商品的库存: ");
            requality[num - 1] = mdid.nextDouble();
            price[num - 1] = reprice[num - 1];
            name[num - 1] = rename[num - 1];
            quality[num - 1] = requality[num - 1];
            System.out.print("输入1继续，输入0退出： ");
            int in = mdid.nextInt();
            if (in == 0){
                System.out.println("编号 \t"+" 名称 "+"\t\t 单价 "+" \t 库存");
                for (int i = 0; i < 10; i++) {
                    System.out.println(id[i]+ "\t\t " + name[i] + "\t " + price[i]+"\t "+quality[i]);
                    System.out.println(" ");
                }
                break loop;
            }else{
             continue loop;
            }
        }

    }

    /**
     * 查找商品
     */
    public static void searchGoods() {
       Scanner in = new Scanner(System.in);
       loop:while (true) {
           System.out.println("请输入想查询的商品编号：");
           int num = in.nextInt();
           System.out.println((num) + "\t\t " + name[num - 1] + "\t " + price[num - 1] + "\t " + quality[num - 1]);
           System.out.println("输入“1”继续，输入“0”退出：");
           int out = in.nextInt();
           if (out == 0) {
               break loop;
           }else{
               continue loop;
           }
       }
    }

    /**
     * 购买
     */
    static double sum = 0;
    static int[] paperid = new int[10];
    static int[] papernum = new int[10];
    static String[] papername = new String[10];
    static double[] paperprice = new double[10];
    static int j = 0;
    public void InitOne() {
        for (int j = 0; j < 10; j++) {
            paperid[j] = 0;
            papernum[j] = 0;
            papername[j] = " ";
            paperprice[j] = 0.0;
        }

    }
    public static void buyGoods() {
        boolean flag = true;
        loop:do{
            System.out.print("请输入商品编号：");
            int buyid = ScanNum.number();
            System.out.print("请输入商品件数：");
            int num = ScanNum.number();
            if (num > quality[buyid-1]){
                System.out.println("超过库存！请重新输入");
                continue loop;
            }
            for (int i = 0; i < 10; i++) {
                if (buyid == id[i]) {
                    sum = price[i] * num + sum;
                    System.out.println("");
                    System.out.println(name[i] + "已加入购物车 " + num + " 件");
                    paperid[j] = buyid;
                    papernum[j] = num;
                    papername[j] = name[i];
                    paperprice[j] = price[i];
                    j++;
                }
            }
            System.out.println(" ");
            System.out.println("继续购买-->1,结束购买-->0");
            int a = ScanNum.number();
            //打印清单
            if (a == 0) {
                System.out.println("*********************购物清单************************");
                System.out.println("编号" + "\t\t商品名称" + "\t\t商品单价" + "\t\t商品个数");
                while (paperid[j] != 0) {
                    System.out.println(+(j + 1) + " ." + "\t\t" + papername[j] + "\t\t" + paperprice[j] + "\t\t" + papernum[j]);
                    j++;
                }
                System.out.println(" ");
                System.out.println("总计: " + sum);
                System.out.println("**************************************************");
                break;
            }
        }while(flag);
    }
}