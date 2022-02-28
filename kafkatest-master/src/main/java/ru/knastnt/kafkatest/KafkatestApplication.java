package ru.knastnt.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;


import static java.lang.Thread.sleep;
.

@SpringBootApplication
public class KafkatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkatestApplication.class, args);
    }


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Component
    public static class Runner implements CommandLineRunner{


        //Кастомные шаблоны
        @Autowired
        private KafkaTemplate<String, UserDTO> kafkaUserTemplate;


        @Override
        public void run(String... args) throws Exception {
            Thread thread = new Thread(() -> {
                try {
                    while (true) {


                        //Шлём объекты через кастомные шаблоны
                        sleep(20);
                        ListenableFuture<SendResult<String, UserDTO>> userFuture = kafkaUserTemplate.send("msg2", "user", UserDTO.getTestInstance());
                        userFuture.addCallback(System.out::println, System.err::println);

                    }
                }catch (InterruptedException e){}
            });
            thread.setDaemon(true);
            thread.start();
        }

    }
}
