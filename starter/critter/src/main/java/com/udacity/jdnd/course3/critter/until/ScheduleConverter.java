package com.udacity.jdnd.course3.critter.until;

import com.udacity.jdnd.course3.critter.entity.ScheduleEntity;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import org.springframework.beans.BeanUtils;

public class ScheduleConverter {
    public static ScheduleDTO convertToDTO(ScheduleEntity scheduleEntity) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(scheduleEntity, scheduleDTO);
        return scheduleDTO;
    }
    public static ScheduleEntity convertToEntity(ScheduleDTO scheduleDTO) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        BeanUtils.copyProperties(scheduleDTO, scheduleEntity);
        scheduleEntity.setId(scheduleDTO.getId());
        return scheduleEntity;
    }
}
