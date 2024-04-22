package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.EmployeeEntity;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Transactional
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }
    @Transactional
    public EmployeeEntity getEmployeeById(Long employeeId) {
        return employeeRepository.getOne(employeeId);
    }
    @Transactional
    public void setAvailability(Set<DayOfWeek> daysAvailable, Long employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(employeeId);
        employeeEntity.setDaysAvailable(daysAvailable);
    }
    @Transactional
    public List<EmployeeEntity> findEmployeesForService(Set<EmployeeSkill> skills, LocalDate date) {
        List<EmployeeEntity> employeeEntityList = this.employeeRepository.findAll();
        return employeeEntityList.stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .filter(employee -> employee.getDaysAvailable().contains(date.getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
