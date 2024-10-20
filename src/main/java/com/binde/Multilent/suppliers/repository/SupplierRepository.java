package com.binde.Multilent.suppliers.repository;

import com.binde.Multilent.suppliers.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
