package com.nolo.nolo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ServiceController {
    
    @GetMapping("/services")
    public ResponseEntity<List<Service>> listaTorres(){
        List<Service> serviceList = new ArrayList<>();
        Service service1 = new Service();
        service1.id=1;
        service1.name="Matrimonios";
        service1.description="Servicios de matrimonio";
        service1.image="https://xxx.com";
        serviceList.add(service1);
        return new ResponseEntity<List<Service>>(serviceList, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public String getHello(){
        return "Hello wordmini";
    }
}