package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class NewController {
	
	@Autowired
	private EmployeeService service;
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> listemployee = service.getEmployees();
        model.addAttribute("listemployee", listemployee);
        System.out.print("Get / ");	
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("employee") Employee emp) {
        service.save(emp);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Employee emp = service.get(id);
        mav.addObject("employee", emp);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
	
}
