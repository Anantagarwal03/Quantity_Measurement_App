package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    private final double epsilon = 0.0001;

    @Test
    public void testConversion_FeetToInches() {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        assertEquals(12.0, feet.convertTo(LengthUnit.INCHES), epsilon);
    }

    @Test
    public void testConversion_YardsToFeet() {
        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        assertEquals(3.0, yard.convertTo(LengthUnit.FEET), epsilon);
    }

    @Test
    public void testConversion_InchesToYards() {
        Quantity inches = new Quantity(36.0, LengthUnit.INCHES);
        assertEquals(1.0, inches.convertTo(LengthUnit.YARDS), epsilon);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        Quantity cm = new Quantity(1.0, LengthUnit.CENTIMETERS);
        assertEquals(0.393701, cm.convertTo(LengthUnit.INCHES), epsilon);
    }

    @Test
    public void testConversion_ZeroValue() {
        Quantity zeroFeet = new Quantity(0.0, LengthUnit.FEET);
        assertEquals(0.0, zeroFeet.convertTo(LengthUnit.INCHES), epsilon);
    }

    @Test
    public void testConversion_NegativeValue() {
        Quantity negFeet = new Quantity(-1.0, LengthUnit.FEET);
        assertEquals(-12.0, negFeet.convertTo(LengthUnit.INCHES), epsilon);
    }

    @Test
    public void testConversion_SameUnit() {
        Quantity feet = new Quantity(5.0, LengthUnit.FEET);
        assertEquals(5.0, feet.convertTo(LengthUnit.FEET), epsilon);
    }

    @Test
    public void testConversion_InvalidValue_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity(Double.NaN, LengthUnit.FEET));
    }
}