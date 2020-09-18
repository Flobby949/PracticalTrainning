package Xingxin.Frame;

import Xingxin.Object.Key;
import Xingxin.Dao.KeyDao;
import Xingxin.Impl.KeyImpl;
import Xingxin.dialog.KeySuccess;
import Xingxin.dialog.NewKeyError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/6/21
 * @ClassName :
 */

public class ExchangeKey extends JFrame implements ActionListener {
    JLabel oldKey = new JLabel("输入旧密钥：");
    JTextField oldKeyJt = new JTextField();
    JLabel newKey = new JLabel("输入新密钥：");
    JTextField newKeyJt = new JTextField();
    JLabel reNewKey = new JLabel("再次输入新密钥：");
    JTextField reNewKeyJt = new JTextField();
    JButton submit = new JButton("确定");

    public ExchangeKey() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        oldKey.setBounds(30,20,200,30);
        oldKeyJt.setBounds(30,55,210,30);
        newKey.setBounds(30,100,200,30);
        newKeyJt.setBounds(30,135,210,30);
        reNewKey.setBounds(30,180,200,30);
        reNewKeyJt.setBounds(30,215,210,30);
        submit.setBounds(100,290,100,30);

        add(oldKey);add(oldKeyJt);add(newKey);add(newKeyJt);add(reNewKey);add(reNewKeyJt);add(submit);

        submit.addActionListener(this);

        setLocation(630, 160);
        this.setSize(300, 420);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        KeyDao dao = new KeyImpl();
        String pw1 =newKeyJt.getText();
        String pw2 =reNewKeyJt.getText();

        List<Key> keyList = null;
        Key key = new Key();
        key.setId(1);
        key.setKey(oldKeyJt.getText());
        keyList = dao.getKey(key);
        if (keyList.size()!=0){
            if (pw1.equals(pw2)){
                Key key1 = new Key();
                key1.setId(1);
                key1.setKey(newKeyJt.getText());
                dao.update(key1);
                new KeySuccess();
            }else{
                new NewKeyError();
            }
        }else {
            new NewKeyError();
        }

    }
}
