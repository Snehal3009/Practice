package com.csi.service;

import com.csi.dao.DaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl {

    @Autowired
    DaoImpl daoImpl;

    public Employee saveData(Employee employee){
        return daoImpl.saveData(employee);
    }

    public Optional<Employee> getaDataById(int empId){
        return daoImpl.getaDataById(empId);
    }

    public Employee updateData(Employee employee){
        return daoImpl.updateData(employee);
    }
    public List<Employee>getAllData(){
        return daoImpl.getAllData();
    }
    public void deleteAll(){
        daoImpl.deleteAll();
    }
}
