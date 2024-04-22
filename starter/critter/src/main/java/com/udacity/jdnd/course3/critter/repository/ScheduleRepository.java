package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
//    List<ScheduleEntity> findSchedulesByPetIds(Long petId);
//    List<ScheduleEntity> findSchedulesByEmployeeIds(Long employeeId);
//
//    List<ScheduleEntity> findByPetIdsIn(List<Long> listPetId);
}
