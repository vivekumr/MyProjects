package com.nit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.EmployeeModel;
import com.nit.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;
	@Override
	public Iterable<EmployeeModel> getAllEmployee() {
		return empRepo.findAll();
	}
	
	@Override
	public String saveEmployee(EmployeeModel emp) {
		return "Employee saved with id :: "+empRepo.save(emp).getEmpno();
	}

	@Override
	public EmployeeModel getEmpbyEno(Integer eno) {
		EmployeeModel employee = empRepo.findById(eno).orElseThrow(() ->new IllegalArgumentException());
		return employee;
	}

	@Override
	public String deleteEmpByEno(Integer eno) {
		empRepo.deleteById(eno);
		return eno+" employee ID deleted";
	}

}
