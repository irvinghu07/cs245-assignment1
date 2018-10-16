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
        // 0 - length: run
//        int runlength = findRunsRecur(a, 0);
//        if (runlength >= RUNNING_SIZE) {
//
//        }
//
//        // 0 - length: unsort
//        int Unsortlength = findUnsortRecur(a, 0);

        findRuns(a);
//        printRuns(a);
        findUnsortedPart(a);
//        printURuns(a);
        mergeBack(a);

    }

    private void mergeBack(int[] a) {
        for (Integer uStart : uruns.keySet()) {
            int uEnd = uruns.get(uStart);
            runs.put(uStart, uEnd);
        }
//        for (Integer start : runs.keySet()) {
//            int end = runs.get(start);
//            System.out.println(String.format("start:%d-end:%d", start, end));
//        }

        System.out.println(runs.keySet().size());
        int i = 0;
        int start = 0;
        int end = 0;
        int ustart = 0;
        int uend = 0;
        Iterator<Integer> iterator = runs.keySet().iterator();
        while (iterator.hasNext()) {
            start = iterator.next();
            end = runs.get(start);
            System.out.println("===========================================");
            System.out.println("i: " + i);
            System.out.println(String.format("start:%d-end:%d", start, end));
            if (i % 2 == 0 && iterator.hasNext()) {
                ustart = iterator.next();
                i++;
                uend = runs.get(ustart);
                merge(a, start, ustart);
                System.out.println(String.format("ustart:%d-uend:%d", ustart, uend));
            } else {
                System.out.println("inside()");
            }
            i++;
        }
    }

    private void merge(int[] a, int start, int ustart) {
        int end = runs.get(start);
        int uend = runs.get(ustart);

    }


    private void findUnsortedPart(int[] a) {
        SelectionSort selectionSort = new SelectionSort();
        int uStart = 0;
        for (Integer start : runs.keySet()) {
            if (start == 0) {
                uStart = runs.get(start) + 1;
                break;
            }
            selectionSort.sortSpecifiedRegion(a, uStart, start - 1);
            uruns.put(uStart, start - 1);
            uStart = runs.get(start) + 1;
        }
        if (uStart != a.length - 1) {
            selectionSort.sortSpecifiedRegion(a, uStart, a.length - 1);
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

}
