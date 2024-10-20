package com.binde.Multilent.suppliers.controllers;

import com.binde.Multilent.suppliers.dto.SupplierDto;
import com.binde.Multilent.suppliers.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/suppliers")
@AllArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    @PostMapping()
    public ResponseEntity<SupplierDto> newSupplier(@RequestBody SupplierDto supplierDto){
        SupplierDto saveSupplier= supplierService.newSupplier(supplierDto);
    return new ResponseEntity<>(saveSupplier, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SupplierDto>>getAllSuppliers(){
        List<SupplierDto>suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto>getSupplierById(@PathVariable("id") UUID supplierId){
      SupplierDto supplierDto = supplierService.getSupplierById(supplierId);
      return ResponseEntity.ok(supplierDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto>updateSuppliers(@PathVariable("id") UUID supplierId,
                                                      @RequestBody SupplierDto supplierDto){
        SupplierDto supplier = supplierService.updateSuppliers(supplierId, supplierDto);
        return ResponseEntity.ok(supplier);
    }
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSupplier(@PathVariable("id") UUID supplierId){
     supplierService.deleteSupplier(supplierId);
     return ResponseEntity.ok("Supplier is deleted successfully !");
  }
}
