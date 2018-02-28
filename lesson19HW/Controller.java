package lesson19HW;

import static java.lang.Character.isLetterOrDigit;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        try {
            dataTest(storage, file);
        }catch(Exception e){
            System.out.println("error: " + e.getMessage());
        }
        boolean done = false;
        File[] files = storage.getFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                done = true;
            }
        }
        if(!done){
            File[] newFiles = new File[storage.getFiles().length + 1];
            for(int i = 0; i < files.length; i++){
                newFiles[i] = files[i];
            }
            newFiles[files.length] = file;
            storage.setFiles(newFiles);
        }
    }

    public void delete(Storage storage, File file) throws Exception {

    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

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

    private boolean fileCheck(File file){
        char[] chars = file.getName().toCharArray();
        if(chars.length > 10) return false;
        for(char ch : chars)
            if (!isLetterOrDigit(ch)) return false;
        return true;
    }

    private void dataTest(Storage storage, File file) {
        if (file == null) {
            throw new RuntimeException("null data is detected");

        }
        if (!maxSizeReached(storage, file)) {
            throw new RuntimeException("there is not enough storage in the storage");

        }
        if (!typeCheck(storage, file)) {
            throw new RuntimeException("data formats do not match");
        }
        if(!fileCheck(file)){
            throw new RuntimeException("filename incorrect");
        }

    }
}
