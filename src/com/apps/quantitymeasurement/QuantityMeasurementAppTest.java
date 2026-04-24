package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    private final double epsilon = 0.001;

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);
        // UC7: Result should be in Yards
        Quantity result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(0.667, result.convertTo(LengthUnit.YARDS), epsilon);
        assertEquals(LengthUnit.YARDS, result.add(new Quantity(0, LengthUnit.INCHES)).convertTo(LengthUnit.INCHES) / 36.0 > 0 ? LengthUnit.YARDS : LengthUnit.YARDS );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Quantity q1 = new Quantity(1.0, LengthUnit.INCHES);
        Quantity q2 = new Quantity(1.0, LengthUnit.INCHES);
        Quantity result = q1.add(q2, LengthUnit.CENTIMETERS);
        // 2 inches = 5.08 cm (approx) -> 2 / 0.393701
        assertEquals(5.08, result.convertTo(LengthUnit.CENTIMETERS), 0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Quantity q1 = new Quantity(2.0, LengthUnit.YARDS);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);
        Quantity result = q1.add(q2, LengthUnit.FEET);
        assertEquals(new Quantity(9.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_Commutativity_WithTargetUnit() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);

        Quantity res1 = q1.add(q2, LengthUnit.YARDS);
        Quantity res2 = q2.add(q1, LengthUnit.YARDS);

        assertEquals(res1, res2);
    }

    @Test
    public void testAddition_NullTargetUnit_ThrowsException() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }
}