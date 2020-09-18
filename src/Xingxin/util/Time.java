package Xingxin.util;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author 231
 * @date 2020-06-23 8:13
 */
public class Time implements Runnable{
    public JLabel lab = new JLabel();
    public Time(JLabel lab){
        this.lab = lab;
    }
    @Override
    public void run() {
        while (true){
            DateFormat d1 = DateFormat.getDateTimeInstance();
            lab.setText(d1.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

