import java.util.Arrays;

public class ArgumentParser {
    public static final String PATTERN = "\\d*";

    public static Integer parseSize(String[] args) {
        if (args.length == 0) {
            System.out.println("no running size entered, setting up as default 16;");
            return 16;
        }
        if (args.length != 1) {
            throw new RuntimeException(String.format("invalid input of argument: enter one integer as input size; your input: %s", Arrays.toString(args)));
        }
        String content = args[0];
        if (!content.matches(PATTERN)) {
            throw new RuntimeException(String.format("invalid input of argument: entered not a number; your input: %s", content));
        } else {
            int value = Integer.valueOf(content);
            if (value <= 0) {
                throw new RuntimeException(String.format("invalid input of argument: running size must be greater than 0;  your input: %d", value));
            }
            return value;
        }
    }
}
