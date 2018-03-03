package lesson19HW;


import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File(1242134, "file1", "doc", 1024);
        File file2 = new File(1242135, "file2", "doc", 1024);
        File file3 = new File(1242136, "file3", "xls", 1024);
        File file4 = new File(1242137, "file4", "doc", 1024);
        File file5 = new File(1242138, "file5", "doc", 1024);
        File file6 = new File(1242139, "file@6", "doc", 1024);
        File file7 = new File(1242140, "file7", "dat", 1024);
        File file8 = new File(1242141, "file8", "doc", 1024);

        File[] files1 = new File[]{file1, file2, file3, file4, file5};
        String[] formatSupportedStorage1 = new String[]{"doc", "txt"};

        Controller controller = new Controller();

        Storage storage1 = new Storage(123453145, files1, formatSupportedStorage1, "Ukraine", 6144);


        try {
            controller.put(storage1, file6);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
        try {
            controller.put(storage1, file7);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
        try {
            controller.put(storage1, file8);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
        try {
            controller.delete(storage1, file7);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
        try {
            controller.delete(storage1, file8);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
        try {
            controller.delete(storage1, file6);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }





//        File[] filesDone = storage1.getFiles();
//        for (File file : filesDone) {
//            System.out.println(file.getName());
//        }

    }
}
