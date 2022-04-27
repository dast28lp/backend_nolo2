package com.nolo.nolo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public ResponseEntity<List<Service>> listaTorres() {
        List<Service> serviceList = new ArrayList<>();
        Service service1 = new Service();
        service1.id = 1;
        service1.name = "Matrimonios";
        service1.description = "Servicios de matrimonio";
        service1.image = "https://xxx.com";
        serviceList.add(service1);
        return new ResponseEntity<List<Service>>(serviceList, HttpStatus.OK);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Service> getServices() {
        return serviceRepository.findAll();
    }

    @PostMapping(value = "/")
    public @ResponseBody String addNewUser(@RequestBody ServiceDto serviceDto) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Service service = new Service();

        service.name = serviceDto.name;
        service.description = serviceDto.description;
        service.image = serviceDto.image;
        serviceRepository.save(service);
        return "Saved";
    }
}