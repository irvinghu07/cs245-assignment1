import java.util.TreeMap;

public class HybridSort extends AbstractSortingImpl {

    public static int RUNNING_SIZE;

    public static TreeMap<Integer, Integer> runs;

    public HybridSort(int running_size) {
        RUNNING_SIZE = running_size;
        runs = new TreeMap<>();
    }

    public HybridSort() {
        RUNNING_SIZE = 16;
        runs = new TreeMap<>();
    }

    @Override
    public void sort(int[] a) {
        findRuns(a);
//        runs.forEach((key, value) -> System.out.println(String.format("start:%d\tvalue:%d", key, value)));
        for (Integer start : runs.keySet()) {
            Integer end = runs.get(start);
            System.out.println(String.format("start:%d\tend:%d", start, end));
            System.out.println("============================");
            for (int i = start; i <= end; i++) {
                System.out.print(a[i] + ",");

            }
            System.out.println();
            System.out.println("============================");
        }
    }

    private void findRuns(int[] a) {
        int start = -1;
        int end = -1;
        boolean mayBeARun = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] <= a[i + 1] && !mayBeARun) {
                start = i;
                mayBeARun = true;
            }
            if (a[i] > a[i + 1] && mayBeARun) {
                end = i;
                mayBeARun = false;
                if (end - start >= RUNNING_SIZE) {
                    runs.put(start, end);
                }
            }
        }
    }


}
