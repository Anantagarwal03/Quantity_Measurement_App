package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Quantity;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);
        assertEquals(new Quantity(3.0, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);
        // Result should be in Feet (unit of the first operand)
        assertEquals(new Quantity(2.0, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() {
        Quantity q1 = new Quantity(12.0, LengthUnit.INCHES);
        Quantity q2 = new Quantity(1.0, LengthUnit.FEET);
        // Result should be in Inches (unit of the first operand)
        assertEquals(new Quantity(24.0, LengthUnit.INCHES), q1.add(q2));
    }

    @Test
    public void testAddition_YardPlusFeet() {
        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        assertEquals(new Quantity(2.0, LengthUnit.YARDS), yard.add(feet));
    }

    @Test
    public void testAddition_WithZeroValue() {
        Quantity q1 = new Quantity(5.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(0.0, LengthUnit.INCHES);
        assertEquals(new Quantity(5.0, LengthUnit.FEET), q1.add(q2));
    }

    @Test
    public void testAddition_Commutativity() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);

        // Note: Comparing equality of values, not necessarily units
        assertEquals(q1.add(q2).convertTo(LengthUnit.INCHES),
                q2.add(q1).convertTo(LengthUnit.INCHES));
    }

    @Test
    public void testAddition_NullOperand_ThrowsException() {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}