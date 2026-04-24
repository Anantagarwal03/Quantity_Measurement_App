package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be a finite number");
            }
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }

        // --- UC6: Implicit Target Unit (Result in unit of first operand) ---
        public Quantity add(Quantity other) {
            return add(other, this.unit);
        }

        // --- UC7: Explicit Target Unit Specification ---
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null) throw new IllegalArgumentException("Operand cannot be null");
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

            // Convert both to base unit (Inches) and sum
            double sumInBase = (this.value * this.unit.conversionFactor) +
                    (other.value * other.unit.conversionFactor);

            // Convert sum to the specified target unit
            double finalValue = sumInBase / targetUnit.conversionFactor;
            return new Quantity(finalValue, targetUnit);
        }

        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            return (this.value * this.unit.conversionFactor) / targetUnit.conversionFactor;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity other = (Quantity) obj;
            // Round to 3 decimal places for precision comparison in UC7
            return Math.abs((this.value * this.unit.conversionFactor) -
                    (other.value * other.unit.conversionFactor)) < 0.001;
        }

        @Override
        public String toString() {
            return String.format("%.3f %s", value, unit);
        }
    }

    public static void main(String[] args) {
        Quantity oneFoot = new Quantity(1.0, LengthUnit.FEET);
        Quantity twelveInches = new Quantity(12.0, LengthUnit.INCHES);

        // UC7 Demo: Add and get result in Yards
        Quantity resultInYards = oneFoot.add(twelveInches, LengthUnit.YARDS);
        System.out.println("1 Foot + 12 Inches = " + resultInYards); // Expected: ~0.667 YARDS
    }
}