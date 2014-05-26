package service;

import model.Company;
import model.Vacancy;

public interface CompanyService {
    Vacancy getVacancyById(Long id);
    Company getCompanyById (Long id);
    Iterable<Vacancy> getAllVacancies();
    Iterable<Vacancy> getVacancyByCategoryId(Long id);
    Vacancy getVacancyByIdWithCategories(Long id);
    void saveVacancy (Vacancy vacancy);
    Iterable<Vacancy> getVacancyByNamePart(String term);
    void deleteVacancy (Long id);
    Company loadUserByUsername(final String username);

}
