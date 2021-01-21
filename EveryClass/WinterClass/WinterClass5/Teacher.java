public class Teacher {
    public String name = "teacher1";//定义时初始化
    public int age = 10;

    {
        name = "teacher2";//构造代码块初始化
        age = 20;
    }

    public Teacher() {
        name = "teacher3";
        age = 30;
    }

    public Teacher(String name, int age) {//通过构造函数初始化
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Teacher{Name: " + name + ", Age: " + age + "}";
    }
}
