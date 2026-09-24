package homework20.test;

import homework20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticTest {
    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Chernenko")
    @Description("Проверяем базовое сложение двух положительных чисел: 2 + 3 = 5")
    @Link(value = "JIRA-003", name = "Task: Addition")
    public void testAddPositiveNumbers() {
        double result = steps.add(2, 3);
        steps.verifyResult(5, result);
        assertEquals(5, result, 0.0001);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Chernenko")
    @Description("Проверяем сложение с отрицательным числом: -5 + 3 = -2")
    public void testAddWithNegativeNumber() {
        double result = steps.add(-5, 3);
        steps.verifyResult(-2, result);
        assertEquals(2, result, 0.0001);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Chernenko")
    @Description("Проверяем вычитание: 10 - 4 = 6")
    @Link(value = "JIRA-002", name = "Task: Subtraction")
    public void testSubtract() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(6, result);
        assertEquals(6, result, 0.0001);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Chernenko")
    @Description("Проверяем умножение: 7 * 8 = 56")
    public void testMultiply() {
        double result = steps.multiply(7, 8);
        steps.verifyResult(56, result);
        assertEquals(56, result, 0.0001);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Chernenko")
    @Description("Проверяем деление: 15 / 3 = 5")
    @Link(value = "JIRA-001", name = "Task: Division")
    public void testDivide() {
        double result = steps.divide(15, 3);
        steps.verifyResult(5, result);
        assertEquals(5, result, 0.0001);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Chernenko")
    @Description("Проверяем деление на ноль: ожидается ArithmeticException")
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            steps.divide(10, 0);
        });
        Allure.parameter("Ожидаемое исключение", "ArithmeticException");
        assertEquals("Деление на ноль", exception.getMessage());
    }
}
