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
        System.out.print("Podaj liczbe przedmiotow: ");
        int itemsNumber = scanner.nextInt();

        if(itemsNumber < 0){
            System.out.println("Liczba przedmiotow nie moze byc ujemna.");
            return false;
        }

        System.out.print("Podaj MAX wage plecaka: ");
        capacity = scanner.nextInt();

        if(capacity < 0){
            System.out.println("Pojemnosc plecaka nie moze byc ujmena.");
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
        int currentWeight = 0;
        for(Item item : items){
            if(currentWeight + item.getWeight() <= capacity){
                knapsack.add(item);
                currentWeight += item.getWeight();
            }
        }

        return knapsack;
    }

    public void demoItems(){
        this.capacity = 10;

        items.add(new Item("Koc", 10, 1));
        items.add(new Item("Pilka", 5, 3));
        items.add(new Item("Woda", 2, 4));
    }

    public void displayItems(){
        for(Item item : items){
            System.out.println(item.getStringFullInfo());
        }
    }

    public void displayFilledKnapsack(){
        for(Item item : knapsack){
            System.out.println(item.getStringFullInfo());
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
