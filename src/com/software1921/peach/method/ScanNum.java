package com.software1921.peach.method;

import java.util.Scanner;

/**
 * @author Flobby
 * @version :1.0
 * @date :2019/12/25
 * @ClassName :输入数字
 */

public class ScanNum {

    public static int number(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        return num;
    }
}
