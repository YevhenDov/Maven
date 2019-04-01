package service;

import model.Fruit;
import model.FruitType;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FruitShopTest {
    public FruitShop fruitShop;
    public static final String PATH_TO_FIRST_JSON = ".\\src\\main\\resources\\first_test.json";
    public static final String PATH_TO_SECOND_JSON = ".\\src\\main\\resources\\second_test.json";

    @Before
    public void setFruitShop() throws ParseException {
        fruitShop = new FruitShop();
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("1.12.2019");
        Date secondDate = new SimpleDateFormat("dd.MM.yyyy").parse("2.12.2019");

        fruitShop.fruits.add(new Fruit(FruitType.APPLE, 10, date, 15));
        fruitShop.fruits.add(new Fruit(FruitType.ORANGE, 15, date, 5));
        fruitShop.fruits.add(new Fruit(FruitType.LEMON, 5, date, 20));
        fruitShop.fruits.add(new Fruit(FruitType.GRAPES, 20, date, 25));
        fruitShop.fruits.add(new Fruit(FruitType.KIWI, 25, date, 40));
        fruitShop.fruits.add(new Fruit(FruitType.PEACH, 30, date, 50));
        fruitShop.fruits.add(new Fruit(FruitType.PLUM, 35, date, 60));
        fruitShop.save(PATH_TO_FIRST_JSON);

        fruitShop.fruits.add(new Fruit(FruitType.KIWI, 10, secondDate, 15));
        fruitShop.fruits.add(new Fruit(FruitType.APPLE, 15, secondDate, 5));
        fruitShop.fruits.add(new Fruit(FruitType.LEMON, 5, secondDate, 20));
        fruitShop.fruits.add(new Fruit(FruitType.GRAPES, 21, secondDate, 25));
        fruitShop.fruits.add(new Fruit(FruitType.KIWI, 25, secondDate, 40));
        fruitShop.fruits.add(new Fruit(FruitType.PEAR, 30, secondDate, 50));
        fruitShop.fruits.add(new Fruit(FruitType.PLUM, 35, secondDate, 60));
        fruitShop.save(PATH_TO_SECOND_JSON);
    }

    @Test
    public void addFruits() {
        fruitShop.fruits.clear();
        assertTrue(fruitShop.fruits.size() == 0);
        fruitShop.addFruits(PATH_TO_FIRST_JSON);
        assertTrue(fruitShop.fruits.size() == 7);
        fruitShop.addFruits(PATH_TO_SECOND_JSON);
        assertTrue(fruitShop.fruits.size() == 14);
    }

    @Test
    public void load() {
        fruitShop.load(PATH_TO_FIRST_JSON);
        assertTrue(fruitShop.fruits.size() == 7);
        fruitShop.load(PATH_TO_SECOND_JSON);
        assertTrue(fruitShop.fruits.size() == 14);
    }

    @Test
    public void getSpoiledFruitsDate() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("17.12.2019");
        List<Fruit> spoiledFruits = fruitShop.getSpoiledFruits(date);
        assertTrue(spoiledFruits.size() == 5);
    }

    @Test
    public void getSpoiledFruitsDateAndType() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("17.12.2019");
        List<Fruit> spoiledFruits = fruitShop.getSpoiledFruits(date, FruitType.APPLE);
        assertTrue(spoiledFruits.size() == 1);
    }

    @Test
    public void getAddedFruitsDate() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("1.12.2019");
        List<Fruit> addedFruits = fruitShop.getAddedFruits(date);
        assertTrue(addedFruits.size() == 7);
    }

    @Test
    public void getAddedFruitsDateAndType() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("1.12.2019");
        List<Fruit> addedFruits = fruitShop.getAddedFruits(date, FruitType.APPLE);
        assertTrue(addedFruits.size() == 1);
    }

    @Test
    public void getAvailableFruitsDate() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("17.12.2019");
        List<Fruit> availableFruits = fruitShop.getAvailableFruits(date);
        assertTrue(availableFruits.size() == 8);
    }

    @Test
    public void getAvailableFruitsDateAndType() throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("17.12.2019");
        List<Fruit> availableFruits = fruitShop.getAvailableFruits(date, FruitType.ORANGE);
        assertTrue(availableFruits.size() == 1);
    }
}
