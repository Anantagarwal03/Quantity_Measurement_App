package com.apps.quantitymeasurement;

public enum LengthUnit {
    YARDS(36.0),
    FEET(12.0),
    INCHES(1.0),
    CENTIMETERS(0.393701);

    public final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
}