package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.entity.PetEntity;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.until.PetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        PetEntity petEntity = petService.savePet(PetConverter.convertToEntity(petDTO));
        return PetConverter.convertToDTO(petEntity);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        PetEntity petEntity = petService.getPetById(petId);
        return PetConverter.convertToDTO(petEntity);
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<PetEntity> petEntityList = petService.getAllPet();
        return petEntityList.stream().map(new Function<PetEntity, PetDTO>() {
            @Override
            public PetDTO apply(PetEntity petEntity) {
                return PetConverter.convertToDTO(petEntity);
            }

            @Override
            public <V> Function<V, PetDTO> compose(Function<? super V, ? extends PetEntity> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<PetEntity, V> andThen(Function<? super PetDTO, ? extends V> after) {
                return Function.super.andThen(after);
            }
        }).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetEntity> petEntityList = petService.getPetsByOwner(ownerId);
        return petEntityList.stream().map(new Function<PetEntity, PetDTO>() {
            @Override
            public PetDTO apply(PetEntity petEntity) {
                return PetConverter.convertToDTO(petEntity);
            }

            @Override
            public <V> Function<V, PetDTO> compose(Function<? super V, ? extends PetEntity> before) {
                return Function.super.compose(before);
            }

            @Override
            public <V> Function<PetEntity, V> andThen(Function<? super PetDTO, ? extends V> after) {
                return Function.super.andThen(after);
            }
        }).collect(Collectors.toList());
    }
}
