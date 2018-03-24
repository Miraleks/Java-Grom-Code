package lesson08.Arithmetics;

public class Arithmetic {

    boolean check(int[] array) {
        boolean result = false;
        if (minElement(array) + maxElement(array) > 100)
            result = true;

        return result;
    }

    int minElement(int[] array) {
        int min = array[0];
        for (int el : array) {
            if (el < min)
                min = el;
        }
        //Sys.out.println("min = "+ min);
        return min;
    }

    int maxElement(int[] array) {
        int max = array[0];
        for (int el : array) {
            if (el > max)
                max = el;
        }
        //Sys.out.println("max = "+ max);
        return max;
    }


}
