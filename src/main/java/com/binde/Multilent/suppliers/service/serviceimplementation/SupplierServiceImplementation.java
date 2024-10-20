package com.binde.Multilent.suppliers.service.serviceimplementation;

import com.binde.Multilent.suppliers.dto.SupplierDto;
import com.binde.Multilent.suppliers.entities.Supplier;
import com.binde.Multilent.suppliers.exception.ResourceNoTFoundException;
import com.binde.Multilent.suppliers.mapper.SupplierMapper;
import com.binde.Multilent.suppliers.repository.SupplierRepository;
import com.binde.Multilent.suppliers.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierServiceImplementation implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    @Transactional
    public SupplierDto newSupplier(SupplierDto supplierDto) {
        if (supplierDto == null) {
            throw new ResourceNoTFoundException("SupplierDto cannot be null");
        }

        try {
            Supplier supplier = SupplierMapper.mapToSupplier(supplierDto);
            Supplier savedSupplier = supplierRepository.save(supplier);
            System.out.println(savedSupplier);
            return SupplierMapper.mapToSupplierDto(savedSupplier);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save the supplier", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDto> getAllSuppliers() {
        List<Supplier>suppliers = supplierRepository.findAll();
        return  suppliers.stream()
                .map(SupplierMapper::mapToSupplierDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SupplierDto updateSuppliers(UUID id, SupplierDto supplierDto) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new ResourceNoTFoundException("Supplier with is Not Found " + id));
        //supplier.setId(supplierDto.getId());
        supplier.setOrganization(supplierDto.getOrganization());
        supplier.setName(supplierDto.getName());
        supplier.setDefaultMarkup(supplierDto.getDefaultMarkup());
        supplier.setDescription(supplierDto.getDescription());
        supplier.setContactFirstName(supplierDto.getContactFirstName());
        supplier.setContactLastName(supplierDto.getContactLastName());
        supplier.setContactEmail(supplierDto.getContactEmail());
        supplier.setContactAddress(supplierDto.getContactAddress());
        supplier.setContactPhone(supplierDto.getContactPhone());
        supplier.setContactWebsite(supplierDto.getContactWebsite());
        supplier.setContactInstagram(supplierDto.getContactInstagram());
        supplier.setContactTwitter(supplierDto.getContactTwitter());
        supplier.setAddressCity(supplierDto.getAddressCity());

        Supplier updateSupplier = supplierRepository.save(supplier);
        return SupplierMapper.mapToSupplierDto(updateSupplier);
    }

    @Override
    @Transactional
    public void deleteSupplier(UUID id) {
     Supplier supplier = supplierRepository.findById(id)
             .orElseThrow(()-> new ResourceNoTFoundException(" Supplier with the ID" +id+ "is not found"));
     supplierRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierDto getSupplierById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Supplier ID cannot be null.");
        }
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNoTFoundException("Supplier with ID " + id + " not found."));
        return SupplierMapper.mapToSupplierDto(supplier);
    }
}
