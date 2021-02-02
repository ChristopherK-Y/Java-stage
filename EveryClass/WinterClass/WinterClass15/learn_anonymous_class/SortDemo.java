package learn_anonymous_class;

import java.util.Arrays;
import java.util.Comparator;

public class SortDemo {
    // 静态内部类的知识点
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // 0. 静态内部类
    // 1. 如何使用泛型类 —— 实现一个泛型接口
    // 2. Comparator 的理解 —— 对象的比较
    static class PersonByAgeComparator implements Comparator<Person> {
        @Override
        // 1. 返回值的含义
        public int compare(Person o1, Person o2) {
            /*
            o1.age < o2.age => o1 < o2 => 负数
            o1.age == o2.age => o1 == o2 => 0
            o1.age > o2.age => o1 > o2 => 正数
             */
            //return o1.age - o2.age;
            if (o1.age < o2.age) {
                // 我认为 o1 比 o2 小
                return -1;  // 通过返回负数，表示 o1 < o2 这个结果
            } else if (o1.age == o2.age) {
                return 0;
            } else {
                return 1;   // 通过返回正数，代表 o1 > o2
            }

            /*
            根据年龄大小比较，设定规则：
            两个 Person 对象：age 小的 对象 “比较小”
            o1  和   o2
            根据 Comparator 的要求
            可以自行处理规则，但结果有要求
            返回 < 0 的值，就代表 o1 < o2
             */
        }
    }

    public static void main(String[] args) {
        Person[] array = {
                new Person("A", 1),
                new Person("B", 2),
                new Person("C", 9),
                new Person("D", 3),
                new Person("E", 7)
        };
//        // 请给我排序 array 数组，使用我传入的 天平 比较
//        // 1. 向上转型 —— 上层的类的引用可以指向下层类的对象
//        Comparator<Person> 天平 = new PersonByAgeComparator();
//
//        // PersonByAgeComparator 这个类，如果只需要用这么一次，构建一个对象之后，就不再使用了
//        // 这种情况下就可以使用匿名类替代
//        Comparator<Person> 天平2 = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.age - o2.age;
//            }
//        };
//        // 1. Comparator 的理解
//        Arrays.sort(array, 天平2);

        Arrays.sort(array, (o1, o2) -> o1.age - o2.age);

        System.out.println(Arrays.toString(array));
    }
}
