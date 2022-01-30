package web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Client;
import web.service.MyService;

@Controller
@RequestMapping("/clients")
public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PutMapping
    public ResponseEntity<Client> blockClient(@RequestParam("client_id") Long clientId) {
        Client client = myService.blockClient(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(client);
        }
    }
}
