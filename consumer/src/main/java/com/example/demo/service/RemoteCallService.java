package com.example.demo.service;


import com.example.demo.domain.Employee;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//employee-producer is the name of service registered in eurka
@FeignClient(name="employee-producer")
public interface RemoteCallService {
    //@RequestMapping(method= RequestMethod.GET, value="/employee")
    @RequestMapping(method=RequestMethod.GET, value="/employee")
    public Employee getData();
}
