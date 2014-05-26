package controller.api;

import model.Company;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.CompanyRepository;
import viewobject.CompanyVO;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController {
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyRestController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<CompanyVO> find(@PathVariable Long id){
        Company company = companyRepository.findOne(id);
        if (company == null) {
            return new ResponseEntity<CompanyVO>(HttpStatus.NOT_FOUND);
        }
        CompanyVO result = new DozerBeanMapper().map(company, CompanyVO.class);
        return new ResponseEntity<CompanyVO>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyVO create(@RequestBody Company company){
        return new DozerBeanMapper().map(companyRepository.save(company), CompanyVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public CompanyVO update(@PathVariable Long id, @RequestBody Company company){
        return new DozerBeanMapper().map(companyRepository.save(company), CompanyVO.class);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        companyRepository.delete(id);
    }

}
