package hello;

import hello.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommunicateService {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend(RabbitConfig.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
    }

    @RabbitListener(queues = RabbitConfig.queueName)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
