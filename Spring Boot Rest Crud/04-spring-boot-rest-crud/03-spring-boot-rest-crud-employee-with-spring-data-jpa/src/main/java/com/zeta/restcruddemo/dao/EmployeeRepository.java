package com.zeta.restcruddemo.dao;

import com.zeta.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that`s it ... no need to write any code


}
