package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.CustomerEntity;
import com.udacity.jdnd.course3.critter.entity.PetEntity;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public PetEntity savePet(PetEntity petEntity) {
       PetEntity returnPetEntity = petRepository.save(petEntity);
       CustomerEntity customerEntity = customerRepository.getOne(petEntity.getOwnerId());
       returnPetEntity.setCustomer(customerEntity);
       customerEntity.addPet(returnPetEntity);
       customerRepository.save(customerEntity);
       return returnPetEntity;
    }
    @Transactional
    public PetEntity getPetById(Long id){
        return petRepository.getOne(id);
    }
    @Transactional
    public List<PetEntity> getAllPet(){
        return petRepository.findAll();
    }
    @Transactional
    public List<PetEntity> getPetsByOwner(Long ownerId){
        return customerRepository.getOne(ownerId).getPets();
    }
}
