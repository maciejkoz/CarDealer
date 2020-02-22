package carDealer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import carDealer.model.Cars;
import java.util.List;

@Repository
public interface CarsRepository extends CrudRepository<Cars, Long> {

    @Override
    List<Cars> findAll();
}
