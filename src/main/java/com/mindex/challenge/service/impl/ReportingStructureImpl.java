package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (employee.getDirectReports() == null || employee.getDirectReports().isEmpty()) {

            reportingStructure.setNumberOfReports("0");

            return reportingStructure;
        }
        final Integer totalReportingEmployees = getReportTotal(employee, total);

        reportingStructure.setNumberOfReports(totalReportingEmployees.toString());

        return reportingStructure;
    }

    /*
        Helper method for retrieving distinct reports of reporting employees
    */
    public Integer getReportTotal(Employee employee, Integer total) {

        if (employee.getDirectReports() != null) {

                total += employee.getDirectReports().size();

                for (Employee reportingEmployee : employee.getDirectReports()) {

                    if (reportingEmployee.getDirectReports() != null) {

                            getReportTotal(reportingEmployee, total);

                    } else {

                        continue;
                    }
            }
        }
        return total;
    }
}
