package Xingxin.Impl;

import Xingxin.util.DBUtils;
import Xingxin.Dao.AdministratorDao;
import Xingxin.Object.Administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 231
 * @date 2020-06-18 10:50
 */
public class AdministratorDaoImpl implements AdministratorDao {

    @Override
    public List<Administrator> getAll() {
        String sql = "select * from administrator";
        List<Administrator> administratorList = new ArrayList<>();
        List<Map<String, Object>> maplist = DBUtils.query(sql);
        for (Map<String, Object> map : maplist) {
            Administrator administrator = new Administrator();
            administrator.setUserName((String) (map.get("username")));
            administrator.setPassword((String) (map.get("password")));
            administrator.setName((String) (map.get("name")));
            administrator.setSex((String) (map.get("sex")));
            administrator.setAge((String) (map.get("age")));
            administrator.setAuthority((String) (map.get("authority")));
            administrator.setTelephoneNumber((String) (map.get("telephonenumber")));
            administrator.setHomeAddress((String) (map.get("homeaddress")));
            administratorList.add(administrator);
        }
        return administratorList;
    }

    @Override
    public List<Administrator> getAdministrator(Administrator administrator) {
        String sql="select * from administrator where username=? and password=? and authority=?";
        List<Administrator> administratorList=new ArrayList<Administrator>();
        List<Map<String, Object>> maplist= DBUtils.query(sql, administrator.getUserName(),administrator.getPassword(),administrator.getAuthority());
        for(Map<String, Object> map:maplist){
            Administrator ne=new Administrator();
            ne.setUserName((String) (map.get("username")));
            ne.setPassword((String)(map.get("password")));
            ne.setAuthority((String)(map.get("authority")));
            administratorList.add(ne);
        }
        return administratorList;
    }

    @Override
    public int addAdministrator(Administrator administrator) {
        int code=0;
        String sql="insert into administrator (username,password,name,sex,age,authority,telephonenumber,homeaddress) " +
                "values(?,?,?,?,?,'管理员',?,?)";
        code= DBUtils.update(sql,administrator.getUserName(), administrator.getPassword(),administrator.getName(),administrator.getSex(),
                administrator.getAge(),administrator.getTelephoneNumber(),administrator.getHomeAddress());
        return code;    }

    @Override
    public int addSuperAdministrator(Administrator superAdministrator) {
        int code=0;
        String sql="insert into administrator (username,password,name,sex,age,authority,telephonenumber,homeaddress) " +
                "values(?,?,?,?,?,'超管',?,?)";
        code= DBUtils.update(sql,superAdministrator.getUserName(), superAdministrator.getPassword(),superAdministrator.getName(),superAdministrator.getSex(),
                superAdministrator.getAge(),superAdministrator.getTelephoneNumber(),superAdministrator.getHomeAddress());
        return code;    }

    @Override
    public int update(Administrator administrator) {
        int code = 0;
        String sql = "update administrator set password=?,name=?,sex=?,age=?,telephonenumber=?,homeaddress=? where username=?";
        code = DBUtils.update(sql, administrator.getPassword(),administrator.getName(),administrator.getSex(),
                administrator.getAge(),administrator.getTelephoneNumber(),administrator.getHomeAddress(),administrator.getUserName());
        return code;
    }

    @Override
    public int delete(Administrator administrator) {
        int code=0;
        String sql="delete from administrator where username=?";
        code=DBUtils.update(sql, administrator.getUserName());
        return code;
    }
}