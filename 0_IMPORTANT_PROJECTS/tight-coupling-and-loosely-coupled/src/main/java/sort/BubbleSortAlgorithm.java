package sort;

public class BubbleSortAlgorithm implements SortAlgorithm{

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
    }
}
