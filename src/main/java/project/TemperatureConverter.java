package project;

public class TemperatureConverter {

    public static final double KELVIN = 273.16;//water freezing point
    public static final double ICEMELTINGPOINT = 32;//Fahrenheit
    public static final double DEGREEFAHRENHEITTOCELSIUS = 1.8000;


    public double convertCelsiusToKelvin(double celsius) {
        return celsius + KELVIN;
    }

    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - KELVIN;
    }

    public double convertCelsiusToFahrenheit(double celsius) {
        return celsius * DEGREEFAHRENHEITTOCELSIUS + ICEMELTINGPOINT;
    }

    public double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - ICEMELTINGPOINT) / DEGREEFAHRENHEITTOCELSIUS;
    }

}
