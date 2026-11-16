package org.example;

public class Item {
    String name;
    int value;
    int weight;

    public Item(String name, int value, int weight){
        if(name.isEmpty()) throw new IllegalArgumentException("Nazwa przedmiotu nie moze byc pusta.");
        if(value < 0) throw new IllegalArgumentException("Wartosc nie moze byc mniejsza niz 0.");
        if(weight <= 0) throw new IllegalArgumentException("Waga musi byc wieksza od 0.");

        this.name = name;
        this.value = value;
        this.weight = weight;
    }
}
