import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger threeCharsCounter = new AtomicInteger();
    public static AtomicInteger fourCharsCounter = new AtomicInteger();
    public static AtomicInteger fiveCharsCounter = new AtomicInteger();

    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        new Thread(() -> {
            for (String text : texts) {
                if (isPalindrome(text)) {
                    counterIncrease(text);
                }
            }
        }).start();

        new Thread(() -> {
            for (String text : texts) {
                if (isSingleCharWord(text)) {
                    counterIncrease(text);
                }
            }
        }).start();


        new Thread(() -> {
            for (String text : texts) {
                if (isAlphabeticalOrder(text)) {
                    counterIncrease(text);
                }
            }
        }).start();

        System.out.println("Красивых слов с длиной 3: " + threeCharsCounter.get() + " шт");
        System.out.println("Красивых слов с длиной 4: " + fourCharsCounter.get() + " шт");
        System.out.println("Красивых слов с длиной 5: " + fiveCharsCounter.get() + " шт");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean isPalindrome(String text) {
        for (int i = 0; i < (text.length() / 2); i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphabeticalOrder(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSingleCharWord(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void counterIncrease(String text) {
        switch (text.length()) {
            case 3 -> threeCharsCounter.getAndIncrement();
            case 4 -> fourCharsCounter.getAndIncrement();
            case 5 -> fiveCharsCounter.getAndIncrement();
        }
    }
}