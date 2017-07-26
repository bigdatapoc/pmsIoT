package com.hcl.pmsiot.messaging.utility;

import java.util.Properties;

import com.hcl.pmsiot.messaging.dto.MessageDTO;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {

	 private static Producer<Integer, String> producer;

     public static void initialize() {
           Properties producerProps = new Properties();
           producerProps.put("metadata.broker.list", "localhost:9092");
           producerProps.put("serializer.class", "kafka.serializer.StringEncoder");
           producerProps.put("request.required.acks", "1");
           ProducerConfig producerConfig = new ProducerConfig(producerProps);
           producer = new Producer<Integer, String>(producerConfig);
           //Producer<String, String> producer = new KafkaProducer<String, String>(props);
     }
     public static void publishMesssage(MessageDTO messageDTO) throws Exception{ 
    	 initialize();
         //Define topic name and message
         KeyedMessage<Integer, String> keyedMsg = new KeyedMessage<Integer, String>(messageDTO.getTopic(), messageDTO.getMessage());
         //ProducerRecord producerRecord =  new ProducerRecord<String, String>("HelloKafkaTopic", msg);
         //producer.send(producerRecord);
         producer.send(keyedMsg); // This publishes message on given topic
        
         producer.close();
     }
     
}
