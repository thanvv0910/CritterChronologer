package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.entity.ScheduleEntity;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import com.udacity.jdnd.course3.critter.until.ScheduleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        ScheduleEntity scheduleEntity = scheduleService.createSchedule(ScheduleConverter.convertToEntity(scheduleDTO));
        return ScheduleConverter.convertToDTO(scheduleEntity);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleEntity> scheduleEntityList = scheduleService.getAllSchedules();
        return scheduleEntityList.stream().map(new Function<ScheduleEntity, ScheduleDTO>() {
            @Override
            public ScheduleDTO apply(ScheduleEntity scheduleEntity) {
                return ScheduleConverter.convertToDTO(scheduleEntity);
            }

            @Override
            public <V> Function<V, ScheduleDTO> compose(Function<? super V, ? extends ScheduleEntity> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<ScheduleEntity, V> andThen(Function<? super ScheduleDTO, ? extends V> after) {
                return Function.super.andThen(after);
            }
        }).collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
               return scheduleService.getScheduleByPetId(petId).stream().map(new Function<ScheduleEntity, ScheduleDTO>() {
                   @Override
                   public ScheduleDTO apply(ScheduleEntity scheduleEntity) {
                       return ScheduleConverter.convertToDTO(scheduleEntity);
                   }

                   @Override
                   public <V> Function<V, ScheduleDTO> compose(Function<? super V, ? extends ScheduleEntity> before) {
                       return Function.super.compose(before);
                   }

                   @Override
                   public <V> Function<ScheduleEntity, V> andThen(Function<? super ScheduleDTO, ? extends V> after) {
                       return Function.super.andThen(after);
                   }
               }).collect(Collectors.toList());

    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return scheduleService.getScheduleByEmployeeId(employeeId).stream().map(new Function<ScheduleEntity, ScheduleDTO>() {
            @Override
            public ScheduleDTO apply(ScheduleEntity scheduleEntity) {
                return ScheduleConverter.convertToDTO(scheduleEntity);
            }

            @Override
            public <V> Function<V, ScheduleDTO> compose(Function<? super V, ? extends ScheduleEntity> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<ScheduleEntity, V> andThen(Function<? super ScheduleDTO, ? extends V> after) {
                return Function.super.andThen(after);
            }
        }).collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return scheduleService.getScheduleByCustomerId(customerId).stream().map(new Function<ScheduleEntity, ScheduleDTO>() {
            @Override
            public ScheduleDTO apply(ScheduleEntity scheduleEntity) {
                return ScheduleConverter.convertToDTO(scheduleEntity);
            }

            @Override
            public <V> Function<V, ScheduleDTO> compose(Function<? super V, ? extends ScheduleEntity> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<ScheduleEntity, V> andThen(Function<? super ScheduleDTO, ? extends V> after) {
                return Function.super.andThen(after);
            }
        }).collect(Collectors.toList());
    }
}
