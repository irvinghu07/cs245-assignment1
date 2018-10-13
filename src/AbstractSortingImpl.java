public abstract class AbstractSortingImpl implements SortingUtils, SortingAlgorithm {
    @Override
    public void swapValues(int[] arr, int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;
        }
    }

    @Override
    public int findMinAtIndex(int[] arr, int startIndex, int endIndex) {
        int minValue = arr[startIndex];
        int minValueIndex = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minValueIndex = i;
            }
        }
        return minValueIndex;
    }

    @Override
    public int findMaxAtIndex(int[] arr, int startIndex, int endIndex) {
        int maxValue = arr[startIndex];
        int maxValueIndex = 0;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
}
