package Xingxin.Frame;

import Xingxin.Dao.BookDao;
import Xingxin.Dao.BorrowDao;
import Xingxin.Impl.BookDaoImpl;
import Xingxin.Impl.BorrowDaoImpl;
import Xingxin.Object.Book;
import Xingxin.Object.Borrow;
import Xingxin.dialog.ReturnSuccess;
import Xingxin.util.mouselistener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import static Xingxin.Frame.Login.us;

/**
 * @author 231
 * @date 2020-06-22 8:46
 */
public class RecordFrame extends JFrame {

    DefaultTableModel tableModel = null;
    JTable table = null;
    String[] labels4 = {"id", "用户姓名", "图书编号", "书名", "借出时间", "期限时间", "归还时间", "是否逾期"};
    JScrollPane scrollPane1 = null;
    JPanel panel4 = new JPanel();

    JPopupMenu jpopupmenu1 = new JPopupMenu();

    public RecordFrame() {
        this.setLayout(null);
        JMenuItem returnbook = new JMenuItem("归还");

        jpopupmenu1.add(returnbook);
        this.addMouseListener(new mouselistener(jpopupmenu1));

        BorrowDao dao3 = new BorrowDaoImpl();
        List<Borrow> borrowList1 = null;
        borrowList1 = dao3.getByUsername(us);
        Vector<Vector<Object>> vectordata = new Vector<>();
        for (Borrow borrow : borrowList1) {
            Vector<Object> objs = new Vector<>();
            objs.add(borrow.getId());
            objs.add(borrow.getUsername());
            objs.add(borrow.getBooknumber());
            objs.add(borrow.getBookname());
            objs.add(borrow.getLoandate());
            objs.add(borrow.getDeadline());
            objs.add(borrow.getReturntime());
            objs.add(borrow.isWhetheritisoverdue());
            vectordata.add(objs);
        }
        Vector<String> columnNames = new Vector<>();
        for (String label : labels4) {
            columnNames.add(label);
        }
        table = new JTable(vectordata, columnNames);
        scrollPane1 = new JScrollPane(table);
        panel4.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 980, 590);
        scrollPane1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.add(scrollPane1);
        setLocation(500, 200);
        this.setSize(1000, 600);
        this.setVisible(true);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });


        returnbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("归还".equals(e.getActionCommand())) {
                    int row = table.getSelectedRow();

                    /* if (tableModel.getValueAt(row, 6)==null) {*/

                    BorrowDao dao = new BorrowDaoImpl();
                    BookDao dao1 = new BookDaoImpl();
                    Book book = new Book();
                    Borrow borrow = new Borrow();

                    tableModel = (DefaultTableModel) table.getModel();
                    String bookname = (String) tableModel.getValueAt(row, 3);
                    borrow.setBookname(bookname);
                    book.setTitle(bookname);

                    int b = Integer.parseInt(UserFrame.a) + 1;
                    book.setRemainingAmount(String.valueOf(b));
                    dao1.updateamount(book);

                    SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
                    String datetime = tempDate.format(new Date());
                    borrow.setReturntime(datetime);
                    String deadline = tableModel.getValueAt(row, 5).toString();
                    try {
                        if (tempDate.parse(datetime).getTime() > tempDate.parse(deadline).getTime()) {
                            borrow.setWhetheritisoverdue(true);
                        } else {
                            borrow.setWhetheritisoverdue(false);
                        }
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    dao.addreturn(borrow);
                    dispose();
                    new RecordFrame();
                    new ReturnSuccess();
                }
            }
        });
    }

    private void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            int focusedRowIndex = table.rowAtPoint(evt.getPoint());
            if (focusedRowIndex == -1) {
                return;
            }
            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
            jpopupmenu1.show(table, evt.getX(), evt.getY());
        }

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

        mouseRightButtonClick(evt);
    }

}





