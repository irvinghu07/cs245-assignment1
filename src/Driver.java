import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        String[] arg = {"8"};
        int running_size = 16;
        System.out.println(Arrays.toString(RandomGenerator.generate()));
        try {
//            running_size = ArgumentParser.parseSize(arg);
//            System.out.println("entered running_size: " + running_size);
        } catch (Exception e) {
            System.out.println("========program shutting down========");
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}
