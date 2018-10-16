public class SelectionSort extends AbstractSortingImpl {
    @Override
    public void sort(int[] a) {
        int minIndex;
        for (int i = 0; i < a.length; i++) {
            minIndex = findMinAtIndex(a, i, a.length);
            swapValues(a, i, minIndex);
        }
    }

    public void sortSpecifiedRegion(int[] a, int start, int end) {
        int minIndex;
        for (int i = start; i < end; i++) {
            minIndex = findMinAtIndex(a, i, end);
            swapValues(a, i, minIndex);
        }
    }
}
