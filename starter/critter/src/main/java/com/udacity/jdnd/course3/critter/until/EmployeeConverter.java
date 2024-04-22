package com.udacity.jdnd.course3.critter.until;

import com.udacity.jdnd.course3.critter.entity.EmployeeEntity;


import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import org.springframework.beans.BeanUtils;

public class EmployeeConverter {
    public static EmployeeDTO convertToDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeEntity, employeeDTO);
        return employeeDTO;
    }
    public static EmployeeEntity convertToEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeEntity.setId(employeeDTO.getId());
        return employeeEntity;
    }
}
