package controller;

import controller.editor.CategoryEditor;
import model.Category;
import model.Company;
import model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CompanyService;
import service.SearchService;
import viewobject.VacancyVO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VacancyController {

    CompanyService companyService;
    SearchService searchService;

    @Autowired
    public VacancyController(CompanyService companyService, SearchService searchService) {
        this.companyService = companyService;
        this.searchService = searchService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor());
    }

    @RequestMapping("/vacancy/{id}")
    public ModelAndView getVacancy(@PathVariable Long id) {
        return new ModelAndView("vacancy_page", "vacancy", companyService.getVacancyById(id));

    }

    @RequestMapping("/vacancy/list")
    public ModelAndView getVacancy() {
        ModelAndView modelAndView = new ModelAndView("vacancy_list");
        modelAndView.addObject("vacancyList", companyService.getAllVacancies());
        modelAndView.addObject("category", 0);
        modelAndView.addObject("allCategories", searchService.getAllCategories());
        return modelAndView;
    }

    @RequestMapping("/vacancy/list/{categoryId}")
    public ModelAndView getVacancyByCategory(@PathVariable Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("vacancy_list");
        modelAndView.addObject("vacancyList", companyService.getVacancyByCategoryId(categoryId));
        modelAndView.addObject("category", categoryId);
        modelAndView.addObject("allCategories", searchService.getAllCategories());
        return modelAndView;
    }

    @RequestMapping("/vacancy/edit/{id}")
    public ModelAndView editVacancy(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("vacancy_edit");
        modelAndView.addObject("vacancy", companyService.getVacancyByIdWithCategories(id));
        modelAndView.addObject("allCategories", searchService.getAllCategories());
        return modelAndView;
    }

    @RequestMapping(value = "/vacancy/save", method = RequestMethod.POST)
    public String saveVacancy(@ModelAttribute Vacancy vacancy) {
        vacancy.setCompany(new Company(1L));
        companyService.saveVacancy(vacancy);
        return "redirect:/vacancy/list";
    }

    @RequestMapping("/vacancy/create")
    public ModelAndView editVacancy() {
        ModelAndView modelAndView = new ModelAndView("vacancy_edit");
        modelAndView.addObject("vacancy", new Vacancy());
        modelAndView.addObject("allCategories", searchService.getAllCategories());
        return modelAndView;
    }

    @RequestMapping("/vacancy/search")
    public
    @ResponseBody
    List<VacancyVO> getVacancies(@RequestParam String term) {
        Iterable<Vacancy> vacancies = companyService.getVacancyByNamePart(term);
        List<VacancyVO> result = new ArrayList<VacancyVO>();
        for (Vacancy vacancy : vacancies) {
            result.add(new VacancyVO(vacancy.getId(), vacancy.getTitle()));
        }
        return result;
    }

    @RequestMapping ("/vacancy/delete/{id}")
    public String deleteVacancy (@PathVariable Long id){
        companyService.deleteVacancy(id);
        return "redirect:/vacancy/list";
    }
}
