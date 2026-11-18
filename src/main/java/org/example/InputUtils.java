package org.example;

import java.util.Scanner;

public class InputUtils {

    // Int
    public static int readInt(Scanner scanner, String message) {
        while(true){
            System.out.print(message);

            if(scanner.hasNextInt()) return scanner.nextInt();

            System.out.println("Niepoprawne dane! Podaj liczbe calkowita.");

            scanner.nextLine();
        }
    }

    // Not empty String
    public static String readString(Scanner scanner, String message) {
        while(true) {
            System.out.print(message);

            String input = scanner.nextLine();

            if(!input.isBlank()) return input.trim();

            System.out.println("Niepoprawne dane! Tekst nie moze byc pusty.");
        }
    }


    public static int readNonNegativeInt(Scanner scanner, String message) {
        while(true){
            int value = readInt(scanner, message);

            if(value >= 0) return value;

            System.out.println("Wartosc nie moze byc ujemna.");
        }
    }

    public static int readPositiveInt(Scanner scanner, String message) {
        while(true){
            int value = readInt(scanner, message);

            if(value > 0){
                return value;
            }

            System.out.println("Wartosc musi byc wieksza od 0.");
        }
    }

}
