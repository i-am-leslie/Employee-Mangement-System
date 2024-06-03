package com.example.Employee.Mangement.System.Model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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


//    Make this a HashMap where the the key is the company and the employess are the values
//    When using data structures use proxy classes to help for lazy loading e.t.c like List,Set,Map
    @OneToMany(mappedBy = "company", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Employee> employees=new HashSet<>();


    public  String  addEmployee(Employee e){
        for(Employee s : employees ){
            if(s.getFirstName().equals(e.getFirstName()) && s.getLastName().equals(e.getLastName())){
                return "Employee already exists";
            }
        }
        employees.add(e);
        return  "Added"+ e.toString();
    }

//    public String viewEmployeesProfile(){
//        StringBuilder s=new StringBuilder();
//        for(Employee e : employees){
//            s.append(e.toString());
//            s.append("\n");
//        }
//        return s.toString();
//    }
    public void deleteEmployee(int id){

    }
    @Override
    public String toString(){
        return getId()+" "+getName();
    }


}
