package cn.jit.aquaponics.mvp.model.entity.db;

import java.util.List;

public class TypeTermBean {

    /**
     * list : [{"deveui":"string","id":0,"name":"string","status":0,"type":0,"username":"string"}]
     * pageNum : 0
     * pageSize : 0
     * pages : 0
     * total : 0
     */

    private int pageNum;
    private int pageSize;
    private int pages;
    private int total;
    private List<TermBean> list;

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

    public List<TermBean> getList() {
        return list;
    }

    public void setList(List<TermBean> list) {
        this.list = list;
    }
}
