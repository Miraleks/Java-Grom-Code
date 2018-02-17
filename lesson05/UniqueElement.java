package lesson05;

public class UniqueElement {
    public static void main(String[] args) {
        int array[] = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }

    static int uniqueCount(int[] array) {

        int arr[] = array;
        sortArray(arr);
        int counter = arr.length;
        for (int el = 0; el < (arr.length - 1); el++) {
            if (arr[el] == arr[el + 1]) {
                counter--;
            }
        }
        return counter;
    }

    static void sortArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
