import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class HybridSort extends AbstractSortingImpl {

    public static int RUNNING_SIZE;

    public static TreeMap<Integer, Integer> runs;

    public static TreeMap<Integer, Integer> uruns;

    public HybridSort(int running_size) {
        RUNNING_SIZE = running_size;
        runs = new TreeMap<>();
        uruns = new TreeMap<>();
    }

    public HybridSort() {
        RUNNING_SIZE = 16;
        runs = new TreeMap<>();
        uruns = new TreeMap<>();
    }


    private int findRunsRecur(int[] a, int i) {
        if (i == a.length - 2) {
            return 0;
        }
        if (a[i] <= a[i + 1]) {
            return 1 + findRunsRecur(a, i++);
        } else {
            return 0;
        }
    }

    private int findUnsortRecur(int[] a, int i) {
        if (i == a.length - 2) {
            return 0;
        }
        if (a[i] <= a[i + 1]) {
            return 0;
        } else {
            return 1 + findUnsortRecur(a, i++);
        }
    }

    @Override
    public void sort(int[] a) {
        System.out.println("a.length: " + a.length);
        findRuns(a);
//        printRuns(a);
        findUnsortedPart(a);
        printURuns(a);
        mergeBack(a);
        isSorted(a);
    }

    private void mergeBack(int[] a) {
        for (Integer uStart : uruns.keySet()) {
            int uEnd = uruns.get(uStart);
            runs.put(uStart, uEnd);
        }
        System.out.println(runs.keySet().size());
        int i;
        int start = 0;
        int end = 0;
        int uStart = 0;
        int uEnd = 0;
        Iterator<Integer> iterator;
        int level = 1;
        int dealer = 0;
        while (true) {
            dealer = (int) Math.pow(2, level);
            i = 0;
            // setting iterator back to the first element of the keySet;
            iterator = runs.keySet().iterator();
            while (iterator.hasNext()) {
                start = iterator.next();
                i++;
                end = runs.get(start);
                if (i % dealer == 0) {
                    int k = 0;
                    while (k < Math.pow(2, level - 1) && iterator.hasNext()) {
                        uStart = iterator.next();
                        k++;
                        i++;
                    }
                    uEnd = runs.get(uStart);
                    System.out.println("===========================================");
                    System.out.println(String.format("i:%d\t merging start:%d-end:%d\twith\tustart:%d-uend:%d", i, start, end, uStart, uEnd));
                    merge(a, start, uStart);
                    // softly deleted unsorted part;
                    System.out.println(Arrays.toString(a));
                    runs.put(start, uEnd);
                }
            }
            level++;
        }
    }

    private void merge(int[] a, int start, int ustart) {
        int index = 0;
        int end = runs.get(start);
        int uend = runs.get(ustart);
        if (end == uend) {
            return;
        }
        int length = uend - start + 1;
        System.out.println("length: " + length);
        int[] temp = new int[length];
        int i = start;
        int j = ustart;
        while (i <= end && j <= uend) {
            if (a[i] <= a[j]) {
                temp[index] = a[i];
                index++;
                i++;
            } else {
                temp[index] = a[j];
                index++;
                j++;
            }
        }
        while (i <= end) {
            temp[index] = a[i];
            i++;
            index++;
        }
        while (j <= uend) {
            temp[index] = a[j];
            j++;
            index++;
        }
        for (int k = 0; k < index; k++) {
            a[k + start] = temp[k];
        }
    }


    private void findUnsortedPart(int[] a) {
        SelectionSort selectionSort = new SelectionSort();
        int uStart = 0;
        for (Integer start : runs.keySet()) {
            if (start == 0) {
                uStart = runs.get(start) + 1;
                break;
            }
            selectionSort.sortSpecifiedRegion(a, uStart, start);
            uruns.put(uStart, start - 1);
            uStart = runs.get(start) + 1;
        }
        if (uStart != a.length - 1) {
            selectionSort.sortSpecifiedRegion(a, uStart, a.length);
            uruns.put(uStart, a.length - 1);
        }
    }


    private void findRuns(int[] a) {
        //start--> beginning of the run
        int start = -1;
        //start--> rear of the run
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


    private void printRuns(int[] a) {
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

    private void printURuns(int[] a) {
        for (Integer start : uruns.keySet()) {
            Integer end = uruns.get(start);
            System.out.println(String.format("start:%d\tend:%d", start, end));
            System.out.println("============================");
            for (int i = start; i <= end; i++) {
                System.out.print(a[i] + ",");

            }
            System.out.println();
            System.out.println("============================");
        }
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

}
