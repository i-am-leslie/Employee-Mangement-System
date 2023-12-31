package com.example.Employee.Mangement.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;



    @ManyToOne
    private  Company company;


    @Override
    public   String toString(){
        return getId()+" "+getFirstName()+" "+getLastName()+" "+getCompany();
    }


}
