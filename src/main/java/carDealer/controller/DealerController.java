package carDealer.controller;

import carDealer.model.Dealers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import carDealer.services.DealersServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/dealer")
public class DealerController {
    private List<Dealers> dealersList;
    private DealersServiceImpl dealersServiceImpl;

    public DealerController(DealersServiceImpl dealersServiceImpl) {
        this.dealersServiceImpl = dealersServiceImpl;
        dealersList = dealersServiceImpl.getAll();
    }

    @RequestMapping("/seeAll")
    public ModelAndView showDealerList(Model model) {
        dealersList = dealersServiceImpl.getAll();
        return new ModelAndView("dealers-list", "list", dealersList);
    }

    @RequestMapping(value = "/getForm", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("dealer", new Dealers());
        return "add-dealer";
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(@ModelAttribute(value = "dealer") Dealers dealer)
                            {

        if (dealer.getId() == 0) {
            addDealerToDB(dealer);
        } else {
            updateDealerInDB(dealer);
        }
        return new ModelAndView("redirect:/dealer/seeAll");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute(value = "dealer_id") String dealer_id) {
        Dealers dealer = getDealersById(Integer.parseInt(dealer_id));
        deleteDealerFromDB(dealer);
        return new ModelAndView("redirect:/dealer/seeAll");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam(value = "dealer_id") String dealer_id) {
        Dealers dealer = getDealersById(Integer.parseInt(dealer_id));
        return new ModelAndView("add-dealer", "dealer", dealer);
    }


    private Dealers getDealersById(@RequestParam int id) {
        return dealersList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private void addDealerToDB(Dealers dealer) {
        try {
            dealersServiceImpl.create(dealer);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void updateDealerInDB(Dealers dealer) {
        try {
            dealersServiceImpl.update(dealer);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void deleteDealerFromDB(Dealers dealer) {
        try {
            dealersServiceImpl.delete(dealer);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
