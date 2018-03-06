package lesson19HW;

import static java.lang.Character.isLetterOrDigit;

public class Controller {

    public void put(Storage storage, File file) throws Exception {
        dataTestForException(storage, file);

        File[] files = storage.getFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i] == null) {
                files[i] = file;
                break;
            }
        }

    }

    public void delete(Storage storage, File file) throws Exception {
        if (file == null) {
            throw new NullPointerException("null data is detected");
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
        if (storageFrom == null || storageTo == null) {
            throw new NullPointerException("null data is detected");
        }
        File[] filesFrom = storageFrom.getFiles();
        int counter = 0;
        boolean flag = false;
        for (File files : filesFrom) {
            if(files != null) {
                if (files.getId() == id) {
                    flag = true;
                    break;
                }
            }
            counter++;
        }
        if (!flag) {
            throw new RuntimeException("file didn't found in storage");
        } else {
            dataTestForException(storageTo, filesFrom[counter]);
            put(storageTo, filesFrom[counter]);
            delete(storageFrom, filesFrom[counter]);
        }
    }

    private boolean maxSizeReached(Storage storage, File file) {
        long maxSize = file.getSize();
        if(storage.getFiles() != null) {
            File[] files = storage.getFiles();
            for (File element : files) {
                if(element != null) {
                    maxSize = maxSize + element.getSize();
                }
            }
        }
        return (maxSize <= storage.getStorageSize());
    }

    private boolean freeSpaceFile(Storage storage){
        if(storage.getFiles() != null) {
            File[] files = storage.getFiles();
            for (File element : files) {
                if (element == null) return true;
            }
            return false;
        }
        return true;
    }

    private boolean typeCheck(Storage storage, File file) {
        String[] storageFormat = storage.getFormatSupported();
        for (String format : storageFormat) {
            if (format == file.getFormat()) return true;
        }
        return false;
    }

    private boolean fileCheckForExist(Storage storage, File file){
        if(storage.getFiles() != null) {
            File[] files = storage.getFiles();
            for(File element : files){
                if(element != null) {
                    if (element.getId() == file.getId()) return false;
                }
            }
        }
        return true;
    }

    private void dataTestForException(Storage storage, File file) {
        if (file == null) {
            throw new NullPointerException("null file data is detected");
        }
        if(storage.getFiles() == null) {
            throw new NullPointerException(("null storage data is detected"));
        }
         if(!freeSpaceFile(storage)){
            throw new RuntimeException("there is no space in the storage: " + storage.getId() + "to file:" + file.getId());
        }
        if(!fileCheckForExist(storage, file)){
            throw new RuntimeException("file: " + file.getId() + " already exist in storage: " + storage.getId());
        }
        if (!typeCheck(storage, file)) {
            throw new RuntimeException("format file don't allowed: " + file.getId() + " to storage: " + storage.getId() );
        }

        if (!maxSizeReached(storage, file)) {
            throw new RuntimeException("there is not enough space in the storage: " + storage.getId() + " to adding file: " + file.getId());

        }

    }
}
