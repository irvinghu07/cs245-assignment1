public class InsertionSort extends AbstractSortingImpl implements SortingAlgorithm {
    @Override
    public void sort(int[] a) {
//        int minValueIndex;
//        for (int i = 0; i < a.length; i++) {
//            minValueIndex = findMinAtIndex(a, i, a.length);
//            swapValues(a, i, minValueIndex);
//        }

        int elementToBeCompare;
        int replaceElementIndex;
        for (int i = 1; i < a.length; i++) {
            elementToBeCompare = a[i];
            replaceElementIndex = i;
            for (int j = i - 1; j >= 0 && elementToBeCompare < a[j]; j--) {
                swapValues(a, j, replaceElementIndex);
                replaceElementIndex--;
            }
        }

    }
}
