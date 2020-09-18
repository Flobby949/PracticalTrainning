package Xingxin.Dao;

import Xingxin.Object.Administrator;

import java.util.List;

/**
 * @author 231
 * @date 2020-06-18 10:47
 */
public interface AdministratorDao {
    List<Administrator> getAll();

    List<Administrator> getAdministrator(Administrator administrator);

    int addAdministrator(Administrator administrator);

    int addSuperAdministrator(Administrator superAdministrator);

    int update(Administrator administrator);

    int delete(Administrator administrator);
    
}