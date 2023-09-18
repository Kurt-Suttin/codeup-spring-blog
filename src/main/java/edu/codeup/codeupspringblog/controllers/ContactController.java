package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Contact;
import edu.codeup.codeupspringblog.repository.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {

//    Constructor Dependency Injection
    private ContactRepository contactDao;

    public ContactController(ContactRepository contactDao) {
        this.contactDao = contactDao;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> returnContacts(){
        return contactDao.findAll();
    }

    @GetMapping("/contacts/view")
    public String returnContacts(Model model){
        model.addAttribute("contacts",contactDao.findAll());
        return "contacts/index";
    }


}
