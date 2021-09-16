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

        Employee employee = employeeRepository.findByEmployeeId(id);

        Integer total = 0;
        ReportingStructure reportingStructure = new ReportingStructure(employee);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        if (employee.getDirectReports().isEmpty() || employee.getDirectReports() == null) {
            reportingStructure.setNumberOfReports("Has no documented reporting hierarchy");

            return reportingStructure;
        }
        Integer totalReportingEmployees = recursiveMethod(employee, total);
        reportingStructure.setNumberOfReports(totalReportingEmployees.toString());
        return reportingStructure;
    }


    public Integer recursiveMethod(Employee employee, Integer total) {
        LOG.debug("Entering the reporting Hierarchy");
        if (employee.getDirectReports() != null) {
            LOG.debug("Entering the first if statement");
                total += employee.getDirectReports().size();
                for (Employee reportingEmployee : employee.getDirectReports()) {
                    LOG.debug("Entering the for loop");
                    if (reportingEmployee.getDirectReports() != null) {
                        LOG.debug("Entering the second if statement");
                            recursiveMethod(reportingEmployee, total);
                    } else {
                        LOG.debug("report must be null");

                        continue;
                    }
//                }
            }
        }
        LOG.debug("Hierarchy end found and has:" + total + " reporting employees");
        return total;
    }
}
