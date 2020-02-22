package carDealer.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import carDealer.model.AppUser;

import java.util.List;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    @Override
    List<AppUser> findAll();
}
