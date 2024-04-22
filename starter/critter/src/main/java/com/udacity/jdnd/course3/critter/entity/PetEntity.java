package com.udacity.jdnd.course3.critter.entity;

import com.udacity.jdnd.course3.critter.pet.PetType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PetType type;
    @Column(length = 50)
    private String name;

    private Long ownerId;
    @ManyToOne(fetch = FetchType.LAZY ,targetEntity = CustomerEntity.class, cascade = CascadeType.ALL)
    private CustomerEntity customer;
    private LocalDate birthDate;
    @Column(length = 500)
    private String notes;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = EmployeeEntity.class,cascade = CascadeType.ALL)
    private List<EmployeeEntity> takeCaredBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<EmployeeEntity> getTakeCaredBy() {
        return takeCaredBy;
    }

    public void setTakeCaredBy(List<EmployeeEntity> takeCaredBy) {
        this.takeCaredBy = takeCaredBy;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
