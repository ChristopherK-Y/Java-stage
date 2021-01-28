package teacher;

public class Main {
    private static Person createObject() {
        return new MathTeacher();
    }

    public static void main(String[] args) {
        Person p = createObject();

        System.out.println(p.getName());
//        p.teach();
//        p.draw();
    }
}
