package com.udacity.jdnd.course3.critter.until;

import com.udacity.jdnd.course3.critter.entity.CustomerEntity;
import com.udacity.jdnd.course3.critter.entity.PetEntity;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import org.springframework.beans.BeanUtils;

public class PetConverter {
    public static PetDTO convertToDTO(PetEntity petEntity) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(petEntity, petDTO);
//        petDTO.setOwnerId(petEntity.getCustomer().getId());
        return petDTO;
    }
    public static PetEntity convertToEntity(PetDTO petDTO) {
        PetEntity petEntity = new PetEntity();
        BeanUtils.copyProperties(petDTO, petEntity);
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setId(petDTO.getOwnerId());
//        petEntity.setCustomer(customerEntity);
        petEntity.setId(null);
        return petEntity;
    }
}
