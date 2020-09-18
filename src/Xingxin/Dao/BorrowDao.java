package Xingxin.Dao;

import Xingxin.Object.Borrow;

import java.util.List;

/**
 * @author 231
 * @date 2020-06-20 16:29
 */
public interface BorrowDao {
    List<Borrow> getAll();

    int addborrow(Borrow borrow);
    int addreturn(Borrow borrow);

    List<Borrow> getByUsername(String username);

    List<Borrow> getByUserName(String username);
    List<Borrow> getByBookName(String bookname);


}
