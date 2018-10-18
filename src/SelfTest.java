public class SelfTest {
    public static void main(String[] args) {
//        System.out.println(findExponent(128));
        System.out.println(Integer.MAX_VALUE);System.out.println(Integer.MIN_VALUE);

    }

    private static int findExponent(int i) {
        if (i == 1) {
            return 0;
        }
        return 1 + findExponent(i / 2);
    }
}
