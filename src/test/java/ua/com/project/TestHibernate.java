package ua.com.project;


import org.junit.Test;
import ua.com.project.config.Factory;
import ua.com.project.dao.CategoryDao;
import ua.com.project.dao.ProductDao;
import ua.com.project.entity.Category;
import ua.com.project.entity.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class TestHibernate {

private Factory factory = Factory.getInstance();

@Test
public void Test1(){

    CategoryDao categoryDao = factory.getCategoryDao();

    Category category = new Category();
    // category.setId(1L);
    category.setName("car");
    category.setDescription("asd sa das sd");
    category.setImage("/images/car/");

    // save
    categoryDao.save(category);
    // findById
    Category category1 = categoryDao.findById(1L);

    // [1, 1] - true / [1,0] -

    assertEquals(1L, category1.getId().longValue());

    // findByName
    Category category2 = categoryDao.findByName("car");
    assertEquals(1L, category1.getId().longValue());


    // findAll
    List<Category> categoryList = categoryDao.findAll();
    assertEquals(1, categoryList.size());

    // update
    category1.setName("beer");
    categoryDao.update(category1);
    Category category3 = categoryDao.findByName("beer");
    assertEquals(1L, category3.getId().longValue());

    // deleteByObj
    // categoryDao.delete(category3);
    // assertEquals(0, categoryDao.findAll().size());

    //    Test ProductDao

    ProductDao productDao = factory.getProductDao();

    Product product = new Product();
    product.setName("beer1");
    product.setDescription("desc");
    product.setImage("/image");
    product.setCategories(category3);
    product.setPrice(new BigDecimal(10.5));

    productDao.save(product);

    List<Product> products = productDao.findAll();

    assertEquals(1,products.size());

    Product product1 = productDao.findById(1L);

    assertEquals("beer1", product1.getName());

    product1.setName("beer2");

    productDao.update(product1);

    Product product2 = productDao.findById(1L);
    assertEquals("beer2", product2.getName());

    Product product3 = productDao.findByName("beer2");

    assertEquals("beer2", product3.getName());

    productDao.delete(product3);
    assertEquals(0, productDao.findAll().size());
}
}
