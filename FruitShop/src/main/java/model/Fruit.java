package model;

import java.util.Date;

public class Fruit {
    private FruitType type;
    private int shelfLife;
    private Date date;
    private double price;


    public Fruit() {
    }

    public Fruit(FruitType type, int shelfLife, Date date, double price) {
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public FruitType getType() {
        return type;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Fruit fruit = (Fruit) obj;
        return (type == fruit.type)
                && (shelfLife == fruit.shelfLife)
                && (price == fruit.price)
                && (date.equals(this.date));
    }
}

