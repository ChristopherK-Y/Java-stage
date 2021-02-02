package learn_generic;

import java.util.Comparator;

class TeacherCmp implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return 0;
    }
}

public class Teacher implements Comparable<Teacher> {
    @Override
    public int compareTo(Teacher o) {
        return 0;
    }
}
