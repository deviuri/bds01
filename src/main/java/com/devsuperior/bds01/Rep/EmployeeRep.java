package com.devsuperior.bds01.Rep;

import com.devsuperior.bds01.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, Long> {
}
