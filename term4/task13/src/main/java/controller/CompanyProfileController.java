package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;

@Controller
public class CompanyProfileController {

    private CompanyService service;

    @Autowired
    public CompanyProfileController(CompanyService service) {
        this.service = service;
    }


    @RequestMapping("/company/{id}")
    public ModelAndView getCV(@PathVariable Long id) {
        return new ModelAndView("company_profile", "company", service.getCompanyById(id));
    }
}
