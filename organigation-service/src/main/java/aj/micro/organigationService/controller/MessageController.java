package aj.micro.organigationService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //without restart the service change the configuration file from git
public class MessageController {

    @Value(value = "${spring.boot.message}")
    private String message;
    @GetMapping("/message")
    public String message(){
        return this.message;
    }
}
