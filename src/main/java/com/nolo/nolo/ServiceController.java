package com.nolo.nolo;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@CrossOrigin("*")
@SessionAttributes("user")
@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private UserRepository userRepository;

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
    
    @PostMapping(value = "/newsletter")
    public ResponseEntity<User> addNewsLetter(@Valid @RequestBody User user, BindingResult result) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        /*
        Service service = new Service();

        service.name = serviceDto.name;
        service.description = serviceDto.description;
        service.image = serviceDto.image;
        serviceRepository.save(service);
        */
        
       
        if (result.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        
        
        User newUser = new User();
        newUser.name = user.name;
        newUser.email = user.email;
        userRepository.save(newUser);
        return ResponseEntity.ok(newUser);
        
        
    }
}