package com.logistic.common.enums;


public enum LocationType {
    PICKUP_POINT("Shipment Pickup Point"),
    WAREHOUSE("Inventory store Point"),
    HUB ("Intermediate Transfer Point"),
    DELIVERY_CENTER("Final Distribution Point");

    private final String description;

    LocationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
