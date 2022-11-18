package com.cybage.swaggerImpl1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.swaggerImpl1.exception.ResourceNotFoundException;
import com.cybage.swaggerImpl1.model.Employee;
import com.cybage.swaggerImpl1.repository.EmployeeRepository;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		}
    @PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
    
    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById (@PathVariable long id){
    	Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:"+id));
    	return ResponseEntity.ok(employee);
    	 }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id ,@RequestBody Employee  employeeDetails){
    	Employee updateemployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" +id));
    	updateemployee.setFirstName(employeeDetails.getFirstName());
    	updateemployee.setLastName(employeeDetails.getLastName());
    	updateemployee.setEmail(updateemployee.getEmail());
    	
    	employeeRepository.save(updateemployee);
    	return ResponseEntity.ok(updateemployee);
    	 }
    
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
    	Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exis by id" + id));
    	
    	employeeRepository.delete(employee);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
