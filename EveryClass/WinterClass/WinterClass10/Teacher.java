public class Teacher extends Person{
    String name;
    String course;

    public Teacher(String name,String name2,String course){
        super(name);
        this.name = name2;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + super.name + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
