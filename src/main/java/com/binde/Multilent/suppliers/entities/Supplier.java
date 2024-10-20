package com.binde.Multilent.suppliers.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "organization")
    private String organization;
    @Column(name = "name")
    private String name;
    @Column(name = "deafult_markup")
    private double defaultMarkup;
    @Column(name = "description")
    private String description;
    @Column(name = "first_name")
    private String contactFirstName;
    @Column(name = "last_name")
    private String contactLastName;
    @Column(name = "email",unique = true)
    private String contactEmail;
    @Column(name = "phone_number")
    private String contactPhone;
    @Column(name = "conatc_address")
    private String contactAddress;
    @Column(name = "web_address")
    private String contactWebsite;
    @Column(name = "instagram_page")
    private String contactInstagram;
    @Column(name = "twitter_page")
    private String contactTwitter;
    @Column(name = "city_address")
    private String addressCity;

    public Supplier(String organization, String name, double defaultMarkup, String description, String contactFirstName, String contactLastName, String contactEmail, String contactPhone, String contactAddress, String contactWebsite, String contactInstagram, String contactTwitter, String addressCity) {
    }
}
