public class MergeSort extends AbstractSortingImpl {
    @Override
    public void sort(int[] a) {
        int start = 0;
        int end = a.length - 1;
        mergeSort(a, start, end);
    }

    private void mergeSort(int[] a, int start, int end) {
        if (end - start < 2) {
            if (a[end] < a[start]) {
                swapValues(a, start, end);
            }
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle + 1, end);
    }

    private void merge(int[] a, int start, int middle, int end) {
        int length = end - start + 1;
        int index = 0;
        int[] temp = new int[length];
        int i = start;
        int j = middle;
        while (i < middle && j <= end) {
            if (a[i] >= a[j]) {
                temp[index] = a[j];
                index++;
                j++;
            } else {
                temp[index] = a[i];
                index++;
                i++;
            }
        }
        while (i < middle) {
            temp[index] = a[i];
            i++;
            index++;
        }

        while (j <= end) {
            temp[index] = a[j];
            j++;
            index++;
        }
        for (int k = 0; k < temp.length; k++) {
            a[start + k] = temp[k];
        }
    }
}
