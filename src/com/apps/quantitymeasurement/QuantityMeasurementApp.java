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
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            // Convert both to Inches and compare
            double value1InInches = this.value * this.unit.conversionFactor;
            double value2InInches = other.value * other.unit.conversionFactor;

            // Using a small epsilon (0.0001) is often good for double precision,
            // but Double.compare works for these fixed factors.
            return Double.compare(value1InInches, value2InInches) == 0;
        }
    }

    public static void main(String[] args) {
        Quantity yard = new Quantity(1.0, LengthUnit.YARDS);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        Quantity cm = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity inch = new Quantity(0.393701, LengthUnit.INCHES);

        System.out.println("1 Yard == 3 Feet? " + yard.equals(feet));
        System.out.println("1 CM == 0.393701 Inches? " + cm.equals(inch));
    }
}