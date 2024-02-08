package com.example.Employee.Mangement.System.Controller;

import com.example.Employee.Mangement.System.Model.Company;
import com.example.Employee.Mangement.System.Model.Employee;
import com.example.Employee.Mangement.System.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @PostMapping("/addEmployee/{id}")
    public String addEmployee( @PathVariable long id  ,@RequestBody Employee employee){
        companyService.saveEmployee(id,employee);
        return employee.toString();
    }

    @GetMapping("/home")
    public String homePage(){

        return "home";
    }

    @PostMapping("/createCompany")
    public String createNewCompany(@RequestBody Company newCompany){
           companyService.createCompany(newCompany);
           return newCompany.toString();
    }

    @GetMapping("/getEmployees")
    public String getAllEmployees(@RequestParam String name){
        return "s";
    }
    @GetMapping("/findCompany/{id}")
    public String company(@PathVariable long id){
        return companyService.findCompany(id).toString();
    }

}
