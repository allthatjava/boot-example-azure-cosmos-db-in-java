package brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Container(containerName = "cars")
public class Car {
    @Id
    private String id;

    @PartitionKey
    private String make;
    private String model;
    private String vin;

    public Car(){}

    public Car(String id, String make, String model, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.vin = vin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
