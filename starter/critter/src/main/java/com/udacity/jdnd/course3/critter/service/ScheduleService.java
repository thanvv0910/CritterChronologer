package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.CustomerEntity;
import com.udacity.jdnd.course3.critter.entity.EmployeeEntity;
import com.udacity.jdnd.course3.critter.entity.PetEntity;
import com.udacity.jdnd.course3.critter.entity.ScheduleEntity;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Transactional
    public ScheduleEntity createSchedule(ScheduleEntity scheduleEntity) {
        scheduleEntity.setEmployees(
                scheduleEntity.getEmployeeIds()
                        .stream().map(id -> employeeRepository.getOne(id))
                        .collect(Collectors.toList())
        );
        scheduleEntity.setPets(
                scheduleEntity.getPetIds()
                        .stream().map(id -> petRepository.getOne(id))
                        .collect(Collectors.toList())
        );
        return scheduleRepository.save(scheduleEntity);
    }

    @Transactional
    public List<ScheduleEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Transactional
    public List<ScheduleEntity> getScheduleByPetId(Long petId) {
        return scheduleRepository.findAll().stream().filter(scheduleEntity ->
                scheduleEntity.getPets()
                        .stream().map(PetEntity::getId)
                        .collect(Collectors.toList())
                        .contains(petId)
        ).collect(Collectors.toList());
    }
    @Transactional
    public List<ScheduleEntity> getScheduleByEmployeeId(Long employeeId) {
        return scheduleRepository.findAll().stream().filter(scheduleEntity ->
                scheduleEntity.getEmployees()
                        .stream().map(EmployeeEntity::getId)
                        .collect(Collectors.toList())
                        .contains(employeeId)
        ).collect(Collectors.toList());
    }
    @Transactional
    public List<ScheduleEntity> getScheduleByCustomerId(Long customerId) {
        CustomerEntity customerEntity = customerRepository.getOne(customerId);
        List<Long> petIdList = customerEntity.getPets().stream().map(PetEntity::getId).collect(Collectors.toList());
        List<ScheduleEntity> scheduleEntityList = new ArrayList<>();
        petIdList.forEach(petId ->
                scheduleEntityList.addAll(getScheduleByPetId(petId)));
        return scheduleEntityList;
    }
}
