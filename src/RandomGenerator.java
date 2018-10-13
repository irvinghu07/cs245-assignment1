import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {

    public static int[] generate() {
        return generate(1000);
    }

    public static int[] generate(int arraySize) {
        return generate(arraySize, 100);
    }

    public static int[] generate(int arraySize, int maximum) {
        int[] out = new int[arraySize];
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() != arraySize) {
            numbers.add(new Random().nextInt(maximum));
        }
        for (int i = 0; i < numbers.size(); i++) {
            out[i] = numbers.get(i);
        }
        return out;
    }
}
