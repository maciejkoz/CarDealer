package carDealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "carDealer.controller",
        "carDealer.config",
        "carDealer.model",
        "carDealer.services",
        "carDealer.repository"
})
@SpringBootApplication
public class CarDealerApp {

    public static void main(String[] args) {
        SpringApplication.run(CarDealerApp.class, args);
    }
}
