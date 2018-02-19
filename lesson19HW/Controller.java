package lesson19HW;

public class Controller {

    public void put(Storage storage, File file) throws Exception{
        if(file == null) throw new RuntimeException("null data is detected");
        if(!maxSizeReached(storage,file)) throw new RuntimeException("there is not enough storage in the storage");
        if(!typeCheck(storage, file)) throw new RuntimeException("data formats do not match");

        File[] files = storage.getFiles();
        for(int i = 0; i < files.length; i++){
            if(files[i] == null){
                files[i] = file;
            }
        }




    }

    public void delete(Storage storage, File file) throws Exception{

    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{

    }

    public boolean maxSizeReached(Storage storage, File file){
        File[] files = storage.getFiles();
        long maxSize = file.getSize();
        for(File element : files){
            maxSize = maxSize + element.getSize();
        }
        return (maxSize <= storage.getStorageSize());
    }

    public boolean typeCheck(Storage storage, File file){
        String[] storageFormat = storage.getFormatSupported();
        for(String format : storageFormat){
            if(format == file.getFormat()) return true;
        }
        return false;
    }
}
