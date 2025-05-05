package com.example.myFirst.controller;


import com.example.myFirst.entity.Employee;
import com.example.myFirst.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    @Autowired private ServiceImpl servicee;


    @PostMapping("/save")
    public Employee saveProduct(@RequestBody Employee employee)
    {
        return servicee.savedata(employee);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        servicee.deletedata(id);
    }

    @GetMapping("/getOne/{id}")
    public Employee getOne(@PathVariable int id)
    {
        return servicee.getOne(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll()
    {
        return servicee.getAll();
    }

    @PutMapping("/update/{id}")
    public Employee updateProduct(@RequestBody Employee employee,@PathVariable int id)
    {
        return servicee.updateData(employee,id);

    }

    @PostMapping("/upload")
    public ResponseEntity<Employee> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("companyName") String companyName,
            @RequestParam("salary") int salary
    ) {
        try {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setCompanyName(companyName);
            employee.setSalary(salary);
            employee.setFileName(file.getOriginalFilename());
            employee.setFileType(file.getContentType());
            employee.setFileData(file.getBytes());

            Employee saved = servicee.savedata(employee);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }









}
