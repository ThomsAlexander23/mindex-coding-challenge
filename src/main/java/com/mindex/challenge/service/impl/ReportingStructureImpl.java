package com.mindex.challenge.service.impl;


import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReportingStructureImpl implements ReportingStructureService {


    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reporting structure for employee with id [{}]");

        List<Employee> reportingEmployees = new ArrayList<Employee>();

        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        if (employee.getDirectReports().isEmpty()) {
            return null;
        }
        Integer totalReportingEmployees = recursiveMethod(employee);
        ReportingStructure reportingStructure = new ReportingStructure(employee, totalReportingEmployees.toString());
        return reportingStructure;
    }


    public Integer recursiveMethod(Employee employee) {
        Integer total = 0;
        while (!employee.getDirectReports().isEmpty()) {
            total += employee.getDirectReports().size();
            for (Employee reportingEmployee : employee.getDirectReports()) {
                total += reportingEmployee.getDirectReports().size();
                recursiveMethod(reportingEmployee);
            }
        }
        return total;
    }
}
