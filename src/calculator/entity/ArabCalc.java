package calculator.entity;

import calculator.service.CalcService;

public class ArabCalc implements CalcService {

    private int value1;
    private int value2;
    private int result;

    public ArabCalc(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }



    @Override
    public int addition() {
        result = value1 + value2;
        return result;

    }

    @Override
    public int division() {
        try {
            result = value1 / value2;
            return result;
        } catch (ArithmeticException exception) {
            System.out.println("Division by zero is impossible");
            return 0;
        }

    }

    @Override
    public int multiplication() {
        result = value1 * value2;
        return result;
    }

    @Override
    public int subtraction() {
        result = value1 - value2;
        return result;
    }

    @Override
    public int getResult() {
        return result;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
