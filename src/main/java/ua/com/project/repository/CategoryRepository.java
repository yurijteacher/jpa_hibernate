package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.CategoryDao;
import ua.com.project.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryRepository implements CategoryDao {

    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Category obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(obj);

        // SQL

        // HQL

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Category obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(obj);

        // SQL
        // HQL

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Category obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // SQl
        entityManager
                .createNativeQuery("delete from `category` as c where c.id=?")
                .setParameter(1,obj.getId())
                .executeUpdate();

        // HQL
        entityManager.createQuery("delete from Category as c where c.id=:id")
                        .setParameter("id", obj.getId())
                        .executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // SQl
        entityManager
                .createNativeQuery("delete from `category`")
                .executeUpdate();

        // HQL
        entityManager.createQuery("delete from Category")
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Category> findAll() {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // sql
        List<Category> categories = entityManager.createNativeQuery("select * from `category`").getResultList();

        // hql
        List<Category> categories1 = entityManager.createQuery("select c from Category as c", Category.class).getResultList();


        entityManager.getTransaction().commit();
        entityManager.close();
        return categories;
    }

    @Override
    public Category findById(Long id) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

            // hql
        Category category = entityManager
                .createQuery("select c from Category as c where  c.id=:id", Category.class)
                .setParameter("id", id).getSingleResult();
                //.getResultList().get(0);


        entityManager.getTransaction().commit();
        entityManager.close();
        return category;
    }

    @Override
    public Category findByName(String name) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Category category = entityManager
                .createQuery("select c from Category as c where  c.name=:name", Category.class)
                .setParameter("name", name)
                .getSingleResult();


        entityManager.getTransaction().commit();
        entityManager.close();
        return category;
    }
}
