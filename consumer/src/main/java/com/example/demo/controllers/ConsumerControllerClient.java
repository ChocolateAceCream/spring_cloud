package com.example.demo.controllers;

import com.example.demo.domain.Employee;
import com.example.demo.service.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
//import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.io.IOException;

@Controller
public class ConsumerControllerClient {
    //without using of Feign
    //@Autowired
    //private DiscoveryClient discoveryClient;
    //private LoadBalancerClient loadBalancer;

    //using Feign
    @Autowired
    private RemoteCallService loadBalancer;

    public void getEmployee() throws RestClientException, IOException {
        try {
            Employee emp = loadBalancer.getData();
            System.out.println(emp.getEmpId()+' '+emp.getName()+' '+emp.getDesignation()+" "+emp.getSalary());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
        //ServiceInstance serviceInstance = instances.get(0);

        //for Ribbon implementation, without using Feign
        //ServiceInstance serviceInstance = loadBalancer.choose("employee-producer");
        //System.out.println(serviceInstance.getUri());
        //String baseUrl = serviceInstance.getUri().toString();
        //baseUrl = baseUrl+"/employee";
        ////String baseUrl = "http://localhost:8080/employee";
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response=null;
        //try{
        //    response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        //} catch(Exception ex) {
        //    System.out.println(ex);
        //}
        //System.out.println(response.getBody());
    }

    //private static HttpEntity<?> getHeaders() throws IOException {
    //    HttpHeaders headers = new HttpHeaders();
    //    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    //    return new HttpEntity<>(headers);
    //}
}
