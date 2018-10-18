import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int running_size = 16;
        int[] arr = RandomGenerator.generate();
        System.out.println(Arrays.toString(arr));
        try {
            running_size = ArgumentParser.parseSize(args);
            System.out.println("entered running_size: " + running_size);
        } catch (Exception e) {
            System.out.println("========program shutting down========");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        HybridSort hybridSort = new HybridSort(running_size);
        hybridSort.sort(arr);
    }
}
