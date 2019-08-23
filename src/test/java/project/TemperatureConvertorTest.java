package project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TemperatureConvertorTest {

    private TemperatureConverter temperatureConvertor;

    @BeforeClass
    public void setUp() {
        temperatureConvertor = new TemperatureConverter();
    }

    @AfterClass
    public void tearDown() {
        temperatureConvertor = null;
    }




    @Test
    public void convertDefaultCelsiusToKelvinTest() {
        double celsiusToKelvinResult = temperatureConvertor.convertCelsiusToKelvin(0.0);

        assertEquals(celsiusToKelvinResult, 273.16, "Wrong Celsius to Kelvin result");
    }

    @Test
    public void convertCelsiusToKelvinAboveZeroTest() {
        double celsiusToKelvinResult = temperatureConvertor.convertCelsiusToKelvin(25.5);

        assertEquals(celsiusToKelvinResult, 298.66, "Wrong Celsius to Kelvin result");
    }

    @Test
    public void convertCelsiusToKelvinLowZeroTest() {
        double celsiusToKelvinResult = temperatureConvertor.convertCelsiusToKelvin(-10.0);

        assertEquals(celsiusToKelvinResult, 263.16, "Wrong Celsius to Kelvin result");
    }

    @Test
    public void convertDefaultKelvinToCelsiusTest() {
        double kelvinToCelsiusResult = temperatureConvertor.convertKelvinToCelsius(0.0);

        assertEquals(kelvinToCelsiusResult, -273.16, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertKelvinToCelsiusAboveZeroTest() {
        double kelvinToCelsiusResult = temperatureConvertor.convertKelvinToCelsius(300.0);

        assertEquals(kelvinToCelsiusResult, 26.839999999999975, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertKelvinToCelsiusLowZeroTest() {
        double kelvinToCelsiusResult = temperatureConvertor.convertKelvinToCelsius(-150.0);

        assertEquals(kelvinToCelsiusResult, -423.16, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertDefaultCelsiusToFahrenheitTest() {
        double сelsiusToFahrenheitResult = temperatureConvertor.convertCelsiusToFahrenheit(0.0);

        assertEquals(сelsiusToFahrenheitResult, 32.0, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertCelsiusToFahrenheitAboveZeroTest() {
        double сelsiusToFahrenheitResult = temperatureConvertor.convertCelsiusToFahrenheit(50.0);

        assertEquals(сelsiusToFahrenheitResult, 122.0, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertCelsiusToFahrenheitLowZeroTest() {
        double сelsiusToFahrenheitResult = temperatureConvertor.convertCelsiusToFahrenheit(-18.0);

        assertEquals(сelsiusToFahrenheitResult, -0.3999999999999986, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertDefaultFahrenheitToCelsiusTest() {
        double fahrenheitToCelsiusResult = temperatureConvertor.convertFahrenheitToCelsius(0.0);

        assertEquals(fahrenheitToCelsiusResult, -17.77777777777778, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertFahrenheitToCelsiusAboveZeroTest() {
        double fahrenheitToCelsiusResult = temperatureConvertor.convertFahrenheitToCelsius(66.0);

        assertEquals(fahrenheitToCelsiusResult, 18.88888888888889, "Wrong Kelvin to Celsius result");
    }

    @Test
    public void convertFahrenheitToCelsiusLowZeroTest() {
        double fahrenheitToCelsiusResult = temperatureConvertor.convertFahrenheitToCelsius(-39.0);

        assertEquals(fahrenheitToCelsiusResult, -39.44444444444444, "Wrong Kelvin to Celsius result");
    }

}
