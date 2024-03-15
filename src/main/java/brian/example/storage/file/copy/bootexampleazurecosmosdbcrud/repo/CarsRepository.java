package brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.repo;

import brian.example.storage.file.copy.bootexampleazurecosmosdbcrud.entity.Car;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends CosmosRepository<Car, String> {
    List<Car> findByMake(String make);
}
