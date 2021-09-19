import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // Пузырковая сортировка
        System.out.println("\nПузырковая сортировка");
        int[] arr = {10, 8, 9, 2, 3, 5, 6, 4, 7, 1};
        System.out.println(Arrays.toString(arr));
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        // Сортировка выбор
        System.out.println("\nСортировка выбор");
        for (int i = 0; i < arr.length; i++) {
            int minVal = arr[i];
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minInd = j;
                }
            }
            int tmp = arr[i];
            arr[i] = minVal;
            arr[minInd] = tmp;
            System.out.println(Arrays.toString(arr));
        }

        // Быстрая сортировка
        System.out.println("\nБыстрая сортировка");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    // Быстрая сортировка
    public static void quickSort(int[] arr, int begin, int end  ) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        int pivot = end;
        int counter = begin;

        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int tmp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = tmp;
                counter++;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = tmp;

        return counter;
    }
}
