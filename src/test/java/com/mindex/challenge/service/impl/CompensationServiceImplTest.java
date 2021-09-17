package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {


        private String compensationUrl;
        private String compensationIdUrl;
        private String employeeId;
        private String employeeIdUrl;

        @Autowired
        private EmployeeService employeeService;

        @Autowired
        private CompensationService compensationService;

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Before
        public void setup() {
            compensationUrl = "http://localhost:" + port + "/compensation";
            compensationIdUrl = "http://localhost:" + port + "/compensation/{id}";
            employeeId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
            employeeIdUrl = "http://localhost:" + port + "/employee/{id}";
        }

        @Test
        public void testCreateReadUpdate() {
            Employee testEmployee = restTemplate.getForEntity(employeeIdUrl, Employee.class, employeeId).getBody();

            Compensation testCompensation = new Compensation();
            testCompensation.setEmployee(testEmployee);
            testCompensation.setSalary("47372");
            testCompensation.setEffectiveDate(new Date());


            // Create checks
            Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, testCompensation, Compensation.class).getBody();

            assertNotNull(createdCompensation);
            assertCompensationEquivalence(testCompensation, createdCompensation);


            // Read checks
            Compensation readCompensation = restTemplate.getForEntity(compensationIdUrl, Compensation.class, createdCompensation.getEmployee().getEmployeeId()).getBody();
            assertEquals(readCompensation.getEmployee().getEmployeeId(),createdCompensation.getEmployee().getEmployeeId());
            assertCompensationEquivalence(readCompensation, createdCompensation);

        }

        static void assertCompensationEquivalence(Compensation expected, Compensation actual) {
            assertEquals(expected.getEmployee().getEmployeeId(), actual.getEmployee().getEmployeeId());
            assertEquals(expected.getSalary(), actual.getSalary());
            assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
        }
}
