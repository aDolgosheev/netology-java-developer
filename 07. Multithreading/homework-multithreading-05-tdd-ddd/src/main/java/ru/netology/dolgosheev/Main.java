package ru.netology.dolgosheev;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aleksandr", 5555555);
        phoneBook.add("Stepan", 2222222);
        phoneBook.add("Marina", 3333333);
        phoneBook.printAllNames();
    }
}