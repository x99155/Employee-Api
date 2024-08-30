package com.process.ems.controller;

import com.process.ems.dto.EmployeeDTO;
import com.process.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // all the clients can call this api
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/employees/{id}")
    EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        return employeeService.updateEmployee(employeeDTO, id);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
