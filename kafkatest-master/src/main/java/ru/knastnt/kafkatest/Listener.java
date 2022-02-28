package ru.knastnt.kafkatest;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class Listener {

    // класс настроек поставляется спрингбутом

    @KafkaListener(topics = "study-12", groupId = "sshebarin")
    public void message(String msg) {
        System.out.println(msg);
    }

    //################################################################################################################



    //Кастомный Json  для класса UserDTO
    @KafkaListener(topics = "study-12", containerFactory = "userKafkaListenerContainerFactory", groupId = "sshebarin")
    public void messageListener(@Payload UserDTO userDTO, @Headers MessageHeaders headers) {
        System.out.println(headers);
        System.out.println(userDTO);
    }


}
