package Xingxin.Frame;

import Xingxin.Dao.AdministratorDao;
import Xingxin.Dao.KeyDao;
import Xingxin.Impl.AdministratorDaoImpl;
import Xingxin.Impl.KeyImpl;
import Xingxin.Object.Administrator;
import Xingxin.Object.Key;
import Xingxin.dialog.KeyWordInfo;
import Xingxin.dialog.RegisterError;
import Xingxin.dialog.RegisterSuccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 231
 * @date 2020-06-18 11:14
 */
public class AdministratorRegister extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名:");
    JTextField usernameJf = new JTextField();
    JLabel password = new JLabel("密码:");
    JTextField passwordJf = new JTextField();
    JLabel name = new JLabel("姓名:");
    JTextField nameJf = new JTextField();
    JLabel sex = new JLabel("性别:");
    JRadioButton male = new JRadioButton("男");
    JRadioButton female = new JRadioButton("女");
    JLabel age = new JLabel("年龄:");
    JTextField ageJf = new JTextField();
    JLabel telephoneNumber = new JLabel("联系方式:");
    JTextField telephoneNumberJf = new JTextField();
    JLabel homeAddress = new JLabel("家庭住址:");
    JTextField homeAddressJf = new JTextField();
    JLabel keyWord = new JLabel("密钥:");
    JTextField keyWordJt = new JTextField();


    JButton RegisterButton = new JButton("确定");

    public AdministratorRegister() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(90, 30, 100, 30);
        usernameJf.setBounds(180, 30, 100, 30);
        password.setBounds(90, 80, 100, 30);
        passwordJf.setBounds(180, 80, 100, 30);
        name.setBounds(90, 130, 100, 30);
        nameJf.setBounds(180, 130, 100, 30);
        sex.setBounds(90, 180, 100, 30);
        male.setBounds(180, 180, 50, 40);
        female.setBounds(240, 180, 50, 40);
        age.setBounds(90, 230, 100, 30);
        ageJf.setBounds(180, 230, 100, 30);

        telephoneNumber.setBounds(350, 30, 100, 30);
        telephoneNumberJf.setBounds(460, 30, 250, 30);
        homeAddress.setBounds(350, 80, 100, 30);
        homeAddressJf.setBounds(460, 80, 250, 30);

        keyWord.setBounds(90, 280, 100, 30);
        keyWordJt.setBounds(180, 280, 100, 30);


        RegisterButton.setBounds(450, 200, 200, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        add(username);
        add(usernameJf);
        add(password);
        add(passwordJf);
        add(name);
        add(nameJf);
        add(sex);
        add(male);
        add(female);
        add(age);
        add(ageJf);
        add(telephoneNumber);
        add(telephoneNumberJf);
        add(homeAddress);
        add(homeAddressJf);
        add(keyWord);
        add(keyWordJt);

        add(name);
        add(nameJf);
        add(RegisterButton);

        RegisterButton.addActionListener(this);

        setLocation(450, 200);
        this.setSize(800, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdministratorDao dao = new AdministratorDaoImpl();
        KeyDao dao1 = new KeyImpl();
        List<Key> keyList = null;
        Key key = new Key();
        key.setId(1);
        key.setKey(keyWordJt.getText());
        keyList = dao1.getKey(key);
        if (keyList.size() != 0) {
            if ("确定".equals(e.getActionCommand())) {
                Administrator administrator = new Administrator();
                administrator.setUserName(usernameJf.getText());
                administrator.setPassword(passwordJf.getText());
                administrator.setName(nameJf.getText());
                if (male.isSelected()){
                    administrator.setSex(male.getText());
                }else {
                    administrator.setSex(female.getText());
                }
                administrator.setAge(ageJf.getText());
                administrator.setTelephoneNumber(telephoneNumberJf.getText());
                administrator.setHomeAddress(homeAddressJf.getText());
                if ((usernameJf!=null&&passwordJf!=null&&nameJf!=null&&ageJf!=null&&telephoneNumberJf!=null&&
                        homeAddressJf!=null)&&(male.isSelected()||female.isSelected())){
                    dao.addAdministrator(administrator);
                    dispose();
                    new Login();
                    new RegisterSuccess();

                }else{

                    new RegisterError();
                }
            }
        }else{
            new KeyWordInfo();
        }
    }
}
