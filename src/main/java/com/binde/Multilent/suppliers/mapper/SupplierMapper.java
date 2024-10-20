package com.binde.Multilent.suppliers.mapper;

import com.binde.Multilent.suppliers.dto.SupplierDto;
import com.binde.Multilent.suppliers.entities.Supplier;

public class SupplierMapper {
    public static SupplierDto mapToSupplierDto(Supplier supplier){
        return new SupplierDto(
                supplier.getId(),
                supplier.getName(),
                supplier.getDefaultMarkup(),
                supplier.getDescription(),
                supplier.getContactFirstName(),
                supplier.getContactLastName(),
                supplier.getContactEmail(),
                supplier.getContactPhone(),
                supplier.getContactAddress(),
                supplier.getContactWebsite(),
                supplier.getContactInstagram(),
                supplier.getContactTwitter(),
                supplier.getAddressCity()
        );
    }
//convert jpa entity to dto
public static Supplier mapToSupplier(SupplierDto supplierDto){
return new Supplier(
        supplierDto.getId(),
        supplierDto.getOrganization(),
        supplierDto.getName(),
        supplierDto.getDefaultMarkup(),
        supplierDto.getDescription(),
        supplierDto.getContactFirstName(),
        supplierDto.getContactLastName(),
        supplierDto.getContactEmail(),
        supplierDto.getContactPhone(),
        supplierDto.getContactAddress(),
        supplierDto.getContactWebsite(),
        supplierDto.getContactInstagram(),
        supplierDto.getContactTwitter(),
        supplierDto.getAddressCity()
);

    }
}
