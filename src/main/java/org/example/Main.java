package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Knapsack knapsack = new Knapsack(scanner);

        System.out.println("===== Problem plecakowy =====");
        System.out.println("1. Wlasna lista przedmiotow");
        System.out.println("2. Przykladowa lista");

        System.out.print("Wybierz: ");
        int choose = scanner.nextInt();

        switch (choose){
            case 1:
                knapsack.provideItems();
                break;
            case 2:
                knapsack.demoItems();
                break;
            default:
                System.out.println("Niepoprawny wybor, konczenie...");
                return;
        }

        System.out.println("\n== Podane przedmioty ==");
        knapsack.displayItems();

        System.out.println("== Pojemnosc plecaka: " + knapsack.getCapacity() + " ==");

        System.out.println("== Przedmioty w plecaku ==");
        knapsack.knapsackFill();
        knapsack.displayFilledKnapsack();

        scanner.close();
    }
}