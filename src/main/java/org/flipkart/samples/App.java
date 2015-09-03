package org.flipkart.samples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chinmay.baid on 15/08/15.
 */
public class App {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        KafkaProducer kafkaProducer = (KafkaProducer)applicationContext.getBean("producer");
        kafkaProducer.produce();
        KafkaConsumerGroup kafkaConsumer = (KafkaConsumerGroup)applicationContext.getBean("consumerGroup");
        kafkaConsumer.consume();
    }
}
