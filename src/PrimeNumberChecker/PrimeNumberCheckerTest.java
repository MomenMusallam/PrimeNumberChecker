package PrimeNumberChecker;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCheckerTest {

    PrimeNumberChecker checker = new PrimeNumberChecker();

    @Test(dataProvider = "CSVDataProvider")
    public void testIsPrime(String testDescription, int number, boolean expectedResult) {

        boolean actualResult = checker.isPrime(number);
        Assert.assertEquals(
                actualResult,
                expectedResult,
                "Failed Test: " + testDescription
        );
    }

    @DataProvider(name = "CSVDataProvider")
    public Object[][] CSVDataProvider() throws Exception {

        String filePath = "src/resources/PrimeNumberTest.csv";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        List<Object[]> testData = new ArrayList<>();

        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] data = line.split(",");

            String testDescription = data[0];
            int number = Integer.parseInt(data[1]);
            boolean expectedResult = Boolean.parseBoolean(data[2]);

            testData.add(new Object[]{testDescription, number, expectedResult});
        }

        reader.close();

        return testData.toArray(new Object[0][]);
    }
}