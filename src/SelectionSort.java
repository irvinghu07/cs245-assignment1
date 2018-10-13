public class SelectionSort extends AbstractSortingImpl {
    @Override
    public void sort(int[] a) {
//        int insertionIndex = 0;
        int minIndex;
        for (int i = 0; i < a.length; i++) {
            minIndex = findMinAtIndex(a, i, a.length);
            swapValues(a, i, minIndex);
//            insertionIndex++;
        }
    }
}
