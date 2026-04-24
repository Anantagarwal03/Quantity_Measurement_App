package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Reference Check
            if (this == obj) return true;

            // 2. Null and Type Check
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            // 3. Conversion Logic (Cross-Unit Equality)
            double firstValueInInches = this.value * this.unit.conversionFactor;
            double secondValueInInches = other.value * other.unit.conversionFactor;

            // 4. Value Comparison
            return Double.compare(firstValueInInches, secondValueInInches) == 0;
        }
    }

    public static void main(String[] args) {
        Quantity feet = new Quantity(1.0, LengthUnit.FEET);
        Quantity inches = new Quantity(12.0, LengthUnit.INCHES);

        System.out.println("Comparing 1.0 Feet and 12.0 Inches...");
        System.out.println("Are they equal? " + feet.equals(inches));
    }
}