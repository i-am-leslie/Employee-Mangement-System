package com.example.Employee.Mangement.System.Controller;

import com.example.Employee.Mangement.System.Model.Company;
import com.example.Employee.Mangement.System.Model.Employee;
import com.example.Employee.Mangement.System.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;



    @PostMapping("/addEmployee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String addEmployeeToCompany( @PathVariable long id  ,@RequestBody Employee employee){
        return companyService.saveEmployee(id,employee);
    }

    @GetMapping("/home")
    public String homePage(){

        return "home";
    }

    @PostMapping("/createCompany")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createNewCompany(@RequestBody Company newCompany){
        try {
            companyService.createCompany(newCompany);
            return ResponseEntity.ok(newCompany.toString());
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating company: " + e.getMessage());
        }
    }

//    TODO: Fix errors  with this endpoint
    @GetMapping("/getEmployees/{id}")
    public Company getAllEmployees(@PathVariable Long id){
        return companyService.findCompany(id);
    }
    @GetMapping("/findCompany/{id}")
    public String company(@PathVariable long id){
        return companyService.findCompany(id).toString();
    }

}
