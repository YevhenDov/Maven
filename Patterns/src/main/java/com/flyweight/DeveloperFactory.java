package com.flyweight;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactory {
    private static final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloper(String specialty){
        Developer developer = developers.get(specialty);

        if (developer == null){
            switch (specialty){
                case "Java":
                {
                    developer = new JavaDeveloper();
                    System.out.println("Hiring Java developer...");
                    break;
                }
                case "C++":
                {
                    developer = new CppDeveloper();
                    System.out.println("Hiring C++ developer...");
                    break;
                }
            }
            developers.put(specialty, developer);
        }
        return developer;
    }
}
