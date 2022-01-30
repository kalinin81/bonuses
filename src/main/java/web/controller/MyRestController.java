package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.DAO.BonusDao;
import web.model.Bonus;
import web.model.Client;
import web.service.MyService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


@RestController
@RequestMapping("/balance")
public class MyRestController {

    private MyService myService;

    @Autowired
    public MyRestController(MyService clientService) {
        this.myService = clientService;
    }

    @GetMapping("/details")
    public Set<Bonus> getDetails(@RequestParam String period, @RequestParam Short currency, @RequestParam("client_id") Long clientId) throws ParseException {
//        не стал разбираться с временной зоной, решил с помощью добавления трех часов
        Date parse = new SimpleDateFormat("yyyy-MM-dd h:m:s").parse(period + "-01 3:0:0");
        return myService.getDetails(parse, currency, clientId);
    }

    @GetMapping("/total")
    public Integer getTotal(@RequestParam Short currency, @RequestParam("client_id") Long clientId) {
        return myService.getBalance(currency, clientId);
    }

}
