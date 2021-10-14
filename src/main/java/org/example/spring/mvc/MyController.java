package org.example.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "firstView";
    }

//    @RequestMapping("/ask-details")
//    public String askEmpDetails() {
//        return "ask-emp-details";
//    }

//    @RequestMapping("/show-details")
//    public String showEmpDetails() {
//        return "show-emp-details";
//    }

//    @RequestMapping("/show-details")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//
//        String empName = request.getParameter("empName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttr", empName);
//        model.addAttribute("description", " - pro Java programmer");
//
//        return "show-emp-details";
//    }

    @RequestMapping("/ask-details")
    public String askEmpDetails(Model model) {

//        Employee employee = new Employee();
//        employee.setName("Alex");
//        employee.setSurname("Shaf");
//        employee.setSalary(2000);
        model.addAttribute("employee", new Employee());

        return "ask-emp-details";
    }

    @GetMapping(path = "/show-details")
    public String showEmpDetails(
            @Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult
    ) {

//        System.out.println("surname length = " + emp.getSurname().length());

        if (bindingResult.hasErrors()) {
            return "ask-emp-details";
        } else {
            String name = emp.getName();
            emp.setName("Mr. " + name);
            String surname = emp.getSurname();
            emp.setSurname("Mr. " + surname);
            int salary = emp.getSalary();
            emp.setSalary(salary * 10);
            return "show-emp-details";
        }
    }
}
