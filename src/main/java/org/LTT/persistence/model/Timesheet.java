package org.LTT.persistence.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timesheet")
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long userid;
    private Date work_day;
    private String time;
    private Date modifileDate;
    private  Date createDate;

    public Long getId() {
        return id;
    }

    public long getUserid() {
        return userid;
    }

    public Date getWork_day() {
        return work_day;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setWork_day(Date work_day) {
        this.work_day = work_day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setModifileDate(Date modifileDate) {
        this.modifileDate = modifileDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTime() {
        return time;
    }

    public Date getModifileDate() {
        return modifileDate;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
