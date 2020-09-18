package Xingxin.Object;

/**
 * @author 231
 * @date 2020-06-20 16:13
 */
public class Borrow {

    private int id;
    private String username;
    private String booknumber;
    private String bookname;
    private String loandate;
    private String deadline;
    private String returntime;
    private boolean whetheritisoverdue;

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    public boolean isWhetheritisoverdue() {
        return whetheritisoverdue;
    }

    public void setWhetheritisoverdue(boolean whetheritisoverdue) {
        this.whetheritisoverdue = whetheritisoverdue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getLoandate() {
        return loandate;
    }

    public void setLoandate(String loandate) {
        this.loandate = loandate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
