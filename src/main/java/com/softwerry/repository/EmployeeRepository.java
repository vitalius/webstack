package com.softwerry.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softwerry.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {}