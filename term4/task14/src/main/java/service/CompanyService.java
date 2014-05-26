package service;

import model.Company;
import model.Vacancy;

public interface CompanyService {
    Vacancy getVacancyById(Long id);
    public Company getCompanyById (Long id);
    Vacancy getVacancyByIdWithCategories(Long id);

    Iterable<Vacancy> getAllVacancies();

    void saveVacancy(Vacancy v);

    Iterable<Vacancy> getVacancyListByCategoryId(Long categoryID);

}
