package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public Optional<Employee> getaDataById(int empId){
    return employeeRepoImpl.findById(empId);
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }
    public List<Employee>getAllData(){
        return employeeRepoImpl.findAll();
    }
    public void deleteAll(){
        employeeRepoImpl.deleteAll();
    }
}
