package com.ai.ems.controller;

import com.ai.ems.dto.EmployeeDTO;
import com.ai.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@jakarta.validation.Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(employeeService.saveEmployee(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@NonNull @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@NonNull @PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@NonNull @PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(employeeService.partialUpdateEmployee(id, dto));
    }
    @GetMapping("/by-dependent")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDependent(
            @NonNull @RequestParam(required = false) String dependentName,
            @NonNull @RequestParam(required = false) String relationship) {
        return ResponseEntity.ok(employeeService.findEmployeesByDependents(dependentName, relationship));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@NonNull @PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(String.format("Delete Successfully for ID: %s",id));
    }
}

