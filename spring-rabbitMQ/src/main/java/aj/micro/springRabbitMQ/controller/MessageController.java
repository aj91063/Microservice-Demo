package aj.micro.springRabbitMQ.controller;

import aj.micro.springRabbitMQ.dto.User;
import aj.micro.springRabbitMQ.producer.JsonProducer;
import aj.micro.springRabbitMQ.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MessageController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;
    @Autowired
    private JsonProducer jsonProducer;
    @GetMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to queue...");
    }

    @PostMapping("/user")
    public ResponseEntity<User> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
      return   ResponseEntity.ok(user);
    }
}
