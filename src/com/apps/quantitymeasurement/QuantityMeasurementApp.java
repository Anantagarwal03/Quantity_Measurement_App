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

        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            return (this.value * this.unit.conversionFactor) / targetUnit.conversionFactor;
        }

        /**
         * UC6: Adds another quantity to this one.
         * The result unit is the unit of the first operand (this).
         */
        public Quantity add(Quantity other) {
            if (other == null) throw new IllegalArgumentException("Operand cannot be null");

            // Convert both to base unit (Inches), add them, then convert back to 'this' unit
            double sumInBase = (this.value * this.unit.conversionFactor) +
                    (other.value * other.unit.conversionFactor);

            double finalValue = sumInBase / this.unit.conversionFactor;
            return new Quantity(finalValue, this.unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity other = (Quantity) obj;
            return Double.compare(Math.round(this.value * this.unit.conversionFactor * 100.0) / 100.0,
                    Math.round(other.value * other.unit.conversionFactor * 100.0) / 100.0) == 0;
        }

        @Override
        public String toString() {
            return String.format("%.2f %s", value, unit);
        }
    }

    public static void main(String[] args) {
        Quantity oneFoot = new Quantity(1.0, LengthUnit.FEET);
        Quantity twelveInches = new Quantity(12.0, LengthUnit.INCHES);

        Quantity result = oneFoot.add(twelveInches);
        System.out.println("1 Foot + 12 Inches = " + result); // Expected: 2.00 FEET
    }
}