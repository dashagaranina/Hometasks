package com.springapp.mvc.dao;

import com.springapp.mvc.dao.Impl.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 25.02.14
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
public class Factory {

    private static UserDao userDao = null;
    private static CompanyDao companyDao = null;
    private static CVDao cvDao = null;
    private static VacancyDao vacancyDao = null;
    private static CategoryDao categoryDao = null;
    private static ResponseDao responseDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserDao getUserDao(){
        if (userDao == null){
            userDao = new UserDAOImpl();
        }
        return userDao;
    }

    public CompanyDao getCompanyDao(){
        if (companyDao == null){
            companyDao = new CompanyDaoImpl();
        }
        return companyDao;
    }

    public CVDao getCvDao(){
        if (cvDao == null){
            cvDao = new CVDaoImpl();
        }
        return cvDao;
    }

    public VacancyDao getVacancyDao(){
        if (vacancyDao == null){
            vacancyDao = new VacancyDaoImpl();
        }
        return vacancyDao;
    }

    public CategoryDao getCategoryDao(){
        if (categoryDao == null){
            categoryDao = new CategoryDaoImpl();
        }
        return categoryDao;
    }

    public ResponseDao getResponseDao(){
        if (responseDao == null){
            responseDao = new ResposeDaoImpl();
        }
        return responseDao;
    }
}
