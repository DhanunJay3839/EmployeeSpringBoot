package com.example.myFirst.service;

import com.example.myFirst.entity.Employee;
import com.example.myFirst.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired public EmpRepo repo;
    @Override
    public Employee savedata(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void deletedata(int id) {
        repo.deleteById(id);

    }

    @Override
    public Employee getOne(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Employee updateData(Employee employee, int id) {
        return repo.save(employee);
    }
}
