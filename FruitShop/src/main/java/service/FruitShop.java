package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Fruit;
import model.FruitType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShop {
    public List<Fruit> fruits = new ArrayList<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy").create();


    public void addFruits(String pathToJsonFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToJsonFile));
            Type fruitsList = new TypeToken<ArrayList<Fruit>>() {
            }.getType();
            fruits = gson.fromJson(bufferedReader, fruitsList);
        } catch (IOException e) {
        }
    }

    public void save(String pathToJsonFile) {
        try {
            Writer writer = new FileWriter(pathToJsonFile);
            String json = gson.toJson(fruits);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
        }
    }

    public void load(String pathToJsonFile) {
        fruits.clear();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToJsonFile));
            Type fruitsList = new TypeToken<ArrayList<Fruit>>() {
            }.getType();
            fruits = gson.fromJson(bufferedReader, fruitsList);
        } catch (IOException e) {
        }
        System.out.println(fruits);
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        return fruits.stream().filter(fruit -> getSpoiledDate(fruit).before(date)).collect(Collectors.toList());
    }

    public List<Fruit> getSpoiledFruits(Date date, FruitType type) {
        return getSpoiledFruits(date).stream().filter(fruit -> fruit.getType() == type).collect(Collectors.toList());
    }

    public List<Fruit> getAddedFruits(Date date) {
        return fruits.stream().filter(fruit -> fruit.getDate().equals(date)).collect(Collectors.toList());
    }

    public List<Fruit> getAddedFruits(Date date, FruitType type) {
        return getAddedFruits(date).stream().filter(fruit -> fruit.getType() == type).collect(Collectors.toList());
    }

    public List<Fruit> getAvailableFruits(Date date) {
        return fruits.stream().filter(fruit -> getSpoiledDate(fruit).after(date)).collect(Collectors.toList());
    }

    public List<Fruit> getAvailableFruits(Date date, FruitType type) {
        return getSpoiledFruits(date).stream().filter(fruit -> fruit.getType() == type).collect(Collectors.toList());
    }

    public Date getSpoiledDate(Fruit fruit) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fruit.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, fruit.getShelfLife());
        return calendar.getTime();
    }
}
