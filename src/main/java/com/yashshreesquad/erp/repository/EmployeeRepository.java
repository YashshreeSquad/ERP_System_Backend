package com.yashshreesquad.erp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yashshreesquad.erp.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Override
	List<Employee> findAll();

	@Override
	Optional<Employee> findById(Long id);

	@Override
	<S extends Employee> S save(S entity);
}
