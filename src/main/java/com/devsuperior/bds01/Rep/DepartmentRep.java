package com.devsuperior.bds01.Rep;

import com.devsuperior.bds01.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRep extends JpaRepository<Department, Long> {
}
