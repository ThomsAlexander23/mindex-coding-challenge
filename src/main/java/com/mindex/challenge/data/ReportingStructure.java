package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private long numberOfReports;

    public ReportingStructure(){}

    public ReportingStructure(Employee employee, long numberOfReports){
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(long numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
