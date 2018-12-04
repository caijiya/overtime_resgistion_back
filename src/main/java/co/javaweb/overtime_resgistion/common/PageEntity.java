package co.javaweb.overtime_resgistion.common;

import java.util.List;

public class PageEntity<T> {
    private int page = 1;
    private int limit = 10;
    private int totalCount;
    private List<T> list;

    public PageEntity() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
