package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class EmployeeController {


    @Autowired
    ServiceImpl serviceImpl;

    

            @PostMapping("/savedata")
    public ResponseEntity<Employee>saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(serviceImpl.saveData(employee));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(serviceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee>updateData(@RequestBody Employee employee, @PathVariable int empId) throws RecordNotFoundException {
        Employee employee1=serviceImpl.getaDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id Does Not Exists"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContatctNumber(employee.getEmpContatctNumber());

        return ResponseEntity.ok(serviceImpl.updateData(employee1));
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData(){
        serviceImpl.deleteAll();
        return ResponseEntity.ok("Delete All Data Successfully");
    }
}
