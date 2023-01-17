package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.ProductDao;
import ua.com.project.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepository implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product obj) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // SQL
//        entityManager.createNativeQuery("INSERT INTO `product` (`description`, `image`, `name`, `price`, `category_id`) VALUES (?, ?, ?, ?, ?)")
//                .setParameter(1, obj.getDescription())
//                .setParameter(2, obj.getImage())
//                .setParameter(3, obj.getName())
//                .setParameter(4, obj.getPrice())
//                .setParameter(5, obj.getCategories())
//                .executeUpdate();

        // HQL ?
//        entityManager.createQuery("INSERT INTO Product (description, image, name, price, categories)" +
//                "VALUES (description=:desc, image=:image, price=:price, name=:name, categories=:category)")
//                .setParameter("name", obj.getName())
//                .setParameter("desc", obj.getDescription())
//                .setParameter("price", obj.getPrice())
//                .setParameter("category", obj.getCategories())
//                .setParameter("image", obj.getImage())
//                .executeUpdate();

        // Void
        entityManager.persist(obj);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void update(Product obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // sql
//        entityManager.createNativeQuery("update `product` set name=?, description=?, price=?, image=?, category_id=? where id=?")
//                .setParameter(1, obj.getName())
//                .setParameter(2, obj.getDescription())
//                .setParameter(3, obj.getPrice())
//                .setParameter(4, obj.getImage())
//                .setParameter(5, obj.getCategories())
//                .setParameter(6, obj.getId()).
//                executeUpdate();
        // hql
        entityManager.createQuery("update Product as p set p.name=:name, p.description=:desc, p.price=:price, p.image=:image, p.categories=:category where p.id=:id")
                .setParameter("name", obj.getName())
                .setParameter("desc", obj.getDescription())
                .setParameter("price", obj.getPrice())
                .setParameter("category", obj.getCategories())
                .setParameter("image", obj.getImage())
                .setParameter("id", obj.getId()).
                executeUpdate();
        // void
        //entityManager.merge(obj);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void delete(Product obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();


        // HQL
        entityManager.createQuery("delete from Product as p where p.id=:id")
                .setParameter("id", obj.getId())
                .executeUpdate();
        // SQL

//        entityManager.createNativeQuery("delete from `product` where id=?")
//                .setParameter(1, obj)
//                .executeUpdate();

        // entityManager.remove(obj);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();


        // HQL
        entityManager.createQuery("delete from Product as p")
                .executeUpdate();
        // SQL

//        entityManager.createNativeQuery("delete from `product`")
//                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Product> findAll() {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();


        // HQL
        List<Product> products = entityManager.createQuery("from Product", Product.class).getResultList();
        // SQL
        // List<Product> products1 = entityManager.createNativeQuery("select * from `product`").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return products;
    }

    @Override
    public Product findById(Long id) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();


        // HQL
        Product products = entityManager.createQuery("select p from Product as p where  p.id=:id", Product.class)
                .setParameter("id", id)
                .getResultList().get(0);
        // SQL ?
        // Product products1 = (Product) entityManager.createNativeQuery("select * from `product` where id=?")
        //                .setParameter(1, id).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return products;
    }

    @Override
    public Product findByName(String name) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();


        // HQL
        Product products = entityManager.createQuery("select p from Product as p where  p.name=:name", Product.class)
                .setParameter("name", name)
                .getResultList().get(0);
        // SQL ?
        // Product products1 = (Product) entityManager.createNativeQuery("select * from `product` where name=?")
        //                .setParameter(1, name).getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return products;
    }
}
