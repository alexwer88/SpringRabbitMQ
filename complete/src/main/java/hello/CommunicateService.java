package hello;

import java.util.concurrent.CountDownLatch;

import hello.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = RabbitConfig.queueName)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
      //  latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
