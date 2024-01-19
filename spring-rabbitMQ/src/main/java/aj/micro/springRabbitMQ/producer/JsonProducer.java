package aj.micro.springRabbitMQ.producer;

import aj.micro.springRabbitMQ.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.json_routing_key.name}")
    private String json_routing_key;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent => %s",user));
        rabbitTemplate.convertAndSend(exchange,json_routing_key,user);
    }
}
