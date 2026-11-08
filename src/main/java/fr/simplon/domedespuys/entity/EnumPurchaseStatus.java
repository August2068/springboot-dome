package fr.simplon.domedespuys.entity;

import lombok.Getter;

@Getter
public enum EnumPurchaseStatus {
    PENDING("pending"),
    PAID("paid"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("cancelled");

    EnumPurchaseStatus(String value) {
        this.value = value;
    }

    private final String value;
}
