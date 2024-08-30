package com.process.ems.service;

import com.process.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployee(Long id);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id);

    void deleteEmployee(Long id);
}
