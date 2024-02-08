package com.example.Employee.Mangement.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Employee> employees=new ArrayList<>();


    public  String addEmployee(Employee e){
        employees.add(e);
        return "Employee with id =" +" "+ e.toString();
    }

    public String viewEmployeesProfile(){
        StringBuilder s=new StringBuilder();
        for(Employee e : employees){
            s.append(e.toString());
            s.append("\n");
        }
        return s.toString();
    }
    public void deleteEmployee(int id){

    }
    @Override
    public String toString(){
        return getId()+" "+getName();
    }


}
