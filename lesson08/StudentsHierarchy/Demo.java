package lesson08.StudentsHierarchy;

public class Demo {
    public static void main(String[] args) {

    }

    Student createHighestParent() {

        Student student = new Student("Alex", "Ivanov", 213, new Course[3]);
        return student;

    }

    SpecialStudent createLowestChild() {
        SpecialStudent specialStudent = new SpecialStudent("Olga", "Petrova", 214, new Course[5], 12323, "email@email.com");
        return specialStudent;
    }
}
