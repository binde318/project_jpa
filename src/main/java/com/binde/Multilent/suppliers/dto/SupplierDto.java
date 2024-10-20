package com.binde.Multilent.suppliers.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    private UUID id;
    private String organization;
    private String name;
    private double defaultMarkup;
    private String description;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactPhone;
    private String contactAddress;
    private String contactWebsite;
    private String contactInstagram;
    private String contactTwitter;
    private String addressCity;
    public SupplierDto(UUID id, String name, double defaultMarkup, String description, String contactFirstName, String contactLastName, String contactEmail, String contactPhone, String contactAddress, String contactWebsite, String contactInstagram, String contactTwitter, String addressCity) {
    }
}
