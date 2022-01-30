package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.BonusDao;
import web.DAO.ClientDao;
import web.model.Bonus;
import web.model.Client;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class MyService {

    private ClientDao clientDao;
    private BonusDao bonusDao;

    @Autowired
    public MyService(ClientDao clientDao, BonusDao bonusDao) {
        this.clientDao = clientDao;
        this.bonusDao = bonusDao;
    }

    public Set<Bonus> getDetails(Date date, Short currency, Long clientId) {
        return bonusDao.getBonuses(date, currency, clientId);
    }

    public Integer getBalance(Short currency, Long clientId) {
        Set<Bonus> bonuses = bonusDao.getBonuses(currency, clientId);
        return bonuses.stream().flatMapToInt(bonus -> IntStream.of(bonus.getBonus())).sum();
    }

    public Client blockClient(Long clientId) {
        Client client = clientDao.findClientById(clientId);
        if (client != null) {
            client.setBlocked(true);
            clientDao.save(client);
        }
        return client;
    }
}
