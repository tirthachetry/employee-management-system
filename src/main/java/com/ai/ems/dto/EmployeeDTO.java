package com.ai.ems.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import java.util.List;
public record EmployeeDTO(Long id, @NonNull @NotBlank(message = "Name cannot be empty") String name, @Valid List<DependentDTO> dependents) {
}
