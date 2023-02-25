package com.example.websocketstompmessaging;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message msg) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello " + HtmlUtils.htmlEscape(msg.getName()) + "!");
    }
}
