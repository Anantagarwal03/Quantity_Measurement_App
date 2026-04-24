package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertEquals(new Quantity(1.0, LengthUnit.FEET), new Quantity(1.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertEquals(new Quantity(1.0, LengthUnit.INCHES), new Quantity(1.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        // UC3 Requirement: 1 ft == 12 inches
        assertEquals(new Quantity(1.0, LengthUnit.FEET), new Quantity(12.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        // Symmetry check
        assertEquals(new Quantity(12.0, LengthUnit.INCHES), new Quantity(1.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_DifferentValue() {
        assertNotEquals(new Quantity(1.0, LengthUnit.FEET), new Quantity(2.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_NullComparison() {
        assertNotEquals(new Quantity(1.0, LengthUnit.FEET), null);
    }

    @Test
    public void testEquality_SameReference() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET);
        assertEquals(q, q);
    }
}