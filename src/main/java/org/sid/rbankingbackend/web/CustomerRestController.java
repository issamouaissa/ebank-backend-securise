package org.sid.rbankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.rbankingbackend.dtos.CustomerDTO;
import org.sid.rbankingbackend.entities.Customer;
import org.sid.rbankingbackend.exceptions.CustomerNotFoundException;
import org.sid.rbankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j

public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customersId}")
    public CustomerDTO updateCustomer(@PathVariable Long customersId,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customersId);
        return bankAccountService.updateCustomer(customerDTO);
    }
@DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);

    }


}
