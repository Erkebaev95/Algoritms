import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // Поиск минимального значения
        System.out.println("\nПоиск минимального значения");
        int[] arrays = {64,45,12,55,74,92,105,22,33};
        System.out.println(Arrays.toString(arrays));

        int minValue = arrays[0];
        int minIndex = 0;

        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] < minValue) {
                minValue = arrays[i];
                minIndex = i;
            }
        }
        System.out.println("минимальное значения: " + minValue);
        System.out.println("минимальное индекс: " + minIndex);

        int[] arr = {10, 8, 9, 2, 3, 5, 6, 4, 7, 1};
        System.out.println(Arrays.toString(arr));

        // Пузырковая сортировка
        System.out.println("\nПузырковая сортировка");
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

        // Бинарный поиск
        System.out.println("\nБинарный поиск");
        System.out.println(binarySearch(new int[] {-1, 3, 5, 8, 10, 14, 16, 20}, 16));

        // Линейный поиск
        System.out.println("\nЛинейный поиск");
        System.out.println(linearSearch(new int[] {89, 57, 91, 47, 95, 3, 27, 22, 67, 99}, 67));

    }

    // Бинарный поиск
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            // находим середину
            int middle = low + (high - low) / 2;

            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // Линейный поиск
    public static int linearSearch(int[] arr, int elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
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
