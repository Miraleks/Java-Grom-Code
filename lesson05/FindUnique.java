package lesson05;

public class FindUnique {
    public static void main(String[] args) {
        int array[] = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }


    static int uniqueCount(int[] array) {

        int uniqueCounter = array.length;
        int lengthArray = array.length;

        for (int i = 0; i < lengthArray; i++) {
            for (int j = i + 1; j < lengthArray; j++) {
                if (array[i] == array[j]) {
                    uniqueCounter--;

                }
                System.out.println("Elem: " + array[i] + " Elem2: " + array[j] + " Counter: " + uniqueCounter);

            }
        }


        return uniqueCounter;
    }
}
