package lesson11.biginterfaceexample;

public class Storage {
    private File[] files = new File[5];

    public Storage(File[] files) {
        this.files = files;

    }

    public File[] getFiles() {
        return files;
    }
}
