package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 200, nullable = false)
    protected String title;

    @Column(length = 4000, nullable = true)
    protected String description;

    @Column(nullable = false)
    protected int quantity;

    @Column(name = "unit_price", nullable = false)
    protected Float unitPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
