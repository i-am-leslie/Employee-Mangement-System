package com.example.Employee.Mangement.System.Service;

import com.example.Employee.Mangement.System.Model.Company;
import com.example.Employee.Mangement.System.Model.Employee;
import com.example.Employee.Mangement.System.Repositories.CompanyRepo;
import com.example.Employee.Mangement.System.Repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public String saveEmployee(long id,Employee newEmployee){
        Optional<Company> c=companyRepo.findById(id);
        Company foundCompany=c.get();// need to add a check method dor thi
        newEmployee.setCompany(foundCompany);
        String addOrNot=foundCompany.addEmployee(newEmployee);
        companyRepo.save(foundCompany);
        return addOrNot;
    }
    public  void createCompany(Company c){
        Company newCompany=new Company();
        newCompany.setName(c.getName());
        companyRepo.save(newCompany);
        System.out.print(companyRepo.findAll());
    }
    public  Set<Company> findAllCompany(){
        Iterable<Company> listOfCompanies=companyRepo.findAll();
        return StreamSupport.stream(listOfCompanies.spliterator(), false)
                .collect(Collectors.toSet());
    }
    public  Company findCompany(Long id){
        Set<Company> companies=findAllCompany();
        for(Company c : companies){
           if (Objects.equals(c.getId(), id)){
               return c;
           }
        }
        return null;
    }
    public List<Employee> findAllEmployees(Long id){
          Company c = findCompany(id);
          Long companyId=c.getId();
          employeeRepo.findById(companyId);
          return null;
    }






}
