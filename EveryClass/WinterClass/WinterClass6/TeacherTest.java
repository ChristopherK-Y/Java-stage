public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = Teacher.getTeacher("Name", 20);
        System.out.println(teacher);
        System.out.println(Teacher.getCountOfTeacher());
        Teacher teacher2 = Teacher.getTeacher("Name2", 30);
        System.out.println(teacher);
        System.out.println(Teacher.getCountOfTeacher());
    }
}
