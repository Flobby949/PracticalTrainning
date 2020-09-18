package Xingxin.Impl;

import Xingxin.util.DBUtils;
import Xingxin.Dao.BookDao;
import Xingxin.Object.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 231
 * @date 2020-06-19 9:18
 */
public class BookDaoImpl implements BookDao {

    public static String bookTitle = null;
    @Override
    public List<Book> getAll() {
        String sql = "select * from book order by (bookNumber-0)";
        List<Book> bookList = new ArrayList<Book>();
        List<Map<String, Object>> maplist = DBUtils.query(sql);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }


    @Override
    public List<Book> getByBookNumber(String booknumber) {
        String sql = "select * from book where booknumber=?";
        List<Book> bookList = new ArrayList<Book>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, booknumber);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getByBookName(String title) {
        String sql = "select * from book where title=?";
        List<Book> bookList = new ArrayList<Book>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, title);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getByAuthor(String author) {
        String sql = "select * from book where author=?";
        List<Book> bookList = new ArrayList<Book>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, author);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getByClassification(String classification) {
        String sql = "select * from book where classification=?";
        List<Book> bookList = new ArrayList<Book>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, classification);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> getByKey(String key) {
        String sql = "select * from book where concat(booknumber,title,author,publishinghouse,classification) like \"%\"?\"%\"";
        List<Book> bookList = new ArrayList<Book>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, key);
        for (Map<String, Object> map : maplist) {
            Book book = new Book();
            book.setBookNumber((String) (map.get("booknumber")));
            book.setTitle((String) (map.get("title")));
            book.setAuthor((String) (map.get("author")));
            book.setPublishingHouse((String) (map.get("publishinghouse")));
            book.setClassification((String) (map.get("classification")));
            book.setPublicationDate((String) (map.get("publicationdate")));
            book.setTotal((String) (map.get("total")));
            book.setRemainingAmount((String) (map.get("remainingamount")));
            bookList.add(book);
        }
        return bookList;
    }


    @Override
    public int add(Book book) {
        int code = 0;
        String sql = "insert into book (booknumber,title,author,publishinghouse,classification,publicationdate,total,remainingamount) values(?,?,?,?,?,?,?,?)";
        code = DBUtils.update(sql, book.getBookNumber(), book.getTitle(), book.getAuthor(), book.getPublishingHouse(), book.getClassification(), book.getPublicationDate(), book.getTotal(), book.getRemainingAmount());
        return code;
    }

    @Override
    public int update(Book book) {
        int code = 0;
        String sql = "update book set title=?,author=?,publishinghouse=?,classification=?,publicationdate=?,total=?,remainingamount=? where booknumber=?";
        code = DBUtils.update(sql, book.getTitle(), book.getAuthor(), book.getPublishingHouse(), book.getClassification(), book.getPublicationDate(), book.getTotal(), book.getRemainingAmount(), book.getBookNumber());
        return code;
    }

    @Override
    public int updateamount(Book book) {
        int code = 0;
        String sql = "update book set remainingamount=? where title=?";
        code = DBUtils.update(sql, book.getRemainingAmount(),book.getTitle());
        return code;
    }

    @Override
    public int delete(Book book) {
        int code = 0;
        String sql = "delete from book where booknumber=?";
        code = DBUtils.update(sql, book.getBookNumber());
        return code;
    }

    @Override
    public int updateAmount(Book book) {
        int code = 0;
        String sql = "update book set remainingamount=? where booknumber=?";
        code = DBUtils.update(sql, book.getRemainingAmount(), book.getBookNumber());
        return code;
    }

    @Override
    public String selectremainamount(String book) {
        String code = null;

        String sql = "select remainingamount from book where title = '"+bookTitle+"'";

        return code;
    }


}