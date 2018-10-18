import java.util.Arrays;

public class Assignment1Test {
    private static final int MIN_RUNNING_SIZE_EXPO = 2;
    private static final int MAX_RUNNING_SIZE_EXPO = 5;
    private static final int MAX_DATA_VOLUME = 500000;
    private static final int MIN_DATA_VOLUME = 50000;

    private static int[] generateArray(int arraySize) {
        return RandomGenerator.generate(arraySize);
    }

    public static int[] copyArray(int arraySize, int[] arr) {
        return Arrays.copyOf(arr, arraySize);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(Arrays.toString(arr));
                System.out.println(String.format("%d is bigger than %d at index:%d", arr[i], arr[i + 1], i));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start;
        long end;
        for (int i = MIN_DATA_VOLUME; i <= MAX_DATA_VOLUME; i += MIN_DATA_VOLUME) {
            System.out.println("***************************************************");
            System.out.println("array length: "+ i);
            int[] originalArr = generateArray(i);
            int[] arrForMerge = copyArray(i, originalArr);
            start = System.currentTimeMillis();
            new MergeSort().sort(arrForMerge);
            end = System.currentTimeMillis();
            if (isSorted(arrForMerge)) {
                System.out.println("total time for MergeSort:" + (end - start) + " ms");
                System.out.println("MergeSort sorted");
            } else {
                System.out.println("MergeSort is not sorted");
            }
            System.out.println("===================================================");
            for (int j = MIN_RUNNING_SIZE_EXPO; j <= MAX_RUNNING_SIZE_EXPO; j++) {
                int[] arrForHybrid = copyArray(i, originalArr);
                start = System.currentTimeMillis();
                new HybridSort((int) Math.pow(2, j)).sort(arrForHybrid);
                end = System.currentTimeMillis();
                if (isSorted(arrForHybrid)) {
                    System.out.println(String.format("total time for MergeSort: %d ms with running size:%d", (end - start), j));
                    System.out.println("HybridSort sorted");

                } else {
                    System.out.println("HybridSort is not sorted");
                }
                System.out.println("----------------------------------------------------");
            }
            System.out.println("***************************************************");
        }
    }
}
