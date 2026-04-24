package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        assertEquals(new Quantity(1.0, LengthUnit.YARDS), new Quantity(1.0, LengthUnit.YARDS));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        // 1 Yard = 3 Feet
        assertEquals(new Quantity(1.0, LengthUnit.YARDS), new Quantity(3.0, LengthUnit.FEET));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        // 1 Yard = 36 Inches
        assertEquals(new Quantity(1.0, LengthUnit.YARDS), new Quantity(36.0, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        // 1 CM = 0.393701 Inches
        assertEquals(new Quantity(1.0, LengthUnit.CENTIMETERS), new Quantity(0.393701, LengthUnit.INCHES));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        Quantity inches = new Quantity(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches); // Transitive
    }

    @Test
    public void testEquality_DifferentValues_ShouldNotBeEqual() {
        assertNotEquals(new Quantity(1.0, LengthUnit.YARDS), new Quantity(2.0, LengthUnit.FEET));
        assertNotEquals(new Quantity(1.0, LengthUnit.CENTIMETERS), new Quantity(1.0, LengthUnit.INCHES));
    }
}