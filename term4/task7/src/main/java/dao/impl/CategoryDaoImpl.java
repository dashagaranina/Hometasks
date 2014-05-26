package dao.impl;

import dao.CategoryDao;
import model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Company: Dasha
 * Date: 01.03.14
 * Time: 1:00
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category, Long> implements CategoryDao {
    @Autowired
    public CategoryDaoImpl (SessionFactory sessionFactory){
        super(Category.class, sessionFactory);
    }
}
