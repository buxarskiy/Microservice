package uz.pdp.customer.mapper;

import org.mapstruct.*;
import uz.pdp.customer.dto.CustomerDTO;
import uz.pdp.customer.entity.Customer;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toEntity(CustomerDTO customerDTO);

    CustomerDTO toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDTO customerDTO, @MappingTarget Customer customer);
}