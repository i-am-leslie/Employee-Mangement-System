package com.example.Employee.Mangement.System.Service;

import com.example.Employee.Mangement.System.Repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
    @Autowired
    private CompanyRepo companyRepo;

    public EmployeeService(){

    }
}
