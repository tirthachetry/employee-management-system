package com.ai.ems.factory;

import com.ai.ems.dto.DependentDTO;
import com.ai.ems.dto.EmployeeDTO;
import com.ai.ems.model.Dependent;
import com.ai.ems.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFactory {

    public static Employee createEmployeeFromDTO(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.name());

        List<Dependent> dependents = dto.dependents().stream().map(depDTO -> {
            Dependent dependent = new Dependent();
            dependent.setName(depDTO.name());
            dependent.setRelationship(depDTO.relationship());
            dependent.setEmployee(employee); // set reverse relationship
            return dependent;
        }).collect(Collectors.toList());

        employee.setDependents(dependents);
        return employee;
    }

    public static Dependent createDependentFromDTO(DependentDTO dep) {
        Dependent dependent = new Dependent();
        dependent.setName(dep.name());
        dependent.setRelationship(dep.relationship());
        return dependent;
    }
}

