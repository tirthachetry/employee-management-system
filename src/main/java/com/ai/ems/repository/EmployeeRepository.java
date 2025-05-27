package com.ai.ems.repository;

import com.ai.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDependentsNameAndDependentsRelationship(@Param("dependentName") String dependentName, @Param("relationship") String relationship);
}
