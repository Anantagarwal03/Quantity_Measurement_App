package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be a finite number");
            }
            this.value = value;
            this.unit = unit;
        }

        /**
         * UC5 Core: Converts this quantity to a target unit.
         * Formula: (Value * SourceFactor) / TargetFactor
         */
        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            return (this.value * this.unit.conversionFactor) / targetUnit.conversionFactor;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity other = (Quantity) obj;
            return Double.compare(this.value * this.unit.conversionFactor,
                    other.value * other.unit.conversionFactor) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // Method Overloading 1: Using raw values
    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        Quantity quantity = new Quantity(value, from);
        double result = quantity.convertTo(to);
        System.out.println("Converted " + value + " " + from + " to " + result + " " + to);
    }

    // Method Overloading 2: Using an existing Quantity object
    public static void demonstrateLengthConversion(Quantity quantity, LengthUnit to) {
        double result = quantity.convertTo(to);
        System.out.println("Converted " + quantity + " to " + result + " " + to);
    }

    public static void main(String[] args) {
        System.out.println("--- UC5 Unit Conversion Demo ---");
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);

        Quantity q = new Quantity(36.0, LengthUnit.INCHES);
        demonstrateLengthConversion(q, LengthUnit.YARDS);
    }
}