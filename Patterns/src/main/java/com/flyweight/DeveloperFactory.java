package com.flyweight;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactory {
    private final String JAVA_DEVELOPER = "Java";
    private final String CPP_DEVELOPER = "C++";
    private static final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloper(String specialty) {
        Developer developer = developers.get(specialty);

        if (developer == null) {
            switch (specialty) {
                case JAVA_DEVELOPER: {
                    developer = new JavaDeveloper();
                    System.out.println("Hiring Java developer...");
                    break;
                }
                case CPP_DEVELOPER: {
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
