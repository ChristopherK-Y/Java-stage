package use_linked_list;

import java.util.LinkedList;

// 结合文档找出 LinkedList 的常见方法
// 备注：LinkedList 除此之外还有很多其他方法，暂时不用管
public class Demo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list);   //[]
        System.out.println(list.isEmpty()); //true
        System.out.println(list.size());    //0
        System.out.println("===============");

        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);   //[A B C]
        System.out.println(list.isEmpty()); //false
        System.out.println(list.size());    //3
        System.out.println("===============");

        list.add(0, "Z");
        list.add(1, "Y");
        list.add(2, "X");
        System.out.println(list);   //[Z Y X A B C]
        System.out.println(list.isEmpty()); //false
        System.out.println(list.size());    //6
        System.out.println("===============");

        list.clear();
        System.out.println(list);   //[]
        System.out.println(list.isEmpty()); //true
        System.out.println(list.size());    //0
        System.out.println("===============");
    }
}
