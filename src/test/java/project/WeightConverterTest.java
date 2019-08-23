package project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WeightConverterTest {

    private WeightConverter weightConverter;

    @BeforeClass
    public void setUp() {
        weightConverter = new WeightConverter();
    }

    @AfterClass
    public void tearDown() {
        weightConverter = null;
    }

    @Test
    public void convertDefaultPoundsToKilogramsTest() {
        double poundsToKilograms = weightConverter.converterPoundsToKilograms(0.0);

        assertEquals(poundsToKilograms, 0.0, "");
//        assertEquals(poundsToKilograms, 0.0, "Wrong Pounds to Kilograms result");
    }

    @Test
    public void convertPoundsToKilogramsAboveZeroTest() {
        double poundsToKilograms = weightConverter.converterPoundsToKilograms(5.5);

        assertEquals(poundsToKilograms, 2.4947836342193592, "Wrong Pounds to Kilograms result");
    }

    @Test
    public void convertDefaultKilogramsToPoundsTest() {
        double kilogramsToPounds = weightConverter.converterKilogramsToPounds(0.0);

        assertEquals(kilogramsToPounds, 0.0, "Wrong Kilograms to Pounds result");
    }

    @Test
    public void convertKilogramsToPoundsAboveZeroTest() {
        double kilogramsToPounds = weightConverter.converterKilogramsToPounds(16.0);

        assertEquals(kilogramsToPounds, 35.2736, "Wrong Kilograms to Pounds result");
    }

}
