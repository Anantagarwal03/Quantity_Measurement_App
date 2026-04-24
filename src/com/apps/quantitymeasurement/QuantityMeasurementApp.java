package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        // Length Category
        QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);

        // Weight Category
        QuantityWeight weight1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight weight2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("1kg equals 1000g? " + weight1.equals(weight2)); // true
        System.out.println("Weight + Weight: " + weight1.add(weight2, WeightUnit.POUND));

        // This would return false, as they are different categories
        System.out.println("Is 1kg equal to 1 foot? " + weight1.equals(length1));
    }
}