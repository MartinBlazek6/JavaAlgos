package implementations;
import java.util.*;

public class ReversalToSort {
    public static void main(String[] args) {
        int[] example1 = {11, 14, 12, 13};
        int[] example2 = {22, 12, 13, 14};
        System.out.println(getReversalsToSort(example1));
        System.out.println(getReversalsToSort(example2));
    }

    public static List<Integer> getReversalsToSort(int[] array) {
        List<Integer> result = new ArrayList<>();
        while (array.length > 1) {
            int max = findIndexOfMax(array);
            reverseUpTo(array, max);


            if (max > 0 && max < array.length - 1){
                result.add(max + 1);
            }
            if (max < array.length - 1) {
                result.add(array.length);
            }
            reverseUpTo(array, array.length - 1);
            array = Arrays.copyOf(array, array.length - 1);
        }
        return result;
    }

    private static void reverseUpTo(int[] array, int to) {
        int from = 0;
        while (from < to) {
            int temp = array[from];
            array[from] = array[to];
            array[to] = temp;
            from++;
            to--;
        }
    }

    private static int findIndexOfMax(int[] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(list::add);
        int max2 = Collections.max(list);
        max2 = list.indexOf(max2);
        return max2;
    }

}
