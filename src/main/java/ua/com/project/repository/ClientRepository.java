package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.ClientDao;
import ua.com.project.entity.Client;

import java.util.List;

public class ClientRepository implements ClientDao {

    private final SessionFactory sessionFactory;

    public ClientRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Client obj) {

    }

    @Override
    public void update(Client obj) {

    }

    @Override
    public void delete(Client obj) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Client findByName(String name) {
        return null;
    }
}
