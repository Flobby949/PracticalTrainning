package Xingxin.Frame;

import Xingxin.Dao.UserDao;
import Xingxin.Impl.UserDaoImpl;
import Xingxin.Object.User;
import Xingxin.dialog.RegisterError;
import Xingxin.dialog.RegisterSuccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 231
 * @date 2020-06-18 23:55
 */
public class UserRegister extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名:");
    JTextField usernameJf = new JTextField();
    JLabel password = new JLabel("密码:");
    JTextField passwordJf = new JTextField();
    JLabel name = new JLabel("姓名:");
    JTextField nameJf = new JTextField();
    JLabel sex = new JLabel("性别:");
    JLabel age = new JLabel("年龄:");
    JTextField ageJf = new JTextField();
    JLabel telephoneNumber = new JLabel("联系方式:");
    JTextField telephoneNumberJf = new JTextField();

    JLabel questionjl = new JLabel("验证问题:");
    JLabel answerjl = new JLabel("验证答案:");

    JComboBox question = new JComboBox();
    JTextField answer = new JTextField();

    JButton RegisterButton = new JButton("确定");

    JRadioButton male = new JRadioButton("男");
    JRadioButton female = new JRadioButton("女");

    public UserRegister() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(90,30,100,30);
        usernameJf.setBounds(180,30,100,30);
        password.setBounds(90,80,100,30);
        passwordJf.setBounds(180,80,100,30);
        name.setBounds(90,130,100,30);
        nameJf.setBounds(180,130,100,30);
        sex.setBounds(90,180,100,30);

        male.setBounds(180, 180, 50, 40);
        female.setBounds(240, 180, 50, 40);

        age.setBounds(90,230,100,30);
        ageJf.setBounds(180,230,100,30);
        telephoneNumber.setBounds(90,280,100,30);
        telephoneNumberJf.setBounds(180,280,100,30);
        RegisterButton.setBounds(450,200,200,30);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        question.addItem("你家乡的名字？");
        question.addItem("你父亲的姓名？");
        question.addItem("你母亲的姓名？");
        question.addItem("你第一次坐飞机去了哪？");
        question.addItem("你最喜欢的动漫角色是谁？");
        question.addItem("你最喜欢的明星？");
        question.addItem("你最好的朋友？");

        questionjl.setBounds(350,30,100,30);
        answerjl.setBounds(350,80,100,30);
        question.setBounds(460,30,250,30);
        answer.setBounds(460,80,250,30);


        add(username);add(usernameJf);
        add(password);add(passwordJf);
        add(name);add(nameJf);
        add(sex);add(male);
        add(female);
        add(age);add(ageJf);
        add(telephoneNumber);add(telephoneNumberJf);
        add(name);add(nameJf);
        add(RegisterButton);
        add(questionjl);add(answerjl);
        add(question);add(answer);

        RegisterButton.addActionListener(this);

        setLocation(450, 200);
        this.setSize(800, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDaoImpl();
        if ("确定".equals(e.getActionCommand())){
            User user = new User();
            user.setUserName(usernameJf.getText());
            user.setPassword(passwordJf.getText());
            user.setName(nameJf.getText());
            if (male.isSelected()){
                user.setSex(male.getText());
            }else {
                user.setSex(female.getText());
            }
            user.setAge(ageJf.getText());
            user.setTelephoneNumber(telephoneNumberJf.getText());
            user.setQuestion((String) question.getSelectedItem());
            user.setAnswer(answer.getText());
            if ((usernameJf!=null&&passwordJf!=null&&nameJf!=null&&
                    ageJf!=null&&telephoneNumberJf!=null&&answer!=null)&&(male.isSelected()||female.isSelected())){
                dao.addUser(user);
                dispose();
                new Login();
                dao.addQuestion(user);
                new RegisterSuccess();
            }else{
                new RegisterError();
            }
        }
    }
}