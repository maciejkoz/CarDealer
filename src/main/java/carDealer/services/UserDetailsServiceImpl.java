package carDealer.services;

import carDealer.model.AppUser;
import carDealer.model.Dealers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import carDealer.repository.AppUserRepository;

import java.util.List;
import javax.persistence.EntityManager;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    @Autowired
    private EntityManager entityManager;


    @Autowired
    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(string);
    }


    public void create(AppUser appUser){
        appUserRepository.save(appUser);
    }

    public List<AppUser> getAll(){return appUserRepository.findAll();
    }

    public void update (AppUser appUser){
        appUserRepository.save(appUser);
    }

    public void delete(AppUser appUser){
        appUser = entityManager.find(AppUser.class, appUser.getId());
        appUserRepository.delete(appUser);
    }

}
