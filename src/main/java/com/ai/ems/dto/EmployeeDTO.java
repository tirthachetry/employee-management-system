package com.ai.ems.dto;

import java.util.List;
public record EmployeeDTO(Long id, String name, List<DependentDTO> dependents) {
}
