package com.apps.quantitymeasurement;

public enum LengthUnit {
    YARDS(36.0),         // 1 Yard = 3 Feet = 36 Inches
    FEET(12.0),          // 1 Foot = 12 Inches
    INCHES(1.0),         // Base Unit
    CENTIMETERS(0.393701); // 1 cm = 0.393701 Inches

    public final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
}