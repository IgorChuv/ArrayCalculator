import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayCalculatorTest {
    private final ArrayCalculator calculator = new ArrayCalculator();
    private final int EXPECTED_VALUE = 14;
    private final int EXPECTED_VALUE_ZERO = 0;

    @Test
    public void calculateSumExclMinMax_validSimpleArgument_success() {
        int[] numArray = new int[]{1, 3, 4, 2, 6, 5};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE, actual);
    }

    @Test
    public void calculateSumExclMinMax_withZeroValues() {
        int[] numArray = new int[]{0, 0, 0, 0, 0, 0};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE_ZERO, actual);
    }

    @Test
    public void calculateSumExclMinMax_withDuplicatedMinMaxValues() {
        int[] numArray = new int[]{1, 3, 4, 2, 6, 5, 1, 6, 6, 1};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE, actual);
    }

    @Test
    public void calculateSumExclMinMax_withSomeNegativeValues() {
        int[] numArray = new int[]{0, 2, 3, 4, 10, 6, -6, 1, -1, -6, -1};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE, actual);
    }

    @Test
    public void calculateSumExclMinMax_withAllNegativeValues() {
        int[] numArray = new int[]{-1, -2, -3, -4, -5, -6};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(-(EXPECTED_VALUE), actual);
    }

    @Test
    public void calculateSumExclMinMax_withTheSameNumbers() {
        int[] numArray = new int[]{6, 6, 6, 6, 6, 6};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE_ZERO, actual);
    }

    @Test
    public void calculateSumExclMinMax_withTheSameNegativeNumbers() {
        int[] numArray = new int[]{-6, -6, -6, -6, -6, -6};
        int actual = calculator.calculateSumExclMinMax(numArray);
        Assert.assertEquals(EXPECTED_VALUE_ZERO, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void calculateSumExclMinMax_emptyArgument() {
        final int[] numArray = new int[]{};
        calculator.calculateSumExclMinMax(numArray);
    }
}
