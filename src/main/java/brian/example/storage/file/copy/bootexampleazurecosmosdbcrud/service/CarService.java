package brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.service;

import brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.entity.Car;
import brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.repo.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CarService {

    private CarsRepository repo;

    @Autowired
    public CarService(CarsRepository repo){
        this.repo = repo;
    }

    public Car createOrUpdateCar(Car car){
        return repo.save(car);
    }

    public List<Car> getItemsByMake(String make){
        return repo.findByMake(make);
    }

    public Iterable<Car> getAll() {
        return repo.findAll();
    }
}
