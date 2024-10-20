package com.binde.Multilent.suppliers.service;

import com.binde.Multilent.suppliers.dto.SupplierDto;

import java.util.List;
import java.util.UUID;

public interface SupplierService {
    public SupplierDto newSupplier(SupplierDto supplierDto);
    public List<SupplierDto>getAllSuppliers();
    public SupplierDto updateSuppliers(UUID id, SupplierDto supplierDto);
    public void deleteSupplier(UUID id);
    public SupplierDto getSupplierById(UUID id);
}
