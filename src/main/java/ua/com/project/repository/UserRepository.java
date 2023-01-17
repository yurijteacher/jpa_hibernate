package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.UsersDao;
import ua.com.project.entity.Users;

import java.util.List;

public class UserRepository implements UsersDao {

    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Users obj) {

    }

    @Override
    public void update(Users obj) {

    }

    @Override
    public void delete(Users obj) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findById(Long id) {
        return null;
    }

    @Override
    public Users findByName(String name) {
        return null;
    }
}
