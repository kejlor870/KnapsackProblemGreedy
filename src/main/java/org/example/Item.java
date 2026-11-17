package org.example;

public class Item {
    String name;
    int value;
    int weight;
    double ratio;

    public Item(String name, int value, int weight){
        if(name.isEmpty()) throw new IllegalArgumentException("Nazwa przedmiotu nie moze byc pusta.");
        if(value < 0) throw new IllegalArgumentException("Wartosc nie moze byc mniejsza niz 0.");
        if(weight <= 0) throw new IllegalArgumentException("Waga musi byc wieksza od 0.");

        this.name = name;
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    public double getRatio(){
        return this.ratio;
    }

    public String getStringFullInfo(){
        return  "V/W: " + String.format("%.3f",  this.ratio) +
                " || Nazwa: " + this.name +
                " | Wartosc: " + this.value +
                " | Waga: " + this.weight
        ;
    }
}
