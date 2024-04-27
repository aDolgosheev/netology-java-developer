package Task_02;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int number : source) {
            if (number >= treshold) {
                logger.log("Элемент " + number + " проходит.");
                count++;
                result.add(number);
            } else {
                logger.log("Элемент " + number + " не проходит.");
            }
        }
        logger.log("Прошло " + count + " элементов из " + source.size());
        return result;
    }
}
