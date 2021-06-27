package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Todo;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository repo;
	
	public List<Todo> listAll() {
        return repo.findAll();
    }
     
    public void save(Todo std) {
        repo.save(std);
    }
     
    public Todo get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
	
}
