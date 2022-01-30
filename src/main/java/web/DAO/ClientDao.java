package web.DAO;

import org.springframework.data.repository.CrudRepository;
import web.model.Client;

public interface ClientDao extends CrudRepository<Client, Long> {

    Client findClientById(Long id);

}
