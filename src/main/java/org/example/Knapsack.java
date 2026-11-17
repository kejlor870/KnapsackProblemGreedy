package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
    private Scanner scanner;
    private List<Item> items = new ArrayList<>();
    private List<Item> knapsack = new ArrayList<>();
    private int capacity;

    public Knapsack(Scanner scanner){
        this.scanner = scanner;
    }

    public boolean provideItems(){
        items.clear();
        knapsack.clear();

        System.out.print("Podaj liczbe przedmiotow: ");
        int itemsNumber = scanner.nextInt();

        if(itemsNumber < 0){
            System.out.println("Liczba przedmiotow nie moze byc ujemna.");
            return false;
        }

        System.out.print("Podaj MAX wage plecaka: ");
        capacity = scanner.nextInt();

        if(capacity < 0){
            System.out.println("Pojemnosc plecaka nie moze byc ujemna.");
            return false;
        }

        scanner.nextLine(); // Cleaning buffor

        // Pobieranie od uzytkonwika danych do itemow i dodawanie ich do listy
        for(int i=1; i <= itemsNumber; i++){
            System.out.println("# Przedmiot nr. " + i);

            System.out.print("Podaj nazwe: ");
            String itemName = scanner.nextLine();

            System.out.print("Podaj wartosc: ");
            int itemValue = scanner.nextInt();

            System.out.print("Podaj wage: ");
            int itemWeight = scanner.nextInt();

            scanner.nextLine(); // Cleaning buffor

            if (itemName.isBlank() || itemValue < 0 || itemWeight <= 0) {
                System.out.println("Podano niepoprawne dane przedmiotu.");
                items.clear();
                return false;
            }

            this.items.add(new Item(itemName, itemValue, itemWeight));
        }

        return true;
    }

    public List<Item> knapsackFill(){
        knapsack.clear();

        // Descending sorting items by ratio
        items.sort((a, b) -> Double.compare(b.getRatio(), a.getRatio()));

        // Greedy algorithm pushing sorted items to knapsack list
        long currentWeight = 0;
        for(Item item : items){
            if(currentWeight + item.getWeight() <= capacity){
                knapsack.add(item);
                currentWeight += item.getWeight();
            }
        }

        return List.copyOf(knapsack);
    }

    public void demoItems(){
        items.clear();
        knapsack.clear();

        capacity = 20;

        items.add(new Item("Laptop", 100, 8));
        items.add(new Item("Telefon", 80, 4));
        items.add(new Item("Koc", 20, 5));
        items.add(new Item("Sluchawki", 50, 2));
        items.add(new Item("Powerbank", 35, 3));
    }

    public void displayItems(){
        if(items.isEmpty()){
            System.out.println("Brak przedmiotow do wyswietlenia.");
            return;
        }

        for(Item item : items){
            System.out.println(item.getStringFullInfo());
        }
    }

    public void displayFilledKnapsack(){
        if(knapsack.isEmpty()){
            System.out.println("Plecak jest pusty.");
            return;
        }

        long totalValue = 0;
        long totalWeight = 0;
        for(Item item : knapsack){
            // Display item info
            System.out.println("\t" +
                    "+ Nazwa: " + item.getName() +
                    " | Wartosc: " + item.getValue() +
                    " | Waga: " + item.getWeight()
            );

            // Increase total value
            totalValue += item.getValue();
            totalWeight += item.getWeight();
        }

        System.out.println("# Laczna wartosc przedmiotow: " + totalValue);
        System.out.println("# Laczna waga przedmiotow: " + totalWeight + "/" + capacity);
    }

    public int getCapacity() {
        return capacity;
    }
}
