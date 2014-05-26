package service;

import model.Company;
import model.Vacancy;

public interface CompanyService {
    Vacancy getVacancyById(Long id);

    Company getCompanyById (Long id);

}
