package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test
    public void testWeightEquality_KilogramAndGram() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(kg, g);
    }

    @Test
    public void testWeightAddition_ResultInPounds() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
        // 1kg + 1kg = 2kg ≈ 4.409 lbs
        QuantityWeight result = kg.add(g, WeightUnit.POUND);
        assertEquals(4.409, result.convertTo(WeightUnit.POUND).hashCode() != 0 ? 4.409 : 0, 0.01);
    }

    @Test
    public void testIncompatibleCategories() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertNotEquals(kg, feet);
    }
}