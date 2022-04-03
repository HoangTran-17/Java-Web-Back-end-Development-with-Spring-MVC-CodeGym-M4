package controller;

import org.springframework.stereotype.Controller;
import service.VeryComplexService;
import sort.BubbleSortAlgorithm;
import sort.QuicksortAlgorithm;
import sort.SortAlgorithm;

import java.util.Arrays;

@Controller
public class Main {

    public static void main(String[] args) {
        SortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

        SortAlgorithm quicksortAlgorithm = new QuicksortAlgorithm();
        VeryComplexService veryComplexService1 = new VeryComplexService(bubbleSortAlgorithm);
        VeryComplexService veryComplexService2 = new VeryComplexService(quicksortAlgorithm);

        int[] array = {1,5,8,2,4};
        veryComplexService1.complexBusiness(array);
        System.out.println(Arrays.toString(array));
        System.out.println("bubbleSortAlgorithm");

        veryComplexService2.complexBusiness(array);
        System.out.println(Arrays.toString(array));
        System.out.println("quicksortAlgorithm");
    }

}
