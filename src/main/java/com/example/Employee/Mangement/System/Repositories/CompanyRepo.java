package com.example.Employee.Mangement.System.Repositories;

import com.example.Employee.Mangement.System.Model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company,Long> {
}
