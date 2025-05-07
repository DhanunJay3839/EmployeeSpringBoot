package com.example.myFirst.controller;


import com.example.myFirst.entity.Employee;
import com.example.myFirst.service.ServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    @Autowired
    private ServiceImpl servicee;


    @PostMapping("/save")
    public Employee saveProduct(@Valid @RequestBody Employee employee) {
        return servicee.savedata(employee);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        servicee.deletedata(id);
    }

    @GetMapping("/getOne/{id}")
    public Employee getOne(@PathVariable int id) {
        return servicee.getOne(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return servicee.getAll();
    }

    @PutMapping("/update/{id}")
    public Employee updateProduct(@RequestBody Employee employee, @PathVariable int id) {
        return servicee.updateData(employee, id);

    }

    @PostMapping("/upload")
    public ResponseEntity<Employee> uploadfile(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("companyName") String companyName,
            @RequestParam("salary") int salary,
            @RequestParam("file") MultipartFile file
    )
    {
        try
        {
            Employee emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setCompanyName(companyName);
            emp.setSalary(salary);
            emp.setFileName(file.getOriginalFilename());
            emp.setFileType(file.getContentType());
            emp.setFileData(file.getBytes());

            Employee saved = servicee.savedata(emp);
            return ResponseEntity.ok(saved);

        }
        catch(Exception e)
        {
            return ResponseEntity.internalServerError().build();

        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable int id) {
        Employee emp = servicee.getOne(id);
        return ResponseEntity.ok()
                .body(emp.getFileData());
    }
}
