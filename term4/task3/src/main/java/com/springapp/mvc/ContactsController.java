package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactsController {

    List<String> contactsNames = new ArrayList<>();
  //  List<String> contactsNumbers = new ArrayList<>();


   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView contasts() {
      return new ModelAndView("index", "command", new Contacts());
   }
   
   @RequestMapping(value = "/addContact", method = RequestMethod.POST)
   public String addContact(@ModelAttribute("SpringWeb")Contacts contacts,
   ModelMap model) {

      contactsNames.add(contacts.toString());
  //    contactsNumbers.add(contacts.getNumber());
      model.addAttribute("name", contactsNames);
  //    model.addAttribute("number", contactsNumbers);

      return "result";
   }
}