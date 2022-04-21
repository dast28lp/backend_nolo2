package com.nolo.nolo;
import java.util.List;
import org.springframework.web.bind.annotacion.RestController;
import org.springframework.web.bind.annotacion.GetMapping;


@RestController
public class ServiceController {
    
    @GetMapping("/services")
    public List<Service> getServices(){
        return null;
    }
    
    @GetMapping("/")
    public String getHello(){
        return "Hello word";
    }
}