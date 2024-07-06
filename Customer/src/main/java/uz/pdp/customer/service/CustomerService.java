package uz.pdp.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.customer.dto.CustomerDTO;
import uz.pdp.customer.entity.Customer;
import uz.pdp.customer.mapper.CustomerMapper;
import uz.pdp.customer.repo.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public HttpEntity<?> register(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }
}
