package com.mindex.challenge.data;

import java.util.Date;


public class Compensation {

    private Employee employee;
    private Date effectiveDate;
    private String salary;

    public Compensation(){}

//    public Compensation(int id, Employee employee, Date effectiveDate, String salary) {
//        this.id = id;
//        this.employee = employee;
//        this.effectiveDate = effectiveDate;
//        this.salary = salary;
//    }
//
//    public Compensation(Employee employee, String salary) {
//        this.employee = employee;
//        this.salary = salary;
//        this.effectiveDate = new Date(effectiveDate.getTime());
//    }
//
//    public Compensation(String salary) {
//        this.salary = salary;
//        this.effectiveDate = new Date(effectiveDate.getTime());
//    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getEffectiveDate() { return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
