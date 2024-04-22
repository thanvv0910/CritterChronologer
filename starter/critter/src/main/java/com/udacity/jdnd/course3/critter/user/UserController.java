package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entity.CustomerEntity;
import com.udacity.jdnd.course3.critter.entity.EmployeeEntity;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import com.udacity.jdnd.course3.critter.until.CustomerConverter;
import com.udacity.jdnd.course3.critter.until.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return CustomerConverter.convertToDTO(
                customerService.saveCustomer(
                        CustomerConverter.convertToEntity(customerDTO)
                )
        );
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers().stream().map(new Function<CustomerEntity, CustomerDTO>() {
            @Override
            public CustomerDTO apply(CustomerEntity customerEntity) {
                return CustomerConverter.convertToDTO(customerEntity);
            }
        }).collect(Collectors.toList());
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {
        CustomerEntity customerEntity = customerService.getOwnerByPetId(petId);
        return CustomerConverter.convertToDTO(
                customerService.getOwnerByPetId(petId)
        );
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeService.saveEmployee(
                EmployeeConverter.convertToEntity(employeeDTO)
        );
        return EmployeeConverter.convertToDTO(employeeEntity);
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        return EmployeeConverter.convertToDTO(
                employeeService.getEmployeeById(employeeId)
        );
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.findEmployeesForService(employeeRequestDTO.getSkills(), employeeRequestDTO.getDate())
                .stream().map(EmployeeConverter::convertToDTO).collect(Collectors.toList());
    }

}
