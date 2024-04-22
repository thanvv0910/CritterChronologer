package com.udacity.jdnd.course3.critter.until;

import com.udacity.jdnd.course3.critter.entity.CustomerEntity;

import com.udacity.jdnd.course3.critter.entity.PetEntity;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

public class CustomerConverter {
    public static CustomerDTO convertToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customerEntity, customerDTO);
//        customerDTO.setPetIds(
//                customerEntity.getPets()
//                        .stream().map(PetEntity::getId)
//                        .collect(Collectors.toList())
//        );
        return customerDTO;
    }
    public static CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customerEntity);
        customerEntity.setId(customerDTO.getId());

//        PetEntity petEntity = new PetEntity();
//        customerEntity.setPets(
//                customerDTO.getPetIds().stream().map(petId ->
//                        {
//                            petEntity.setId(petId);
//                            return petEntity;
//                        }
//                ).collect(Collectors.toList())
//        );
        return customerEntity;
    }
}
