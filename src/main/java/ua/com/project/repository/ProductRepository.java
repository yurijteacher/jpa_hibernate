package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.ProductDao;
import ua.com.project.entity.Product;

import java.util.List;

public class ProductRepository implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product obj) {

    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void delete(Product obj) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
