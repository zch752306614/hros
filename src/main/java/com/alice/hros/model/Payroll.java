package com.alice.hros.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/22 10:33
 */
public class Payroll {

    private Integer id;
    private Integer eid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8" )
    private Date date;
    private Float payable;
    private Float realwage;
    private Float deduction;

    public Integer getId() {
        return id;
    }

    public Integer getEid() {
        return eid;
    }

    public Date getDate() {
        return date;
    }

    public Float getPayable() {
        return payable;
    }

    public Float getRealwage() {
        return realwage;
    }

    public Float getDeduction() {
        return deduction;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayable(Float payable) {
        this.payable = payable;
    }

    public void setRealwage(Float realwage) {
        this.realwage = realwage;
    }

    public void setDeduction(Float deduction) {
        this.deduction = deduction;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "id=" + id +
                ", eid=" + eid +
                ", date=" + date +
                ", payable=" + payable +
                ", realwage=" + realwage +
                ", deduction=" + deduction +
                '}';
    }
}
