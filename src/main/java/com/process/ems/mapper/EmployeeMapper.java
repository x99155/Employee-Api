package com.process.ems.mapper;

import com.process.ems.dto.EmployeeDTO;
import com.process.ems.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeMapper {

    // Convert Employee -> EmployeeDTO | bdd -> client
    public static EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    // Convert EmployeeDTO -> Employee | client -> bdd
    public static Employee toEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}
