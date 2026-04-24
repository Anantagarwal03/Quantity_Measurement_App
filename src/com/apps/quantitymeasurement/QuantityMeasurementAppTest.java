package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        assertEquals(new Feet(1.0), new Feet(1.0));
    }

    @Test
    public void testInchesEquality_SameValue() {
        assertEquals(new Inches(1.0), new Inches(1.0));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertNotEquals(new Inches(1.0), new Inches(2.0));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        assertFalse(new Inches(1.0).equals(null));
    }
}