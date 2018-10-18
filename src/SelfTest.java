public class SelfTest {
    public static void main(String[] args) {
        System.out.println(findExponent(128));
    }

    private static int findExponent(int i) {
        if (i == 1) {
            return 0;
        }
        return 1 + findExponent(i / 2);
    }
}
