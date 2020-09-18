package Xingxin.Impl;

import Xingxin.util.DBUtils;
import Xingxin.Dao.UserDao;
import Xingxin.Object.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 231
 * @date 2020-06-18 23:46
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getUser(User user) {
        String sql="select * from user where username=? and password=?";
        List<User> userList=new ArrayList<User>();
        List<Map<String, Object>> maplist= DBUtils.query(sql, user.getUserName(),user.getPassword());
        for(Map<String, Object> map:maplist){
            User ne=new User();
            ne.setUserName((String) (map.get("username")));
            ne.setPassword((String)(map.get("password")));
            userList.add(ne);
        }
        return userList;
    }

    @Override
    public List<User> getAnswer(User user) {
        String sql = "select * from verificationproblem where username=? and answer=?";
        List<User> userList = new ArrayList<User>();
        List<Map<String, Object>> maplist = DBUtils.query(sql, user.getUserName(),user.getAnswer());
        for (Map<String, Object> map : maplist) {
            User ne = new User();
            ne.setUserName((String) (map.get("username")));
            ne.setAnswer((String) (map.get("answer")));
            userList.add(ne);
        }
        return userList;
    }

    @Override
    public int addUser(User user) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        int code=0;
        String sql="insert into user (username,password,name,sex,age,authority,telephonenumber,registrationtime) " +
                "values(?,?,?,?,?,'普通会员',?,'"+str+"')";
        code= DBUtils.update(sql,user.getUserName(), user.getPassword(),user.getName(),user.getSex(),
                user.getAge(),user.getTelephoneNumber());
        return code;    }

    @Override
    public int addQuestion(User user) {
        int code=0;
        String sql="insert into verificationproblem (username,question,answer) " +
                "values(?,?,?)";
        code= DBUtils.update(sql,user.getUserName(),user.getQuestion(),user.getAnswer());
        return code;    }

    @Override
    public int update(User user) {
        int code = 0;
        String sql = "update user set password=? where username=?";
        code = DBUtils.update(sql,user.getPassword(),user.getUserName());
        return code;
    }

}
