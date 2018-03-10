package lesson19HW;

import static java.lang.Character.isLetterOrDigit;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File (long id, String name, String format, long size){

        if (!fileCheck(name)) throw new RuntimeException("incorrect file name");
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;

    }

    private boolean fileCheck(String name) {
        char[] chars = name.toCharArray();
        if (chars.length > 10) return false;
        for (char ch : chars)
            if (!isLetterOrDigit(ch)) return false;
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != file.id) return false;
        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
