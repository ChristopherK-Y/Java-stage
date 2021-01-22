public class Teacher {
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static int countOfTeacher;

    public static Teacher getTeacher(String name,int age){
        countOfTeacher++;
        return new Teacher(name,age);
    }

    public static int getCountOfTeacher(){
        return countOfTeacher;
    }

    public String method(){
        return this.name;
    }

}
