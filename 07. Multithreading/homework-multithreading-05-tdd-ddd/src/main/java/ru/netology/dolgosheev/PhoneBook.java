package ru.netology.dolgosheev;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, Integer> phoneBook = new HashMap<>();

    public int add(String name, int number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(int number) {
        Optional<String> result = phoneBook.entrySet()
                .stream()
                .filter(entry -> number == entry.getValue())
                .map(Map.Entry::getKey)
                .findFirst();

        return result.orElse(null);
    }

    public int findByName(String name) {
        if (phoneBook.containsKey(name)) return phoneBook.get(name);
        return -1;
    }

    public void printAllNames() {
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(phoneBook);
        StringBuilder stringBuilder = null;
        treeMap.forEach((key, value) -> {
            System.out.println(key);
        });
    }
}
