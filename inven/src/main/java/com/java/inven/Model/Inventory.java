

package com.java.inven.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer inventoryId;
    @Column(name="itemName")
    private String itemName;
    @Column(name="description")
    private String itemDescription;
    @Column(name="brand")
    private String itemBrand;
    @Column(name="manufacturedIn")
    private String manufacturedIn;
    @Column(name="price")
    private double itemPrice;
    @Column(name="expiryDate")
    private String expiryDate;

    public Inventory(Integer inventoryId, String itemName, String itemDescription, String itemBrand,
            String manufacturedIn, double itemPrice, String expiryDate) {
        this.inventoryId = inventoryId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemBrand = itemBrand;
        this.manufacturedIn = manufacturedIn;
        this.itemPrice = itemPrice;
        this.expiryDate = expiryDate;
    }
    
    // Getters and setters omitted for brevity
}
