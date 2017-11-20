package cn.it.phw.ms.pojo;

public class BookusedinfoWithBLOBs extends Bookusedinfo {
    private String borrowTime;

    private String returnTime;

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime == null ? null : borrowTime.trim();
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime == null ? null : returnTime.trim();
    }
}