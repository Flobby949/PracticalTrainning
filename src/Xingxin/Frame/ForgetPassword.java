package Xingxin.Frame;

import Xingxin.Dao.UserDao;
import Xingxin.Impl.UserDaoImpl;
import Xingxin.Object.User;
import Xingxin.dialog.ExchangePassword;
import Xingxin.dialog.QuestionInfo;
import Xingxin.dialog.Success;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 231
 * @date 2020-06-19 8:27
 */
public class ForgetPassword extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名：");
    JTextField usernameTf = new JTextField();
    JLabel password1 = new JLabel("新密码：");
    JTextField passwordTf1 = new JTextField();
    JLabel password2 = new JLabel("请再次输入：");
    JTextField passwordTf2 = new JTextField();
    JLabel choose = new JLabel("请选择密保问题");
    JComboBox question = new JComboBox();
    JLabel answer = new JLabel("答案：");
    JTextField answerTf = new JTextField();
    JButton submit = new JButton("确定");

    public ForgetPassword() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(60,20,100,30);
        password1.setBounds(60,100,100,30);
        password2.setBounds(60,180,200,30);
        choose.setBounds(320,30,200,30);
        answer.setBounds(310,130,100,30);

        usernameTf.setBounds(60,60,200,30);
        passwordTf1.setBounds(60,140,200,30);
        passwordTf2.setBounds(60,220,200,30);
        question.setBounds(310,70,200,40);
        answerTf.setBounds(310,170,200,30);
        submit.setBounds(180,280,200,30);

        question.addItem("你家乡的名字？");
        question.addItem("你父亲的姓名？");
        question.addItem("你母亲的姓名？");
        question.addItem("你第一次坐飞机去了哪？");
        question.addItem("你最喜欢的动漫角色是谁？");
        question.addItem("你最喜欢的明星？");
        question.addItem("你最好的朋友？");

        add(username);add(usernameTf);add(password1);add(password2);
        add(passwordTf1);add(passwordTf2);add(question);add(choose);
        add(answer);add(answerTf);add(submit);

        submit.addActionListener(this);

        setLocation(450, 200);
        this.setSize(580, 400);
        this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDaoImpl();
        if ("确定".equals(e.getActionCommand())) {
            List<User> userList = null;
            User user = new User();
            user.setUserName(usernameTf.getText());
            user.setAnswer(answerTf.getText());
            userList = dao.getAnswer(user);
            if (userList.size() != 0) {
                String pw1 = passwordTf1.getText();
                String pw2 = passwordTf2.getText();
                if (pw1.equals(pw2)){
                    User user1 = new User();
                    user1.setUserName(usernameTf.getText());
                    user1.setPassword(passwordTf1.getText());
                    dao.update(user1);
                    dispose();

                    new Success();
                }else {
                    new ExchangePassword();
                }
            }else {
                new QuestionInfo();
            }
        }
    }
}
