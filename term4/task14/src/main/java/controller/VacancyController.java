package controller;

import model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;
import service.SearchService;


@Controller
public class VacancyController {
    private CompanyService service;
    private SearchService searchService;

    @Autowired
    public VacancyController(CompanyService service, SearchService searchService) {
        this.service = service;
        this.searchService=searchService;
    }


    @RequestMapping("/vacancy/{id}")
    public ModelAndView getVacancy(@PathVariable Long id) {
        return new ModelAndView("vacancy", "vacancy", service.getVacancyById(id));
    }

    @RequestMapping("/vacancy/list")
    public ModelAndView getVacancy() {
        ModelAndView mv = new ModelAndView("vacancy_list");
        mv.addObject("vacancyList", service.getAllVacancies());
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/list/{id}")
    public ModelAndView getVacancyByCategory(Long categoryID) {
        ModelAndView mv = new ModelAndView("vacancy_list");
        mv.addObject("vacancyList", service.getVacancyListByCategoryId(categoryID));
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/edit/{id}")
    public ModelAndView editVacancy(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("vacancy_edit");
        mv.addObject("vacancy", service.getVacancyListByCategoryId(id));
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }

    @RequestMapping("/vacancy/create")
    public ModelAndView editVacancy() {
        ModelAndView mv = new ModelAndView("vacancy_edit");
        mv.addObject("vacancy", new Vacancy());
        mv.addObject("allCategories", searchService.getAllCategories());
        return mv;
    }
}
