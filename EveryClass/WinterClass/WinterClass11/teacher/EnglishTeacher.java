package teacher;

public class EnglishTeacher extends Teacher {
    @Override
    public String getName() {
        return "english:" + super.getName();
    }

    @Override
    public void teach() {
        System.out.println("我是英语老师");
        super.teach();
    }

    public void speak() {
        System.out.println("听说读写");
    }
}
