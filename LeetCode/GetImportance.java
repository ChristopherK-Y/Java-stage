package LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/employee-importance/submissions/
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

public class GetImportance {
    public int sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        List<Integer> list = getList(employees,id);//首先找到第一个id所在的，然后把下属表找出来，顺便把重要度加上。
        if (list == null) {
            return 0;
        }
        myGetImportance(employees, list);//把下属表传入，计算下属的重要度
        return sum;
    }

    private void myGetImportance(List<Employee> employees, List<Integer> list) {
        for (int oneNumber : list) {//遍历每个数字，即下属id
            List<Integer> target = getList(employees, oneNumber);//找到他们的下属List
            if (target != null) {
                myGetImportance(employees, target);//如果下属不为空，继续递归
            }
        }
    }

    private List<Integer> getList(List<Employee> employees, int id) {
        for (Employee e : employees) {//如果找到id的时候，把重要度一加
            if (e.id == id) {
                sum += e.importance;
                return e.subordinates;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        //[[1,5,[2,3]],[2,3,[]],[3,3,[]]]
        List<Integer> one = new ArrayList<>();
        one.add(2);
        one.add(3);
        list.add(new Employee(1, 5, one));
        list.add(new Employee(2, 3, new ArrayList<>()));
        list.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(new GetImportance().getImportance(list, 1));
    }

}

