package carDealer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import carDealer.model.Dealers;
import java.util.List;

@Repository
public interface DealersRepository extends CrudRepository<Dealers, Long> {

    @Override
    List<Dealers> findAll();
}
