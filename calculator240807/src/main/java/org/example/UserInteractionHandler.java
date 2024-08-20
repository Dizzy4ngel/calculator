package org.example;

import org.example.exceptions.NoSuchCalculatorTypeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInteractionHandler {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static CalculatorType getType(){
        System.out.println("Adja meg milyen kalkulátort szeretne használni. A Calculator szóval egy egyszerűsített, míg a Scientific szóval" +
                "egy tudományos számológépet fog választani");
        System.out.println("Az egyszerű számológép összeadni, kivonni, szorozni és osztani tud.");
        System.out.println("A tudományos számológép ezeken kívül tud hatványozni és gyököt vonni");
        try {
            return CalculatorType.valueOf(SCANNER.next().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new NoSuchCalculatorTypeException();
        }
    }

    public static Map<InputType, String> getInput() {
        System.out.println("Adja meg milyen számokkal, és milyen művelettel szeretne számolni.");
        System.out.println("Először adja meg a számot, amelyen a műveletet elvégezni szeretné, majd az operátort, majd azt a számot, amellyel szertné a műveletet elvégezni");
        System.out.println("Az operátorok a következők");
        System.out.println("Összeadás: +");
        System.out.println("Kivánás: -");
        System.out.println("Szorzás: *");
        System.out.println("Osztás: /");
        System.out.println("Hatványozás, ahol a második szám a kitevő: $");
        System.out.println("Gyökvonás, ahol a második szám jelzi, hogy hanyadik gyök: #");
        Map<InputType , String> input = new HashMap<>();
        input.put(InputType.A, SCANNER.next());
        input.put(InputType.OPERATOR, SCANNER.next());
        input.put(InputType.B, SCANNER.next());
        return input;
    }
}
