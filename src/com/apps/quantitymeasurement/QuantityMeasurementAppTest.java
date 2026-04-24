package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    // Test the new Enum Responsibilities
    @Test
    public void testLengthUnit_convertToBaseUnit() {
        assertEquals(36.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 0.001);
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(1.0), 0.001);
    }

    @Test
    public void testLengthUnit_convertFromBaseUnit() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(36.0), 0.001);
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 0.001);
    }

    // Verify Backward Compatibility (UC1-UC7)
    @Test
    public void testQuantityEquality_Refactored() {
        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        assertEquals(yard, feet);
    }

    @Test
    public void testQuantityAddition_Refactored() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);
        Quantity result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(0.667, result.convertTo(LengthUnit.YARDS), 0.001);
    }
}