package sort;

public class QuicksortAlgorithm implements SortAlgorithm{

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length -1 ; i++) {
            int max = array[i];
            int indexMax = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    indexMax = j;
                }
            }
            int tam = array[i];
            array[i] = max;
            array[indexMax] = tam;
        }
    }
}

