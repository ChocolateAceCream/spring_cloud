package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.io.IOException;
import java.util.List;

@Controller
public class ConsumerControllerClient {

    @Autowired
    //private DiscoveryClient discoveryClient;
    private LoadBalancerClient loadBalancer;

    public void getEmployee() throws RestClientException, IOException {
        //List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
        //ServiceInstance serviceInstance = instances.get(0);

        //for Ribbon implementation:
        ServiceInstance serviceInstance = loadBalancer.choose("employee-producer");
        System.out.println(serviceInstance.getUri());
        String baseUrl = serviceInstance.getUri().toString();
        baseUrl = baseUrl+"/employee";
        //String baseUrl = "http://localhost:8080/employee";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        } catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}
