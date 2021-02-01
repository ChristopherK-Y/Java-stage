package CMP;

import java.util.Objects;

class Teacher{
    String name;
    int age ;
    String course;

    public Teacher(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Objects.equals(name, teacher.name) && Objects.equals(course, teacher.course);
    }
}

public class OverRideEquals {

}
