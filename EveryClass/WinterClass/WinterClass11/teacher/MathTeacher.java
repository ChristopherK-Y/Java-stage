package teacher;

public class MathTeacher extends Teacher {
    @Override
    public String getName() {
        return "math:" + super.getName();
    }

    @Override
    public void teach() {
        System.out.println("我是数学老师");
        super.teach();
    }

    public void draw() {
        System.out.println("画图形");
    }
}
