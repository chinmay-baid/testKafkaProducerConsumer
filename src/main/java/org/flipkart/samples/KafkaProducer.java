package org.flipkart.samples;

/**
 * Created by chinmay.baid on 15/08/15.
 */
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class KafkaProducer {
    private Producer<String, String> producer;

    public void produce(){
        Properties props = new Properties();

        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "org.flipkart.samples.SimplePartitioner");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);

        for(int i = 0; i < 100; i++) {
            Random rnd = new Random();
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;

            KeyedMessage<String, String> data = new KeyedMessage<String, String>("ci_signalscd", ip, msg);
            producer.send(data);
        }
        producer.close();
    }
}
