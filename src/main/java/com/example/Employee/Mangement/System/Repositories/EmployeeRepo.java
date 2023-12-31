package com.example.Employee.Mangement.System.Repositories;

import com.example.Employee.Mangement.System.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long>  {
}
