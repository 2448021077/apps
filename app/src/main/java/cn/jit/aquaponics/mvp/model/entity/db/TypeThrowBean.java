package cn.jit.aquaponics.mvp.model.entity.db;

import java.util.List;

public class TypeThrowBean {
    /**
     * list : [{"count":0,"id":0,"image":"string","name":"string","price":0,"server":"string","sysTime":"2020-01-07T01:19:22.342Z","tel":"string","total":0,"type":0,"unit":"string","username":"string"}]
     * pageNum : 0
     * pageSize : 0
     * pages : 0
     * total : 0
     */

    private int pageNum;
    private int pageSize;
    private int pages;
    private int total;
    private List<DailyThrowBean> list;

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

    public List<DailyThrowBean> getList() {
        return list;
    }

    public void setList(List<DailyThrowBean> list) {
        this.list = list;
    }
}
