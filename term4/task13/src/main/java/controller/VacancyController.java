package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;

/**
 * Created with IntelliJ IDEA.
 * User: Dasha
 * Date: 31.03.14
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class VacancyController {
    private CompanyService service;

    @Autowired
    public VacancyController(CompanyService service) {
        this.service = service;
    }


    @RequestMapping("/vacancy/{id}")
    public ModelAndView getCV(@PathVariable Long id) {
        return new ModelAndView("vacancy", "vacancy", service.getVacancyById(id));
    }
}
