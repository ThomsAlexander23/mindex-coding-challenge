package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private String numberOfReports;

    public ReportingStructure(){}

    public ReportingStructure(Employee employee, String numberOfReports){
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    public ReportingStructure(Employee employee){
        this.employee = employee;
    }


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
