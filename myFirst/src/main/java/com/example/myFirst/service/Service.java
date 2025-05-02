package com.example.myFirst.service;

import com.example.myFirst.entity.Employee;
import java.util.*;
public interface Service {

    public Employee savedata(Employee employee);
    public void deletedata(int id);
    public Employee getOne(int id);
    public List<Employee> getAll();
    public Employee updateData(Employee employee,int id);
}
