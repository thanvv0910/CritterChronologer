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
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetRepository petRepository;

    @Transactional
    public CustomerEntity saveCustomer(CustomerEntity customerEntity){
        return customerRepository.save(customerEntity);
    }
    @Transactional
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Transactional
    public CustomerEntity getOwnerByPetId(Long petId){
        PetEntity petEntity = petRepository.getOne(petId);
        return customerRepository.getOne(petEntity.getOwnerId());
    }
}
