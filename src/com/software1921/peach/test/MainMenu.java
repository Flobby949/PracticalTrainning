package com.software1921.peach.test;

import com.software1921.peach.control.Administrator;
import com.software1921.peach.control.Cashier;
import com.software1921.peach.control.Customer;
import com.software1921.peach.storehouse.GoodsManager;

import java.util.Scanner;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/24
 * @ClassName :测试
 */

public class MainMenu {
    static Scanner scan = new Scanner(System.in);
    static boolean t = true;
    static boolean f = true;

    public static void main(String[] args) {
        while (f) {
            Menu.menu();
            String ctrl = scan.next();
            switch (ctrl) {
                case "1":
                    t = true;
                {
                    Menu.administrator();
                    loop:while (t) {
                        Administrator.administratorMenu();
                        String admin = scan.next();
                        do {
                            switch (admin) {
                                case "1":
                                    GoodsManager.addGoods();
                                    continue loop;
                                case "2":
                                    GoodsManager.showInformation();
                                    continue loop;
                                case "3":
                                    GoodsManager.deleteGoods();
                                    continue loop;
                                case "4":
                                    GoodsManager.modifyGoods();
                                    continue loop;
                                case "0":
                                    t = false;
                                    break;
                                default:
                            }
                        } while (t);
                    }
                }
                break;
                case "2":
                    t = true;
                {
                    Menu.cashier();
                    cash:while (t) {
                        Cashier.cashierMenu();
                        String cash = scan.next();
                        do {
                            switch (cash) {
                                case "1":
                                    GoodsManager.searchGoods();
                                   continue cash;
                                case "2":
                                    GoodsManager.buyGoods();
                                    continue cash;
                                case "3":
                                    GoodsManager.showInformation();
                                    continue cash;
                                case "0":
                                    t = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请输入0~4之间的数");
                            }
                        } while (t);
                    }
                }
                break;
                case "3":
                    t = true;
                {
                    Menu.customer();
                    cxk:while (t) {
                        Customer.customerMenu();
                        String cuter = scan.next();
                        do {
                            switch (cuter) {
                                case "1":
                                    GoodsManager.searchGoods();
                                    continue cxk;
                                case "0":
                                    t = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请输入0或1");
                            }
                        } while (t);
                    }
                }
                break;
                case "0":
                    f = false;
                    System.out.println("欢迎再次光临");
                    break;
                default:
                    System.out.println("输入有误，请输入0~3之间的数");
            }
        }
    }
}
