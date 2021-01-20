public class Teacher {
    public String name;
    public int age;
    public String[] courseArrays;

    public Teacher() {
        this(null);
    }

    public Teacher(String name) {
        this(name,0);
    }

    public Teacher(String name, int age) {
        this(name,age,null);
    }

    public Teacher(String name, int age, String[] courseArrays) {
        this.name = name;
        this.age = age;
        this.courseArrays = courseArrays;
    }

    public void selfIntroduction() {
        System.out.println("My name is " + name + ", I'm " + age + " years old." + "My courseArrays is: ");
        if (courseArrays != null) {
            for (String courses : courseArrays) {
                System.out.println(courses);
            }
        } else {
            System.out.println("null");
        }
    }


}
