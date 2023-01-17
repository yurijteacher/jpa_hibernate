package ua.com.project.config;

import org.hibernate.SessionFactory;
import ua.com.project.dao.CategoryDao;
import ua.com.project.dao.ClientDao;
import ua.com.project.dao.ProductDao;
import ua.com.project.dao.UsersDao;
import ua.com.project.repository.CategoryRepository;
import ua.com.project.repository.ClientRepository;
import ua.com.project.repository.ProductRepository;
import ua.com.project.repository.UserRepository;

import javax.persistence.Persistence;

public class Factory {
    public final static Factory INSTANCE = new Factory();
    public static Factory getInstance() {
        return INSTANCE;
    }
    private final SessionFactory session;
    public Factory() {
        this.session = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public ProductDao getProductDao() {
        return new ProductRepository(session);
    }

    public CategoryDao getCategoryDao() {
        return new CategoryRepository(session);
    }

    public UsersDao getUserDao(){return new UserRepository(session);
    }
    public ClientDao getClientDao(){return new ClientRepository(session);
    }
}
