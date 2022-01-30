package web.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import web.model.Bonus;

import java.util.Date;
import java.util.Set;

public interface BonusDao extends CrudRepository<Bonus, Long> {

    @Query(value = "select b from Bonus b where b.date = ?1 and b.card.currency = ?2 and b.card.client.id = ?3")
    Set<Bonus> getBonuses(Date date, Short currency, Long clientId);

    Bonus getBonusById(Long id);

    Set<Bonus> findAll();

    @Query(value = "select b from Bonus b where b.card.currency = ?1 and b.card.client.id = ?2")
    Set<Bonus> getBonuses(Short currency, Long clientId);
}
