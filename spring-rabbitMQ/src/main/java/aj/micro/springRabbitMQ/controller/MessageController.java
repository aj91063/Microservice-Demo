package aj.micro.springRabbitMQ.controller;

import aj.micro.springRabbitMQ.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;
    @GetMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to queue...");
    }
}
