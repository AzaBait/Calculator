package calculator;

import calculator.entity.ArabCalc;
import calculator.entity.Converter;

import java.util.Scanner;

public class Main {

    private static String calc(String input) throws Exception {
        String[] numbers = input.split(" ");
        if (numbers.length == 3) {
            String value1 = numbers[0];
            String operation = numbers[1];
            String value2 = numbers[2];

            int a = Integer.parseInt(value1);
            int b = Integer.parseInt(value2);
            ArabCalc arabCalc = new ArabCalc(a, b);
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new Exception();
            }
            switch (operation) {
                case "+":
                    arabCalc.addition();
                    break;
                case "-":
                    arabCalc.subtraction();
                    break;
                case "*":
                    arabCalc.multiplication();
                    break;
                case "/":
                    arabCalc.division();
                    break;
                default:
                    throw new Exception();
            }
            return Integer.toString(arabCalc.getResult());
        } else throw new Exception();
    }

    public static boolean checkArabic(String inputArab) {
        String[] cheks = inputArab.split(" ");
        boolean a = true;
        boolean b = true;
        String arabicNum1 = cheks[0];
        String arabicNum2 = cheks[2];
        String[] arabic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String element : arabic) {
            a = arabicNum1.equals(element);
            if (a) {
                break;
            }
            for (String item : arabic) {
                b = arabicNum2.equals(item);
                if (b) {
                    break;
                }
            }
        }
        return a & b;
    }

    public static boolean checkRoman(String inputRom) {
        String[] check = inputRom.split(" ");
        boolean a = true;
        boolean b = true;
        String romanNum1 = check[0];
        String romanNum2 = check[2];
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String element:roman) {
            a = romanNum1.equals(element);
            if (a){
                break;
            }
        }
        for (String item:roman) {
            b = romanNum2.equals(item);
            if (b){
                break;
            }
        }
        return a&b;
    }

    public static String romanToArabic(String input){
        String[] convert = input.split(" ");
        String roman1 = convert[0];
        String roman2 = convert[2];
        Converter con1 = Converter.valueOf(roman1);
        String str1 = con1.getArab();
        Converter con2 = Converter.valueOf(roman2);
        String str2 = con2.getArab();
        String result = str1+" "+convert[1]+" "+str2;
        return result;
    }

    public static String arabicToRoman(String input){
        int num = Integer.parseInt(input);
        Converter con = Converter.values()[num-1];
        return con.name();
    }



    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean check1 = checkArabic(input);
        boolean check2 = checkRoman(input);
        String resultRomeToArab;
        if ((!check1)&(!check2)){
            throw new Exception();
        }
        if (check2){
            resultRomeToArab=romanToArabic(input);
            String output2 = calc(resultRomeToArab);
            String resultRome = arabicToRoman(output2);
            System.out.println(resultRome);
        }
        if (check1){
            String output = calc(input);
            System.out.println(output);
        }

    }
}
