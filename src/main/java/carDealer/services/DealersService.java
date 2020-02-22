package carDealer.services;

import carDealer.model.Dealers;

import java.util.List;

public interface DealersService {

    void create(Dealers dealer);

    List<Dealers> getAll();

    void update(Dealers dealer);

    void delete(Dealers dealer);

}
