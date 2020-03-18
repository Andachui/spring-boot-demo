package com.dachui.componentrabbitmq.producter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产者
 */
@Component
public class MyRabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {

        Map<String,Object> sendContext = new HashMap<>();
        sendContext.put("name","张三");
        sendContext.put("sex","男");
        sendContext.put("msg",msg);
        rabbitTemplate.convertAndSend("tulingDirectExchange","tuling.directkey",sendContext);
    }

    /**
     * 发送到扇形交换机上
     * @param msg
     */
    public void sendMsg2Fanout(String msg) {

        rabbitTemplate.convertAndSend("tulingFanoutExchange","aaaabbdd",msg);

    }


    /**
     * 发送到扇形交换机上
     * @param msg
     */
    public void sendMsg2Topic(String msg) {
        rabbitTemplate.convertAndSend("tulingTopicExchange","topic.key.aaa",msg);
        rabbitTemplate.convertAndSend("tulingTopicExchange","aa.key",msg);

    }


}
