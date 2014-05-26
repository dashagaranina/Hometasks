package service.impl;

import model.Company;
import model.Vacancy;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CompanyRepository;
import repository.VacancyRepository;
import service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;
    private VacancyRepository vacancyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, VacancyRepository vacancyRepository) {
        this.companyRepository = companyRepository;
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy getVacancyById(Long id) {
        return vacancyRepository.findOne(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Iterable<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    @Override
    public Iterable<Vacancy> getVacancyByCategoryId(Long id) {
        return  vacancyRepository.findByCategory(id);
    }

    @Override
    public Vacancy getVacancyByIdWithCategories(Long id) {
        Vacancy vacancy = vacancyRepository.findOne(id);
        Hibernate.initialize(vacancy.getCategory());
        return vacancy;
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public Iterable<Vacancy> getVacancyByNamePart(String term) {
        return vacancyRepository.findByTitleStartingWithIgnoreCase(term);
    }

    @Override
    public void deleteVacancy(Long id) {
        vacancyRepository.delete(id);
    }

    @Override
    public Company loadUserByUsername(String username) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
/*    @Override
    public Company loadUserByUsername(final String username) throws UsernameNotFoundException {
        Company company = companyRepository.findByUsername(username);
        Role r = new Role();
        r.setName("COMPANY");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        company.setAuthorities(roles);
        return company;
    }*/


}
