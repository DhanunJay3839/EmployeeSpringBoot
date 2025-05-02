package com.example.myFirst.controller;


import com.example.myFirst.entity.Employee;
import com.example.myFirst.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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




}
