package com.process.ems.service.impl;

import com.process.ems.dto.EmployeeDTO;
import com.process.ems.entity.Employee;
import com.process.ems.exception.ResourceNotFoundException;
import com.process.ems.mapper.EmployeeMapper;
import com.process.ems.repository.EmployeeRepository;
import com.process.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // convert employeedto to employee entity
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);

        // save employee
        Employee savedEmployee = employeeRepository.save(employee);

        // return employeedto
        return  EmployeeMapper.toEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::toEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return EmployeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long id) {
        // Raise exception if id don't exist
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        // update entity
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);

        return EmployeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employeeRepository.delete(employee);
    }
}
