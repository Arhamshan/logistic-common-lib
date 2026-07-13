package com.logistic.common.enums;


public enum ItemStatus {
    BOOKED("Shipment Booked"),
    PICKED_UP("Picked Up"),
    IN_TRANSIT("In Transit"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    ON_HOLD("On Hold"),
    CANCELLED("Cancelled");

    private final String description;

    ItemStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
