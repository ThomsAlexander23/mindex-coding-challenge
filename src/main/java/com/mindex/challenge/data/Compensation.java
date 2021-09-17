package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {

    private Employee employee;
    private Date effectiveDate;
    private String salary;

    public Compensation(){}

    public Compensation(Employee employee, String salary, Date effectiveDate){
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = new Date(effectiveDate.getTime());
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getEffectiveDate() {
        return new Date(effectiveDate.getTime());
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = new Date(effectiveDate.getTime());
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
