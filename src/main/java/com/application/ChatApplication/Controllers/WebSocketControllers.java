package com.application.ChatApplication.Controllers;

import com.application.ChatApplication.Message.FromMessage;
import com.application.ChatApplication.Message.ToMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketControllers {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ToMessage SendToMessage(FromMessage fromMessage) throws InterruptedException {
        Thread.sleep(1000);
        return new ToMessage("Hello " + HtmlUtils.htmlEscape(fromMessage.getName()) + "!");
    }
}
