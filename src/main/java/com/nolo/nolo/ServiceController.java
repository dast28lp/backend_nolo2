package com.nolo.nolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/service")
    public @ResponseBody Iterable<Service> getServices() {
        return serviceRepository.findAll();
    }

    @PostMapping(value = "/service")
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