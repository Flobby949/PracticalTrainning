package Xingxin.Frame;

import Xingxin.Dao.BookDao;
import Xingxin.Impl.BookDaoImpl;
import Xingxin.Object.Book;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

/**
 * @author 231
 * @date 2020-06-20 14:39
 */
public class BookTableFrame extends JFrame implements ActionListener, MouseListener {


    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("添加");
    JMenu m2 = new JMenu("修改");
    JMenu m3 = new JMenu("删除");

    JMenuItem insertRow = new JMenuItem("添加行");
    JMenuItem save = new JMenuItem("保存");
    JMenuItem Delete = new JMenuItem("删除行");
    JMenuItem exchange = new JMenuItem("修改并保存");
    private DefaultTableModel tableModel = null ;
    JTable table = null;

    String[] labels={"图书编号","书名","作者","出版社","图书类别","出版时间","总数量","剩余数量"};


    public BookTableFrame(List<Book> list) {

        JButton jb1 = new JButton("修改");
        jb1.setBounds(500, 200, 80, 40);

        JButton jb2 = new JButton("删除");
        jb2.setBounds(500, 100, 80, 40);

        JButton jb3 = new JButton("添加");
        jb3.setBounds(500, 10, 80, 40);

        add(jb1);add(jb2);add(jb3);

        Vector<Vector<Object>> vectordata=new Vector<>();

        for(Book book:list){
            Vector<Object> objs=new Vector<>();
            objs.add(book.getBookNumber());
            objs.add(book.getTitle());
            objs.add(book.getAuthor());
            objs.add(book.getPublishingHouse());
            objs.add(book.getClassification());
            objs.add(book.getPublicationDate());
            objs.add(book.getTotal());
            objs.add(book.getRemainingAmount());
            vectordata.add(objs);
        }

        Vector<String> columnNames=new Vector<>();
        for(String label:labels){
            columnNames.add(label);
        }

        table=new JTable(vectordata, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        jb1.addMouseListener(this);
        jb2.addMouseListener(this);
        jb3.addMouseListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "总面板", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));

        this.getContentPane().add(panel);

        panel.add(scrollPane);
        scrollPane.setBounds(15, 15, 800, 800);
        scrollPane.setBorder(new TitledBorder(null, "信息面板",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setSize(1280, 720);


        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);
        m1.add(insertRow);
        m1.add(save);
        m3.add(Delete);
        m2.add(exchange);
        this.setJMenuBar(menuBar);


        insertRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = (DefaultTableModel) table.getModel();
                tableModel.addRow(new Object[]{"", "", "", "","", "", "", ""});
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl() ;
                Book book = new Book();
                tableModel = (DefaultTableModel) table.getModel();
                int row = table.getSelectedRow();
                book.setBookNumber((String) tableModel.getValueAt(row, 0));
                book.setTitle((String) tableModel.getValueAt(row, 1));
                book.setAuthor((String) tableModel.getValueAt(row, 2));
                book.setPublishingHouse((String) tableModel.getValueAt(row, 3));
                book.setClassification((String) tableModel.getValueAt(row, 4));
                book.setPublicationDate((String) tableModel.getValueAt(row, 5));
                book.setTotal((String) tableModel.getValueAt(row, 6));
                book.setRemainingAmount((String) tableModel.getValueAt(row, 7));
                dao.add(book);
            }
        });

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl() ;
                Book book = new Book();
                tableModel = (DefaultTableModel) table.getModel();
                int row = table.getSelectedRow();
                book.setBookNumber((String) tableModel.getValueAt(row, 0));
                dao.delete(book);
                tableModel.removeRow(row);
            }
        });

        exchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl() ;
                Book book = new Book();
                tableModel = (DefaultTableModel) table.getModel();
                int row = table.getSelectedRow();
                book.setBookNumber((String) tableModel.getValueAt(row, 0));
                book.setTitle((String) tableModel.getValueAt(row, 1));
                book.setAuthor((String) tableModel.getValueAt(row, 2));
                book.setPublishingHouse((String) tableModel.getValueAt(row, 3));
                book.setClassification((String) tableModel.getValueAt(row, 4));
                book.setPublicationDate((String) tableModel.getValueAt(row, 5));
                book.setTotal((String) tableModel.getValueAt(row, 6));
                book.setRemainingAmount((String) tableModel.getValueAt(row, 7));
                dao.update(book);
            }
        });


        table.setRowHeight(20);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        BookDao dao = new BookDaoImpl() ;
        Book book = new Book();
        tableModel = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        if ("修改".equals(e.getActionCommand())) {
            book.setBookNumber((String) tableModel.getValueAt(row, 0));
            book.setTitle((String) tableModel.getValueAt(row, 1));
            book.setAuthor((String) tableModel.getValueAt(row, 2));
            book.setPublishingHouse((String) tableModel.getValueAt(row, 3));
            book.setClassification((String) tableModel.getValueAt(row, 4));
            book.setPublicationDate((String) tableModel.getValueAt(row, 5));
            book.setTotal((String) tableModel.getValueAt(row, 6));
            book.setRemainingAmount((String) tableModel.getValueAt(row, 7));
            dao.update(book);
        } else if ("删除".equals(e.getActionCommand())) {
            book.setBookNumber((String) tableModel.getValueAt(row, 0));
            dao.delete(book);
            tableModel.removeRow(row);
        } else if ("添加".equals(e.getActionCommand())) {
            book.setBookNumber((String) tableModel.getValueAt(row, 0));
            book.setTitle((String) tableModel.getValueAt(row, 1));
            book.setAuthor((String) tableModel.getValueAt(row, 2));
            book.setPublishingHouse((String) tableModel.getValueAt(row, 3));
            book.setClassification((String) tableModel.getValueAt(row, 4));
            book.setPublicationDate((String) tableModel.getValueAt(row, 5));
            book.setTotal((String) tableModel.getValueAt(row, 6));
            book.setRemainingAmount((String) tableModel.getValueAt(row, 7));
            dao.add(book);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img1=kit.getImage("src/UpArrow.png");
        Cursor cu=kit.createCustomCursor(img1,new Point(20,5),"stick");
        this.setCursor(cu);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img1=kit.getImage("src/Arrow.png");
        Cursor cu=kit.createCustomCursor(img1,new Point(20,5),"stick");
        this.setCursor(cu);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img1=kit.getImage("src/Hand.png");
        Cursor cu=kit.createCustomCursor(img1,new Point(20,5),"stick");
        this.setCursor(cu);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img1=kit.getImage("src/Arrow.png");
        Cursor cu=kit.createCustomCursor(img1,new Point(20,5),"stick");
        this.setCursor(cu);
    }
}



