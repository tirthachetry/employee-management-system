package com.ai.ems.service;

import com.ai.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO dto);
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
    EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO dto);
    List<EmployeeDTO> findEmployeesByDependents(String dependentName, String relationship);

    void deleteEmployee(Long id);
}

