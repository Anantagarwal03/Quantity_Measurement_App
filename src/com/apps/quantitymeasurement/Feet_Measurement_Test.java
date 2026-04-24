package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Feet_Measurement_Test {

    @Test
    public void testFeetEquality_SameValue() {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        Feet_Measurement f2 = new Feet_Measurement(1.0);
        assertEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        Feet_Measurement f2 = new Feet_Measurement(2.0);
        assertNotEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        Object obj = new Object();
        assertNotEquals(f1, obj);
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        assertEquals(f1, f1);
    }
}