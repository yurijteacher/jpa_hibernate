package ua.com.project;


import org.junit.Test;
import ua.com.project.config.Factory;
import ua.com.project.dao.CategoryDao;
import ua.com.project.entity.Category;

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
    categoryDao.delete(category3);
    assertEquals(0, categoryDao.findAll().size());



}
}
