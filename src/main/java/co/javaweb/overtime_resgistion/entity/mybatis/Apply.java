package co.javaweb.overtime_resgistion.entity.mybatis;

import java.util.Date;

public class Apply {
    private int overtime_id;
    private int apply_status;
    private String approver_id;
    private int employee_id;
    private Date endtime;
    private int overtime_hours;
    private String overtime_reason;
    private int send_person_id;
    private String starttime;
    private int status;
    private String approval_reason;

    public Apply() {
    }

    public int getOvertime_id() {
        return overtime_id;
    }

    public void setOvertime_id(int overtime_id) {
        this.overtime_id = overtime_id;
    }

    public int getApply_status() {
        return apply_status;
    }

    public void setApply_status(int apply_status) {
        this.apply_status = apply_status;
    }

    public String getApprover_id() {
        return approver_id;
    }

    public void setApprover_id(String approver_id) {
        this.approver_id = approver_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getOvertime_hours() {
        return overtime_hours;
    }

    public void setOvertime_hours(int overtime_hours) {
        this.overtime_hours = overtime_hours;
    }

    public String getOvertime_reason() {
        return overtime_reason;
    }

    public void setOvertime_reason(String overtime_reason) {
        this.overtime_reason = overtime_reason;
    }

    public int getSend_person_id() {
        return send_person_id;
    }

    public void setSend_person_id(int send_person_id) {
        this.send_person_id = send_person_id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getApproval_reason() {
        return approval_reason;
    }

    public void setApproval_reason(String approval_reason) {
        this.approval_reason = approval_reason;
    }
}
