
package di.dell.stream.controller;

import di.dell.stream.model.Employee;
import di.dell.stream.service.EmployeeRegistrationSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {
    @Autowired
    EmployeeRegistrationSource employeeRegistrationSource;

    @RequestMapping("/register")
    @ResponseBody
    public String orderFood(@RequestBody Employee employee) {
        // Employee emp = new Employee();
        // emp.setEmpID("asd");
        // emp.setEmpName("fff");
        System.out.println(employee.toString());
        employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
        return employee.toString();
    }
}
