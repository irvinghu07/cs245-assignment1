public class ArgumentParser {
    public static final String PATTERN = "\\d";
    public static Integer parseSize(String[] args) {
        if (args.length!= 1){
            throw new RuntimeException("invalid input of argument: enter one integer as input size");
        }
        String content = args[0];
        if (!content.matches(PATTERN)){
            throw new RuntimeException("invalid input of argument: entered not a number");
        }else{
            return Integer.valueOf(content);
        }
    }
}
