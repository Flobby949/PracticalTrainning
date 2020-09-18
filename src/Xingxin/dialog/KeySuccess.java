package Xingxin.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/6/21
 * @ClassName :
 */

public class KeySuccess extends JFrame {
    JLabel jl1 = new JLabel("SUCCESS");
    JLabel jl2 = new JLabel("密钥修改成功！");
    JButton jb = new JButton("确定");

    public KeySuccess() {
        this.setLayout(null);

        jl1.setBounds(95, 10, 120, 60);
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
