package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    /**
     * Converts current weight to a target weight unit.
     */
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    /**
     * Adds another weight to this weight. Result unit matches 'this' unit.
     */
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    /**
     * Adds another weight with an explicit target result unit.
     */
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        double sumInBase = this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);

        double finalValue = targetUnit.convertFromBaseUnit(sumInBase);
        return new QuantityWeight(finalValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Strictly checks that the other object is also a QuantityWeight
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;
        double v1 = this.unit.convertToBaseUnit(this.value);
        double v2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(v1 - v2) < 0.001; // Epsilon comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.convertToBaseUnit(this.value));
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, unit);
    }
}