package lesson25HW;

public class GeneralDAO<T>  {

    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {

        if(t == null) {
            throw new NullPointerException("null data is detected");
        }
//        if (array == null) return null;

        for (T tr : array) {
            if (t.equals(tr)) {
                throw new Exception("Transaction " + t.toString() + "is already exist");
            }
        }
        int index = 0;
        for (T tr : array) {
            if (tr == null) {
                array[index] = t;
                return t;
            }
            index++;
        }
        throw new Exception("There is no free space to save transaction. Transaction " + t.toString() + " can't be saved");

    }

    public T[] getAll() {
        return array;
    }
}
