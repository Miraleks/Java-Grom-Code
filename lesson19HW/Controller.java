package lesson19HW;

import java.util.Arrays;

import static java.lang.Character.isLetterOrDigit;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        dataTest(storage, file);
        boolean done = false;
        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                done = true;
            }
        }
        if (!done) {
            File[] newFiles = new File[storage.getFiles().length + 1];
            for (int i = 0; i < files.length; i++) {
                newFiles[i] = files[i];
            }
            newFiles[files.length] = file;
            storage.setFiles(newFiles);
        }
    }

    public void delete(Storage storage, File file) throws Exception {
        if (file == null) {
            throw new RuntimeException("null data is detected");
        }
        File[] files = storage.getFiles();
        boolean check = false;
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null &&  files[i].getId() == file.getId()) {
                files[i] = null;
                check = true;
            }
        }
        if (!check) {
            throw new RuntimeException("file not found in storage: " + file.getId());
        } else storage.setFiles(files);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom.getFormatSupported() != storageTo.getFormatSupported()) {
            throw new RuntimeException("storage incorrect from: " + storageFrom.getId() + " to: " + storageTo.getId());
        }
        long spaceValue = 0;
        File[] filesFrom = storageFrom.getFiles();
        for (File file : filesFrom) {
            spaceValue = spaceValue + file.getSize();
        }
        File[] filesTo = storageTo.getFiles();
        int counter = filesFrom.length;
        for (File file : filesTo) {
            spaceValue = spaceValue + file.getSize();
            if (file == null) counter = counter - 1;
        }
        if (counter < 0) counter = 0;

        if (storageTo.getStorageSize() < spaceValue) {
            throw new RuntimeException("not enough space in the destination storage");
        }

        File[] newFiles = new File[storageTo.getFiles().length + counter];
        int j = 0;
        for (int i = 0; i < newFiles.length; i++) {
            if (filesTo[i] == null) {
                filesTo[i] = filesFrom[j];
                j = j + 1;
            }
        }
        storageTo.setFiles(newFiles);

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File[] filesFrom = storageFrom.getFiles();
        int counter = 0;
        boolean flag = false;
        for (File files : filesFrom) {
            if (files.getId() == id) {
                flag = true;
                break;
            }
            counter++;
        }
        if (!flag) {
            throw new RuntimeException("file didn't found in storage");
        } else {
            put(storageTo, filesFrom[counter]);
            delete(storageFrom, filesFrom[counter]);
        }
    }

    private boolean maxSizeReached(Storage storage, File file) {
        File[] files = storage.getFiles();
        long maxSize = file.getSize();
        for (File element : files) {
            maxSize = maxSize + element.getSize();
        }
        return (maxSize <= storage.getStorageSize());

    }

    private boolean typeCheck(Storage storage, File file) {
        String[] storageFormat = storage.getFormatSupported();
        for (String format : storageFormat) {
            if (format == file.getFormat()) return true;
        }
        return false;
    }

    private boolean fileCheck(File file) {
        char[] chars = file.getName().toCharArray();
        if (chars.length > 10) return false;
        for (char ch : chars)
            if (!isLetterOrDigit(ch)) return false;
        return true;
    }

    private void dataTest(Storage storage, File file) {
        if (file == null) {
            throw new RuntimeException("null data is detected: " + file.getId());

        }
        if (!typeCheck(storage, file)) {
            throw new RuntimeException("format file don't allowed: " + file.getId() + " to storage: " + storage.getId() );
        }
        if (!fileCheck(file)) {
            throw new RuntimeException("filename incorrect: "+ file.getId());
        }
        if (!maxSizeReached(storage, file)) {
            throw new RuntimeException("there is not enough space in the storage: " + storage.getId() + " to adding file: " + file.getId());

        }

    }
}
