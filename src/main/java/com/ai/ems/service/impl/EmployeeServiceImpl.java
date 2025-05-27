package com.ai.ems.service.impl;

import com.ai.ems.dto.DependentDTO;
import com.ai.ems.dto.EmployeeDTO;
import com.ai.ems.factory.EmployeeFactory;
import com.ai.ems.exception.EmployeeNotFoundException;
import com.ai.ems.model.Dependent;
import com.ai.ems.model.Employee;
import com.ai.ems.repository.EmployeeRepository;
import com.ai.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee employee = EmployeeFactory.createEmployeeFromDTO(dto);
        return mapToDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        return mapToDTO(employee);
    }

    private EmployeeDTO mapToDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getDependents().stream().map(
                dep -> new DependentDTO(dep.getName(), dep.getRelationship())
        ).collect(Collectors.toList()));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        existingEmployee.setName(dto.name());

        // Update the dependents collection
        if (dto.dependents() != null) {
            existingEmployee.getDependents().clear(); // Clear the existing collection
            dto.dependents().forEach(depDTO -> {
                Dependent dependent = EmployeeFactory.createDependentFromDTO(depDTO);
                dependent.setEmployee(existingEmployee); // Set the owning side
                existingEmployee.getDependents().add(dependent); // Add the new dependent
            });
        }

        return mapToDTO(employeeRepository.save(existingEmployee));
    }

    @Override
    public EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO dto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        if (dto.name() != null) {
            existingEmployee.setName(dto.name());
        }
        if (dto.dependents() != null) {
            existingEmployee.setDependents(dto.dependents().stream()
                    .map(EmployeeFactory::createDependentFromDTO)
                    .collect(Collectors.toList()));
        }

        return mapToDTO(employeeRepository.save(existingEmployee));
    }

    @Override
    public List<EmployeeDTO> findEmployeesByDependents(String dependentName, String relationship) {
        return employeeRepository.findByDependentsNameAndDependentsRelationship(dependentName, relationship).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}

