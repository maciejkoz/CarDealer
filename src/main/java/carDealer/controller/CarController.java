package carDealer.controller;

import carDealer.model.Dealers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import carDealer.model.Cars;
import carDealer.services.CarsServiceImpl;
import carDealer.services.DealersServiceImpl;

import java.util.List;

@Controller
@RequestMapping("car")
public class CarController {
    private List<Cars> carsList;
    private List<Dealers> dealersList;
    private CarsServiceImpl carsServiceImpl;
    private DealersServiceImpl dealersServiceImpl;

    public CarController(CarsServiceImpl carsService , DealersServiceImpl dealersService) {

        this.carsServiceImpl = carsService;
        this.dealersServiceImpl = dealersService;

        carsList = carsService.getAll();
        dealersList = dealersService.getAll();
    }

    @RequestMapping("/seeAll")
    public ModelAndView showCarList(Model model) {
        carsList = carsServiceImpl.getAll();
        return new ModelAndView("cars-list", "carsList", carsList);
    }

    @RequestMapping(value = "/getForm", method = RequestMethod.GET)
    public String showForm(Model model) {
        dealersList = dealersServiceImpl.getAll();
        model.addAttribute("car", new Cars());
        model.addAttribute("dealersList", dealersList);
        return "add-car";
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(@ModelAttribute(value = "car") Cars car
            , @ModelAttribute(value = "item.id") String itemId)
    {
        int idAsInt = Integer.parseInt(itemId);
        Dealers dealerToSet = dealersList.stream().filter(f -> f.getId() == idAsInt).findFirst().get();
        car.setDealers(dealerToSet);

        if (car.getId() == 0) {
            addCarToDB(car);
        } else {
            updateCarInDB(car);
        }
        return new ModelAndView("redirect:/car/seeAll");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute(value = "car_id") String car_id) {
        Cars car = getCarById(Integer.parseInt(car_id));
        deleteCarFromDB(car);
        return new ModelAndView("redirect:/car/seeAll");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value = "car_id") String car_id, Model model) {
        dealersList = dealersServiceImpl.getAll();
        Cars car = getCarById(Integer.parseInt(car_id));
        model.addAttribute("car", car);
        model.addAttribute("dealersList", dealersList);
        return new ModelAndView("add-car");
    }

    private Cars getCarById(@RequestParam int id) {
        return carsList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private void addCarToDB(Cars car) {
        try {
            carsServiceImpl.create(car);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void updateCarInDB(Cars car) {
        try {
            carsServiceImpl.create(car);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void deleteCarFromDB(Cars car) {
        try {
            carsServiceImpl.delete(car);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
