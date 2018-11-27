package co.javaweb.overtime_resgistion.common;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8785606535249965194L;
    private int page;
    private int limit;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    public BaseEntity() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
