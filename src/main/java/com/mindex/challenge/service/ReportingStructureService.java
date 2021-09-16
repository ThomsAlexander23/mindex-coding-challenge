package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

import java.util.HashMap;

public interface ReportingStructureService {

    ReportingStructure read(String id);

    Integer recursiveMethod(Employee employee);
}
