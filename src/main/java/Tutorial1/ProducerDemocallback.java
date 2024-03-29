package Tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemocallback {
    public static void main(String[] args) {
        //Create producer property
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);
        // create a producer record
        ProducerRecord<String,String> record = new ProducerRecord<String, String>("first_topic","Hello saurabh how are you man");
        //send data
        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                //Execute every time a record is sucessfully sent or an exe
            }
        });
        producer.flush();
        producer.close();
    }
}
