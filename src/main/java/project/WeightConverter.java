package project;

public class WeightConverter {
    public static final double POUNDSINKILOGRAM = 2.2046;


    public static double converterPoundsToKilograms (double pounds) {
        return pounds / POUNDSINKILOGRAM;
    }

    public static double converterKilogramsToPounds (double kilograms) {
        return kilograms * POUNDSINKILOGRAM;
    }
}
