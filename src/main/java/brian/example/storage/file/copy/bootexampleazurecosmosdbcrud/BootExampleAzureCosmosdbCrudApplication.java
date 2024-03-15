package brian.example.storage.file.copy.bootexampleazurecosmosdbcrud;

import brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.entity.Car;
import brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class BootExampleAzureCosmosdbCrudApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootExampleAzureCosmosdbCrudApplication.class);

    @Autowired
    private CarService service;

    public static void main(String[] args) {
        SpringApplication.run(BootExampleAzureCosmosdbCrudApplication.class, args);
    }

    public void run(String... var1){
        LOGGER.info("============== run method started");
        Car car1 = new Car("3","Toyota", "Prius", "112233");
        service.createOrUpdateCar(car1);

//        List<Car> cars = service.getItemsByMake("honda");
        Iterable<Car> cars = service.getAll();
        ObjectMapper mapper = new ObjectMapper();
        cars.forEach(car -> {
            try {
                LOGGER.info("Car:"+ mapper.writeValueAsString(car));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        LOGGER.info("============== run method finished");
    }

}
