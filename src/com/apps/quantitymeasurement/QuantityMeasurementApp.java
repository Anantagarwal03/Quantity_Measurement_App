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

        // Delegate conversion to the unit class
        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
            double baseValue = this.unit.convertToBaseUnit(this.value);
            return targetUnit.convertFromBaseUnit(baseValue);
        }

        // Delegate addition math to unit conversion methods
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) throw new IllegalArgumentException("Parameters cannot be null");

            double sumInBase = this.unit.convertToBaseUnit(this.value) +
                    other.unit.convertToBaseUnit(other.value);

            double finalValue = targetUnit.convertFromBaseUnit(sumInBase);
            return new Quantity(finalValue, targetUnit);
        }

        public Quantity add(Quantity other) {
            return add(other, this.unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity other = (Quantity) obj;

            double v1 = this.unit.convertToBaseUnit(this.value);
            double v2 = other.unit.convertToBaseUnit(other.value);

            return Math.abs(v1 - v2) < 0.001;
        }

        @Override
        public String toString() {
            return String.format("%.3f %s", value, unit);
        }
    }

    public static void main(String[] args) {
        Quantity oneYard = new Quantity(1.0, LengthUnit.YARDS);
        // Demonstrating delegation:
        System.out.println("1 Yard in Feet: " + oneYard.convertTo(LengthUnit.FEET));
        System.out.println("1 Yard + 3 Feet in Yards: " + oneYard.add(new Quantity(3.0, LengthUnit.FEET), LengthUnit.YARDS));
    }
}