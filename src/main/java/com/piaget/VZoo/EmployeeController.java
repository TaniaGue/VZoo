package com.piaget.VZoo;

import com.piaget.VZoo.entities.Employee;
import com.piaget.VZoo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;


    @GetMapping("/employeePage")
    public String attendants(Model model)
    {
        model.addAttribute("employeePage", new EmployeePage());
        return "employeePage";
    }

    @PostMapping("/employeePage")
    public String goToAnimals(Model model)
    {
        return "employeePage";
    }


    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }


    @GetMapping("/createEmployee")
    public String createEmployee(Employee employee) {
        return "addEmployee";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        employeeRepository.save(employee);
        model.addEmployee("attendants", employeeRepository.findAll());
        return "employeePage";
    }


}
