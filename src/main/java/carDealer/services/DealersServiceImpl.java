package carDealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import carDealer.repository.DealersRepository;
import carDealer.model.Dealers;


import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DealersServiceImpl implements DealersService {

    private DealersRepository dealersRepository;

    @Autowired
    private EntityManager entityManager;

    public DealersServiceImpl(DealersRepository dealersRepository) {
        this.dealersRepository = dealersRepository;
    }

    public void create(Dealers dealers){
        dealersRepository.save(dealers);
    }

    public List<Dealers> getAll(){
        return dealersRepository.findAll();
    }

    public void update (Dealers dealer){
        dealersRepository.save(dealer);
    }

    public void delete(Dealers dealer){
        dealer = entityManager.find(Dealers.class, dealer.getId());
        dealersRepository.delete(dealer);
    }
}
