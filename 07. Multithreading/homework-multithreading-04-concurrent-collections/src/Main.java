import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static String[] texts = new String[10_000];

    public static BlockingQueue<String> stringsMaxAThread = new ArrayBlockingQueue<>(100);
    public static BlockingQueue<String> stringsMaxBThread = new ArrayBlockingQueue<>(100);
    public static BlockingQueue<String> stringsMaxCThread = new ArrayBlockingQueue<>(100);

    public static String stringMaxA;
    public static String stringMaxB;
    public static String stringMaxC;

    public static int maxA;
    public static int maxB;
    public static int maxC;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                texts[i] = generateText("abc", 100_000);
                try {
                    stringsMaxAThread.put(texts[i]);
                    stringsMaxBThread.put(texts[i]);
                    stringsMaxCThread.put(texts[i]);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        Thread threadACount = new Thread(() -> {
//            charCounter(stringsMaxAThread, stringMaxA, maxA);
            for (int i = 0; i < texts.length; i++) {
                try {
                    String tempString = stringsMaxAThread.take();
                    int tempCount = 0;
                    for (char c : tempString.toCharArray()) {
                        if (c == 'a') {
                            tempCount++;
                        }
                    }
                    if (tempCount > maxA) {
                        maxA = tempCount;
                        stringMaxA = tempString;
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadACount.start();

        Thread threadBCount = new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                try {
                    String tempString = stringsMaxBThread.take();
                    int tempCount = 0;
                    for (char c : tempString.toCharArray()) {
                        if (c == 'b') {
                            tempCount++;
                        }
                    }
                    if (tempCount > maxB) {
                        maxB = tempCount;
                        stringMaxB = tempString;
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadBCount.start();

        Thread threadCCount = new Thread(() -> {
            for (int i = 0; i < texts.length; i++) {
                try {
                    String tempString = stringsMaxCThread.take();
                    int tempCount = 0;
                    for (char c : tempString.toCharArray()) {
                        if (c == 'c') {
                            tempCount++;
                        }
                    }
                    if (tempCount > maxC) {
                        maxC = tempCount;
                        stringMaxC = tempString;
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        threadCCount.start();

        threadACount.join();
        threadBCount.join();
        threadCCount.join();

        System.out.println(stringMaxA);
        System.out.println(stringMaxB);
        System.out.println(stringMaxC);

        System.out.println(maxA);
        System.out.println(maxB);
        System.out.println(maxC);
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

//    public static void charCounter(BlockingQueue<String> stringsMaxThread, String maxString, int maxChar) {
//        for (int i = 0; i < texts.length; i++) {
//            try {
//                String tempString = stringsMaxThread.take();
//                int tempCount = 0;
//                for (char c : tempString.toCharArray()) {
//                    if (c == 'a') {
//                        tempCount++;
//                    }
//                }
//                if (tempCount > maxChar) {
//                    maxChar = tempCount;
//                    maxString = tempString;
//                }
//            } catch (InterruptedException e) {
//                return;
//            }
//        }
//    }
}
