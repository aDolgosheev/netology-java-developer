package ru.netology.dolgosheev;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @Test
    public void testAddFirstContact() {
        PhoneBook phoneBook = new PhoneBook();
        assertTrue(phoneBook.add("Aleksandr", 5555555) == 1,
                "Неверное число контактов");
    }

    @Test
    public void testAddSecondContact() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aleksandr", 5555555);
        assertTrue(phoneBook.add("Stepan", 2222222) == 2,
                "Неверное число контактов");
    }

    @Test
    public void testAddSameContact() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aleksandr", 5555555);
        assertTrue(phoneBook.add("Aleksandr", 5555555) == 1,
                "Неверное число контактов");
    }

    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aleksandr", 5555555);
        phoneBook.add("Stepan", 2222222);
        assertTrue(phoneBook.findByNumber(2222222).equals("Stepan"),
                "Контакта с таким номером не существует");
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Aleksandr", 5555555);
        phoneBook.add("Stepan", 2222222);
        assertTrue(phoneBook.findByName("Stepan") == 2222222,
                "Контактов с таким именем не существует");
    }

    @Test
    public void testPrintAllNames() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Stepan", 2222222);
        phoneBook.add("Aleksandr", 5555555);
        phoneBook.printAllNames();
        String stringBuilder = new StringBuilder()
                .append("Aleksandr\r")
                .append("Stepan\r")
                .toString();
        stringBuilder = stringBuilder
                .replaceAll("\n", "")
                .replaceAll("\r", "");
        String outputString = output.toString()
                .replaceAll("\n", "")
                .replaceAll("\r", "");
        assertEquals(stringBuilder, outputString);
        System.setOut(null);
    }
}