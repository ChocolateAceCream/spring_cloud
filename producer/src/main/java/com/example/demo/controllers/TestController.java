package com.example.demo.controllers;

import com.example.demo.domain.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() throws InterruptedException {

        System.out.println("Inside firstPage");
        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        //simulate timeout
        //Thread.sleep( 1888);
        return emp;
    }

    public Employee getDataFallBack() {

        System.out.println("Inside fallback");
        Employee emp = new Employee();
        emp.setName("fallback-emp1");
        emp.setDesignation("fallback-mananger");
        emp.setEmpId("fallback-1");
        emp.setSalary(3000);

        return emp;
    }
}
