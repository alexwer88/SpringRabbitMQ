package hello.controller;

import hello.CommunicateService;
import hello.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;


@Controller
public class SampleController {

    Logger logger = Logger.getLogger("SampleController.class");

    @Autowired
    private CommunicateService communicateService;


    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        logger.info("Emit to queue1");

        communicateService.send();

        return "Emit to queue";
    }

}
