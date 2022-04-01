package cn.jit.aquaponics.mvp.model.entity.db;

import java.util.List;

public class BaseFishPondPageBean<T> {
    private int pageNum;
    private int pageSize;
    private int pages;
    private int total;
    private List<T> ponds;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getPonds() {
        return ponds;
    }

    public void setPonds(List<T> ponds) {
        this.ponds = ponds;
    }
}
