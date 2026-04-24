package com.apps.quantitymeasurement;

public class Feet_Measurement {
    private final double value;

    public Feet_Measurement(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Feet_Measurement other = (Feet_Measurement) obj;
        return Double.compare(this.value, other.value) == 0;
    }

    public static void main(String[] args) {
        Feet_Measurement f1 = new Feet_Measurement(1.0);
        Feet_Measurement f2 = new Feet_Measurement(1.0);
        System.out.println("Are they equal? " + f1.equals(f2));
    }
}