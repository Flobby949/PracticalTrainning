package Xingxin.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 231
 * @date 2020-06-21 15:16
 */
public class LogInInfo extends JFrame {
    JLabel jl1 = new JLabel("ERROR");
    JLabel jl2 = new JLabel("账号信息错误！");
    JButton jb = new JButton("确定");

    public LogInInfo() {
        this.setLayout(null);

        jl1.setBounds(105, 10, 100, 60);
        Font font = new Font("宋体", Font.BOLD, 25);
        jl1.setFont(font);
        jl2.setBounds(75, 70, 150, 60);
        Font font1 = new Font("宋体", Font.BOLD, 20);
        jl2.setFont(font1);
        jb.setBounds(105, 150, 70, 30);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.add(jl1);
        add(jl2);
        this.add(jb);

        this.setVisible(true);
        this.setBounds(600, 250, 300, 250);
    }
}