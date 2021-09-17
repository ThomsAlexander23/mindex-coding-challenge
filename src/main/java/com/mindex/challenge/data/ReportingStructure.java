package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private String numberOfReports;

    /*
    employee parameter needed to assign reporting structure class at read method in implementation
     */
    public ReportingStructure(Employee employee){}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(String numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
