package web.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import web.DAO.BonusDao;
import web.DAO.ClientDao;
import web.model.Bonus;
import web.model.Client;

import java.util.*;

@SpringBootTest
class MyServiceTest {

    @Mock
    private ClientDao clientDao;
    @Mock
    private BonusDao bonusDao;
    @InjectMocks
    private MyService myService;

    @BeforeEach
    void setUp() {

        Bonus bonus = new Bonus(1L, new Date(1L), 1);
        Set<Bonus> bonuses = new HashSet<>();
        bonuses.add(bonus);
        Mockito.when(bonusDao.getBonuses(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(bonuses);
        Mockito.when(bonusDao.getBonuses(Mockito.any(), Mockito.any())).thenReturn(bonuses);

    }

    @Test
    void getDetails() {
        Set<Bonus> bonuses = myService.getDetails(new Date(1L), (short) 810, 1L);
        assertThat(bonuses.size()).isEqualTo(1);
    }

    @Test
    void getBalance() {
        assertThat(myService.getBalance((short) 810, 1L)).isEqualTo(1);
    }

    @Test
    void blockClient_Success() {
        Mockito.when(clientDao.findClientById(Mockito.any())).thenReturn(new Client(1L, "test client", null));
        assertThat(myService.blockClient(1L)).isNotNull();
    }

    @Test
    void blockClient_Fail() {
        Mockito.when(clientDao.findClientById(Mockito.any())).thenReturn(null);
        assertThat(myService.blockClient(1L)).isNull();
    }
}